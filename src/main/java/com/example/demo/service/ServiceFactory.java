package com.example.demo.service;

public class ServiceFactory {

    public static AutoService getService(String service) {
        return service.equals("jedis") ? new JedisAutoServiceImpl() : new AutoServiceImpl();
    }
}
