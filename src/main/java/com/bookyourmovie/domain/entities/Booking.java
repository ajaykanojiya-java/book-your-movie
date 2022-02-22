package com.bookyourmovie.domain.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="BOOKING")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="BOOKING_ID")
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @Column(name="NO_SEAT_BOOKED")
    private Long noOfSeatBooked;

    @Column(name="TICKET_AMOUNT")
    private Float ticketAmount;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="SHOW_ID")
    private MovieShow movieShow;
}
