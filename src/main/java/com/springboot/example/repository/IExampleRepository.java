package com.springboot.example.repository;

import com.springboot.example.domain.Example;
import org.springframework.http.ResponseEntity;

public interface IExampleRepository {
    public void create(Example example);
    public Example findById(Integer id);


}
