package com.example.demo.controller;

import com.example.demo.dto.AutoDTO;
import com.example.demo.factory.AutoServiceFactory;
import com.example.demo.factory.AutoServiceType;
import com.example.demo.mapper.AutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/automobiles/{service}")
public class AutoController {

    private final AutoServiceFactory autoServiceFactory;
    private final AutoMapper mapper;

    @Autowired
    public AutoController(AutoServiceFactory autoServiceFactory, AutoMapper mapper) {
        this.autoServiceFactory = autoServiceFactory;
        this.mapper = mapper;
    }

    @PostMapping
    public AutoDTO create(AutoDTO autoDTO, @PathVariable("service") AutoServiceType serviceType) {
        try {
            autoDTO = autoServiceFactory.getService(serviceType).create(mapper.toEntity(autoDTO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return autoDTO;
    }

    @GetMapping("/{id}")
    public AutoDTO get(@PathVariable("id") long id, @PathVariable("service") AutoServiceType serviceType) throws Exception {
        return autoServiceFactory.getService(serviceType).get(id);
    }

    @PutMapping
    public AutoDTO update(AutoDTO autoDTO, @PathVariable("service") AutoServiceType serviceType) {
        try {
            autoDTO = autoServiceFactory.getService(serviceType).update(mapper.toEntity(autoDTO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return autoDTO;
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") long id, @PathVariable("service") AutoServiceType serviceType) {
        autoServiceFactory.getService(serviceType).remove(id);
    }

    @GetMapping
    public List getAll(@PathVariable("service") AutoServiceType serviceType) {
        return autoServiceFactory.getService(serviceType).getAll();
    }
}

