//package com.caogen.jfd.skt;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//import java.util.Timer;
//
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
///**
// * 处理类：Handler--建立连接，发送消息，关闭连接自动执行
// * @author 01
// *
// */
//public class MyHandler extends TextWebSocketHandler{
//
//    //在线用户列表
//    private static final Map<Integer, WebSocketSession> users;
//    private static final String DUN_ID = "dunId"; //用户标识
//    //类加载初始化一个map集合，存放用户的websocket对象
//    static{
//        users = new HashMap<Integer, WebSocketSession>();
//    }
//
//    /**
//     * 获取用户标识,获取websocekt对象的map集合
//     * @param session
//     * @return
//     */
//    private Integer getClientId(WebSocketSession session) {
//        try {
//            //获取存入websocket的userid
//            Integer clientId = (Integer) session.getAttributes().get(DUN_ID);
//            return clientId;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//
//    /**
//     * 成功建立连接触发的方法，
//     */
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        //取出拦截器放入的dunID，为当前的websoket绑定用户到map
//        Integer userId = getClientId(session);
//        System.out.println(userId+"：链接获得id");
//        if (userId != null) {
//            users.put(userId, session);
//            session.sendMessage(new TextMessage("成功建立socket连接"));
//            System.out.println(userId);
//            System.out.println(session);
//        }
//    }
//
//
//    /**
//     * 当接收到客户端浏览器后接收的方法
//     */
//    @Override
//    public void handleTextMessage(WebSocketSession session, TextMessage message) {
//        // ...
//        System.out.println(message.getPayload());
//        WebSocketMessage message1 = new TextMessage("server:"+message);
//        try {
//            session.sendMessage(message1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 发送信息给指定用户
//     * @param clientId
//     * @param message
//     * @return
//     * map中根据用户的id获取对应得websoket，发送信息
//     */
//    public boolean sendMessageToUser(Integer dunId, TextMessage message) {
//        //获取当前的
//        if (users.get(dunId) == null) return false;
//        WebSocketSession session = users.get(dunId);
//        System.out.println("sendMessage:" + session);
//        if (!session.isOpen()) return false;
//        try {
//            session.sendMessage(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 广播信息（发送给所有人）
//     * @param message
//     * @return
//     * 遍历出map中所有的websocket发送在线消息
//     */
//    public boolean sendMessageToAllUsers(TextMessage message) {
//
//        boolean allSendSuccess = true;
//        Set<Integer> dunIds = users.keySet();
//        WebSocketSession session = null;
//        for (
//                Integer dunId : dunIds)
//
//        {
//            try {
//                session = users.get(dunId);
//                if (session.isOpen()) {
//                    session.sendMessage(message);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//                allSendSuccess = false;
//            }
//        }
//
//        return allSendSuccess;
//
//    }
//
//
//
//    /**
//     * 当链接发生异常后触发的方法，关闭出错会话的连接，和删除在Map集合中的记录
//     */
//    @Override
//    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
//        //判断当前的链接是否在继续，关闭连接
//        if (session.isOpen()) {
//            session.close();
//        }
//        System.out.println("连接出错");
//        users.remove(getClientId(session));
//    }
//
//    /**
//     * 当链接关闭后触发的方法，连接已关闭，移除在Map集合中的记录。
//     */
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        System.out.println("连接已关闭：" + status); //当前的状态码，并删除存储在map中的websocket的链接对象
//        users.remove(getClientId(session));
//    }
//
//    @Override
//    public boolean supportsPartialMessages() {
//        return false;
//    }
//
//
//
//}
