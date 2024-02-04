package com.example.tacos.domain;


import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Table(value = "ingredients")
public class Ingredient{
    @PrimaryKey
    private final String id;
    private final String name;
    private final Type type;
}
