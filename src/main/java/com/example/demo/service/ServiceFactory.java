package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServiceFactory {

    @Autowired
    private final List<AutoService> serviceList;

    @Autowired
    private AutoServiceImpl autoService;

    @Autowired
    private JedisAutoServiceImpl jedisAutoService;

    @Autowired
    public ServiceFactory() {
        serviceList = Arrays.asList(autoService,jedisAutoService);
    }

    public AutoService getService(ServiceType type) {
        return serviceList.stream()
                .filter(service -> type.equals(service.getType()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public enum ServiceType {
        JERIS, STANDARD
    }
}
