package com.example.demo.controller;

import com.example.demo.dto.AutoDTO;
import com.example.demo.factory.AutoServiceFactory;
import com.example.demo.factory.AutoServiceType;
import com.example.demo.mapper.AutoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/automobiles/{service}")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AutoController {

    private final AutoServiceFactory autoServiceFactory;
    private final AutoMapper mapper;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public AutoDTO create(@RequestBody AutoDTO autoDTO, @PathVariable("service") AutoServiceType serviceType) {
        log.info("LogInfo: " + this.getClass().getName() + " create");
        return autoServiceFactory.getService(serviceType).create(mapper.toEntity(autoDTO));
    }

    @GetMapping("/{id}")
    public AutoDTO get(@PathVariable("id") long id, @PathVariable("service") AutoServiceType serviceType) {
        log.info("LogInfo: class " + this.getClass().getName() + " get");
        return autoServiceFactory.getService(serviceType).get(id);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public AutoDTO update(@RequestBody AutoDTO autoDTO, @PathVariable("service") AutoServiceType serviceType) {
        log.info("LogInfo: class " + this.getClass().getName() + " update");
        return autoServiceFactory.getService(serviceType).update(mapper.toEntity(autoDTO));
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") long id, @PathVariable("service") AutoServiceType serviceType) {
        log.info("LogInfo: class " + this.getClass().getName() + " remove");
        autoServiceFactory.getService(serviceType).remove(id);
    }

    @GetMapping
    public List getAll(@PathVariable("service") AutoServiceType serviceType) {
        log.info("LogInfo: class " + this.getClass().getName() + " getAll");
        return autoServiceFactory.getService(serviceType).getAll();
    }
}

