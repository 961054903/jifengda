package com.caogen.jfd.controller;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.*;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.*;
import com.caogen.jfd.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("PersonalCenter")
public class PersonalController {

    @Autowired
    private PersonalService personalService;
    @Autowired
    private AppDriverService appDriverService;

    /**
     * 查询上下线状态全部
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"upAndDown","app/upAndDown"})
    public Message upAndDown(Message data) {
        Message message = new Message();
        try {
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            Personal appDriver = Constants.gson.fromJson((String) data.getData(),Personal.class);
            Personal cities = personalService.getss(driver.getId());
            message.setData(cities.getIs_online());
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }
    /**
     * 修改上下线在线
     *
     */
    @ResponseBody
    @RequestMapping(value = {"state","app/state"})
    public Message state(Message data)  {
        Message message = new Message();
        try {
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            Personal appDriver = Constants.gson.fromJson((String) data.getData(),Personal.class);
             personalService.getstate(appDriver.getIs_online(),driver.getId());
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }

    /**
     * 个人信息
     * 四条信息
     */

    @ResponseBody
    @RequestMapping(value = {"information","app/information"})
    public Message information(Message data)  {
        Message message = new Message();
        try {
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            Personal appDriver = Constants.gson.fromJson((String) data.getData(),Personal.class);
            Personal cities = personalService.getmany(driver.getId());
            message.setData(cities);
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }

    /**
     * 个人信息全部
     */
    @Autowired
    private ModelService modelService;

    @ResponseBody
    @RequestMapping(value = {"whole","app/whole"})
    public Message whole(Message data)  {
        Message message = new Message();
        try {
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            Personal appDriver = Constants.gson.fromJson((String) data.getData(),Personal.class);
            Personal cities = personalService.getwhole(driver.getId());
            message.setData(cities);
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }
    /**
     * 修改个人信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"edit","app/edit"})
    public Message edit(Message data) {
        Message message = new Message();
        try {
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            Personal appDriver = Constants.gson.fromJson((String) data.getData(),Personal.class);
            appDriver.setUser_id(driver.getId());
            personalService.getmodify(appDriver);
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }




    /**
     * 预约订单
     * @param phone
     * @return
     */
    @Autowired
    private PeservationService peservationService;

    @ResponseBody
    @RequestMapping(value = {"make","app/make"})
    public Message make(Message data) {

        Message message = new Message();
        try {
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            Peservation appDriver = Constants.gson.fromJson((String) data.getData(),Peservation.class);
           List <Peservation> personals = peservationService.getmake(driver.getId(),appDriver.getMode());
            Map<String,Object> appDrivers = new HashMap();
            appDrivers.put("order",personals);
            message.setData(appDrivers);
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }

    /**
     * 订单详情
     * @param phone
     * @return
     */

     @Autowired
     private UserService userService;

    @Autowired
    private RoyaltyService royaltyService;

    @ResponseBody
    @RequestMapping(value = {"details", "app/details"})
    public Message details(String code) {
        Message message = new Message();
        try {
            Peservation peservation = peservationService.getma(code);
            message.setData(peservation);
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;

    }

    @Autowired
    private  DetaiService detaiService;

    /**
     * 计算在线时间
     */
//    @ResponseBody
//    @RequestMapping(value = {"cout","app/cout"})
//    public Message cout(String data) {
//        Message message = new Message();
//        try {
//            Detail appDriver = Constants.gson.fromJson(data,Detail.class);
//            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
//            String cc = detaiService.getime(appDriver.getPhone());
//            message.setData(cc,driver.getDes_key(),driver.getDes_iv());
//            message.setCode(ErrorCode.SUCCEED.getCode());
//            message.setDesc(ErrorCode.SUCCEED.getDesc());
//        } catch (Exception e) {
//            message.setCode(ErrorCode.FAIL.getCode());
//            message.setDesc(ErrorCode.FAIL.getDesc());
//            StaticLogger.logger().error(message.getDesc(), e);
//        }
//        return message;
//    }

    /**
     * 取出时间
     * @return
     */

    @Autowired
    private TimeService timeService;

    @ResponseBody
    @RequestMapping(value = {"cumulative","app/cumulative"})
    public Message cumulative(Message data) {
        Message message = new Message();
        try {
            Time appDriver = Constants.gson.fromJson((String) data.getData(),Time.class);
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            Time cc = timeService.gettime(appDriver.getPhone(),appDriver.getTim());
            message.setData(cc);
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }



       @Autowired
       private  CompleteService completeService;
    /**
     * 今日
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"royalty","app/royalty"})
    public Message royalty(Message data) {
        Message message = new Message();
        try {
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            List <Complete> peservation = completeService.getto(driver.getId());
            String cc = detaiService.getime(driver.getId());
            int size = peservation.size();
            BigDecimal aa = new BigDecimal("0.00");
            //Double aa =0.0;
            for(int i = 0;i<peservation.size();i++){
                double d = peservation.get(i).getBonus();
                BigDecimal ss = new BigDecimal(Double.toString(d));
                aa = aa.add(ss);
            }
              Map<String,Object> appDrivers = new HashMap();
               appDrivers.put("order",size);
               if (cc==null){
                   appDrivers.put("time",0);

               }else {
                   appDrivers.put("time",cc);
               }
               appDrivers.put("royalty",aa.setScale(2, BigDecimal.ROUND_UP));
                message.setData(appDrivers);
            } catch (Exception e) {
                    message.setErrorCode(ErrorCode.FAIL);
                    StaticLogger.error("user order count error", e);
            }
                return message;

}
//
//    /**
//     * 今日接单
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = {"receipt","app/receipt"})
//    public Message receipt(String data) {
//        Message message = new Message();
//        try {
//            Complete appDriver = Constants.gson.fromJson(data,Complete.class);
//            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
//            List <Complete> peservation = completeService.getto(appDriver.getPhone());
//            int size = peservation.size();
//            List<Object>ASD = new ArrayList<Object>( );
//            ASD.add(size);
//            if (appDriver.getAa()){
//                ASD.add(peservation);
//            }
//            message.setData(ASD,driver.getDes_key(),driver.getDes_iv());
//            message.setCode(ErrorCode.SUCCEED.getCode());
//            message.setDesc(ErrorCode.SUCCEED.getDesc());
//        } catch (Exception e) {
//            message.setCode(ErrorCode.FAIL.getCode());
//            message.setDesc(ErrorCode.FAIL.getDesc());
//            StaticLogger.logger().error(message.getDesc(), e);
//        }
//        return message;


//
//    /**
//     * 本月接单
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = {"month","app/month"})
//    public Message month(String data) {
//        Message message = new Message();
//        try {
//            Complete appDriver = Constants.gson.fromJson(data,Complete.class);
//            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
//            List <Complete> peservation = completeService.getmon(appDriver.getPhone());
//            int size = peservation.size();
//            List<Object>ASD = new ArrayList<Object>( );
//            ASD.add(size);
//            if (appDriver.getAa()){
//                ASD.add(peservation);
//            }
//            message.setData(ASD,driver.getDes_key(),driver.getDes_iv());
//            message.setCode(ErrorCode.SUCCEED.getCode());
//            message.setDesc(ErrorCode.SUCCEED.getDesc());
//        } catch (Exception e) {
//            message.setCode(ErrorCode.FAIL.getCode());
//            message.setDesc(ErrorCode.FAIL.getDesc());
//            StaticLogger.logger().error(message.getDesc(), e);
//        }
//        return message;
//
//    }

    /**
     * 本月
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"mont","app/mont"})
    public Message mont(Message data){
        Message message = new Message();
        try {
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            if (driver!=null){
                //Complete appDriver = Constants.gson.fromJson((String)data.getData(),Complete.class);
                List <Complete> peservation = completeService.getmon(driver.getId());
                BigDecimal aa = new BigDecimal("0.00");
                for(int i = 0;i<peservation.size();i++){

                    double d = peservation.get(i).getBonus();
                    BigDecimal ss = new BigDecimal(Double.toString(d));
                    aa = aa.add(ss);
                }
                int size = peservation.size();
                Map<String,Object> appDrivers = new HashMap();
                appDrivers.put("order",size);
                appDrivers.put("royalty",aa.setScale(2, BigDecimal.ROUND_UP));
                message.setData(appDrivers);
                message.setCode(ErrorCode.SUCCEED.getCode());
                message.setDesc(ErrorCode.SUCCEED.getDesc());
            }

        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;

    }

    /**
     * 历史收入
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"history","app/history"})
    public Message history(Message data) {
        Message message = new Message();
        try {
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            Complete appDriver = Constants.gson.fromJson((String)data.getData(),Complete.class);
           List <Complete> completes = completeService.gethistory(driver.getId(),appDriver.getStart(),appDriver.getEnd());
            BigDecimal aa = new BigDecimal("0.00");
            for(int i = 0;i<completes.size();i++){
                double d = completes.get(i).getBonus();
                BigDecimal ss = new BigDecimal(Double.toString(d));
                aa = aa.add(ss);
            }
            int size = completes.size();
            Map<String,Object>qq =new HashMap();
             qq.put("royalty",aa.setScale(2, BigDecimal.ROUND_UP));
             qq.put("order",size);
             qq.put("information",completes);
             message.setData(qq);
        message.setCode(ErrorCode.SUCCEED.getCode());
        message.setDesc(ErrorCode.SUCCEED.getDesc());
    } catch (Exception e) {
        message.setCode(ErrorCode.FAIL.getCode());
        message.setDesc(ErrorCode.FAIL.getDesc());
        StaticLogger.logger().error(message.getDesc(), e);
    }
        return message;
}

    /**
     * 订单冠军
     * @return
     */
    @ResponseBody
    @RequestMapping("champion")
    public Message champion() {
        Message message = new Message();
        try {
           List <Personal> cc = personalService.getchampion();
            message.setData(cc);
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
        }

    /**
     * 推送
     * @return
     */
    @ResponseBody
    @RequestMapping("push")
    public Message push(String code,String flag) {//flag:add新增订单 cancle取消订单 refund用户退款
        Message message = new Message();
        try {
            peservationService.getput(code,flag);
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }

    /**
     * 抢单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"spike","app/spike"})
    public Message spike(String code,Integer driver_id) {
        Message message = new Message();
        try {
            boolean peservations = peservationService.getspike(driver_id,code);
            if (peservations){
                peservationService.getfenjie(code);//抢单成功记录地址
                //给websocket发消息删除
                // 发送HTTP请求
                Map<String, String> map = new HashMap<String, String>();
                map.put("flag", "spike");
                map.put("code", code);
                HttpClientUtils.doPost(Constants.NOTIFY_URL, map);
            }
            message.setData(peservations);
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }





      @Autowired
      private TaskService taskService;

    /**
     * 多点订单状态
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"already","app/already"})
    public Message already(Message data) {
        Message message = new Message();
        try {
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            Task appDriver = Constants.gson.fromJson((String) data.getData(),Task.class);
            taskService.getalready(driver.getId(),appDriver.getCode(),appDriver.getSerial());
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }

    /**
     * 单点订单状态
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"Single","app/Single"})
    public Message Single(Message data) {
        Message message = new Message();
        try {
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            Peservation appDriver = Constants.gson.fromJson((String) data.getData(),Peservation.class);
            peservationService.getsingle(driver.getId(),appDriver.getCode());
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }


    /**
     * 订单对应所有地址信息接口
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"taskInfoList","app/taskInfoList"})
    public Message taskInfoList(String code) {
        Message message = new Message();
        try {
            List<Task> taskList = peservationService.taskInfoList(code);
            message.setData(taskList);
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }

    /**
     * 订单对应所有地址信息接口
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"completeOrder","app/completeOrder"})
    public Message completeOrder(String code,Integer taskId) {
        Message message = new Message();
        try {
            peservationService.completeOrder(code,taskId);
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }

    /**
     * 订单冠军
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"currentOrder","app/currentOrder"})
    public Message currentOrder(Integer driverId) {
        Message message = new Message();
        try {
            List<Map> cc = peservationService.currentOrder(driverId);
            message.setData(cc);
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }



//    /**
//     * 存入历史
//     */
//    @ResponseBody
//    @RequestMapping("cunru")
//    public Message cunru(String phone ,String code) {
//        Message message = new Message();
//        try {
//             peservationService.gettake(phone,code);
//            message.setCode(ErrorCode.SUCCEED.getCode());
//            message.setDesc(ErrorCode.SUCCEED.getDesc());
//        } catch (Exception e) {
//            message.setCode(ErrorCode.FAIL.getCode());
//            message.setDesc(ErrorCode.FAIL.getDesc());
//            StaticLogger.logger().error(message.getDesc(), e);
//        }
//        return message;
//    }
//
////
//    /**
//     * 推送订单
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping("tuis")
//    public Message tuis( ) {
//        Message message = new Message();
//        try {
//           List <Peservation> peservation = peservationService.gettui();
//            message.setData(peservation);
//            message.setCode(ErrorCode.SUCCEED.getCode());
//            message.setDesc(ErrorCode.SUCCEED.getDesc());
//        } catch (Exception e) {
//            message.setCode(ErrorCode.FAIL.getCode());
//            message.setDesc(ErrorCode.FAIL.getDesc());
//            StaticLogger.logger().error(message.getDesc(), e);
//        }
//        return message;
//
//    }
}
