package edu.learning.api.composite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
public class ServiceAddressesDTO {
    private final String cmp;
    private final String pro;
    private final String rev;
    private final String rec;
}
