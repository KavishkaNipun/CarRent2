package lk.carrent.spring.service.impl;

import lk.carrent.spring.dto.CustomerDTO;
import lk.carrent.spring.entity.Customer;
import lk.carrent.spring.exception.ValidateException;
import lk.carrent.spring.repo.CustomerRepo;
import lk.carrent.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDTO dto) {
        if (customerRepo.existsCustomerByNic(dto.getNic())) {
            throw new ValidateException("Customer Already Exist");
        }

        System.out.println("addCustomer(service) : "+dto);

        customerRepo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void deleteCustomer(Long id) {
        if (!customerRepo.existsById(id)) {
            throw new ValidateException("No Customer for Delete..!");
        }
        customerRepo.deleteById(id);
    }

    @Override
    public CustomerDTO searchCustomer(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), CustomerDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<CustomerDTO> SearchCustomersByName(String name) {
        List<Customer> all = customerRepo.searchCustomersByName(name);
        return mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCustomerID())) {
            customerRepo.save(mapper.map(dto, Customer.class));
        }
    }

}
