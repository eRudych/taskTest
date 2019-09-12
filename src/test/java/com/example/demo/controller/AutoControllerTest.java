package com.example.demo.controller;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.AutoModel;
import com.example.demo.factory.AutoServiceFactory;
import com.example.demo.factory.AutoServiceType;
import com.example.demo.mapper.AutoMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class AutoControllerTest {

    @Mock
    private AutoServiceFactory factory;

    @Mock
    private AutoController autoController;

    @Mock
    private AutoMapper mapper;


    private AutoDTO autoDTO;
    private AutoModel auto;
    private long autoId;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void initial() {
        auto = new AutoModel(3, "audi", "a4");
        autoDTO = mapper.toDto(auto);
        autoId = auto.getId();
    }

    @Test
    public void testGetAll() throws Exception {
        for (AutoServiceType type : AutoServiceType.values()) {
            mockMvc.perform(get("/automobiles/" + type + "/"))
                    .andExpect(status().isOk());
            verify(autoController).getAll(type);
        }
    }

    @Test
    public void testRemove() throws Exception {
        for (AutoServiceType type : AutoServiceType.values()) {
            mockMvc.perform(delete("/automobiles/" + type + "/" + autoId + "/"))
                    .andExpect(status().isOk());
            verify(autoController).remove(autoId, type);
        }

    }

    @Test
    public void testCreate() throws Exception {
        for (AutoServiceType type : AutoServiceType.values()) {
            when(factory.getService(type).create(auto)).thenReturn(autoDTO);
            mockMvc.perform(post("/automobiles/" + type + "/")).andExpect(status().isOk());
            verify(autoController).create(autoDTO,type);
        }
    }

    @Test
    public void testGet() throws Exception {
        for (AutoServiceType type : AutoServiceType.values()) {
            when(factory.getService(type).get(autoId)).thenReturn(autoDTO);
            mockMvc.perform(get("/automobiles/" + type + "/" + autoId + "/"))
                    .andExpect(status().isOk());
            verify(autoController).get(autoId,type);
        }
    }

    @Test
    public void testUpdate() throws Exception {
        for (AutoServiceType type : AutoServiceType.values()) {
            when(factory.getService(type).update(auto)).thenReturn(autoDTO);
            mockMvc.perform(put("/automobiles/" + type + "/"))
                    .andExpect(status().isOk());
            verify(autoController.update(autoDTO,type));
        }
    }
}
