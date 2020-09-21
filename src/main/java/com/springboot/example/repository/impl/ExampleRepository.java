package com.springboot.example.repository.impl;

import com.springboot.example.domain.Example;
import com.springboot.example.mapper.ExampleRowMapper;
import com.springboot.example.repository.IExampleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ExampleRepository implements IExampleRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Example example) {
        jdbcTemplate.update("insert into example\n" +
                "values(?, ?,CURRENT_TIMESTAMP());"
                ,new Object[]{
                        example.getName(),
                        example.getVersion()
            });
    }
    @Override
    public Example findById(Integer id) {
       List<Example> example= jdbcTemplate.query("SELECT ex.ID,ex.NAME,ex.INSERTDATE,ex.VERSION" +
                       " From example ex Where ex.id =?"
               ,new Object[]{id}
               ,new ExampleRowMapper());
        return example.get(0);
    }
}
