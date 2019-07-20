package com.caogen.jfd.ces;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class WebSocketMapUtil {
    public static ConcurrentMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    public static void put(String key, WebSocketServer myWebSocket){

        webSocketMap.put(key, myWebSocket);
    }
    public static void add(String key, WebSocketServer myWebSocket){

        webSocketMap.put(key, myWebSocket);
    }

    public static WebSocketServer get(String key){
        return webSocketMap.get(key);
    }

    public static void remove(String key){
        webSocketMap.remove(key);
    }

    public static Collection<WebSocketServer> getValues(){
        return webSocketMap.values();
}
   public static void sendNewOrderMessage(Map<String,Object>message, String[]driver) throws IOException {
       System.out.println("-------------" + driver);
    //循环找出司机
    for (int i = 0; i <driver.length; i++) {
        String id = driver[i];
        //取出司机对象， 发送订单消息
        WebSocketServer obj = WebSocketMapUtil.get(id);
        System.out.println("WebSocketServer Object:" + obj);
        if (obj != null) {
            try {
                obj.sendMessage(message.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
}