package com.example.demo.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.embedded.RedisServer;


import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Configuration
public class InitialConfig {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.timeout}")
    private int redisTimeOut;

    @Value("${spring.redis.password}")
    private String redisPassword;

    @Value("${spring.redis.jedis.pool.max-active}")
    private int redisMaxActive;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int redisMaxIdle;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private int redisMinIdle;


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return mapper;
    }

    @Bean
    public RedisServer redisServer() {
        RedisServer.builder().reset();
        return RedisServer.builder().port(redisPort).setting("maxmemory 128M").build();
    }

    @Bean
    public Jedis jedis() {
        return new Jedis(redisHost, redisPort);
    }

    @Bean
    public JedisPool getJedisPool() {
        GenericObjectPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisMaxIdle);
        poolConfig.setMaxTotal(redisMaxActive + redisMaxIdle);
        poolConfig.setMinIdle(redisMinIdle);
        return new JedisPool(poolConfig, redisHost, redisPort, redisTimeOut);
    }

}