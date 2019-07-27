package com.caogen.jfd.ces;




import com.google.gson.Gson;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;


public class EncoderConvert implements Encoder.Text<Msg> {

    @Override
    public void init(EndpointConfig endpointConfig) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(Msg msg) {
        return new Gson().toJson(msg);
    }


}