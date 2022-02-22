package com.bookyourmovie.service.b2c;

import com.bookyourmovie.domain.entities.Location;
import com.bookyourmovie.domain.entities.Movie;
import com.bookyourmovie.domain.entities.MovieShow;
import com.bookyourmovie.domain.entities.Theatre;
import com.bookyourmovie.domain.valueobject.MovieVO;
import com.bookyourmovie.domain.valueobject.TheatreListVO;

import java.util.List;

public interface TheatreService {

    public TheatreListVO getAllTheatre(String city);
    public Theatre getTheatreById(Long id);

    public List<Theatre> getAllTheatre(Location location);
    public List<MovieShow> getMovieShow(String movieName);
    public Long getAvailableSeat(Movie movie, Theatre theatre);
    MovieVO getMovie(String movieName);

    public List<Theatre> getTheatreForAMovie(Movie movie, Location location);
    public List<Movie> getMovieListOnTheatre(Theatre theatre);

}
