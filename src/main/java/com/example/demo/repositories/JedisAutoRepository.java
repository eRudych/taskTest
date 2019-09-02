package com.example.demo.repositories;

import com.example.demo.entity.AutoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JedisAutoRepository extends CrudRepository<AutoModel, String> {
}
