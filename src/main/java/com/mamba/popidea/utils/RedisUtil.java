package com.mamba.popidea.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static com.mamba.popidea.conf.constant.StaticConstant.*;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/22 10:58
 */
@Component
public class RedisUtil {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
        return stringRedisTemplate.keys(key) != null;
    }

    public Boolean delete(String key) {
        return stringRedisTemplate.delete(key);
    }

    public void expireKey(String key) {
        stringRedisTemplate.expire(key, LOGIN_EXPIRE_TIME, TimeUnit.MINUTES);
    }
}