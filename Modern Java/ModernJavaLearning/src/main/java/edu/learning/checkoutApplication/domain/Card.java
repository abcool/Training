package edu.learning.checkoutApplication.domain;

public record Card(String cardHolderName, String cardNumber,String cvv, String expiry, CardType cardType, String issuer, String cardNetwork) {
}
