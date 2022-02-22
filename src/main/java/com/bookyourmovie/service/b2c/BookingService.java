package com.bookyourmovie.service.b2c;

import com.bookyourmovie.domain.valueobject.BookingRequest;
import com.bookyourmovie.domain.valueobject.BookingResponse;

public interface BookingService {

    BookingResponse bookMyShow(BookingRequest bookingRequest);

}
