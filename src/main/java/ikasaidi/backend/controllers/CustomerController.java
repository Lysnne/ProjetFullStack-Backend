package ikasaidi.backend.controllers;


import ikasaidi.backend.exception.CustomerNotFoundException;
import ikasaidi.backend.exception.StockNotFoundException;
import ikasaidi.backend.model.Customer;
import ikasaidi.backend.model.Stock;
import ikasaidi.backend.repositories.CustomerRepository;
import ikasaidi.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/signin/{username}/{pwd}")
    public boolean signin(@PathVariable String username, @PathVariable String pwd){
        return customerService.login(username, pwd);
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAll(){
        return customerService.findAllCustomers();
    }



    @GetMapping("/getCustomer/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
    @PutMapping("/updateCustomer/{id}")
    public Customer updatCustomer(@RequestBody Customer newOne, @PathVariable Long id) {
        return customerService.updateCustomer(newOne, id);
    }





}
