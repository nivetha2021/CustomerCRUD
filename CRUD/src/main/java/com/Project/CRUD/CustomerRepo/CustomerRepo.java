package com.Project.CRUD.CustomerRepo;

import com.Project.CRUD.CustomerEntity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByOrderByCustomerIdAsc();
}
