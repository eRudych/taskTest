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
        log.info("LogInfo: " + this.getClass().getName() + " create: " + autoModel);
        HashMap<Long, AutoModel> map;
        if (jedis.get(KEY) == null) {
            map = new HashMap<>();
        } else {
            map = getMapFromJedis();
        }
        map.put(autoModel.getId(), autoModel);
        setMapInJedis(map);
        return get(autoModel.getId());
    }

    @Override
    public void update(AutoModel autoModel) {
        log.info("LogInfo: " + this.getClass().getName() + " update: " + autoModel.toString());
        create(autoModel);
    }

    @Override
    public void remove(long id) {
        log.info("LogInfo: " + this.getClass().getName() + " remove: " + id);
        if (jedis.get(KEY) != null) {
            HashMap<Long, AutoModel> map = getMapFromJedis();
            map.remove(id);
            setMapInJedis(map);
        }
    }

    @Override
    public AutoModel get(long id) {
        log.info("LogInfo: " + this.getClass().getName() + " get: " + id);
        return getMapFromJedis().get(id);
    }

    @Override
    public List<AutoModel> getAll() {
        log.info("LogInfo: " + this.getClass().getName() + " getAll ");
        return new ArrayList<>(getMapFromJedis().values());
    }

    private HashMap<Long, AutoModel> getMapFromJedis() {
        log.info("LogInfo: " + this.getClass().getName() + " getMapFromJedis ");
        return gson.fromJson(jedis.get(KEY), TYPE);
    }


    private void setMapInJedis(HashMap<Long, AutoModel> map) {
        log.info("LogInfo: " + this.getClass().getName() + " setMapInJedis ");
        jedis.set(KEY, gson.toJson(map));
    }
}
