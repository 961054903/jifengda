package com.caogen.jfd.ces;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;



@ServerEndpoint(value = "/Web/{driverId}",encoders = EncoderConvert.class)
public class WebSocketServer {
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的
     */
    private static int onlineCount = 0;
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识*
     */
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    /**
     * 用于存放有效的Session ID
     */
    private static CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
    /**
     * 连接建立成功调用的方法
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     * @throws Exception
     */
    @OnOpen
    public void onOpen(@PathParam("driverId") String driverId, Session session) throws Exception {
        this.session = session;
        System.out.println("driver id:" + driverId);
        WebSocketMapUtil.put(driverId, this);
        webSocketSet.add(this);
        set.add(driverId);
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    /**
     *
     * 连接关闭调用的方法
     *
     * @throws Exception
     */
    @OnClose
    public void onClose() throws Exception {
        //从中删除
        webSocketSet.remove(this);
        set.add(session.getId());
        WebSocketMapUtil.remove(this.session.getId());
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }
    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message,@PathParam("driverId") String driverId) throws IOException, EncodeException {
        System.out.println("来自客户端的消息:" + message);
        if (message.equals("ping")){
             set.add(driverId);

        }else {
        }
    }

    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 发送消息方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        System.out.println("fasongxiaoxi");
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 发送消息方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(Object message) throws IOException, EncodeException {
        this.session.getBasicRemote().sendObject(message);
    }

    /**
     * 群发消息方法。
     *
     * @param message
     * @throws IOException
     */
    public static void sendMessageAll(Map<String,Object> message) throws IOException {
        //循环发送
        for (WebSocketServer item : webSocketSet) {
            try {
                //查询Service
                String msg = "{title: '消息通知',text: '" + message + "'}";
                item.sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }


    public void name() {
        System.out.println("这个方法执行了---------------------------------------");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 迭代WebSocketSet 如果里面的对象Session ID不存在于有效的Set里,则删除
                Iterator<WebSocketServer> it = webSocketSet.iterator();
                while (it.hasNext()) {
                    WebSocketServer next = it.next();
                    if(!set.contains(next.session.getId())) {
                        it.remove();
                        WebSocketMapUtil.remove(next.session.getId());
                        subOnlineCount();           //在线数减1
                    }
                }
                // 清空有效Set
                set.clear();
            }
        }, 5000 );
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

}