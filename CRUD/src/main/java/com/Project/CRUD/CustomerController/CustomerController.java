
package com.Project.CRUD.CustomerController;

import com.Project.CRUD.CustomerService.CustomerService;
import com.Project.CRUD.DTO.CustomerDTO;
import com.Project.CRUD.DTO.CustomerSaveDTO;
import com.Project.CRUD.DTO.CustomerUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<CustomerSaveDTO> saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO){
        CustomerSaveDTO savedCustomer = customerService.addCustomer(customerSaveDTO);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);

    }
    @GetMapping("/allCustomerDetails")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        List<CustomerDTO> allEmployees = customerService.getAllCustomers();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }
    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<CustomerUpdateDTO> updateCustomer(@PathVariable("id") Integer customerId, @RequestBody CustomerUpdateDTO customerUpdateDTO){
        CustomerUpdateDTO updatedCustomer = customerService.updateCustomer(customerId, customerUpdateDTO);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Integer customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("customer deleted successfully..", HttpStatus.OK);
    }
}
