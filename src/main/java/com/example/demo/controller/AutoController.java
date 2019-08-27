package com.example.demo.controller;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;
import com.example.demo.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/automobiles")
public class AutoController {


    @Autowired
    private AutoService autoService;

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
    public boolean remove(@PathVariable ("id") long id) {
        return autoService.remove(id);
    }

    @GetMapping
    public List list() {
        return autoService.list();
    }
}

