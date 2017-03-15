package ${basepackagecore}.base;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.Date;

/***
 * JSON 序列化数据转化类
 */
public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {

        super();

        // 空值处理为空串
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {

            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeString("");
            }
        });

        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, new JsonSerializer<Long>() {
            @Override
            public void serialize(Long value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
                jgen.writeString(String.valueOf(value));
            }
        });
        module.addSerializer(Integer.class, new JsonSerializer<Integer>() {
            @Override
            public void serialize(Integer value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
                jgen.writeString(String.valueOf(value));
            }
        });
        module.addSerializer(Double.class, new JsonSerializer<Double>() {
            @Override
            public void serialize(Double value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
                jgen.writeString(String.valueOf(value));
            }
        });
        module.addSerializer(Short.class, new JsonSerializer<Short>() {
            @Override
            public void serialize(Short value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
                jgen.writeString(String.valueOf(value));
            }
        });
        module.addSerializer(Date.class, new JsonSerializer<Date>() {
            @Override
            public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
                jgen.writeString(String.valueOf(value.getTime()));
            }
        });
        this.registerModule(module);
    }
}