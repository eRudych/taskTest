package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;
import com.example.demo.factory.AutoServiceType;
import com.example.demo.mapper.AutoMapper;
import com.example.demo.repository.AutoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.LinkedList;
import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    private final AutoRepositoryImpl repository;
    private final AutoMapper mapper;

    @Autowired
    public AutoServiceImpl(AutoRepositoryImpl repository, AutoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AutoServiceType getType() {
        return AutoServiceType.STANDARD;
    }

    @Override
    @Transactional
    public AutoDTO create(AutoModel auto) {
        return mapper.toDto(repository.create(auto));
    }

    @Override
    @Transactional
    public AutoDTO update(AutoModel auto) {
        repository.update(auto);
        return get(auto.getId());
    }

    @Override
    @Transactional
    public void remove(long id) {
        repository.delete(id);
    }

    @Override
    public AutoDTO get(long id) {
        return mapper.toDto(repository.selectById(id));
    }

    @Override
    public List<AutoDTO> getAll() {
        List<AutoDTO> autoDTOS = new LinkedList<>();
        for (AutoModel autoModel : repository.selectAll()) autoDTOS.add(mapper.toDto(autoModel));
        return autoDTOS;
    }
}
