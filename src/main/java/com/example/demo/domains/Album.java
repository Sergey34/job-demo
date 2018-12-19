package com.example.demo.domains;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private LocalDate releaseDate;
    private boolean single;
    private boolean collector;
    @OneToOne
    private Singer singer;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Song> songs;
}
