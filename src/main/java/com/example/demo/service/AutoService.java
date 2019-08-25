package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;

import java.util.Set;

public interface AutoService {
    AutoDTO create(AutoDTO autoDTO);

    AutoDTO update(AutoDTO autoDTO);

    boolean remove(int id);

    AutoModel select(int id);

    Set list();
}
