package com.java.everis.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Document("Customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastName;

    @Valid
    private TypeCustomer typeCustomer;

    @NotNull
    private String document;

    @NotNull
    private Integer age;

    @NotNull
    private String gender;


    
    

}
