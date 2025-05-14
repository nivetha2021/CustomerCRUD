package com.Project.CRUD.CustomerService;

import com.Project.CRUD.CustomerEntity.Customer;
import com.Project.CRUD.DTO.CustomerDTO;
import com.Project.CRUD.DTO.CustomerSaveDTO;
import com.Project.CRUD.DTO.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {

    CustomerSaveDTO addCustomer(CustomerSaveDTO customerSaveDTO);
    List<CustomerDTO> getAllCustomers();
    //update
    CustomerUpdateDTO updateCustomer(Integer customerId, CustomerUpdateDTO customerUpdateDTO);
    //delete
    void deleteCustomer(Integer customerId);
}
