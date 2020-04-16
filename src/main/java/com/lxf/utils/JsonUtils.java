package com.lxf.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * JSON 工具类
 */
public class JsonUtils {
  private static final JsonParser jsonParser = new JsonParser();
  static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

  /**
   * 将目标对象转化成 JSON 串
   *
   * @param src 目标对象
   * @return String JSON 串
   */
  public static String toJson(Object src) {
    if (src == null) {
      return "";
    }
    return gson.toJson(src);
  }

  /**
   * 将 JSON 串转化成目标对象
   *
   * @param json     能够产生 JSON 串的 Reader
   * @param classOfT 目标对象类型
   * @return T 目标对象
   */
  public static <T> T fromJson(Reader json, Class<T> classOfT) {
    T r = null;
    try {
      r = gson.fromJson(json, classOfT);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return r;
  }

  /**
   * 将 JSON 串转化成目标对象
   *
   * @param json 能够产生 JSON 串的 Reader
   * @return T 目标对象
   */
  public static <T> T fromJson(Reader json, Type typeOfT) {
    T r = null;
    try {
      r = gson.fromJson(json, typeOfT);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return r;
  }

  /**
   * 将 JSON 串转化成目标对象（默认UTF-8）
   *
   * @param json     JSON 串
   * @param classOfT 目标对象类型
   * @return T 目标对象
   */
  public static <T> T fromJson(String json, Class<T> classOfT) {
    Charset charset = Charset.forName("UTF-8");
    return fromJson(json, classOfT, charset);
  }


  /**
   * 将 JSON 串转化成目标对象
   *
   * @param json JSON 串
   * @return T 目标对象
   * <p>
   * Type 反射
   */
  public static <T> T fromJsonToList(String json, Type typeOfT) {
    if (StringUtils.isBlank(json)) {
      return null;
    }
    Charset charset = Charset.forName("UTF-8");
    InputStream in = new ByteArrayInputStream(json.getBytes(charset));
    Reader reader = new InputStreamReader(in, charset);
    return fromJson(reader, typeOfT);
  }

  /**
   * 将 JSON 串转化成目标对象
   *
   * @param json     JSON 串
   * @param classOfT 目标对象类型
   * @param charset  编码
   * @return T 目标对象
   */
  public static <T> T fromJson(String json, Class<T> classOfT, Charset charset) {
    if (StringUtils.isBlank(json)) {
      return null;
    }
    InputStream in = new ByteArrayInputStream(json.getBytes(charset));
    Reader reader = new InputStreamReader(in, charset);
    return fromJson(reader, classOfT);
  }

  /**
   * 将JSON串转化成Map对象
   *
   * @param json Json字符串
   * @return 返回解析后的Map对象(不为null)
   */
  public static Map<String, Object> fromJson(String json) {

    Type type = new TypeToken<Map<String, Object>>() {
    }.getType();
    Map<String, Object> map = gson.fromJson(json, type);

    return map;
  }

  /**
   * 将JSON串转化成Map对象
   *
   * @param json Json字符串
   * @return 返回解析后的Map对象
   */
  @SuppressWarnings("unchecked")
  public static Map<String, String> fromJsonMap(String json) {

    Type type = new TypeToken<Map<String, Object>>() {
    }.getType();
    return gson.fromJson(json, type);
  }

  /**
   * 解析没有数据头的纯数组
   */
  public static JsonArray parseNoHeaderJArray(String json) {
    if (StringUtils.isBlank(json) || "null".equals(json)) {
      return null;
    }
    JsonArray jsonArray = null;
    if (StringUtils.isNotBlank(json)) {
      jsonArray = jsonParser.parse(json).getAsJsonArray();
    }
    return jsonArray;
  }

}
