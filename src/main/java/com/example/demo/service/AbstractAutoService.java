package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;
import com.example.demo.mapper.AutoMapper;
import com.example.demo.repository.AutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public abstract class AbstractAutoService implements AutoService {

    private final AutoRepository repository;
    private final AutoMapper mapper;

    @Override
    @Transactional
    public AutoDTO create(AutoModel auto) {
        log.info("LogInfo: " + this.getClass().getName() + " create: " + auto);
        try {
            return mapper.toDto(repository.create(auto));
        } catch (Exception ex) {
            log.error("LogError: " + this.getClass().getName() + " create: " + auto, ex);
            return null;
        }
    }

    @Override
    @Transactional
    public AutoDTO update(AutoModel auto) {
        log.info("LogInfo: " + this.getClass().getName() + " update: " + auto);
        try {

            repository.update(auto);
        } catch (Exception ex) {
            log.error("LogError: " + this.getClass().getName() + " update: " + auto, ex);
        }
        return get(auto.getId());
    }

    @Override
    @Transactional
    public void remove(long id) {
        log.info("LogInfo: " + this.getClass().getName() + " remove: " + id);
        try {
            repository.remove(id);
        } catch (Exception ex) {
            log.error("LogError: " + this.getClass().getName() + " remove: " + id, ex);
        }
    }

    @Override
    public AutoDTO get(long id) {
        log.info("LogInfo: " + this.getClass().getName() + " get: " + id);
        try {
            return mapper.toDto(repository.get(id));
        } catch (Exception ex) {
            log.error("LogError: " + this.getClass().getName() + " get: " + id, ex);
            return null;
        }
    }

    @Override
    public List<AutoDTO> getAll() {
        log.info("LogInfo: " + this.getClass().getName() + " getAll");
        try {
            return repository.getAll().stream().map(mapper::toDto).collect(Collectors.toList());
        } catch (Exception ex) {
            log.error("LogError: " + this.getClass().getName() + " getAll", ex);
            return null;
        }
    }
}
