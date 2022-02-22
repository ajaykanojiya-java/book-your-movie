package com.bookyourmovie.service.b2c;

import com.bookyourmovie.domain.entities.Booking;
import com.bookyourmovie.domain.entities.MovieShow;
import com.bookyourmovie.domain.entities.User;
import com.bookyourmovie.domain.valueobject.Amount;
import com.bookyourmovie.domain.valueobject.BookingRequest;
import com.bookyourmovie.domain.valueobject.BookingResponse;
import com.bookyourmovie.domain.valueobject.UserVO;
import com.bookyourmovie.repository.BookingRepository;
import com.bookyourmovie.repository.MovieShowRepository;
import com.bookyourmovie.repository.UserRepository;
import com.bookyourmovie.util.AmountCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

    @Autowired
    AmountCalculator amountCalculator;

    @Autowired
    MovieShowRepository movieShowRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public BookingResponse bookMyShow(BookingRequest bookingRequest) {

        logger.info("Inside bookMyShow(BookingRequest bookingRequest) method with {} param",bookingRequest);

        logger.info("Invoking MovieShowRepository::findById(id) with {} id",bookingRequest.getShowId());
        Optional<MovieShow> optionalMovieShow = movieShowRepository.findById(bookingRequest.getShowId());

        optionalMovieShow.orElseThrow(()-> {
            logger.error("Incorrect show id",bookingRequest.getShowId());
            return new RuntimeException("Incorrect show id..");});

        MovieShow movieShow = optionalMovieShow.get();

        logger.info("Invoking UserRepository::findByUserName(username) with {} username",
                bookingRequest.getUserVO().getUsername());

        Optional<User> optionalUser = userRepository.findByUserName(bookingRequest.getUserVO().getUsername());
        UserVO userVO = bookingRequest.getUserVO();
        boolean isExistingUser = optionalUser.isPresent();
        User savedUser = null;
        Booking savedBooking = null;
        BookingResponse bookingResponse = null;

        if(!isExistingUser){
            logger.info("Found new user save it {}",bookingRequest.getUserVO());
            User user = new User();
            user.setUserName(userVO.getUsername());
            user.setEmail(userVO.getEmail());
            user.setContactNo(userVO.getContactNo());
            logger.info("Invoking UserRepository::save() with {} user details",bookingRequest.getUserVO());
            savedUser = userRepository.save(user);
        }else{
            logger.info("Found existing user {}",bookingRequest.getUserVO());
            savedUser = optionalUser.get();
        }

        logger.info("Total {} available seat for show name {} movie name {}",
                movieShow.getAvailableSeat(), movieShow.getShowName(),movieShow.getMovie().getName());
        if(movieShow.getAvailableSeat() > bookingRequest.getNoOfSeat()){

            Booking booking = new Booking();
            booking.setMovieShow(movieShow);
            booking.setUser(savedUser);
            booking.setNoOfSeatBooked(bookingRequest.getNoOfSeat());

            Amount amount = amountCalculator.calculateAmount(bookingRequest.getNoOfSeat());
            if(makePayment(userVO,amount.getTicketAmount())){

                movieShow.setAvailableSeat(movieShow.getAvailableSeat() - bookingRequest.getNoOfSeat());
                movieShow.setBookedSeat(bookingRequest.getNoOfSeat());

                booking.setTicketAmount(amount.getTicketAmount());
                logger.info("Updating movie show entity for total available seat {} and booked seat {}",
                        movieShow.getAvailableSeat(),movieShow.getBookedSeat());

                movieShowRepository.save(movieShow);

                logger.info("Making a final Booking call BookingRepository::save with {}",
                        bookingRequest);
                savedBooking = bookingRepository.save(booking);
                bookingResponse = createBookingResponse(savedBooking,bookingRequest);
                bookingResponse.setTotalDiscount(amount.getDiscountAmount());
            }else{
                logger.error("Payment declined of {} by user {}",amount.getTicketAmount(),userVO.getUsername());
                throw new RuntimeException("Payment Declined.. Ticket not booked...");
            }

        }else{
            logger.error("Requested seat: {} and available seat: {}",bookingRequest.getNoOfSeat(),
                    movieShow.getAvailableSeat());
            throw new RuntimeException("Requested seat not available..");
        }
        return bookingResponse;
    }

private BookingResponse createBookingResponse(Booking booking, BookingRequest bookingRequest){
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(booking.getId());
        bookingResponse.setMovieName(booking.getMovieShow().getMovie().getName());
        bookingResponse.setNoOfSeats(booking.getNoOfSeatBooked());
        bookingResponse.setTheatreName(booking.getMovieShow().getScreen().getTheatre().getTheatreName());
        bookingResponse.setCity(bookingRequest.getCity());
        bookingResponse.setScreenName(booking.getMovieShow().getScreen().getScreenName());
        bookingResponse.setStartTime(booking.getMovieShow().getStartTime());
        bookingResponse.setEndTime(booking.getMovieShow().getEndTime());
        bookingResponse.setTotalPrice(booking.getTicketAmount());
        bookingResponse.setUserVO(bookingRequest.getUserVO());
        return bookingResponse;
    }
    private boolean makePayment(UserVO userVO, float paymentAmount){
        logger.info("Requesting for Payment of {} by user {}",paymentAmount,userVO.getUsername());
        //integrate payment service call
        logger.info("Requested Payment of {} by user {} completed",paymentAmount,userVO.getUsername());
        return true;
    }
}
