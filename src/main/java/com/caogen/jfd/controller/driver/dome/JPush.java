package com.caogen.jfd.controller.driver.dome;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import com.caogen.jfd.entity.driver.Peservation;

import java.util.List;
import java.util.Map;

public class JPush {
    private static String APP_KEY = "2f7bd160b5c947f95012ba8e";
private static String MASTER_SECRET = "d83374c1a5ab9fba6bc1deec";

    //极光推送>>Android
    //Map<String, String> parm是我自己传过来的参数,同学们可以自定义参数
    public static void jpushAndroid(List<Peservation> parm) {

        //创建JPushClient(极光推送的实例)
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        //推送的关键,构造一个payload
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android())//指定android平台的用户
                .setAudience(Audience.all())//你项目中的所有用户
               // .setAudience(Audience.registrationId(parm.get("id")))//registrationId指定用户
            //.setNotification(Notification.android(parm., "这是title",parm))
                //发送内容
                .setOptions(Options.newBuilder().setApnsProduction(false).build())
                //这里是指定开发环境,不用设置也没关系
               //
                // .setMessage(Message.content(parm.get(0))//自定义信息
                .setMessage(Message.content(String.valueOf(parm.get(0))))
                .build();

        try {
            PushResult pu = jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }
}

