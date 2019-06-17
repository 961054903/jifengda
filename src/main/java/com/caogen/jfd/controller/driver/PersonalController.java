package com.caogen.jfd.controller.driver;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.driver.*;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.driver.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * 累计今天
     * @return
     */
    @Autowired
    private TodayService todayService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private TimeService timeService;

    @ResponseBody
    @RequestMapping("cumulative")
    public Message cumulative(String phone) {
        Message message = new Message();
        try {
            Personal cities = personalService.getset(phone);
            Today today = todayService.gettoday(phone);
             Order order = orderService.getorder(phone);
            Time time = timeService.gettime(phone);
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
