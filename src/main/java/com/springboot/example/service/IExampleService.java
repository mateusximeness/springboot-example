package com.springboot.example.service;

import com.springboot.example.domain.Example;

public interface IExampleService {
    public void create(Example example);
    public Example findById(Integer id);
}
