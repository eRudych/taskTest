package com.example.demo.controller;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.Auto;
import com.example.demo.service.AutoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest
public class AutoControllerTest {

    @MockBean
    private AutoService autoService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    AutoController autoController;

    @Autowired
    private MockMvc mockMvc;

    private AutoDTO autoDTO;
    private Auto auto;
    private int autoId;

    @Before
    public void initial() {
        autoDTO = new AutoDTO(1, "Brand", "Model");
        auto = Auto.builder()
                .id(autoDTO.getId())
                .brand(autoDTO.getBrand())
                .model(autoDTO.getModel())
                .build();
        autoId = autoDTO.getId();
        autoController.create(autoDTO);
    }

    @After
    public void remove() {
        autoController.remove(autoId);
    }

    @Test
    public void testList() throws Exception {
        mockMvc.perform(delete("/"))
                .andExpect(status().isOk());
        verify(autoController).list();
    }

    @Test
    public void testRemove() throws Exception {
        when(autoService.remove(autoId)).thenReturn(true);
        mockMvc.perform(delete("/{AUTO_ID}"))
                .andExpect(status().isOk());
        verify(autoController).remove(autoId);
    }

    @Test
    public void testCreate() throws Exception {
        when(autoService.create(autoDTO)).thenReturn(autoDTO);
        mockMvc.perform(post("/"))
                .andExpect(status().isOk());
        verify(autoController).create(autoDTO);
    }

    @Test
    public void testSelect() throws Exception {
        when(autoService.select(autoDTO.getId())).thenReturn(auto);
        mockMvc.perform(get("/{autoDTO.getId()}"))
                .andExpect(status().isOk());
        verify(autoController).select(autoId);
    }

    @Test
    public void testUpdate() throws Exception {
        when(autoService.update(autoDTO)).thenReturn(autoDTO);
        mockMvc.perform(put("/"))
                .andExpect(status().isOk());
        verify(autoController).update(autoDTO);
    }
}
