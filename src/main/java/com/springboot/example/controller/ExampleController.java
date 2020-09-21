package com.springboot.example.controller;

import com.springboot.example.domain.Example;
import com.springboot.example.service.IExampleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
