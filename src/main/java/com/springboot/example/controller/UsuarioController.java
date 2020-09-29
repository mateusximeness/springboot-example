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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@RestController

public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping(value = "/usuario")
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = service.findAll();

        if (list!=null) {
            return ResponseEntity.ok().body(list);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/usuario/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable(value = "id") Integer id) {
        Usuario response = null;
        if (id != null) {
            response=service.findById(id);

        }
        if (response!=null) {
            return new ResponseEntity<Usuario>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(value = "/usuario")
    public ResponseEntity<HttpStatus> create(@RequestBody Usuario usuario){
        service.create(usuario);
        if (usuario!=null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value="/usuario/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable(value="id") Integer id,
                                            @RequestBody Usuario usuario) {

        service.update(id,usuario);
        if (usuario!=null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(value="/usuario/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(value="id") Integer id) {

        service.delete(id);
        if (id!=null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(value="/usuario/cpf/{cpf}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(value="cpf") String cpf) {

        service.delete(cpf);
        if (cpf!=null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

      @GetMapping(value = "/usuario/nascimento/{datanasc}")

    public ResponseEntity<Usuario> findByData(@PathVariable(value = "datanasc") String data) {

        Usuario response = null;
        if (data != null) {
            response=service.findByData(data);

        }
        if (response!=null) {
            return new ResponseEntity<Usuario>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }




}
