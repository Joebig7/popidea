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


    public void incrementForHash(String key, Long hashKey) {
        stringRedisTemplate.opsForHash().increment(key, hashKey, 1L);
    }


    public void decrementForHash(String key, Long hashKey) {
        stringRedisTemplate.opsForHash().increment(key, hashKey, -1L);
    }

    public long getCountForHash(String key, Long hashKey) {
        return (Long) stringRedisTemplate.opsForHash().get(key, hashKey);
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