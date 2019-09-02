package com.example.demo.controller;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;
import com.example.demo.service.AutoService;
import com.example.demo.service.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/automobiles/{service}" ,"/automobiles"})
public class AutoController {

    private AutoService autoService;

    @Autowired
    public void setService(@PathVariable("service") String service) {
        this.autoService = ServiceFactory.getService(service);
    }

    @PostMapping
    public AutoDTO create(AutoDTO autoDTO) {
        return autoService.create(autoDTO.createAutoModel());
    }

    @GetMapping("/{id}")
    public AutoModel select(@PathVariable("id") long id) {
        return autoService.select(id);
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

