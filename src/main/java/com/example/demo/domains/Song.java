package com.example.demo.domains;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;

    private String text;
    private String title;
    private String genre;
    @OneToOne
    private Singer singer;
    @OneToOne
    private Album album;
}
