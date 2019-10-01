package com.example.demo.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoServiceFactoryTest {

    @Autowired
    private AutoServiceFactory factory;

    @Test
    public void getService() {
        for (AutoServiceType type : AutoServiceType.values()) {
            assertThat(factory.getService(type).getType(), is(type));
        }
    }
}