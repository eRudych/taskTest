package com.example.demo.repository;

import com.example.demo.entity.AutoModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Repository(value = "jedisAutoRepositoryImpl")
public class JedisAutoRepositoryImpl implements AutoRepository {

    private final String KEY = "automobiles";

    private final Jedis jedis;

    private final Gson gson;

    private Map<Long,AutoModel> autoModelMap;

    private final Type type = new TypeToken<Map<String, AutoModel>>() {}.getType();

    @Autowired
    public JedisAutoRepositoryImpl(JedisPool jedisPool, Gson gson) {
        this.jedis = jedisPool.getResource();
        this.gson = gson;
        initialMap();
    }

    private void initialMap(){
        autoModelMap=new HashMap<>();
        autoModelMap.put((long) 1,new AutoModel(1,"bmw","m2"));
        jedis.set(KEY,gson.toJson(autoModelMap));
    }

    @Override
    public AutoModel create(AutoModel autoModel) {
        autoModelMap.put(autoModel.getId(),autoModel);
        jedis.set(KEY,gson.toJson(autoModelMap));
        return selectById(autoModel.getId());
    }

    @Override
    public void update(AutoModel autoModel) {
        create(autoModel);
    }

    @Override
    public void delete(long id) {
        autoModelMap.remove(id);
        jedis.set(KEY,gson.toJson(autoModelMap)); }

    @Override
    public AutoModel selectById(long id) {
        autoModelMap = gson.fromJson(jedis.get(KEY),type);
        return autoModelMap.get(id);
    }

    @Override
    public List<AutoModel> selectAll() {
        return new LinkedList<>(autoModelMap.values());
    }
}
