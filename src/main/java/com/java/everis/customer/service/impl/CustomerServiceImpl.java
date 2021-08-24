package com.java.everis.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.java.everis.customer.entity.Customer;
import com.java.everis.customer.entity.TypeCustomer;
import com.java.everis.customer.repository.CustomerRepository;
import com.java.everis.customer.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    WebClient webClient = WebClient.create("http://servicio-zuul-server:9090/ms-profile/typecustomer");

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Mono<Customer> create(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> findById(String id) {
        return customerRepository.findById(id) ;
    }

    @Override
    public Mono<Customer> update(Customer customer) {
        return customerRepository.findById(customer.getId())
                .flatMap(custDB -> {
                    return customerRepository.save(customer);
                });

    }

    @Override
    public Mono<Boolean> delete(String id) {
        return customerRepository.findById(id)
                .flatMap(
                        deleteCustomer -> customerRepository.delete(deleteCustomer)
                                .then(Mono.just(Boolean.TRUE))
                )
                .defaultIfEmpty(Boolean.FALSE);
    }

    @Override
    public Mono<TypeCustomer> findTypeCustomer(String id) {
        return webClient.get().uri("/find/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(TypeCustomer.class);
    }
}
