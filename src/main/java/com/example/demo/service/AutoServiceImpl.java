package com.example.demo.service;

import com.example.demo.factory.AutoServiceType;
import com.example.demo.mapper.AutoMapper;

import com.example.demo.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AutoServiceImpl extends AbstractAutoService {
    public AutoServiceImpl(@Qualifier("autoRepositoryImpl") AutoRepository repository, AutoMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public AutoServiceType getType() {
        return AutoServiceType.STANDARD;
    }
}
