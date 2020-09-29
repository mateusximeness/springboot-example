package com.springboot.example.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(value="usuario")
public class Usuario {
    @Id
    private Integer id;
    private String nome;
    private String CPF;
    private String email;
    private Date datanasc;

}
