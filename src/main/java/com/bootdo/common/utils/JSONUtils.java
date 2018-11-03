package com.bootdo.common.utils;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: JSONUtils</p>
 * <p>Description: JSONUtils</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public class JSONUtils {

    /**
     * beanToJson Bean对象转JSON
     *
     * @param object           object
     * @param dataFormatString dataFormatString
     * @return String
     */
    public static String beanToJson(Object object, String dataFormatString) {
        if (object != null) {
            if (StringUtils.isEmpty(dataFormatString)) {
                return JSONObject.toJSONString(object);
            }
            return JSON.toJSONStringWithDateFormat(object, dataFormatString);
        } else {
            return null;
        }
    }

    /**
     * beanToJson Bean对象转JSON
     *
     * @param object object
     * @return String
     */
    public static String beanToJson(Object object) {
        if (object != null) {
            return JSON.toJSONString(object);
        } else {
            return null;
        }
    }

    /**
     * stringToJsonByFastjson String转JSON字符串
     *
     * @param key   key
     * @param value key
     * @return String
     */
    public static String stringToJsonByFastjson(String key, String value) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>(16);
        map.put(key, value);
        return beanToJson(map, null);
    }

    /**
     * jsonToBean 将json字符串转换成对象
     *
     * @param json  json
     * @param clazz clazz
     * @return Object
     */
    public static Object jsonToBean(String json, Object clazz) {
        if (StringUtils.isEmpty(json) || clazz == null) {
            return null;
        }
        return JSON.parseObject(json, clazz.getClass());
    }

    /**
     * jsonToMap json字符串转map
     *
     * @param json json
     * @return Map<String, Object>
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> jsonToMap(String json) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        return JSON.parseObject(json, Map.class);
    }
}
