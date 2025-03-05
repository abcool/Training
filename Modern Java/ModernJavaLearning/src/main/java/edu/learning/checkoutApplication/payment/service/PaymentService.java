package edu.learning.checkoutApplication.payment.service;

import edu.learning.checkoutApplication.domain.OrderDetails;
import edu.learning.checkoutApplication.domain.PaymentResponse;
import edu.learning.checkoutApplication.payment.factory.PaymentFactory;
import edu.learning.checkoutApplication.payment.gateway.PaymentGateway;

public class PaymentService {
    public PaymentResponse makePayment(OrderDetails orderDetails){
        PaymentGateway paymentGateway = PaymentFactory.paymentGateway(orderDetails.card().cardType());
        return paymentGateway.makePayment(orderDetails.card(),orderDetails.amount());
    }
}
