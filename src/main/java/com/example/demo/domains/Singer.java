package com.example.demo.domains;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Singer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String family;
    private String alias;

}
