package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;
import com.example.demo.repositories.AutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository;

    @Override
    public ServiceFactory.ServiceType getType() {
        return ServiceFactory.ServiceType.STANDARD;
    }

    @Override
    @Transactional
    public AutoDTO create(AutoModel auto) {
        return AutoDTO.createAutoDTO(autoRepository.create(auto));
    }

    @Override
    @Transactional
    public AutoDTO update(AutoModel auto) {
        autoRepository.update(auto);
        return get(auto.getId());
    }

    @Override
    @Transactional
    public void remove(long id) {
        autoRepository.delete(id);
    }

    @Override
    public AutoDTO get(long id) {
        return AutoDTO.createAutoDTO(autoRepository.selectById(id));
    }

    @Override
    public List<AutoModel> list() {
        return autoRepository.selectAll();
    }
}
