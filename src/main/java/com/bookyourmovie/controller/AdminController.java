package com.bookyourmovie.controller;

import com.bookyourmovie.domain.valueobject.ScreenVO;
import com.bookyourmovie.domain.valueobject.TheatreVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//path /api/v1/admin needs to be protected by implementing the spring sequrity
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping("/theatre/add")
    public ResponseEntity<?> addTheatre(@RequestBody TheatreVO theatreVO){
        logger.info("Inside addTheatre() method");
        return new ResponseEntity<>(null , HttpStatus.OK);
    }

    @PutMapping("/theatre/{theatreId}")
    public ResponseEntity<?> updateTheatre(@PathVariable String theatreId){
        logger.info("Inside updateTheatre() method");
        return new ResponseEntity<>(null , HttpStatus.OK);
    }

    @DeleteMapping("/theatre/{theatreId}")
    public ResponseEntity<?> deleteTheatre(@PathVariable String theatreId){
        logger.info("Inside deleteTheatre() method");
        return new ResponseEntity<>(null , HttpStatus.OK);
    }

    @PostMapping("/theatre/{theatreId}/screen")
    public ResponseEntity<?> addScreenToTheatre(@PathVariable String theatreId, @RequestBody ScreenVO screenVO){
        logger.info("Inside addScreenToTheatre() method");
        return new ResponseEntity<>(null , HttpStatus.OK);
    }

    @PutMapping("/theatre/{theatreId}/screen/{screenId}")
    public ResponseEntity<?> updateScreenToTheatre(@PathVariable String theatreId, @PathVariable String screenId){
        logger.info("Inside updateScreenToTheatre() method");
        return new ResponseEntity<>(null , HttpStatus.OK);
    }

    @DeleteMapping("/theatre/{theatreId}/screen/{screenId}")
    public ResponseEntity<?> deleteScreenToTheatre(@PathVariable String theatreId, @PathVariable String screenId){
        logger.info("Inside deleteScreenToTheatre() method");
        return new ResponseEntity<>(null , HttpStatus.OK);
    }
}
