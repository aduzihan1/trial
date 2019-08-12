package com.dzh.trial.trial.utils;

import com.dzh.trial.trial.tryJPA.entity.User;
import org.junit.platform.commons.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityUtil {
    private static final String SET_METHOD_PREFIX = "set";

    public static void injectMapIntoEntity(Map map, Object entity) throws IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {
        Class clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            String fieldName = field.getName();
            if(map.containsKey(fieldName)) {
                Method setMethod = clazz.getMethod(getSetMethodName(fieldName), field.getType());
                setMethod.invoke(entity, map.get(fieldName));
            }
        }
    }


    private static String getSetMethodName(String fieldName) {
        StringBuilder setMethodNameBuilder = new StringBuilder();
        if(StringUtils.isNotBlank(fieldName)) {
            String[] strArr = fieldName.split("");
            for(int i = 0;i < strArr.length;i++) {
                String strToAppend = strArr[i];
                if(i == 0)
                    strToAppend = strToAppend.toUpperCase();
                setMethodNameBuilder.append(strToAppend);
            }
        }else {
            return null;
        }
        return SET_METHOD_PREFIX + setMethodNameBuilder.toString();
    }

    public static void tryFinally() {
        try {
            System.out.println(123);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(234);
        }
    }

    public static void main(String[] args) {
        tryFinally();
    }
}
