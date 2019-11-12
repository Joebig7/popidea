package com.mamba.popidea.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/22 10:58
 */
@Component
public class RedisUtil {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public void incrementForHash(String key, Object hashKey) {
        stringRedisTemplate.opsForHash().increment(key, hashKey + "", 1L);
    }


    public void decrementForHash(String key, Object hashKey) {
        stringRedisTemplate.opsForHash().increment(key, hashKey + "", -1L);
    }

    public Long getCountForHash(String key, Object hashKey) {
        Object value = stringRedisTemplate.opsForHash().get(key, hashKey + "");
        if (value == null) {
            return null;
        }
        return Long.parseLong(String.valueOf(value));
    }

    /**
     * 添加key value
     */
    public void add(String key, String value, Long expireTime) {
        stringRedisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.MINUTES);
    }

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public boolean isKeyExist(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    public Boolean delete(String key) {
        return stringRedisTemplate.delete(key);
    }

}