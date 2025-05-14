package com.Project.CRUD.CustomerService;

import com.Project.CRUD.CustomerEntity.Customer;
import com.Project.CRUD.CustomerRepo.CustomerRepo;
import com.Project.CRUD.DTO.CustomerDTO;
import com.Project.CRUD.DTO.CustomerSaveDTO;
import com.Project.CRUD.DTO.CustomerUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public CustomerSaveDTO addCustomer(CustomerSaveDTO customerSaveDTO) {
        Customer customer = new Customer();
        customer.setCustomerName(customerSaveDTO.getCustomerName());
        customer.setCustomerAddress(customerSaveDTO.getCustomerAddress());
        customer.setMobile(customerSaveDTO.getMobile());
        Customer savedCustomer = customerRepo.save(customer);
        CustomerSaveDTO customerSaveDTO1 = new CustomerSaveDTO();
        customerSaveDTO1.setCustomerName(savedCustomer.getCustomerName());
        customerSaveDTO1.setCustomerAddress(savedCustomer.getCustomerAddress());
        customerSaveDTO1.setMobile(savedCustomer.getMobile());
        return customerSaveDTO1;
    }
    public List<CustomerDTO> getAllCustomers(){
        List<Customer> customers = customerRepo.findAllByOrderByCustomerIdAsc();
        return customers.stream().map(cust ->{
            CustomerDTO customerDTO1 = new CustomerDTO();
            customerDTO1.setCustomerId(cust.getCustomerId());
            customerDTO1.setCustomerName(cust.getCustomerName());
            customerDTO1.setCustomerAddress(cust.getCustomerAddress());
            customerDTO1.setMobile(cust.getMobile());
            return customerDTO1;
        }).collect(Collectors.toList());
    }

    public CustomerUpdateDTO updateCustomer(Integer customerId, CustomerUpdateDTO customerUpdateDTO){
        Customer existingCustomer = customerRepo.findById(customerId).orElseThrow(()->new RuntimeException("customer id not found.."+customerId));
        existingCustomer.setCustomerName(customerUpdateDTO.getCustomerName());
        existingCustomer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
        existingCustomer.setMobile(customerUpdateDTO.getMobile());
        Customer updatedCustomer = customerRepo.save(existingCustomer);
        CustomerUpdateDTO customerUpdateDTO1 = new CustomerUpdateDTO();
        customerUpdateDTO1.setCustomerId(updatedCustomer.getCustomerId());
        customerUpdateDTO1.setCustomerName(updatedCustomer.getCustomerName());
        customerUpdateDTO1.setCustomerAddress(updatedCustomer.getCustomerAddress());
        customerUpdateDTO1.setMobile(updatedCustomer.getMobile());
        return customerUpdateDTO1;
    }

    public void deleteCustomer(Integer customerId){
        Customer deleteACustomer = customerRepo.findById(customerId).orElseThrow(()->new RuntimeException("Customer not found.."+customerId));
        customerRepo.delete(deleteACustomer);
    }
}



