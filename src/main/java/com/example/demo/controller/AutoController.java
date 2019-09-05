package com.example.demo.controller;

import com.example.demo.dto.AutoDTO;
import com.example.demo.service.AutoService;
import com.example.demo.service.ServiceFactory;
import com.example.demo.service.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/automobiles/{service}")
public class AutoController {

    private final AutoService autoService;

    @Autowired(required=false)
    private ServiceType serviceType;

    @Autowired
    public AutoController(ServiceFactory serviceFactory) {
        this.autoService = serviceFactory.getService(ServiceType.STANDARD);
    }
//
//    @GetMapping
//    void setServiceType(@RequestParam("service") ServiceType service){
//        this.serviceType = service;
//    }
//
//    private ServiceType getServiceType(){
//        return this.serviceType;
//    }


    @PostMapping
    public AutoDTO create(AutoDTO autoDTO) {
        return autoService.create(autoDTO.createAutoModel());
    }

    @GetMapping("/{id}")
    public AutoDTO select(@PathVariable("id") long id) {
        return autoService.get(id);
    }

    @PutMapping
    public AutoDTO update(AutoDTO autoDTO) {
        return autoService.update(autoDTO.createAutoModel());
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") long id) {
        autoService.remove(id);
    }

    @GetMapping
    public List list() {
        return autoService.list();
    }
}

