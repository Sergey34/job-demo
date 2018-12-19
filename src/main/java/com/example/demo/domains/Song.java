package com.example.demo.domains;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private Long duration;
    @OneToOne
    private Singer singer;
    @OneToOne
    private Album album;
    private LocalDate release;
    private String genre;
}
