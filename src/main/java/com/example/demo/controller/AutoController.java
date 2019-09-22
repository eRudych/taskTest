package com.example.demo.controller;

import com.example.demo.dto.AutoDTO;
import com.example.demo.factory.AutoServiceFactory;
import com.example.demo.factory.AutoServiceType;
import com.example.demo.mapper.AutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/automobiles/{service}")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AutoController {

    private final AutoServiceFactory autoServiceFactory;
    private final AutoMapper mapper;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public AutoDTO create(@RequestBody AutoDTO autoDTO, @PathVariable("service") AutoServiceType serviceType) {
        return autoServiceFactory.getService(serviceType).create(mapper.toEntity(autoDTO));
    }

    @GetMapping("/{id}")
    public AutoDTO get(@PathVariable("id") long id, @PathVariable("service") AutoServiceType serviceType) {
        return autoServiceFactory.getService(serviceType).get(id);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public AutoDTO update(@RequestBody AutoDTO autoDTO, @PathVariable("service") AutoServiceType serviceType) {
        return autoServiceFactory.getService(serviceType).update(mapper.toEntity(autoDTO));
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

