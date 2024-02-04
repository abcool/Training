package com.example.tacos.domain;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table(value = "orders")
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = -8585693300900663696L;

    @PrimaryKey
    private UUID orderId = Uuids.timeBased();

    private Date orderDate;

    @NotBlank(message = "Delivery name is required")
    private String deliveryName;
    @NotBlank(message = "Delivery street is required")
    private String deliveryStreet;
    @NotBlank(message = "delivery City is required")
    private String deliveryCity;
    @NotBlank(message = "delivery State is required")
    private String deliveryState;
    @NotBlank(message = "delivery Zip is required")
    private String deliveryZip;
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Not a valid expiry date")
    @Column(value = "CC_EXPIRATION")
    private String ccExpiry;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;
   @Column("tacos")
    private List<TacoUDT> tacos = new ArrayList<>();

    public void addTaco(TacoUDT taco){
        this.tacos.add(taco);
    }
}
