package com.java.everis.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeCustomer {
    private String id;

    private EnumTypeCustomer value;

    private SubType subType;

    public enum EnumTypeCustomer {
        EMPRESARIAL, PERSONAL
    }

    
}

