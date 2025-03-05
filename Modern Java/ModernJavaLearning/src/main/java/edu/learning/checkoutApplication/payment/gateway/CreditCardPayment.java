package edu.learning.checkoutApplication.payment.gateway;

import edu.learning.checkoutApplication.domain.Card;
import edu.learning.checkoutApplication.domain.PaymentResponse;

public final class CreditCardPayment extends PaymentGateway {
    public CreditCardPayment() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj != null && obj.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "CreditCardPayment[]";
    }

    @Override
    public PaymentResponse makePayment(Card card, double amount) {
        System.out.println("Payment deducted from credit card for the amount: "+ amount);
        return PaymentResponse.SUCCESS;
    }
}
