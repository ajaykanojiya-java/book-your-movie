package com.bookyourmovie.controller;


import com.bookyourmovie.domain.valueobject.MovieVO;
import com.bookyourmovie.domain.valueobject.TheatreListVO;
import com.bookyourmovie.service.b2c.TheatreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class TheatreController {

    Logger logger = LoggerFactory.getLogger(TheatreController.class);

    @Autowired
    TheatreService theatreService;

    @GetMapping("/movie/{name}")
    public ResponseEntity<MovieVO> getMovieShowByMovieName(@PathVariable String name){
        logger.info("TheatreController invoked getMovieShowByMovieName() method with {} param",name);
        MovieVO movie = theatreService.getMovie(name);
        logger.info("TheatreController invoked getMovieShowByMovieName() method end");
        return new ResponseEntity<>(movie , HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<TheatreListVO> getTheatreByCity(@PathVariable String city){
        logger.info("TheatreController invoked getTheatreByCity() method with {} param",city);
        TheatreListVO theatreList = theatreService.getAllTheatre(city);
        logger.info("TheatreController invoked getTheatreByCity() method end ");
        return new ResponseEntity<>(theatreList, HttpStatus.OK);
    }


}
