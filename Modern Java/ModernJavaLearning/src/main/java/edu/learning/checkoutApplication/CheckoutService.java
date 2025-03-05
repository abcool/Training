package edu.learning.checkoutApplication;

import edu.learning.checkoutApplication.domain.CheckoutStatus;
import edu.learning.checkoutApplication.domain.OrderDetails;
import edu.learning.checkoutApplication.domain.PaymentResponse;
import edu.learning.checkoutApplication.payment.service.PaymentService;

public class CheckoutService {
    private final PaymentService paymentService;
    public CheckoutService(PaymentService paymentService){
        this.paymentService=paymentService;
    }
    public CheckoutStatus checkoutOrder(OrderDetails orderDetails){
        var paymentResponse = paymentService.makePayment(orderDetails);
        if (paymentResponse.equals(PaymentResponse.SUCCESS))
            return CheckoutStatus.SUCCESS;
        return CheckoutStatus.FAILURE;
    }
}
