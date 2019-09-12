package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;
import com.example.demo.exception.ValueNotFoundException;
import com.example.demo.factory.AutoServiceType;
import com.example.demo.mapper.AutoMapper;
import com.example.demo.repository.JedisAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
@EnableAutoConfiguration
public class JedisAutoServiceImpl implements AutoService {

    private final JedisAutoRepository repository;
    private final AutoMapper mapper;

    @Autowired
    public JedisAutoServiceImpl(JedisAutoRepository repository, AutoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AutoServiceType getType() {
        return AutoServiceType.JEDIS;
    }

    @Override
    public AutoDTO create(AutoModel auto) {
        long autoId = repository.save(auto).getId();
        return get(autoId);
    }

    @Override
    public AutoDTO update(AutoModel auto) {
        return create(auto);
    }

    @Override
    public void remove(long id) {
        repository.deleteById(Long.toString(id));
    }


    @Override
    public AutoDTO get(long id) {
        AutoDTO autoDTO = null;
        try {
            autoDTO = mapper.toDto(repository.findById(Long.toString(id)).orElseThrow(new ValueNotFoundException()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return autoDTO;
    }

    @Override
    public List<AutoDTO> getAll() {
        LinkedList<AutoDTO> autoDTOS = new LinkedList<>();
        for (AutoModel autoModel : repository.findAll()) autoDTOS.add(mapper.toDto(autoModel));
        return autoDTOS;
    }
}
