package com.example.demo.config;

import com.example.demo.entity.AutoModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.embedded.RedisServer;


import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Configuration
public class InitialConfig {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;


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
    public RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHost, redisPort);
        redisStandaloneConfiguration.setPassword("");
        return redisStandaloneConfiguration;
    }

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(redisStandaloneConfiguration());
    }


    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisClientConfiguration clientConfig = JedisClientConfiguration
                .builder().build();
        return new JedisConnectionFactory(redisStandaloneConfiguration(), clientConfig);
    }

    @Bean
    public RedisTemplate<String, AutoModel> redisTemplate(RedisConnectionFactory jedisConnectionFactory) {
        final RedisTemplate<String, AutoModel> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        return redisTemplate;
    }
}