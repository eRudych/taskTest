package com.example.demo.mapper;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AutoMapper implements Mapper<AutoModel, AutoDTO> {

    private final ModelMapper mapper;

    public AutoModel toEntity(AutoDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, AutoModel.class);
    }

    public AutoDTO toDto(AutoModel entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, AutoDTO.class);
    }
}
