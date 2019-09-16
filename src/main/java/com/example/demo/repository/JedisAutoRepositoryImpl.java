package com.example.demo.repository;

import com.example.demo.entity.AutoModel;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class JedisAutoRepositoryImpl implements AutoRepository {

    private final DSLContext dsl;

    @Override
    public AutoModel create(AutoModel autoModel) {
        return null;
    }

    @Override
    public void update(AutoModel autoModel) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public AutoModel selectById(long id) {
        return null;
    }

    @Override
    public List<AutoModel> selectAll() {
        return null;
    }
}
