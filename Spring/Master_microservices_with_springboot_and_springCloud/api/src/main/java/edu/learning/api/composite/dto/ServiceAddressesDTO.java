package edu.learning.api.composite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@ToString
public class ServiceAddressesDTO {
    private final String cmp;
    private final String pro;
    private final String rev;
    private final String rec;
}
