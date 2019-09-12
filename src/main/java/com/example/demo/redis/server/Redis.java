package com.example.demo.redis.server;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@RequiredArgsConstructor
public class Redis {

    private final RedisServer redisServer;

    @PostConstruct
    public void start() {
        if (!redisServer.isActive()) redisServer.start();
    }

    @PreDestroy
    public void stop() {
        redisServer.stop();
    }
}
