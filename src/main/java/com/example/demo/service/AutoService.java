package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;

import java.util.List;

public interface AutoService {
    AutoDTO create(AutoModel auto);

    AutoDTO update(AutoModel auto);

    boolean remove(long id);

    AutoModel select(long id);

    List list();
}
