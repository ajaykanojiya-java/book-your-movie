package com.bookyourmovie.domain.valueobject;

import lombok.Data;

import java.time.LocalTime;

@Data
public class MovieShowVO {
    private String showName;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long totalSeat;
    private Long availableSeat;
    private String screenName;
    private String theatreName;
    private String city;
}
