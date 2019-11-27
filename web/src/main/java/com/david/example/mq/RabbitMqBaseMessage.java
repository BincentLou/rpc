package com.david.example.mq;

import java.io.Serializable;

/**
 * @version $Id: null.java, v 1.0 2019/9/11 3:44 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:rabbitMq 消息基础类
 * @since 1.0
 **/
public class  RabbitMqBaseMessage<T extends Serializable> implements Serializable {

    private static volatile int count = 0;

    private static final long serialVersionUID = -3785826785160020375L;
    private int id;

    private long timestamp;

    private T data;

    public T getData() {
        return data;
    }

    public RabbitMqBaseMessage<T> setData(T data) {
        this.data = data;
        return this;
    }

    public RabbitMqBaseMessage() {
        build();
    }

    private void build() {
        ++count;
        id = count;
        timestamp = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public RabbitMqBaseMessage setId(int id) {
        this.id = id;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public RabbitMqBaseMessage setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public RabbitMqBaseMessage(T data) {
        build();
        this.data = data;
    }
}
