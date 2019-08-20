package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.Auto;

import java.util.Set;

public interface AutoService {
    AutoDTO create(AutoDTO autoDTO);

    AutoDTO update(AutoDTO autoDTO);

    boolean remove(int id);

    Auto select(int id);

    Set list();
}
