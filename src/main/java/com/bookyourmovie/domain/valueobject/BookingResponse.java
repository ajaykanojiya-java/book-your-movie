package com.bookyourmovie.domain.valueobject;

import lombok.Data;

import java.time.LocalTime;

@Data
public class BookingResponse {
    private Long bookingId;
    private String city;
    private String movieName;
    private String theatreName;
    private String screenName;
    private Long noOfSeats;
    private LocalTime startTime;
    private LocalTime endTime;
    private Float totalPrice;
    private Float totalDiscount;
    private UserVO userVO;
}
