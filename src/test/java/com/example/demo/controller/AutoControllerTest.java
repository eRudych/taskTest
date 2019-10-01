package com.example.demo.controller;

import com.example.demo.dto.AutoDTO;
import com.example.demo.factory.AutoServiceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class AutoControllerTest {

    @Autowired
    private AutoController autoController;

    private final AutoDTO autoDTO = new AutoDTO(7, "audi", "a10");

    private final long autoId = autoDTO.getId();


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAll() throws Exception {
        String actualBody = "[{\"id\":4,\"brand\":\"audi\",\"model\":\"a6\"}]";
        for (AutoServiceType type : AutoServiceType.values()) {
            MvcResult result = mockMvc.perform(get("/automobiles/" + type + "/"))
                    .andExpect(status().isOk()).andReturn();
            assertThat(result.getResponse().getContentAsString(), is(actualBody));
        }
    }

    @Test
    public void testRemove() throws Exception {
        for (AutoServiceType type : AutoServiceType.values()) {
            mockMvc.perform(delete("/automobiles/" + type + "/" + autoId + "/"))
                    .andExpect(status().isOk());
        }

    }

    @Test
    public void testCreate() throws Exception {
        for (AutoServiceType type : AutoServiceType.values()) {
            mockMvc.perform(post("/automobiles/" + type + "/")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content("{\"brand\": \"audi\", \"model\": \"a10\" }")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
            assertThat(autoController.create(autoDTO, type), is(autoDTO));
        }
    }

    @Test
    public void testGet() throws Exception {
        for (AutoServiceType type : AutoServiceType.values()) {
            mockMvc.perform(get("/automobiles/" + type + "/" + autoId)
            ).andExpect(status().isOk());
            assertThat(autoController.get(autoId, type), is(autoDTO));
        }
    }

    @Test
    public void testUpdate() throws Exception {
        for (AutoServiceType type : AutoServiceType.values()) {
            mockMvc.perform(put("/automobiles/" + type + "/")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content("{ \"id\": 4, \"brand\": \"audi\", \"model\": \"a6\" }")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
            assertThat(autoController.update(autoDTO, type), is(autoDTO));
        }
    }
}
