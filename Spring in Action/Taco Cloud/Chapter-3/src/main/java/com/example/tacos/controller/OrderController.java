package com.example.tacos.controller;

import com.example.tacos.domain.TacoOrder;
import com.example.tacos.repository.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@Slf4j
@RequestMapping(path = "/orders")
@SessionAttributes(value = {"tacoOrder"})
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(path = "/current")
    public String orderForm(){
        return "orderForm";
    }
    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus){
        if(errors.hasErrors()){
            log.info("Invalid order, try again");
            return "orderForm";
        }
        orderRepository.saveOrder(order);
        log.info("Order submitted: {}",order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
