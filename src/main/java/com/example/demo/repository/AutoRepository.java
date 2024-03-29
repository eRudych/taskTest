package com.example.demo.repository;

import com.example.demo.entity.AutoModel;

import java.util.List;

public interface AutoRepository {

    AutoModel create(AutoModel autoModel);

    void update(AutoModel autoModel);

    void remove(long id);

    AutoModel get(long id);

    List<AutoModel> getAll();

}
