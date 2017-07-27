package com.hu.yang.baseskill_android.bean;

/**
 * Created by yanghu on 2017/7/26.
 */

public class Msg {
    /**
     * 信息类型，1：接收到的信息，2：发送的信息
     */
    private int type;
    /**
     * 发件人号码
     */
    private String address;
    /**
     * 消息内容
     */
    private String body;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "type=" + type +
                ", address='" + address + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
