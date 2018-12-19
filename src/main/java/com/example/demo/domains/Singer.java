package com.example.demo.domains;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Singer {
    @Id
    @GeneratedValue
    private Long id;
    private String fio;
    private LocalDate birthday;
    private String country;
    private String genre;
    private String alias;

}
