package lk.carrent.spring.service;

import lk.carrent.spring.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface CustomerService {
    void addCustomer(CustomerDTO dto);

    void deleteCustomer(Long id);

    CustomerDTO searchCustomer(Long id);

    ArrayList<CustomerDTO> getAllCustomers();

    ArrayList<CustomerDTO> SearchCustomersByName(String name);

    void updateCustomer(CustomerDTO dto);
}
