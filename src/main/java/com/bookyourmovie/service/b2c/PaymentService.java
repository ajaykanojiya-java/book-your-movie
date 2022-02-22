package com.bookyourmovie.service.b2c;

public interface PaymentService {

    public boolean makePayment();
    public boolean isPaymentDone();
    public boolean isPaymentPending();

}
