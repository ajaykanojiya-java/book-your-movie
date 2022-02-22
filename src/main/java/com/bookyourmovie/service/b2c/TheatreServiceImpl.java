package com.bookyourmovie.service.b2c;

import com.bookyourmovie.domain.entities.Location;
import com.bookyourmovie.domain.entities.Movie;
import com.bookyourmovie.domain.entities.MovieShow;
import com.bookyourmovie.domain.entities.Theatre;
import com.bookyourmovie.domain.valueobject.MovieVO;
import com.bookyourmovie.domain.valueobject.TheatreListVO;
import com.bookyourmovie.repository.LocationRepository;
import com.bookyourmovie.repository.MovieRepository;
import com.bookyourmovie.repository.MovieShowRepository;
import com.bookyourmovie.repository.TheatreRepository;
import com.bookyourmovie.util.MovieVOHelper;
import com.bookyourmovie.util.TheatreVOHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreServiceImpl implements TheatreService {

    Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    MovieShowRepository movieShowRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieVOHelper movieVOHelper;

    @Autowired
    TheatreVOHelper theatreVOHelper;

    @Override
    public TheatreListVO getAllTheatre(String city) {
        logger.info("Inside getAllTheatre(city) method with {} param",city);
        List<Theatre> theatreList = theatreRepository.findAllByLocationCityContaining(city);
        TheatreListVO theatreListVO = theatreVOHelper.constructTheatreVO(theatreList);
        logger.info("Inside getAllTheatre(city) method end");
        return theatreListVO;
    }

    @Override
    public List<Theatre> getAllTheatre(Location location) {
        return null;
    }

    @Override
    public MovieVO getMovie(String movieName) {
        logger.info("Inside getMovie(movieName) method with {} param",movieName);
        Optional<Movie> optionalMovie = movieRepository.findFirstByNameContaining(movieName);
        optionalMovie.orElseThrow(()->{
            logger.error("Incorrect movie name {}",movieName);
            return new RuntimeException("Invalid movie name...");
        });
        Movie movie = optionalMovie.get();
        MovieVO movieVO = movieVOHelper.constructMovieVO(movie);
        return movieVO;
    }

    @Override
    public List<MovieShow> getMovieShow(String movieName) {
        logger.info("Inside getMovieShow(movieName) method with {} param",movieName);
        Optional<Movie> optionalMovie = movieRepository.findFirstByNameContaining(movieName);
        optionalMovie.orElseThrow(()->{
            logger.error("Incorrect movie name {}",movieName);
            return new RuntimeException("Invalid movie name...");});
        List<MovieShow> movies = movieShowRepository.findMovieShowByMovie_Name(optionalMovie.get().getName());
        return movies;
    }

    @Override
    public Long getAvailableSeat(Movie movie, Theatre theatre) {
        return null;
    }

    @Override
    public Theatre getTheatreById(Long id) {
        return null;
    }

    @Override
    public List<Theatre> getTheatreForAMovie(Movie movie, Location location) {
        return null;
    }

    @Override
    public List<Movie> getMovieListOnTheatre(Theatre theatre) {
        return null;
    }
}
