package com.example.demo.factory;

import com.example.demo.service.AutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class AutoServiceFactory {

    private final Map<AutoServiceType, AutoService> mapping;

    @Autowired
    public AutoServiceFactory(List<AutoService> autoServices) {
        this.mapping = autoServices.stream().collect(Collectors.toMap(AutoService::getType, Function.identity()));
    }

    public AutoService getService(AutoServiceType type) {
        log.info("LogInfo: " + this.getClass().getName() + " getService");
        return mapping.computeIfAbsent(type, key ->
        {
            log.error("LogError: " + this.getClass().getName() + " getService: - not found value for key");
            throw new IllegalArgumentException(this.getClass().getName() + " getService - not found value for key");
        });

    }
}
