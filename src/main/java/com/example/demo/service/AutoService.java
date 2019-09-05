package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;

import java.util.List;

public interface AutoService {

    ServiceType getType();

    AutoDTO create(AutoModel auto);

    AutoDTO update(AutoModel auto);

    void remove(long id);

    AutoDTO get(long id);

    List list();
}
