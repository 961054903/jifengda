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
    @Autowired
    private AppDriverService appDriverService;

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
            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
            Personal cities = personalService.getss(appDriver.getPhone());
            message.setData(cities.getIs_online(),driver.getDes_key(),driver.getDes_iv());
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
            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
            Personal cities = personalService.getmany(appDriver.getPhone());
            message.setData(cities,driver.getDes_key(),driver.getDes_iv());
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
            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
            Personal cities = personalService.getwhole(appDriver.getPhone());
            Model vehicle = modelService.getvehicle(appDriver.getPhone());
            List<Object>ASD = new ArrayList<Object>( );
            ASD.add(cities);
            ASD.add(vehicle);
            message.setData(ASD,driver.getDes_key(),driver.getDes_iv());
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
            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
           List <Peservation> personals = peservationService.getmake(appDriver.getPhone(),appDriver.getMode());
            message.setData(personals,driver.getDes_key(),driver.getDes_iv());
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
            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
            User user = userService.getuser(appDriver.getCode());
            Peservation peservation = peservationService.getma(appDriver.getCode());
            System.out.println(peservation);
            List<Object>ASD = new ArrayList<Object>( );
            ASD.add(user);
            ASD.add(peservation);
            message.setData(ASD,driver.getDes_key(),driver.getDes_iv());
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
            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
            String cc = detaiService.getime(appDriver.getPhone());
            message.setData(cc,driver.getDes_key(),driver.getDes_iv());
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
    @RequestMapping(value = {"cumulative","app/cumulative"})
    public Message cumulative(String data) {
        Message message = new Message();
        try {
            Time appDriver = Constants.gson.fromJson(data,Time.class);
            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
            Time cc = timeService.gettime(appDriver.getPhone(),appDriver.getTim());
            message.setData(cc,driver.getDes_key(),driver.getDes_iv());
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
    @RequestMapping(value = {"royalty","app/royalty"})
    public Message royalty(String data) {
        Message message = new Message();
        try {
            Complete appDriver = Constants.gson.fromJson(data,Complete.class);
            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
        List <Complete> peservation = completeService.getto(appDriver.getPhone());
        Double aa =0.0;
    for(int i = 0;i<peservation.size();i++){
        Double ss = peservation.get(i).getBonus();
        aa += ss;
    }
        List<Object>ASD = new ArrayList<Object>( );
        ASD.add(aa);
        if (appDriver.getAa()){
            ASD.add(peservation);
        }
        message.setData(ASD,driver.getDes_key(),driver.getDes_iv());
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
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"receipt","app/receipt"})
    public Message receipt(String data) {
        Message message = new Message();
        try {
            Complete appDriver = Constants.gson.fromJson(data,Complete.class);
            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
            List <Complete> peservation = completeService.getto(appDriver.getPhone());
            int size = peservation.size();
            List<Object>ASD = new ArrayList<Object>( );
            ASD.add(size);
            if (appDriver.getAa()){
                ASD.add(peservation);
            }
            message.setData(ASD,driver.getDes_key(),driver.getDes_iv());
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
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"month","app/month"})
    public Message month(String data) {
        Message message = new Message();
        try {
            Complete appDriver = Constants.gson.fromJson(data,Complete.class);
            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
            List <Complete> peservation = completeService.getmon(appDriver.getPhone());
            int size = peservation.size();
            List<Object>ASD = new ArrayList<Object>( );
            ASD.add(size);
            if (appDriver.getAa()){
                ASD.add(peservation);
            }
            message.setData(ASD,driver.getDes_key(),driver.getDes_iv());
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
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"mont","app/mont"})
    public Message mont(String data){
        Message message = new Message();
        try {
            Complete appDriver = Constants.gson.fromJson(data,Complete.class);
            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
            List <Complete> peservation = completeService.getmon(appDriver.getPhone());
            Double aa =0.0;
            for(int i = 0;i<peservation.size();i++){
                Double ss = peservation.get(i).getBonus();
                aa += ss;
            }
            List<Object>ASD = new ArrayList<Object>( );
            ASD.add(aa);
            if (appDriver.getAa()){
                ASD.add(peservation);
            }
            message.setData(ASD,driver.getDes_key(),driver.getDes_iv());
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
    @RequestMapping(value = {"history","app/history"})
    public Message history(String data) {
        Message message = new Message();
        try {
            Complete appDriver = Constants.gson.fromJson(data,Complete.class);
            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
          List <Complete> completes = completeService.gethistory(appDriver.getPhone(),appDriver.getStart(),appDriver.getEnd());
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
            message.setData(ASD,driver.getDes_key(),driver.getDes_iv());
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
    @RequestMapping(value = {"spike","app/spike"})
    public Message spike(String data) {
        Message message = new Message();
        try {
            Peservation appDriver = Constants.gson.fromJson(data,Peservation.class);
            AppDriver driver =appDriverService.getByPhone(appDriver.getPhone());
            boolean peservations = peservationService.getspike(appDriver.getPhone(),appDriver.getCode());
            if (peservations){
                peservationService.getfenjie(appDriver.getCode());
            }
            message.setData(peservations,driver.getDes_key(),driver.getDes_iv());
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
    @RequestMapping(value = {"arrive","app/arrive"})
    public Message arrive(String data) {
        Message message = new Message();
        try {
            Task appDriver = Constants.gson.fromJson(data,Task.class);
            taskService.getarrive(appDriver.getCode(),appDriver.getSerial());
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
     * 配送中
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"peisong","app/peisong"})
    public Message peisong(String data) {
        Message message = new Message();
        try {
            Task appDriver = Constants.gson.fromJson(data,Task.class);
            taskService.getpei(appDriver.getCode(),appDriver.getSerial());
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
     * 已送达
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"da","app/da"})
    public Message da(String data) {
        Message message = new Message();
        try {
            Task appDriver = Constants.gson.fromJson(data,Task.class);
            taskService.getda(appDriver.getCode(),appDriver.getSerial());
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
     * 存入历史
     */
    @ResponseBody
    @RequestMapping("cunru")
    public Message cunru(String phone ,String code) {
        Message message = new Message();
        try {
             peservationService.gettake(phone,code);
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
