package com.caogen.jfd.ces;


import com.caogen.jfd.common.StaticLogger;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import static com.caogen.jfd.ces.WebSocketMapUtil.subOnlineCount;
@ServerEndpoint(value = "/Web/{driverId}/{flag}",encoders = EncoderConvert.class)
public class WebSocketServer {
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    // ID
    private String driverId;
    //
    private String flag;


    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session, @PathParam("driverId") String driverId,@PathParam("flag") String flag) {
        this.session = session;
        this.driverId = driverId;
        this.flag = flag;
        StaticLogger.info("我连接成功了------"+driverId);
        WebSocketMapUtil.put(driverId,flag,this);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        WebSocketMapUtil.remove(driverId);
        subOnlineCount();           //在线数减1
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message) {
        StaticLogger.info("客户端发来了消息--------"+message);
        // 处理客户端心跳
        if("ping".equals(message)) {
            WebSocketMapUtil.heartbeat(driverId,flag);
            return;
        }
//        // 处理其他消息
        try {
            sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        StaticLogger.info("连接错误了-----------"+error.getMessage());
        error.printStackTrace();
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);

    }
}