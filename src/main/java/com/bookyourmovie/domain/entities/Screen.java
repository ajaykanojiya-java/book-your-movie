package com.bookyourmovie.domain.entities;

import lombok.AccessLevel;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="SCREEN")
@Setter(value = AccessLevel.NONE)
public class Screen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCREEN_ID")
    private Long id;

    @Column(name = "SCREEN_NAME")
    private String screenName;

    @Column(name = "NO_OF_SEAT")
    private Integer noOfSeat;

    @ManyToOne
    @JoinColumn(name = "THEATRE_ID")
    private Theatre theatre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "screen")
    private List<MovieShow> shows = new ArrayList<>();

    public Screen addMovieShow(MovieShow movieShow){
        movieShow.setScreen(this);
        shows.add(movieShow);
        return this;
    }

    public List<MovieShow> getMovieShow(){
        return shows;
    }

    public Screen() {
    }

    public Screen(String screenName, Integer noOfSeat, Theatre theatre) {
        this.screenName = screenName;
        this.noOfSeat = noOfSeat;
        this.theatre = theatre;
    }

    public Long getId() {
        return id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Integer getNoOfSeat() {
        return noOfSeat;
    }

    public void setNoOfSeat(Integer noOfSeat) {
        this.noOfSeat = noOfSeat;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
