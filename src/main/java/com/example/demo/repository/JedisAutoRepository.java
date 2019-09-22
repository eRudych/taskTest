package com.example.demo.repository;

import com.example.demo.entity.AutoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "jedisAutoRepository")
public interface JedisAutoRepository extends CrudRepository<AutoModel, String> {
}
