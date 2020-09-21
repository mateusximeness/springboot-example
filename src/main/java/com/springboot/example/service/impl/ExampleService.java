package com.springboot.example.service.impl;

import com.springboot.example.domain.Example;
import com.springboot.example.repository.IExampleRepository;
import com.springboot.example.service.IExampleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ExampleService implements IExampleService {

    @Autowired
    IExampleRepository repository;
    @Override
    public void create(Example example) {
        repository.create(example);
    }

    @Override
    public Example findById(Integer id) {
        return repository.findById(id);
    }
}
