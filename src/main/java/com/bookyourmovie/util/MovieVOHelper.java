package com.bookyourmovie.util;

import com.bookyourmovie.domain.entities.Movie;
import com.bookyourmovie.domain.valueobject.MovieShowVO;
import com.bookyourmovie.domain.valueobject.MovieVO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieVOHelper {

    public MovieVO constructMovieVO(Movie movie){
        MovieVO movieVO = new MovieVO();
        movieVO.setMovieName(movie.getName());
        movieVO.setGenre(movie.getGenre());
        movieVO.setLanguage(movie.getLanguage());

        List<MovieShowVO> movieShowVOList = movie.getShows().stream().map(movieShow -> {
            MovieShowVO movieShowVO = new MovieShowVO();
            movieShowVO.setShowName(movieShow.getShowName());
            movieShowVO.setStartTime(movieShow.getStartTime());
            movieShowVO.setEndTime(movieShow.getEndTime());
            movieShowVO.setTotalSeat(movieShow.getTotalSeat());
            movieShowVO.setAvailableSeat(movieShow.getAvailableSeat());
            movieShowVO.setScreenName(movieShow.getScreen().getScreenName());
            movieShowVO.setTheatreName(movieShow.getScreen().getTheatre().getTheatreName());
            movieShowVO.setCity(movieShow.getScreen().getTheatre().getLocation().getCity());
            return movieShowVO;
        }).collect(Collectors.toList());
        movieVO.setMovieShowVOList(movieShowVOList);
        return movieVO;
    }
}
