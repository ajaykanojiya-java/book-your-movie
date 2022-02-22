package com.bookyourmovie.domain.valueobject;

import lombok.Data;

import java.util.List;

@Data
public class ScreenVO {
    private String screenName;
    private Integer noOfSeats;
    private List<MovieShowVO> movieShowVOList;
}
