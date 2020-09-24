package com.springboot.example.repository.impl;


import com.springboot.example.domain.Example;
import com.springboot.example.domain.Usuario;
import com.springboot.example.mapper.ExampleRowMapper;
import com.springboot.example.mapper.UsuarioRowMapper;
import com.springboot.example.repository.IExampleRepository;
import com.springboot.example.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Repository
@AllArgsConstructor
public class UsuarioRepository implements IUsuarioRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Usuario usuario) {
        jdbcTemplate.update("insert into usuario(nome, CPF, email) \n" +
                "values(?, ?,?);"
                ,
                usuario.getNome(),
                usuario.getCPF(),
                usuario.getEmail());


    }
    @Override
    public void update(Integer id) {
        Usuario usuario =findById(id);

        if (usuario!=null) {
            jdbcTemplate.update("UPDATE usuario "
                            + "SET NOME =?, CPF=?, EMAIL=? WHERE ID=?"
                    ,
                    usuario.getNome(),
                    usuario.getCPF(),
                    usuario.getEmail(),
                    id);
        }
    }
    @Override
    public void delete(Integer id) {

        jdbcTemplate.update("DELETE FROM usuario "
                        + "WHERE ID =?"
                ,
                id);

    }

    @Override
    public void delete(String cpf) {
        jdbcTemplate.update("DELETE FROM usuario "
                        + "WHERE CPF =?"
                ,
                cpf);

    }



   @Override
    public Usuario findById(Integer id) {

        try
        {
            List<Usuario> usuario = jdbcTemplate.query("SELECT TOP 1 ID, NOME, CPF, EMAIL" +
                            " From USUARIO Where id =?"
                    ,new Object[]{id}
                    ,new UsuarioRowMapper());
            return usuario.get(0);
        }catch (Exception e){
            return new Usuario();
        }
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuario =  jdbcTemplate.query("SELECT ID, NOME , CPF, EMAIL FROM USUARIO "
        , new UsuarioRowMapper());

        return usuario;
    }






    public Usuario findByCPF(String cpf) {   try
    {
        List<Usuario> usuario = jdbcTemplate.query("SELECT TOP 1 ID, NOME, CPF, EMAIL" +
                        " From USUARIO Where CPF =?"
                ,new Object[]{cpf}
                ,new UsuarioRowMapper());
        return usuario.get(0);
    }catch (Exception e){
        return new Usuario();
    }
    }


    }



