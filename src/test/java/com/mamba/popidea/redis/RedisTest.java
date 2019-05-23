package com.mamba.popidea.redis;

import com.mamba.popidea.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/22 11:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

     @Test
     public void add(){
         redisUtil.add("token","test",1000L);
     }
}