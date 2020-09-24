package com.springboot.example.repository;

import com.springboot.example.domain.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUsuarioRepository {
    public void create(Usuario usuario);
    public Usuario findById(Integer id);
    public List<Usuario> findAll();

    public void update(Integer id, Usuario usuario);
    public void delete(Integer id);
    public void delete(String cpf);



}
