package com.example.demo.entity;

import lombok.Value;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Value
@RedisHash("AutoModel")
public class AutoModel implements Serializable, BaseEntity {
    private final long id;
    private final String brand;
    private final String model;
}
