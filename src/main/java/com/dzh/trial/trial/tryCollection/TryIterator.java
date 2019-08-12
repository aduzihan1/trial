package com.dzh.trial.trial.tryCollection;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.*;

public class TryIterator {
    private static List list = new ArrayList();

    static {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
    }

    public static void useIterator() {
        Iterator iterator = list.iterator();
        Field field = null;
        while (iterator.hasNext()) {

            try {
                field = iterator.getClass().getDeclaredField("cursor");
                field.setAccessible(true);
                System.out.println((Integer) field.get(iterator));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ("2".equals(iterator.next())) {
                iterator.remove();
            }
        }
        System.out.println(JSONObject.toJSONString(list));
    }

    public static void useForEach() {
        list.forEach(e -> {
            if ("2".equals(e))
                list.remove(e);
        });
        System.out.println(JSONObject.toJSONString(list));
    }

    //与迭代器的方式等价，但是remove操作并不一致
    public static void useStrengthenFor() {
        for (Object e : list) {
            if ("5".equals(e))
                list.remove(e);
        }
        System.out.println(JSONObject.toJSONString(list));
    }

    public static void compileStrenthenFor() {
        Iterator var0 = list.iterator();

        while(var0.hasNext()) {
            Object e = var0.next();
            if ("3".equals(e)) {
                list.remove(e);
            }
        }

        System.out.println(JSONObject.toJSONString(list));

    }

    public static void tryIterateMap() {
        Map<String, Integer> map = new HashMap();
        map.put("key1", 1);
        map.put("key2", 2);
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()));
        }
    }

    public static void main(String[] args) {
        tryIterateMap();
        String[] strArray = {"1", "2", "3"};
        Arrays.asList(strArray);
    }
}
