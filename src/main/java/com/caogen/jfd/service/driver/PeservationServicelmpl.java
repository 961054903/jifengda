package com.caogen.jfd.service.driver;
import com.caogen.jfd.common.Constants;
import com.caogen.jfd.controller.driver.dome.JPush;
import com.caogen.jfd.dao.driver.*;
import com.caogen.jfd.entity.driver.*;
import com.caogen.jfd.entity.user.AppUserSite;

import com.caogen.jfd.util.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        return peservations;
    }

    @Override
    public  Peservation getma(String code) {
        Peservation peservation = new Peservation();
        peservation.setCode(code);
        Peservation peservation1 = peservationDao.get(peservation);
        String s = FormatUtils.dateToStr(peservation1.getCreate_date());
        peservation1.setCreatedate(s);
        return  peservation1;
    }
    @Override
    public void  getput() {
        Personal personal = new Personal();
        Vehicle vehicle = new Vehicle();
        Peservation peservation = new Peservation();
        Map<String,String> wt = new HashMap<>();
        Map<String,String> dd = new HashMap<>();

        List<Vehicle> vehicles = vehicleDao.find(vehicle);
        for (int c =0; c<vehicles.size();c++){
            Integer id = vehicles.get(c).getModel_id();

        List<Personal> personalDao1 = personalDao.find3(personal);
        for (int s = 0; s < personalDao1.size(); s++) {
            Double longitude1 = personalDao1.get(s).getLongitude();
            Double latitude1 = personalDao1.get(s).getLatitude();
            //订单
                List<Peservation> peservations = peservationDao.findput(peservation);
                for (int i = 0; i < peservations.size(); i++) {
                    Integer status = peservations.get(i).getStatus();
                    String origin = peservations.get(i).getOrigin();
                    Integer model_id = peservations.get(i).getModel_id();
                    AppUserSite appUserSite = Constants.gson.fromJson(origin, AppUserSite.class);
                    Double latitude2 = appUserSite.getLatitude();
                    Double longitude2 = appUserSite.getLongitude();
                if (id != model_id) {
                    continue;

                }


                if (status != 1) {
                    continue;
                }

                peservations.get(i).setModel_id(null);
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
                    String s1 = Constants.gson.toJson(peservations);
                   wt.put("id",s1);
                    if (ss <= 100000000) {
                    //推送
                    JPush.jpushIOS(wt);

                }
                 dd.put("cc","司机已接单");
                    JPush.jpush(dd);
            }
        }
        }

    }


    @Override
    public boolean getspike(Integer driver_id, String code) {
        AppDriver appDriver = new AppDriver();
        Peservation peservation = new Peservation();
        appDriver.setId(driver_id);
        Integer id1 = appDriverDao.get(appDriver).getId();
        peservation.setDriver_id(id1);
        peservation.setCode(code);
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


    @Autowired
    private TaskDao taskDao;
    @Override
    public void getfenjie(String code) {
        Peservation peservation = new Peservation();
        peservation.setCode(code);
        Peservation  peservations = peservationDao.getss(peservation);
        String destination = peservations.getDestination();

        AppUserSite[] appUserSite = Constants.gson.fromJson(destination,AppUserSite[].class);
        for (int i =0;i<appUserSite.length;i++){
            Task task = new Task();
            String s = Constants.gson.toJson(appUserSite[i]);
            task.setDestination(s);
            task.setCode(code);
            String a = Integer.toString(i);
            task.setSerial(a);
            task.setStatus(0);
            taskDao.insert(task);
        }

        }

    @Override
    public void gettake(String phone, String code) {
        Peservation peservation = new Peservation();
        Complete complete = new Complete();
        peservation.setCode(code);
        peservation.setPhone(phone);
        Peservation  peservations = peservationDao.get6(peservation);
        String code1 = peservations.getCode();
        String phone1 = peservations.getPhone();
        LocalDateTime create_date = peservations.getCreate_date();
        Integer status = peservations.getStatus();
        Peservation.Mode mode = peservations.getMode();
        String origin = peservations.getOrigin();
        String destination = peservations.getDestination();
        Double kilometre = peservations.getKilometre();
        Double bonus = peservations.getBonus();
        Integer user_id = peservations.getUser_id();
        Integer driver_id = peservations.getDriver_id();
        Integer model_id = peservations.getModel_id();
        Peservation.Type type = peservations.getType();
        LocalDateTime appoint_date = peservations.getAppoint_date();
        Peservation.Label label = peservations.getLabel();
        String name = peservations.getName();
        Double night_service_cost = peservations.getNight_service_cost();
        Double traffic_jam_cost = peservations.getTraffic_jam_cost();
        Boolean is_support = peservations.getIs_support();
        Double support_money = peservations.getSupport_money();
        Double support_cost = peservations.getSupport_cost();
        Double order_money = peservations.getOrder_money();
        Double ticket_money = peservations.getTicket_money();
        Double actually_paid = peservations.getActually_paid();

        complete.setActually_paid(actually_paid);
        complete.setTicket_money(ticket_money);
        complete.setOrder_money(order_money);
        complete.setSupport_cost(support_cost);
        complete.setSupport_money(support_money);
        complete.setIs_support(is_support);
        complete.setTraffic_jam_cost(traffic_jam_cost);
        complete.setNight_service_cost(night_service_cost);
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
        complete.setStatus(status);
        complete.setMode(mode);
        complete.setOrigin(origin);
        complete.setDestination(destination);
        complete.setKilometre(kilometre);
        complete.setBonus(bonus);
        complete.setFinish_date(LocalDateTime.now());
        completeDao.insert(complete);
        peservationDao.delete(peservation);
    }

    @Override
    public List <Peservation> gettui() {
        Peservation peservation = new Peservation();
        List<Peservation> aaa =  peservationDao.find8(peservation);
        return aaa;
    }
}


