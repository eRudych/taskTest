package com.example.demo.mapper;

public interface Mapper<Entity, DTO> {

    Entity toEntity(DTO dto);

    DTO toDto(Entity entity);
}
