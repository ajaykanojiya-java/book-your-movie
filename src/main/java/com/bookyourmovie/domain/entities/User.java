package com.bookyourmovie.domain.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MOVIE_USER")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @Column(name="USERNAME")
    private String userName;

    @Column(name="CONTACT_NO")
    private String contactNo;

    @Column(name="EMAIL")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Booking> bookingList = new ArrayList<>();

    //making bidirectional
    public User addBooking(Booking booking){
        booking.setUser(this);
        bookingList.add(booking);
        return this;
    }
}
