package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;
import com.example.demo.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoRepository autoRepository;

    @Override
    @Transactional
    public AutoDTO create(AutoModel auto) {
        return getAutoDTOById(autoRepository.insert(auto));
    }

    @Override
    @Transactional
    public AutoDTO update(AutoModel auto) {
        return autoRepository.update(auto)  ? getAutoDTOById(auto.getId()) : null;
    }

    @Override
    @Transactional
    public boolean remove(long id) {
         return autoRepository.delete(id);
    }

    @Override
    public AutoModel select(long id) {
        return autoRepository.selectById(id);
    }

    @Override
    public List<AutoModel> list() {
        return autoRepository.selectAll();
    }


    private AutoDTO getAutoDTOById(long id){
        return AutoDTO.createAutoDTO(autoRepository.selectById(id));
    }
}
