package com.caogen.jfd.ces;

public class Msg {
    /**
     * 消息名称
     */
    private String title;
    /**
     * 消息内容
     */
    private String text;

    public Msg() {
    }

    public Msg(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}