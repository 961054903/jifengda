package com.caogen.jfd.controller.driver;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.driver.*;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.driver.*;
import com.caogen.jfd.service.user.AppUserService;
import com.sun.jmx.snmp.tasks.TaskServer;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("PersonalCenter")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    /**
     * 查询上下线状态全部
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"upAndDown","app/upAndDown"})
    public Message upAndDown(String data) {
        Message message = new Message();
        try {
            Personal appDriver = Constants.gson.fromJson(data,Personal.class);
            Personal cities = personalService.getss(appDriver.getPhone());
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
     * 查询是否在线
     *
     */
    @ResponseBody
    @RequestMapping(value = {"state","app/state"})
    public Message state(String data)  {
        Message message = new Message();
        try {
            Personal appDriver = Constants.gson.fromJson(data,Personal.class);
             personalService.getstate(appDriver.getIs_online(),appDriver.getPhone());
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
    public Message information(String data)  {
        Message message = new Message();
        try {
            Personal appDriver = Constants.gson.fromJson(data,Personal.class);
            Personal cities = personalService.getmany(appDriver.getPhone());
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
     *
     */
    @Autowired
    private ModelService modelService;

    @ResponseBody
    @RequestMapping(value = {"whole","app/whole"})
    public Message whole(String data)  {
        Message message = new Message();
        try {
            Personal appDriver = Constants.gson.fromJson(data,Personal.class);
            Personal cities = personalService.getwhole(appDriver.getPhone());
            Model vehicle = modelService.getvehicle(appDriver.getPhone());
            List<Object>ASD = new ArrayList<Object>( );
            ASD.add(cities);
            ASD.add(vehicle);
            message.setData(ASD);
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
    public Message edit(String data) {
        Message message = new Message();
        try {
            Personal appDriver = Constants.gson.fromJson(data,Personal.class);
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
    public Message make(String data) {

        Message message = new Message();
        try {
            Peservation appDriver = Constants.gson.fromJson(data,Peservation.class);
           List <Peservation> personals = peservationService.getmake(appDriver.getPhone(),appDriver.getMode());
            message.setData(personals);
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
    @RequestMapping(value = {"details","app/details"})
    public Message details(String data) {
        Message message = new Message();
        try {
            Peservation appDriver = Constants.gson.fromJson(data,Peservation.class);
            User user = userService.getuser(appDriver.getCode());
            Peservation peservation = peservationService.getma(appDriver.getCode());
            List<Object>ASD = new ArrayList<Object>( );
            ASD.add(user);
            ASD.add(peservation);
            message.setData(ASD);
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
     * 计算在线时间
     */
    @Autowired
    private  DetaiService detaiService;

    @ResponseBody
    @RequestMapping(value = {"cout","app/cout"})
    public Message cout(String data) {
        Message message = new Message();
        try {
            Detail appDriver = Constants.gson.fromJson(data,Detail.class);
            String cc = detaiService.getime(appDriver.getPhone());
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
     * 取出时间
     * @return
     */

    @Autowired
    private TimeService timeService;

    @ResponseBody
    @RequestMapping("cumulative")
    public Message cumulative(String phone,String time) {
        Message message = new Message();
        try {
            Time cc = timeService.gettime(phone,time);
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
     * 今日提成
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("royalty")
    public Message royalty(String phone,Boolean cc) {
        Message message = new Message();
        try {
        List <Complete> peservation = completeService.getto(phone);
        Double aa =0.0;
    for(int i = 0;i<peservation.size();i++){
        Double ss = peservation.get(i).getBonus();
        aa += ss;
    }
        List<Object>ASD = new ArrayList<Object>( );
        ASD.add(aa);
        if (cc){
            ASD.add(peservation);
        }
        message.setData(ASD);
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
     * 今日接单
     * @param phone
     * @param cc
     * @return
     */
    @ResponseBody
    @RequestMapping("receipt")
    public Message receipt(String phone,Boolean cc) {
        Message message = new Message();
        try {
            List <Complete> peservation = completeService.getto(phone);
            int size = peservation.size();
            List<Object>ASD = new ArrayList<Object>( );
            ASD.add(size);
            if (cc){
                ASD.add(peservation);
            }
            message.setData(ASD);
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
     * 本月接单
     * @param phone
     * @param cc
     * @return
     */
    @ResponseBody
    @RequestMapping("month")
    public Message month(String phone,Boolean cc) {
        Message message = new Message();
        try {
            List <Complete> peservation = completeService.getmon(phone);
            int size = peservation.size();
            List<Object>ASD = new ArrayList<Object>( );
            ASD.add(size);
            if (cc){
                ASD.add(peservation);
            }
            message.setData(ASD);
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
     * 本月提成
     * @param phone
     * @param cc
     * @return
     */
    @ResponseBody
    @RequestMapping("mont")
    public Message mont(String phone,Boolean cc) {
        Message message = new Message();
        try {
            List <Complete> peservation = completeService.getmon(phone);
            Double aa =0.0;
            for(int i = 0;i<peservation.size();i++){
                Double ss = peservation.get(i).getBonus();
                aa += ss;
            }
            List<Object>ASD = new ArrayList<Object>( );
            ASD.add(aa);
            if (cc){
                ASD.add(peservation);
            }
            message.setData(ASD);
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
     * 历史收入
     * @return
     */
    @ResponseBody
    @RequestMapping("history")
    public Message history(String start,String end,String phone) {
        Message message = new Message();
        try {
        List <Complete> completes = completeService.gethistory(phone,start,end);
            Double aa =0.0;
            for(int i = 0;i<completes.size();i++){
                Double ss = completes.get(i).getBonus();
                aa += ss;
            }
            int size = completes.size();
            List<Object>ASD = new ArrayList<Object>( );
                ASD.add(aa);
                ASD.add(size);
                ASD.add(completes);
            message.setData(ASD);
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
    public Message champion( ) {
        Message message = new Message();
        try {

         Personal personal = personalService.getchampion();
            message.setData(personal);
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
    public Message push() {
        Message message = new Message();
        try {
            List<Peservation> peservations = peservationService.getput();
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

    /**
     * 抢单
     * @return
     */
    @ResponseBody
    @RequestMapping("spike")
    public Message spike(String phone,String code) {
        Message message = new Message();
        try {
            boolean peservations = peservationService.getspike(phone,code);
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

    /**
     * 已到达
     * @return
     */
      @Autowired
      private TaskService taskService;

    @ResponseBody
    @RequestMapping("arrive")
    public Message arrive(String code,String serial) {
        Message message = new Message();
        try {
            taskService.getarrive(code,serial);
            message.setCode(ErrorCode.SUCCEED.getCode());
            message.setDesc(ErrorCode.SUCCEED.getDesc());
        } catch (Exception e) {
            message.setCode(ErrorCode.FAIL.getCode());
            message.setDesc(ErrorCode.FAIL.getDesc());
            StaticLogger.logger().error(message.getDesc(), e);
        }
        return message;
    }
}
