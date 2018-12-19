package com.example.demo.domains;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @OneToOne
    private Singer singer;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Song> songs;
}
