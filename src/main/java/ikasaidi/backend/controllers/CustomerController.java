package ikasaidi.backend.controllers;


import ikasaidi.backend.dto.EditCustomer;
import ikasaidi.backend.model.Customer;
import ikasaidi.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/signin/{username}/{pwd}")
    public Customer signin(@PathVariable String username, @PathVariable String pwd){
        return customerService.login(username,pwd);

    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAll(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/getCustomer/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/updateBalance/{id}")
    public Customer updateBalance(@RequestBody Customer newOne, @PathVariable Long id) {
        return customerService.updateBalance(newOne, id);
    }



    @PutMapping("/customers/{id}")
    public Customer editCustomer(@RequestBody EditCustomer dto, @PathVariable Long id) {
        return customerService.editCusto(dto, id);
    }




}
