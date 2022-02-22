package com.bookyourmovie.domain.valueobject;

import lombok.Data;

@Data
public class BookingRequest {
    private String city;
    private String movieName;
    private Long showId;
    private Long theatreId;
    private Long noOfSeat;
    private UserVO userVO;
}
