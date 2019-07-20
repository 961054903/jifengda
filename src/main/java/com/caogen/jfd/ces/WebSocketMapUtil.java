package com.caogen.jfd.ces;

import javax.jms.Session;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;


public class WebSocketMapUtil {
    private static ConcurrentMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    // 用于存放有效的连接ID
    private static CopyOnWriteArraySet<String> effectiveSet = new CopyOnWriteArraySet<>();
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    public static void put(String key, WebSocketServer myWebSocket){
        webSocketMap.put(key, myWebSocket);
        heartbeat(key);
        addOnlineCount();
    }

    public static WebSocketServer get(String key){
        return webSocketMap.get(key);
    }

    public static void remove(String key){
        webSocketMap.remove(key);
        subOnlineCount();
    }

    public static Collection<WebSocketServer> getValues(){
        return webSocketMap.values();
    }

    public static  void heartbeat(String key) {
        effectiveSet.add(key);
    }

    public static void sendNewOrderMessage(Map<String,Object> message, String[] driver) throws IOException {
        System.out.println("-------------" + driver);
        //循环找出司机
        for (int i = 0; i <driver.length; i++) {
            String id = driver[i];
            //取出司机对象， 发送订单消息
            WebSocketServer obj = get(id);
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

    /**
     * 定时清除无效的连接(项目启动时调用)
     * 当有新连接加入或收到连接心跳,会往有效列表里存入ID
     * 当方法执行时,有效列表里没有这个连接,说明这个连接已经无效,删除掉
     * 方法执行后清空有效数据列表
     * 执行间隔需大于心跳间隔
     */
    public static void removeInvalid() {
        System.out.println("这个方法执行了---------------------------------------");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 迭代WebSocketSet 如果里面的对象ID不存在于有效的Set里,则删除
                Iterator<Map.Entry<String, WebSocketServer>> it = webSocketMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, WebSocketServer> next = it.next();
                    if(!effectiveSet.contains(next.getKey())) {
                        it.remove();
                        subOnlineCount();           //在线数减1
                    }
                }
                // 清空有效Set
                effectiveSet.clear();
            }
        }, 5000 );
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        onlineCount--;
    }
}