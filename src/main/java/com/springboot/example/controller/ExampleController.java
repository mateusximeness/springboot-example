package com.springboot.example.controller;

import com.springboot.example.domain.Example;
import com.springboot.example.service.IExampleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ExampleController {
    @Autowired
    IExampleService service;

    @GetMapping(value = "/example/{id}")
    public ResponseEntity<Example> findById(@PathVariable(value = "id") Integer id){
        Example response = null;
        if(id!=null){
            response = service.findById(id);
        }
        return new ResponseEntity<Example>(response, HttpStatus.OK);
    }
    @PostMapping(value = "/example")
    public ResponseEntity<HttpStatus> create(@RequestBody Example example){
        service.create(example);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
