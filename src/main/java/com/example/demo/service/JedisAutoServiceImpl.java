package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;
import com.example.demo.repositories.JedisAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class JedisAutoServiceImpl implements AutoService {

    @Autowired
    private JedisAutoRepository repository;

    @Override
    public AutoDTO create(AutoModel auto) {
        repository.save(auto);
        return AutoDTO.createAutoDTO(select(auto.getId()));
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
    public AutoModel select(long id) {
        return repository.findById(Long.toString(id)).orElse(null);
    }

    @Override
    public List list() {
        List list=new LinkedList<AutoModel>();
         repository.findAll().forEach(list::add);
         return list;
    }
}
