package com.springboot.example.controller;


import com.springboot.example.domain.Example;
import com.springboot.example.domain.Usuario;

import com.springboot.example.service.IUsuarioService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController

public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping(value = "/usuario")
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = service.findAll();


        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/usuario/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable(value = "id") Integer id) {
        Usuario response = null;
        if (id != null) {
            response=service.findById(id);

        }

        return new ResponseEntity<Usuario>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/usuario")
    public ResponseEntity<HttpStatus> create(@RequestBody Usuario usuario){
        service.create(usuario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value="/usuario/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable(value="id") Integer id,
                                            @RequestBody Usuario usuario) {

        service.update(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value="/usuario/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(value="id") Integer id) {

        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value="/usuario/cpf/{cpf}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(value="cpf") String cpf) {

        service.delete(cpf);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
