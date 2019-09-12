package com.example.demo.dto;

import lombok.Data;

@Data
public class AutoDTO implements BaseDTO {
    private long id;
    private String brand;
    private String model;
}
