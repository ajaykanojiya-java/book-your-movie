package com.bookyourmovie.controller;

import com.bookyourmovie.domain.valueobject.BookingRequest;
import com.bookyourmovie.domain.valueobject.BookingResponse;
import com.bookyourmovie.service.b2c.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// publicly accessed path, no need to implement spring security for the path "/api/v1"
@RestController
@RequestMapping("/api/v1")
public class BookingController {

    Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<BookingResponse> bookShow(@RequestBody BookingRequest bookingRequest){
        logger.info("BookingController invoked bookShow() method with {} parameters",bookingRequest);
        BookingResponse bookingResponse = bookingService.bookMyShow(bookingRequest);
        logger.info("BookingController invoked bookShow() end..");
        return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
    }
}
