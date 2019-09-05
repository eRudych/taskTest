package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;
import com.example.demo.repositories.JedisAutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class JedisAutoServiceImpl implements AutoService {

    private final JedisAutoRepository repository;

    @Override
    public ServiceType getType() {
        return ServiceType.JEDIS;
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
        return AutoDTO.createAutoDTO(Objects.requireNonNull(repository.findById(Long.toString(id)).orElse(null)));
    }

    @Override
    public List list() {
        List list = new LinkedList<AutoModel>();
        for (AutoModel autoModel : repository.findAll()) list.add(autoModel);
        return list;
    }
}
