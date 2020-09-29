package com.springboot.example.service;

import com.springboot.example.domain.Usuario;

import java.util.Date;
import java.util.List;

public interface IUsuarioService {

    public Usuario findById(Integer id);

    public Usuario findByData(String data);

    public List<Usuario> findAll();

    public void  create(Usuario usuario);

    public void update(Integer id, Usuario usuario);

    public void delete(Integer id);

    public void delete(String cpf);





}
