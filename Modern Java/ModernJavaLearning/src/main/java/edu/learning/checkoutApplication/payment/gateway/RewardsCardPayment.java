package edu.learning.checkoutApplication.payment.gateway;

import edu.learning.checkoutApplication.domain.Card;
import edu.learning.checkoutApplication.domain.PaymentResponse;

public final class RewardsCardPayment extends PaymentGateway {
    public RewardsCardPayment() {
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
        return "RewardsCardPayment[]";
    }

    @Override
    public PaymentResponse makePayment(Card card, double amount) {
        System.out.println("Rewards deducted for amount: "+ amount);
        return PaymentResponse.SUCCESS;
    }
}
