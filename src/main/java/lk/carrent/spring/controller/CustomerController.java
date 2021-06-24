package lk.carrent.spring.controller;

import lk.carrent.spring.dto.CustomerDTO;
import lk.carrent.spring.exception.NotFoundException;
import lk.carrent.spring.service.CustomerService;
import lk.carrent.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/carrent/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    private static final String UPLOADED_FOLDER = "lk/carrent/spring/saveFile/customer";

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id) {
        CustomerDTO dto = service.searchCustomer(Long.valueOf(id));
        return new ResponseEntity(new StandardResponce("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) {
//        if (dto.getCustomerID().trim().length() <= 0 || dto.getAddress().trim().length() <= 0 ||
//                dto.getFirstName().trim().length() <= 0 || dto.getLastName().trim().length() <= 0 ||
//                dto.getContactNumber().trim().length() <= 0 || dto.getDriveLicenseNumber().trim().length() <= 0 ||
//                dto.getNic().trim().length() <= 0) {
//            throw new ValidateException("Fields Can't be empty");
//        }
        System.out.println("saveCustomer(controller) : "+dto);
        service.addCustomer(dto);

        return new ResponseEntity(new StandardResponce("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto) {
        if (dto.getCustomerID() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateCustomer(dto);
        return new ResponseEntity(new StandardResponce("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteCustomer(String id) {
        service.deleteCustomer(Long.valueOf(id));
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCustomer() {
        ArrayList<CustomerDTO> allCustomers = service.getAllCustomers();
        return new ResponseEntity(new StandardResponce("200", "Done", allCustomers), HttpStatus.OK);
    }

    @GetMapping(path = "searchByName/{name}")
    public ResponseEntity searchByName(@PathVariable String name) {
        ArrayList<CustomerDTO> allCustomers = service.SearchCustomersByName(name);
        return new ResponseEntity(new StandardResponce("200", "Done", allCustomers), HttpStatus.OK);
    }
}
