package com.springboot.example.mapper;

import com.springboot.example.domain.Example;
import com.springboot.example.domain.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRowMapper implements RowMapper<Usuario> {
    @Override
    public Usuario mapRow(ResultSet resultSet, int i) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getInt("ID"));
        usuario.setNome(resultSet.getString("NOME"));
        usuario.setCPF(resultSet.getString("CPF"));
        usuario.setEmail(resultSet.getString("EMAIL"));
        return usuario;
    }
}
