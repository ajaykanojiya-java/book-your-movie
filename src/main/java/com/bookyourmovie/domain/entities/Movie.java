package com.bookyourmovie.domain.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MOVIE")
@Data
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @Column(name="MOVIE_NAME")
    private String name;

    @Column(name="MOVIE_LANGUAGE")
    private String language;

    @Column(name="GENRE")
    private String genre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<MovieShow> shows = new ArrayList<>();

    //making bidirectional
    public Movie addShow(MovieShow movieShow){
        movieShow.setMovie(this);
        shows.add(movieShow);
        return this;
    }
}
