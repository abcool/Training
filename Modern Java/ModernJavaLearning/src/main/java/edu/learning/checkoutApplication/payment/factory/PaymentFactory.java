package edu.learning.checkoutApplication.payment.factory;

import edu.learning.checkoutApplication.domain.CardType;
import edu.learning.checkoutApplication.payment.gateway.CreditCardPayment;
import edu.learning.checkoutApplication.payment.gateway.DebitCardPayment;
import edu.learning.checkoutApplication.payment.gateway.RewardsCardPayment;
import edu.learning.checkoutApplication.payment.gateway.PaymentGateway;

public class PaymentFactory {
    public static PaymentGateway paymentGateway(CardType cardType){
        return switch (cardType){
          case DEBIT -> new DebitCardPayment();
          case CREDIT -> new CreditCardPayment();
          case REWARDS -> new RewardsCardPayment();
          case null, default -> throw new IllegalArgumentException("Invalid card type selected");
        };
    }
}
