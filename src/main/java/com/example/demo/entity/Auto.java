package com.example.demo.entity;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Builder
@Value
public class Auto implements Serializable {
    private final int id;
    private final String brand;
    private final String model;
}
