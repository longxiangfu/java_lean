//package com.lxf.controllerAdvice;
//
//import com.alibaba.fastjson.serializer.JSONSerializer;
//import com.alibaba.fastjson.serializer.ObjectSerializer;
//import com.alibaba.fastjson.serializer.SerializeWriter;
//import org.bson.types.ObjectId;
//
//import java.io.IOException;
//import java.lang.reflect.Type;
//
//public class ObjectIdJsonSerializer implements ObjectSerializer {
//
//    @Override
//    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
//        SerializeWriter out = jsonSerializer.getWriter();
//        if (o == null) {
//            jsonSerializer.getWriter().writeNull();
//            return;
//        }
//        out.write("\"" + ((ObjectId) o).toString() + "\"");
//    }
//}
