package com.david.example.springMvc.serilizabe;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.core.serializer.DefaultSerializer;

import java.io.IOException;

/**
 * @version $Id: null.java, v 1.0 2019/9/2 5:08 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:序列化
 * @since 1.0
 **/
public class ExampleSerializer extends JsonObjectSerializer {
    @Override
    protected void serializeObject(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {

    }
}
