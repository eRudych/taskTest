package com.example.demo.entity;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Builder
@Value
public class AutoModel implements Serializable  {
    private final long id;
    private final String brand;
    private final String model;
}
