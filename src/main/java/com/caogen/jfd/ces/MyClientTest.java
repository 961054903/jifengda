package com.caogen.jfd.ces;

public class MyClientTest {
    private static WebSocketClient client = null;
    public static void main(String [] args){
        try {
            client = new WebSocketClient();
            String uri = "ws://192.168.1.181:8080/web/3";
            client.start(uri);
           for (int i = 0; i < 2000000000; i++) {
                Thread.sleep(1000000);
                client.sendMessage("模板消息测试");
           }
            client.closeSocket();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
