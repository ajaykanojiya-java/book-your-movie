package com.bookyourmovie.service.b2c;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean makePayment() {
        return false;
    }

    @Override
    public boolean isPaymentDone() {
        return false;
    }

    @Override
    public boolean isPaymentPending() {
        return false;
    }
}
