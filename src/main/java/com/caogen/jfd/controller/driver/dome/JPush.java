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
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.caogen.jfd.entity.driver.Peservation;

import java.util.List;
import java.util.Map;

public class JPush {
    private static String APP_KEY = "d8bb17e6c576a7419f6d8b34";
private static String MASTER_SECRET = "9beeb2ac891b19d90ed9ed20";
    //极光推送>>Android
    //Map<String, String> parm是我自己传过来的参数,同学们可以自定义参数
    public static void jpushAndroid(Map<String,String> wt) {

        //创建JPushClient(极光推送的实例)
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        //推送的关键,构造一个payload
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android())//指定android平台的用户
                .setAudience(Audience.all())//你项目中的所有用户
                //.setAudience(Audience.registrationId(parm.get("id")))//registrationId指定用户
                .setNotification(Notification.android(wt.get("id"), "这是title", wt))
                //发送内容
                .setOptions(Options.newBuilder().setApnsProduction(false).build())
                //这里是指定开发环境,不用设置也没关系
                .setMessage(Message.content(wt.get("id")))//自定义信息
                .build();

        try {
            PushResult pu = jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }
    //极光推送>>ios
    //Map<String, String> parm是我自己传过来的参数,同学们可以自定义参数
    public static  void jpushIOS(Map<String, String> wt) {

        //创建JPushClient
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.ios())//ios平台的用户
                .setAudience(Audience.all())//所有用户
                //.setAudience(Audience.registrationId(parm.get("id")))//registrationId指定用户
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(wt.get("id"))
                                .setBadge(+1)
                                .setSound("happy")//这里是设置提示音(更多可以去官网看看)
                                .addExtras(wt)
                                .build())
                        .build())
                .setOptions(Options.newBuilder().setApnsProduction(false).build())
                .setMessage(Message.newBuilder().setMsgContent(wt.get("id")).addExtras(wt).build())//自定义信息
                .build();

        try {
            PushResult pu = jpushClient.sendPush(payload);

        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }
    //极光推送>>All所有平台
    public static void jpushAll(Map<String, String> wt) {

        //创建JPushClient
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        //创建option
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.all())  //所有平台的用户
               // .setAudience(Audience.registrationId(wt.get("id")))//registrationId指定用户
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder() //发送ios
                                .setAlert(wt.get("id")) //消息体
                                .setBadge(+1)
                                .setSound("happy") //ios提示音
                                .addExtras(wt) //附加参数
                                .build())
                        .addPlatformNotification(AndroidNotification.newBuilder() //发送android
                                .addExtras(wt) //附加参数
                                .setAlert(wt.get("id")) //消息体
                                .build())
                        .build())
                .setOptions(Options.newBuilder().setApnsProduction(true).build())//指定开发环境 true为生产模式 false 为测试模式 (android不区分模式,ios区分模式)
                .setMessage(Message.newBuilder().setMsgContent(wt.get("id")).addExtras(wt).build())//自定义信息
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


