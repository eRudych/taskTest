package com.example.demo.service;

import com.example.demo.factory.AutoServiceType;
import com.example.demo.mapper.AutoMapper;
import com.example.demo.repository.JedisAutoRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class JedisAutoServiceImpl extends AbstractAutoService {

    public JedisAutoServiceImpl(JedisAutoRepositoryImpl repository, AutoMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public AutoServiceType getType() {
        return AutoServiceType.JEDIS;
    }

}
