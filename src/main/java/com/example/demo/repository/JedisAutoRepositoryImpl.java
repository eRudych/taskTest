package com.example.demo.repository;

import com.example.demo.entity.AutoModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.lang.reflect.Type;
import java.util.*;

@Slf4j
@Repository
public class JedisAutoRepositoryImpl implements AutoRepository {

    private final String KEY = "automobiles";

    private final Jedis jedis;

    private final Gson gson;

    private final Type TYPE = new TypeToken<HashMap<String, AutoModel>>() {
    }.getType();

    @Autowired
    public JedisAutoRepositoryImpl(JedisPool jedisPool, Gson gson) {
        this.jedis = jedisPool.getResource();
        this.gson = gson;
    }

    @Override
    public AutoModel create(AutoModel autoModel) {
        log.info("LogInfo: " + this.getClass() + " create: " + autoModel);
        Map<Long, AutoModel> map = getMap();
        map.put(autoModel.getId(), autoModel);
        setMapInJedis(map);
        return get(autoModel.getId());
    }

    @Override
    public void update(AutoModel autoModel) {
        log.info("LogInfo: " + this.getClass() + " update: " + autoModel.toString());
        create(autoModel);
    }

    @Override
    public void remove(long id) {
        log.info("LogInfo: " + this.getClass() + " remove: " + id);
        if (jedis.get(KEY) != null) {
            Map<Long, AutoModel> map = getMap();
            map.remove(id);
            setMapInJedis(map);
        }
    }

    @Override
    public AutoModel get(long id) {
        log.info("LogInfo: " + this.getClass() + " get: " + id);
        return getMapFromJedis().get(id);
    }

    @Override
    public List<AutoModel> getAll() {
        log.info("LogInfo: " + this.getClass() + " getAll");
        return new ArrayList<>(getMapFromJedis().values());
    }

    private Map<Long, AutoModel> getMapFromJedis() {
        log.info("LogInfo: " + this.getClass() + " getMapFromJedis");
        return gson.fromJson(jedis.get(KEY), TYPE);
    }


    private void setMapInJedis(Map<Long, AutoModel> map) {
        log.info("LogInfo: " + this.getClass() + " setMapInJedis");
        jedis.set(KEY, gson.toJson(map));
    }

    private Map<Long, AutoModel> getMap() {
        log.info("LogInfo: " + this.getClass() + " getMap");
        if (jedis.get(KEY) == null) {
            return new HashMap<>();
        } else {
            return getMapFromJedis();
        }
    }
}
