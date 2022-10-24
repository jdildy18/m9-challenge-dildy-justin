package com.company.m9challengedildyjustin.repository;

import com.company.m9challengedildyjustin.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //Find by Customer ID
    List<Customer> findById(String customerId);

    //Find by Customer State
    List<Customer> findByState(String customerState);

}
