package edu.learning.api.composite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ServiceAddressesDTO {
    private String cmp;
    private String pro;
    private String rev;
    private String rec;
}
