package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.Auto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AutoServiceImpl implements AutoService {

    private Set<Auto> autoList = new HashSet<>();

    @Override
    public AutoDTO create(AutoDTO autoDTO) {
        autoList.add(Auto.builder()
                .model(autoDTO.getModel())
                .brand(autoDTO.getBrand())
                .build());
        return autoDTO;
    }

    @Override
    public AutoDTO update(AutoDTO autoDTO) {
        Auto auto = Auto.builder().id(autoDTO.getId())
                .brand(autoDTO.getBrand())
                .model(autoDTO.getModel())
                .build();
        return this.remove(autoDTO.getId()) && autoList.add(auto) ? autoDTO : new AutoDTO(0, "", "");
    }

    @Override
    public boolean remove(int id) {
        Optional<Auto> firstAuto = findAutoById(id);
        return firstAuto.isPresent() && autoList.remove(firstAuto.get());
    }

    @Override
    public Auto select(int id) {
        Optional<Auto> optionalAuto = findAutoById(id);
        return optionalAuto.orElseGet(() -> Auto.builder().build());
    }

    @Override
    public Set<Auto> list() {
        return autoList;
    }

    private Optional<Auto> findFirstAuto(Auto finalAuto) {
        return autoList.stream()
                .filter(auto -> auto.equals(finalAuto))
                .findFirst();
    }

    private Optional<Auto> findAutoById(int id) {
        return autoList.stream().filter(auto -> auto.getId() == id).findFirst();
    }
}
