package com.springboot.example.repository;

import com.springboot.example.domain.Example;

public interface IExampleRepository {
    public void create(Example example);
    public Example findById(Integer id);
}
