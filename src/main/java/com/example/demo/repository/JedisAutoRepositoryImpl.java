package com.example.demo.repository;

import com.example.demo.entity.AutoModel;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository(value = "jedisAutoRepositoryImpl")
public class JedisAutoRepositoryImpl implements AutoRepository {

    private final String KEY = "automobiles";


    private final RedisTemplate<String, AutoModel> redisTemplate;

    private final ListOperations<String, AutoModel> listOperations;

    public JedisAutoRepositoryImpl(RedisTemplate<String, AutoModel> redisTemplate) {
        this.redisTemplate = redisTemplate;
        listOperations = redisTemplate.opsForList();
    }

    @Override
    public AutoModel create(AutoModel autoModel) {
        listOperations.rightPush(KEY, autoModel);
        return selectById(autoModel.getId());
    }

    @Override
    public void update(AutoModel autoModel) {
        create(autoModel);
    }

    @Override
    public void delete(long id) {
        listOperations.remove(KEY, 1, selectById(id));
    }

    @Override
    public AutoModel selectById(long id) {
        return (AutoModel) redisTemplate.opsForList().index(KEY, id);
    }

    @Override
    public List<AutoModel> selectAll() {
        return listOperations.range(KEY, 0, listOperations.size(KEY));
    }
}
