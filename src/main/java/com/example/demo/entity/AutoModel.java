package com.example.demo.entity;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Builder
@Value
@RedisHash("AutoModel")
public class AutoModel implements Serializable  {
    private final long id;
    private final String brand;
    private final String model;
}
