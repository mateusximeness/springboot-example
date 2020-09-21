package com.springboot.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Table
public class Example {
    @Id
    BigInteger id;
    String name;
    String version;
    Date lastDate;
}
