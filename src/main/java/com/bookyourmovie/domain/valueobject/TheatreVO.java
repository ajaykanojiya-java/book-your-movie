package com.bookyourmovie.domain.valueobject;

import lombok.Data;

import java.util.List;

@Data
public class TheatreVO {
    private String theatreName;
    private Integer noOfScreen;
    private String city;
    private List<ScreenVO> screenVOList;
}
