package com.storage.config;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyCache {
    private final static Map<String,Object> map = new HashMap<>();
    private final static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    /**
     * 新增不过期缓存
     * @param key
     * @param data
     */
    public static void put(String key,Object data){
        put(key,data,-1l);
    }

    /**
     *
     * @param key
     * @param data
     * @param expire 毫秒数
     */
    public static void put(String key,Object data,long expire){
        put(key,data,expire,TimeUnit.MILLISECONDS);
    }

    /**
     *
     * @param key
     * @param data
     * @param expire 过期时间
     * @param timeUnit 时间单位
     */
    public static void put(String key, Object data, long expire, TimeUnit timeUnit){
        if(expire==0) throw new InvalidParameterException("超时时间不可为空");
        synchronized (MyCache.class){
            if(expire>0){
                executor.schedule(()->{
                    synchronized (MyCache.class){
                        map.remove(key);
                    }
                },expire,timeUnit);
            }
            map.put(key,data);
        }
    }
    public static Object get(String key){
        synchronized (MyCache.class){
            return map.get(key);
        }
    }


}
