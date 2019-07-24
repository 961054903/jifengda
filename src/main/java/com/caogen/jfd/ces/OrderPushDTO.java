package com.caogen.jfd.ces;


import java.util.Map;
public class OrderPushDTO {
    /** 订单明细 */
    private  Map<String, String> message;
    /** 推送时间 */
    private  Long time;

    public Map<String, String> getMessage() {
        return message;
    }

    public void setMessage(Map<String, String> message) {
        this.message = message;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
