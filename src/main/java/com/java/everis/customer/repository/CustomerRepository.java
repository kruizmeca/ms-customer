package com.java.everis.customer.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.java.everis.customer.entity.Customer;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
