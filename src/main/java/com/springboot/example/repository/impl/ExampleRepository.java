package com.springboot.example.repository.impl;

import com.springboot.example.domain.Example;
import com.springboot.example.repository.IExampleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ExampleRepository implements IExampleRepository {
    @Override
    public void create(Example example) {

    }
    @Override
    public Example findById(Integer id) {
        return null;
    }
}
