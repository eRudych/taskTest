package com.example.demo.service;

import com.example.demo.db.automobiles.tables.pojos.Auto;
import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;
import com.example.demo.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AutoServiceImpl implements AutoService {

    private Set<AutoModel> autoList = new HashSet<>();

    @Autowired
    private AutoRepository autoRepository;

    @Override
    public AutoDTO create(AutoDTO autoDTO) {
        AutoModel auto = AutoModel.builder()
                .model(autoDTO.getModel())
                .brand(autoDTO.getBrand())
                .build();
        int autoId = autoRepository.insert(auto);
        autoList.add(auto);
        return autoDTO;
    }

    @Override
    public AutoDTO update(AutoDTO autoDTO) {
        AutoModel auto = AutoModel.builder()
                .id(autoDTO.getId())
                .brand(autoDTO.getBrand())
                .model(autoDTO.getModel())
                .build();
        return autoRepository.update(auto) && this.remove(autoDTO.getId()) && autoList.add(auto) ? autoDTO : new AutoDTO(0, "", "");
    }

    @Override
    public boolean remove(int id) {
        Optional<AutoModel> firstAuto = findAutoById(id);
        return autoRepository.delete(id) && firstAuto.isPresent() && autoList.remove(firstAuto.get());
    }

    @Override
    public AutoModel select(int id) {
        Auto autoDb = autoRepository.selectById(id);
        return AutoModel.builder().id(autoDb.getId()).model(autoDb.getModel()).brand(autoDb.getBrand()).build();
    }

    @Override
    public Set<AutoModel> list() {
        return autoList;
    }

    public List<Auto> listFromDb() {
        return autoRepository.selectAll();
    }

    private Optional<AutoModel> findFirstAuto(AutoModel finalAuto) {
        return autoList.stream()
                .filter(auto -> auto.equals(finalAuto))
                .findFirst();
    }

    private Optional<AutoModel> findAutoById(int id) {
        return autoList.stream().filter(auto -> auto.getId() == id).findFirst();
    }
}
