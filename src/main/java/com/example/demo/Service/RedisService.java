package com.example.demo.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.redis.Prefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {
    @Autowired
    private JedisPool jedisPool;
    public <T> T get(Prefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            String value = jedis.get(realKey);
            T t = stringToBean(value, clazz);
            return t;
        } finally {
            jedis.close();
        }
    }
    public <T> boolean set(Prefix prefix, String key, T value) {
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String str=beanToString(value);
            if (str==null)
                return false;
            String realKey=prefix.getPrefix()+key;
            int seconds = prefix.expireSeconds();
            if (seconds<=0){
                jedis.set(realKey,str);
            } else {
                jedis.setex(realKey, seconds, str);
            }
            return true;
        } finally {
            jedis.close();
        }
    }

    private <T> String beanToString(T value) {
        if (value==null)
            return null;
        Class<?> clazz = value.getClass();
        if (clazz==int.class||clazz==Integer.class||clazz==long.class||clazz==Long.class||clazz==String.class){
            return value.toString();
        }else {
            return JSON.toJSONString(value);
        }
    }
    private <T> T stringToBean(String value, Class<T> clazz) {
        if (value==null||value.length()==0||clazz==null)
            return null;
        if (clazz==int.class||clazz==Integer.class){
            return (T)Integer.valueOf(value);
        }else if (clazz==long.class||clazz==Long.class){
            return (T) Long.valueOf(value);
        }else if(clazz==String.class){
            return (T) value;
        }else
            return JSON.toJavaObject(JSON.parseObject(value),clazz);
    }
}
