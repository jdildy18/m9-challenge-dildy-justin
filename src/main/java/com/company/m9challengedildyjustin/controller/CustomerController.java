package com.company.m9challengedildyjustin.controller;

import com.company.m9challengedildyjustin.model.Customer;
import com.company.m9challengedildyjustin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repo;

    @GetMapping("/customers")
    public List<Customer> getCustomers() { return repo.findAll();}

    @GetMapping("customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {

        Optional<Customer> returnVal = repo.findById(id);
        if(returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }


    //CREATE DATABASE
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) { return repo.save(customer);}

    //UPDATE DATABASE
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {repo.save(customer);}

    //DELETE DATABASE
    @DeleteMapping("/customers{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) { repo.deleteById(id);}










}
