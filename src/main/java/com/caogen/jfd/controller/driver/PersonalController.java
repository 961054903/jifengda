package com.caogen.jfd.controller.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.Complete;
import com.caogen.jfd.entity.driver.Personal;
import com.caogen.jfd.entity.driver.Peservation;
import com.caogen.jfd.entity.driver.Task;
import com.caogen.jfd.entity.driver.Time;
import com.caogen.jfd.entity.driver.User;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.driver.AppDriverService;
import com.caogen.jfd.service.driver.CompleteService;
import com.caogen.jfd.service.driver.DetaiService;
import com.caogen.jfd.service.driver.ModelService;
import com.caogen.jfd.service.driver.PersonalService;
import com.caogen.jfd.service.driver.PeservationService;
import com.caogen.jfd.service.driver.RoyaltyService;
import com.caogen.jfd.service.driver.TaskService;
import com.caogen.jfd.service.driver.TimeService;
import com.caogen.jfd.service.driver.UserService;

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
            Map<String,Object> appDrivers = new HashMap<>();
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
    @RequestMapping(value = {"details","app/details"})
    public Message details(Message data) {
        Message message = new Message();
        try {
            Peservation appDriver = Constants.gson.fromJson((String) data.getData(),Peservation.class);
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            User user = userService.getuser(appDriver.getCode());
            Peservation peservation = peservationService.getma(appDriver.getCode());
            Map<String,Object> appDrivers = new HashMap<>();
            appDrivers.put("user",user);
            appDrivers.put("order",peservation);
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
             Complete appDriver = Constants.gson.fromJson((String)data.getData(),Complete.class);
            List <Complete> peservation = completeService.getto(driver.getId());
            String cc = detaiService.getime(driver.getId());
            int size = peservation.size();
        Double aa =0.0;
    for(int i = 0;i<peservation.size();i++){
        Double ss = peservation.get(i).getBonus();
        aa += ss;
    }
      Map<String,Object> appDrivers = new HashMap<>();
       appDrivers.put("order",size);
       if (cc==null){
           appDrivers.put("time",0);

       }else {
           appDrivers.put("time",cc);
       }
       appDrivers.put("royalty",aa);
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
            Complete appDriver = Constants.gson.fromJson((String)data.getData(),Complete.class);
            List <Complete> peservation = completeService.getmon(driver.getId());
            Double aa =0.0;
            for(int i = 0;i<peservation.size();i++){
                Double ss = peservation.get(i).getBonus();
                aa += ss;
            }
            int size = peservation.size();
            Map<String,Object> appDrivers = new HashMap<>();
            appDrivers.put("order",size);
            appDrivers.put("royalty",aa);
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
            Double aa =0.0;
            for(int i = 0;i<completes.size();i++){
                Double ss = completes.get(i).getBonus();
                aa += ss;
            }
            int size = completes.size();
            Map<String,Object>qq =new HashMap<>();
             qq.put("royalty",aa);
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

//    /**
//     * 推送
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping("push")
//    public Message push() {
//        Message message = new Message();
//        try {
//            peservationService.getput();
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
     * 抢单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"spike","app/spike"})
    public Message spike(Message data) {
        Message message = new Message();
        try {
            AppDriver driver =appDriverService.getByToken(data.getDesc());
            Peservation appDriver = Constants.gson.fromJson((String) data.getData(),Peservation.class);
            boolean peservations = peservationService.getspike(driver.getId(),appDriver.getCode());
            if (peservations){
                peservationService.getfenjie(appDriver.getCode());
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
