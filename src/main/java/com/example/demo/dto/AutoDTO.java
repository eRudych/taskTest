package com.example.demo.dto;

import com.example.demo.entity.AutoModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AutoDTO  {
    private  long id;
    private  String brand;
    private  String model;

    public AutoModel createAutoModel(){
        return AutoModel.builder()
                .id(this.id)
                .brand(this.brand)
                .model(this.model)
                .build();
    }

    static public AutoDTO createAutoDTO(AutoModel autoModel){
        return new AutoDTO(autoModel.getId(),autoModel.getBrand(),autoModel.getModel());
    }
}
