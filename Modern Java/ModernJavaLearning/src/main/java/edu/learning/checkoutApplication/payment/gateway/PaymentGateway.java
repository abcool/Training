package edu.learning.checkoutApplication.payment.gateway;

import edu.learning.checkoutApplication.domain.Card;
import edu.learning.checkoutApplication.domain.PaymentResponse;

public sealed abstract class PaymentGateway permits DebitCardPayment, CreditCardPayment, RewardsCardPayment {
    public abstract PaymentResponse makePayment(Card card, double amount);
}
