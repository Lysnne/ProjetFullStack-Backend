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
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/signin/{username}/{pwd}")
    public boolean signin(@PathVariable String username, @PathVariable String pwd){
        return customerService.login(username, pwd);
    }

    @GetMapping("/signin2")
    public boolean signin2(@RequestParam String username, @RequestParam String pwd){
        return customerService.login(username, pwd);
    }
    /*
    @GetMapping("/getAllCustomers")
    public List<Customer> getAll(){
        return customerService.findAll();
    }

    @PostMapping("/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer){
        CustomerRepository.save(customer);
        return customer;
    }

     */

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }


    @PutMapping("/customer/{id}")
    Customer updateCustomer(@RequestBody Customer newOne, @PathVariable Long id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setBalance(newOne.getBalance());
                    customer.setDate_of_birth(newOne.getDate_of_birth());
                    customer.setEmail(newOne.getEmail());
                    customer.setFirst_name(newOne.getFirst_name());
                    customer.setLast_name(newOne.getLast_name());
                    customer.setPassword(newOne.getPassword());
                    customer.setPhone(newOne.getPhone());
                    customer.setUsername(newOne.getUsername());
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @DeleteMapping("/customer/{id}")
    String deleteCustomer(@PathVariable Long id){
        if(!customerRepository.existsById(id)){
            throw new CustomerNotFoundException(id);
        }
        customerRepository.deleteById(id);
        return  "Customer with id "+ id +" has been deleted success.";
    }
}
