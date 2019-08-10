package com.caogen.jfd.service.driver;

import com.caogen.jfd.ces.WebSocketMapUtil;
import com.caogen.jfd.common.Constants;
import com.caogen.jfd.dao.driver.*;
import com.caogen.jfd.dome.JPush;
import com.caogen.jfd.entity.AppUserSite;
import com.caogen.jfd.entity.driver.*;
import com.caogen.jfd.util.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;


@Service
public class PeservationServicelmpl implements PeservationService {
    /**
     * 地球半径,单位 km
     */
    private static final double EARTH_RADIUS = 6378.137;

    @Autowired
    private PeservationDao peservationDao;
    @Autowired
    private AppDriverDao appDriverDao;
    @Autowired
    private PersonalDao personalDao;
    @Autowired
    private VehicleDao vehicleDao;
    @Autowired
    private TaskService taskService;
    @Autowired
    private CompleteDao completeDao;
    @Autowired
    private PriceDao priceDao;

    @Override
    public void create(Peservation entity) {

    }

    @Override
    public void remove(Peservation entity) {

    }

    @Override
    public void modify(Peservation entity) {

    }

    @Override
    public Peservation getById(Integer id) {
        return null;
    }

    @Override
    public List<Peservation> getmake(Integer driver_id, Peservation.Mode mode) { ;
        Peservation peservation = new Peservation();
        peservation.setDriver_id(driver_id);
        peservation.setMode(mode);
        List<Peservation>peservations = peservationDao.find(peservation);
        for (Peservation item : peservations) {
            item.setCreatedate(FormatUtils.dateToStr(item.getCreate_date()));
            item.setCreate_date(null);
        }        return peservations;
    }

    @Override
    public  Peservation getma(String code) {
            Peservation peservation1 = peservationDao.get333(code);
            return  peservation1;
        }

    @Override
    public void getput() {
    }

    @Override
    public void  getput(String code,String flag) {
        Personal personal = new Personal();
        Vehicle vehicle = new Vehicle();
        //取出新订单
        Peservation peservations = peservationDao.findput(code);
        Map<String, Object> message = new HashMap<>();
        String name = peservations.getName();
        Integer status = peservations.getStatus();
        String origin = peservations.getOrigin();
        String destination = peservations.getDestination();
        Integer model_id = peservations.getModel_id();
        System.out.println(model_id);
        AppUserSite appUserSite = Constants.gson.fromJson(origin, AppUserSite.class);
        Double latitude2 = appUserSite.getLatitude();
        Double longitude2 = appUserSite.getLongitude();
        LocalDateTime create_date = peservations.getCreate_date();
        String gap = peservations.getGap();

        message.put("name", name);
        message.put("code", code);
        message.put("status", status);
        message.put("origin", origin);
        message.put("gap",gap);
        message.put("destination", destination);
        message.put("create_date", create_date);
        if("cancle".equals(flag) || "refund".equals(flag)){
            message.put("isShow",flag);
        }else {
            message.put("isShow","y");
        }

        //司机
        List<Personal> personalDao1 = personalDao.find3(personal);
        List<String> aa = new LinkedList<>();
        for (int s = 0; s < personalDao1.size(); s++) {
            Integer user_id = personalDao1.get(s).getUser_id();
            String s2 = String.valueOf(user_id);
            System.out.println(s2);
            Double latitude1 = personalDao1.get(s).getLatitude();
            Double longitude1 = personalDao1.get(s).getLongitude();
            Integer vehicle_id = personalDao1.get(s).getVehicle_id();
            vehicle.setId(vehicle_id);
            Vehicle vehicle1 = vehicleDao.get(vehicle);
            Integer model_id1 = vehicle1.getModel_id();
            if (model_id != model_id1) {
                continue;
            }
            if (status != 1) {
                continue;
            }
            // 纬度
            double lat1 = Math.toRadians(latitude1);
            double lat2 = Math.toRadians(latitude2);
            // 经度
            double lng1 = Math.toRadians(longitude1);
            double lng2 = Math.toRadians(longitude2);
            // 纬度之差
            double a = lat1 - lat2;
            // 经度之差
            double b = lng1 - lng2;
            // 计算两点距离的公式
            double ss = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                    Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(b / 2), 2)));
            // 弧长乘地球半径, 返回单位: 千米
            ss = ss * EARTH_RADIUS;
            //公里自定义
            price priceDao1 = priceDao.get1();
            Double scope = priceDao1.getScope();
            if (ss <= scope) {
                System.out.println("添加司机：" + s2);
                aa.add(s2);
            }
        }
        String[] driverIds = aa.toArray(new String[aa.size()]);
        try {
            System.out.println("准备发送：" + message);
            WebSocketMapUtil.sendNewOrderMessage(message, driverIds, "m");
        } catch (Exception e) {
        }
        if("add".equals(flag)){
            //过十秒后再次发送停止显示订单信息
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    //1.判断该订单是否被抢单
                    //根据订单号来获取司机id判断是否为空
                    Peservation personal1 = peservationDao.get11(code);
                    Integer driver_id = personal1.getDriver_id();
                    if (driver_id == null) {
                        //未被抢：a.删除司机手机关于此订单的信息 b.推送给管理后台
                        try {
                            message.put("isShow","n");
                            WebSocketMapUtil.sendNewOrderMessage(message, driverIds, "m");
                            WebSocketMapUtil.sendNewOrderMessage(message, null, "p");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, 10000);
        }

    }


    //抢单接口
    @Override
    public boolean getspike(Integer driver_id, String code) {
        AppDriver appDriver = new AppDriver();
        Peservation peservation = new Peservation();
        appDriver.setId(driver_id);
        Integer id1 = appDriverDao.get(appDriver).getId();
        peservation.setDriver_id(id1);
        peservation.setCode(code);
        peservation.setStatus(2);
        Peservation  peservations = peservationDao.getdsp(peservation);
        //判断库存
        if(peservations.getCode()==null){
            return false;
        }

        //判断是否已经秒杀到了
        if (peservations.getDriver_id()!=null) {
            return false;
        }
        peservations.setDriver_id(id1);
        peservationDao.update(peservation);
        return true;
    }


    //抢单完成后，记录地址
    @Autowired
    private TaskDao taskDao;
    @Override
    public void getfenjie(String code) {
        Peservation peservation = new Peservation();
        peservation.setCode(code);
        Peservation  peservations = peservationDao.getss(peservation);
        String destination = peservations.getDestination();
        //插入发货地址
        Task task1 = new Task();
        String origin = peservations.getOrigin();
        task1.setDestination(origin);
        task1.setCode(code);
        task1.setSerial("00");
        task1.setStatus(0);
        taskDao.insert(task1);//地址表插入数据
        //插入收货地址
        AppUserSite[] appUserSite = Constants.gson.fromJson(destination,AppUserSite[].class);
        for (int i =0;i<appUserSite.length;i++){
            Task task = new Task();
            String s = Constants.gson.toJson(appUserSite[i]);
            task.setDestination(s);
            task.setCode(code);
            String a = Integer.toString(i);
            task.setSerial(a);
            task.setStatus(0);
            taskDao.insert(task);//地址表插入数据
        }

        }

        //订单完成，插入历史表
    public void gettake(String code) {
        Peservation peservation = new Peservation();
        Complete complete = new Complete();
        peservation.setCode(code);
        Peservation  peservations = peservationDao.get6(peservation);
        String code1 = peservations.getCode();
        String phone1 = peservations.getPhone();
        LocalDateTime create_date = peservations.getCreate_date();
        Integer status = peservations.getStatus();
        Peservation.Mode mode = peservations.getMode();
        String origin = peservations.getOrigin();
        String destination = peservations.getDestination();
        Double kilometre = peservations.getKilometer();
        Double bonus = peservations.getBonus();
        Integer user_id = peservations.getUser_id();
        Integer driver_id = peservations.getDriver_id();
        Integer model_id = peservations.getModel_id();
        Peservation.Type type = peservations.getType();
        LocalDateTime appoint_date = peservations.getAppoint_date();
        String label = peservations.getLabel();
        String name = peservations.getName();
        Double night_cost = peservations.getNight_cost();
        Double jam_cost = peservations.getJam_cost();
        Boolean is_support = peservations.getIs_support();
        Double support_money = peservations.getSupport_money();
        Double support_cost = peservations.getSupport_cost();
        Double order_money = peservations.getOrder_money();
        Double ticket_money = peservations.getTicket_money();
        Double actually_paid = peservations.getActually_paid();
        String city = peservations.getCity();

        complete.setActually_paid(actually_paid);
        complete.setTicket_money(ticket_money);
        complete.setOrder_money(order_money);
        complete.setSupport_cost(support_cost);
        complete.setSupport_money(support_money);
        complete.setIs_support(is_support);
        complete.setJam_cost(jam_cost);
        complete.setNight_cost(night_cost);
        complete.setName(name);
        complete.setLabel(label);
        complete.setAppoint_date(appoint_date);
        complete.setType(type);
        complete.setModel_id(model_id);
        complete.setDriver_id(driver_id);
        complete.setUser_id(user_id);
        complete.setCode(code1);
        complete.setPhone(phone1);
        complete.setCreate_date(create_date);
        complete.setStatus(4);//已完成
        complete.setMode(mode);
        complete.setOrigin(origin);
        complete.setDestination(destination);
        complete.setKilometer(kilometre);
        complete.setBonus(bonus);
        complete.setFinish_date(LocalDateTime.now());
        complete.setCity(city);
        completeDao.insert(complete);
        peservationDao.delete(peservation);
    }

    @Override
    public List <Peservation> gettui() {
        Peservation peservation = new Peservation();
        List<Peservation> aaa =  peservationDao.find8(peservation);
        return aaa;
    }

    @Override
    public void getsingle(Integer id, String code) {
       Peservation peservation =new Peservation();
        peservation.setDriver_id(id);
        peservation.setCode(code);
        Peservation task = peservationDao.get8(peservation);
        if(task.getStatus() == 1){
            task.setStatus(2);
            peservationDao.update1(task);
        }else if (task.getStatus()== 2) {
            task.setStatus(3);
            peservationDao.update1(task);
        }else if (task.getStatus()== 3) {
            task.setStatus(4);
            peservationDao.update1(task);
        }else if (task.getStatus()== 4) {
            task.setStatus(5);
            peservationDao.update1(task);
        }else if (task.getStatus()== 5) {
            task.setStatus(6);
            peservationDao.update1(task);
            gettake(code);
        }
        Map<String,String>aa = new HashMap<>();
        aa.put("msg","订单状态发生改变");
        JPush.jpushAll(aa);
    }

    @Override
    public List<Task> taskInfoList(String code) {
        return peservationDao.taskInfoList(code);
    }

    @Override
    public void completeOrder(String code, Integer taskId) {

        //更新此地址信息
        Task task = new Task();
        task.setId(taskId);
        taskDao.update(task);

        //订单信息
        Peservation peservation =new Peservation();
        peservation.setCode(code);

        task.setCode(code);
        //判断此地址是否为第一个，即发货地址
        Integer minId = taskDao.checkMin(task);
        if(minId.equals(taskId)){
            //更新订单状态
            peservationDao.update1(peservation);
        }

        //判断此地址是否为最后一个，即订单完成
        Integer maxId = taskDao.checkMax(task);
        if (taskId.equals(maxId)){//相同，说明是最后一个地址
            //删除orderInfo，添加至orderHistory
            gettake(code);
            //根据订单查询人的极光id
            String registrationID = taskDao.getRegistrationID(code);
            //极光推送
            Map<String,String>aa = new HashMap<>();
            aa.put("msg","订单状态发生改变");
            aa.put("id",registrationID);
            try{
                JPush.jpushAll(aa);
            }catch (Exception e){

            }
        }
    }

    @Override
    public List<Map> currentOrder(Integer driverId) {
        return peservationDao.currentOrder(driverId);
    }

}


