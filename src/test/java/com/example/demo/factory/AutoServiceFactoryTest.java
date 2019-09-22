package com.example.demo.factory;

import com.example.demo.service.AutoService;
import com.example.demo.service.AutoServiceImpl;
import com.example.demo.service.JedisAutoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoServiceFactoryTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private AutoServiceFactory factory;

    private AutoService autoServiceImpl;
    private AutoService jedisAutoServiceImpl;

    @Before
    public void beforeClass() {
        autoServiceImpl = context.getBean(AutoServiceImpl.class);
        jedisAutoServiceImpl = context.getBean(JedisAutoServiceImpl.class);
    }

    @Test
    public void getService() {
        assertEquals(AutoServiceType.STANDARD, autoServiceImpl.getType());
        assertEquals(AutoServiceType.JEDIS, jedisAutoServiceImpl.getType());

        for (AutoServiceType type : AutoServiceType.values()) {
            assertThat(factory.getService(type).getType(), is(type));
        }
    }
}