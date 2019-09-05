package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ServiceFactory {

    private final List<AutoService> serviceList;

    public AutoService getService(ServiceType type) {
        return serviceList.stream()
                .filter(service -> type.equals(service.getType()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
