package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;
import com.example.demo.factory.AutoServiceType;

import java.util.List;

public interface AutoService {

    AutoServiceType getType();

    AutoDTO create(AutoModel auto) throws Exception;

    AutoDTO update(AutoModel auto) throws Exception;

    void remove(long id);

    AutoDTO get(long id) throws Exception;

    List<AutoDTO> getAll();
}
