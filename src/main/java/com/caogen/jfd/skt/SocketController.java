//package com.caogen.jfd.skt;
//
//
//import com.caogen.jfd.model.Message;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.socket.TextMessage;
//
//
//@Controller
//public class SocketController {
//
//    //注入发送消息的Handler类
//    private MyHandler myHandler =new MyHandler();
//
//    @RequestMapping("/sendMessage")
//    @ResponseBody
//    public Message sendMessage(String messageText){
//        TextMessage textMessage = new TextMessage(messageText);
//        boolean hasSend = myHandler.sendMessageToAllUsers(textMessage);
//        System.out.println(hasSend);
//        Message message = new Message();
//        if (hasSend) {
//            message.setDesc("接收成功");
//        }else{
//            message.setDesc("接收失败");
//        }
//        return message;
//    }
//}
