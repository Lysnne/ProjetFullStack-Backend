package ikasaidi.backend.service;

import ikasaidi.backend.model.Customer;
import ikasaidi.backend.repositories.CustomerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public boolean login(String username, String frontEndPWD){
        // findUserByUsername
        Customer customer = customerRepository.findCustomerByUsername(username);
        //check id pwds matches
        return passwordEncoder.matches(frontEndPWD, customer.getPassword());
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public String registerCustomer(String password) {
        return passwordEncoder.encode(password); // Save this in the database
    }


    public List<Customer> insertListCustomer(List<Customer> list){
        return customerRepository.saveAll(list);
    }
}
