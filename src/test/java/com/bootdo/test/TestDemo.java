package com.bootdo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: TestDemo</p>
 * <p>Description: TestDemo</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@RestController()
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test() {
        redisTemplate.opsForValue().set("aaacc", "b123中aaabbccc很好");
        System.out.println(redisTemplate.opsForValue().get("aaacc"));
    }
}
