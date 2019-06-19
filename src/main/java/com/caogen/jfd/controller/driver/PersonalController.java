package com.caogen.jfd.controller.driver;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.driver.*;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.driver.*;
import com.caogen.jfd.service.user.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("upAndDown")
    public Message upAndDown(String phone) {
        Message message = new Message();
        try {
            Personal cities = personalService.getss(phone);
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
    @RequestMapping("state")
    public Message state(Boolean is_online, String phone)  {
        Message message = new Message();
        try {
             personalService.getstate(is_online,phone);
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
    @RequestMapping("information")
    public Message information(String phone)  {
        Message message = new Message();
        try {
            Personal cities = personalService.getmany(phone);
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
    @RequestMapping("whole")
    public Message whole(String phone)  {
        Message message = new Message();
        try {
            Personal cities = personalService.getwhole(phone);
            Model vehicle = modelService.getvehicle(phone);
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
     * @param cities
     * @return
     */
    @ResponseBody
    @RequestMapping("edit")
    public Message edit(Personal cities) {
        Message message = new Message();
        try {
            personalService.getmodify(cities);
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
    private PeservationService reservationService;

    @ResponseBody
    @RequestMapping("make")
    public Message make(String phone,Peservation.Mode mode) {

        Message message = new Message();
        try {
           List <Peservation> personals = reservationService.getmake(phone,mode);
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
    @RequestMapping("details")
    public Message details(String code) {
        Message message = new Message();
        try {
            User user = userService.getuser(code);
            Peservation peservation = reservationService.getma(code);
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
    @RequestMapping("cout")
    public Message cout(String phone) {
        Message message = new Message();
        try {
            String cc = detaiService.getime(phone);
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
            List <Complete> completes = completeService.getmon(phone);
            Double aa =0.0;
            for(int i = 0;i<completes.size();i++){
                Double ss = completes.get(i).getBonus();
                aa += ss;
            }
            List<Object>ASD = new ArrayList<Object>( );
            ASD.add(aa);
            if (cc){
                ASD.add(completes);
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
}
