package edu.learning.checkoutApplication.domain;

public record OrderDetails(Card card, String order_id, double amount) {
}
