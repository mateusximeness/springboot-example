package com.springboot.example.mapper;

import com.springboot.example.domain.Example;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExampleRowMapper implements RowMapper<Example> {
    @Override
    public Example mapRow(ResultSet resultSet, int i) throws SQLException {
        Example example = new Example();
        example.setId(resultSet.getInt("ID"));
        example.setName(resultSet.getString("NAME"));
        example.setVersion(resultSet.getString("VERSION"));
        return example;
    }
}
