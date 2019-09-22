package com.example.demo.factory;

import com.example.demo.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class AutoServiceFactory {

    private final Map<AutoServiceType, AutoService> mapping;

    @Autowired
    public AutoServiceFactory(List<AutoService> autoServices) {
        this.mapping = autoServices.stream().collect(Collectors.toMap(AutoService::getType, Function.identity()));
    }

    public AutoService getService(AutoServiceType type) {
        return mapping.computeIfAbsent(type,
                k -> {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        return null;
                    }
                });

    }
}
