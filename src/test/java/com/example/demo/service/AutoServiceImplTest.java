package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.entity.Auto;
import lombok.var;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class AutoServiceImplTest {

    @InjectMocks
    private final AutoService autoService = new AutoServiceImpl();

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
    }

    @After
    public void finish() {
        assertNotNull(autoDTO);
        assertNotNull(auto);
    }

    @Test
    public void testCreate() throws Exception {
        mockMvc.perform(post("/"))
                .andExpect(status().isOk());
        assertThat(autoDTO, is(autoService.create(autoDTO)));
    }

    @Test
    public void testUpdate() throws Exception {
        mockMvc.perform(put("/"))
                .andExpect(status().isOk());
        assertThat(autoDTO, is(autoService.update(autoDTO)));
    }

    @Test
    public void testRemove() throws Exception {
        mockMvc.perform(delete("/{AUTO_ID}"))
                .andExpect(status().isOk());
        assertThat(true,is(autoService.remove(autoId)));
    }

    @Test
    public void testSelect() throws Exception {
        mockMvc.perform(get("/{autoDTO.getId()}"))
                .andExpect(status().isOk());
        assertThat(autoDTO, is(autoService.select(autoId)));
    }

    @Test
    public void testList() throws Exception {
        var autoList = (HashSet<Auto>) Arrays.asList(auto);
        mockMvc.perform(delete("/"))
                .andExpect(status().isOk());
        assertThat(autoList, is(autoService.list()));
    }
}
