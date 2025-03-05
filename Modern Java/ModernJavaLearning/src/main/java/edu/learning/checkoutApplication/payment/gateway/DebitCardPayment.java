package edu.learning.checkoutApplication.payment.gateway;

import edu.learning.checkoutApplication.domain.Card;
import edu.learning.checkoutApplication.domain.PaymentResponse;

public final class DebitCardPayment extends PaymentGateway {

    @Override
    public PaymentResponse makePayment(Card card, double amount) {
        System.out.println("Payment deducted from debit card for the amount: "+ amount);
        return PaymentResponse.SUCCESS;
    }
}
