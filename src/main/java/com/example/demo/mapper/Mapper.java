package com.example.demo.mapper;

import com.example.demo.dto.BaseDTO;
import com.example.demo.entity.BaseEntity;

public interface Mapper<Entity extends BaseEntity, DTO extends BaseDTO> {

    Entity toEntity(DTO dto);

    DTO toDto(Entity entity);
}
