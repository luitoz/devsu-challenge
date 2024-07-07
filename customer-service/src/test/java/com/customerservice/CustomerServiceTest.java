package com.customerservice;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.customerservice.Customer;
import com.customerservice.CustomerRepository;
import com.customerservice.CustomerService;
import com.customerservice.Gender;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testGetCustomerById() {
        Long customerId = 1l;
        Customer mockCustomer = new Customer(customerId, "Franklin Bernal", 
        		Gender.MASCULINO, 30, "Cacique Chaparra", "0979100036", "password123", true);

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(mockCustomer));

        Customer retrievedCustomer = customerService.getCustomerById(customerId).orElse(null);

        assertEquals(mockCustomer, retrievedCustomer);
        verify(customerRepository, times(1)).findById(customerId);
    }

}