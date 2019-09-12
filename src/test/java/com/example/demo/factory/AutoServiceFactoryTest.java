package com.example.demo.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoServiceFactoryTest {

    private final AutoServiceFactory factory = mock(AutoServiceFactory.class);

    @Test
    public void getService() {
        for (AutoServiceType type : AutoServiceType.values()) {
            when(factory.getService(type).getType()).thenReturn(type);
        }
    }
}