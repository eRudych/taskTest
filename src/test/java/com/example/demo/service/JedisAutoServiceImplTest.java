package com.example.demo.service;

import com.example.demo.entity.AutoModel;
import com.example.demo.factory.AutoServiceType;
import com.example.demo.mapper.AutoMapper;
import com.example.demo.repository.AutoRepositoryImpl;
import com.example.demo.repository.JedisAutoRepository;
import com.example.demo.repository.JedisAutoRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class JedisAutoServiceImplTest {

    private final JedisAutoRepositoryImpl repository = mock(JedisAutoRepositoryImpl.class);

    private final AutoMapper mapper = mock(AutoMapper.class);

    private JedisAutoServiceImpl service = new JedisAutoServiceImpl(repository, mapper);

    private AutoModel auto;
    private long autoId;

    @Before
    public void initial() {
        auto = new AutoModel(4, "audi", "a6");
        autoId = auto.getId();
    }


    @Test
    public void getType() {
        assertThat(service.getType(), is(AutoServiceType.JEDIS));
    }

    @Test
    public void create() {
        service.create(auto);
        when(repository.create(auto)).thenReturn(auto);
    }

    @Test
    public void update() {
        service.update(auto);
        verify(repository).update(auto);
    }

    @Test
    public void remove() {
        service.remove(autoId);
        verify(repository).delete(autoId);
    }

    @Test
    public void get() {
        service.get(autoId);
        when(repository.selectById(autoId)).thenReturn(auto);
    }

    @Test
    public void getAll() {
        service.getAll();
        verify(repository).selectAll();
    }

}