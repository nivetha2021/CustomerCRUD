package com.Project.CRUD.CustomerService;

import com.Project.CRUD.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerSaveDTO addCustomer(CustomerSaveDTO customerSaveDTO);
    List<CustomerDTO> getAllCustomers();
    //update
    CustomerUpdateDTO updateCustomer(Integer customerId, CustomerUpdateDTO customerUpdateDTO);
    //delete
    void deleteCustomer(Integer customerId);
}
