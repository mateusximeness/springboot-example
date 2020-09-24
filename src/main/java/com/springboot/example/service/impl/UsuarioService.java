package com.springboot.example.service.impl;

import com.springboot.example.domain.Example;
import com.springboot.example.domain.Usuario;
import com.springboot.example.repository.IExampleRepository;
import com.springboot.example.repository.IUsuarioRepository;
import com.springboot.example.service.IExampleService;
import com.springboot.example.service.IUsuarioService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioService implements IUsuarioService {

    @Autowired
    IUsuarioRepository repository;

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }


    @Override
    public void create(Usuario usuario) {
        repository.create(usuario);
    }

    @Override
    public Usuario findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void update(Integer id) {
        repository.update(id);
    }
    @Override
    public void delete(Integer id){
        repository.delete(id);
    }
    @Override
    public void delete(String cpf){
        repository.delete(cpf);
    }







}
