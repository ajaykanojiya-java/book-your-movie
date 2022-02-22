package com.bookyourmovie.domain.valueobject;

import lombok.Data;

import java.util.List;

@Data
public class MovieVO {
    private String movieName;
    private String genre;
    private String language;
    private List<MovieShowVO> movieShowVOList;
}
