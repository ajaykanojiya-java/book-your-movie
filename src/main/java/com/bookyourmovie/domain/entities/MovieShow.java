package com.bookyourmovie.domain.entities;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MOVIE_SHOW")
@Data
public class MovieShow implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="SHOW_ID")
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @Column(name="SHOW_NAME")
    private String showName;

    @Column(name = "START_TIME")
    private LocalTime startTime;

    @Column(name = "END_TIME")
    private LocalTime endTime;

    @Column(name="TOTAL_SEAT")
    private Long totalSeat;

    @Column(name="AVAILABLE_SEAT")
    private Long availableSeat;

    @Column(name="BOOKED_SEAT")
    private Long bookedSeat;

    @Column(name="PRICE")
    private Float price;

    @ManyToOne
    @JoinColumn(name="MOVIE_ID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="SCREEN_ID")
    private Screen screen;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieShow")
    private List<Booking> bookingList = new ArrayList<>();

    public MovieShow(){}

    public MovieShow(String showName, LocalTime startTime, LocalTime endTime, Long totalSeat, Long availableSeat,
                     Long bookedSeat, Movie movie, Screen screen) {
        this.showName = showName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalSeat = totalSeat;
        this.availableSeat = availableSeat;
        this.bookedSeat = bookedSeat;
        this.movie = movie;
        this.screen = screen;
    }

    //Bidirectional
    public MovieShow addBooking(Booking booking){
        booking.setMovieShow(this);
        bookingList.add(booking);
        return this;
    }
}
