package com.example.demo.controller;

import com.example.demo.dto.AutoDTO;
import com.example.demo.service.AutoService;
import com.example.demo.service.ServiceFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/automobiles/{service}"})
public class AutoController {

    private final AutoService autoService;

    public AutoController(@PathVariable("service") ServiceFactory.ServiceType service) {
        ServiceFactory factory = new ServiceFactory();
        this.autoService = factory.getService(service);
    }

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
    public void remove(@PathVariable ("id") long id) {
        autoService.remove(id);
    }

    @GetMapping
    public List list() {
        return autoService.list();
    }
}

