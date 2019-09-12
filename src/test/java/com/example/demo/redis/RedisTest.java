package com.example.demo.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.embedded.RedisServer;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    private final RedisServer redis = mock(RedisServer.class);

    @Before
    public void setUp() {
        redis.start();
    }

    @Test
    public void test() {

    }

    @After
    public void tearDown() {
        redis.stop();
    }
}
