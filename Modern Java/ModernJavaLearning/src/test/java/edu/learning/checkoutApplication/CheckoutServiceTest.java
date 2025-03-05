package edu.learning.checkoutApplication;

import edu.learning.checkoutApplication.domain.*;
import edu.learning.checkoutApplication.payment.service.PaymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutServiceTest {

    private PaymentService paymentService = new PaymentService();
    private CheckoutService checkoutService = new CheckoutService(paymentService);

    @Test
    void checkoutOrder() {
        Card card = new Card("Rohit","4471414033487991","331","03/31",CardType.CREDIT,"HDFC","VISA");
        OrderDetails orderDetails = new OrderDetails(card,"123",2999.90);
        var response = checkoutService.checkoutOrder(orderDetails);
        Assertions.assertEquals(CheckoutStatus.SUCCESS,response);
    }
}