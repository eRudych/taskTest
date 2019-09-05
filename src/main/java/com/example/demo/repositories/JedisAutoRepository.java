package com.example.demo.repositories;

import com.example.demo.entity.AutoModel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration
public interface JedisAutoRepository extends CrudRepository<AutoModel, String> {
}
