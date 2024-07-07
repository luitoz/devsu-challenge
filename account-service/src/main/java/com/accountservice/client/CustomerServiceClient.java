package com.accountservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accountservice.dto.CustomerDTO;

@Service
public class CustomerServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String CUSTOMER_SERVICE_URL = "http://app1:8080/clientes";

    public CustomerDTO getCustomerById(Long customerId) {
        return restTemplate.getForObject(CUSTOMER_SERVICE_URL + "/" + customerId, CustomerDTO.class);
    }
}
