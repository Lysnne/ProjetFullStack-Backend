package ikasaidi.backend.service;

import ikasaidi.backend.exception.CustomerNotFoundException;
import ikasaidi.backend.model.Customer;
import ikasaidi.backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public String registerCustomer(String password) {
        return passwordEncoder.encode(password); // Save this in the database
    }


    public List<Customer> insertListCustomer(List<Customer> list){
        return customerRepository.saveAll(list);
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer createCustomer(Customer customer){
        customerRepository.save(customer);
        return customer;
    }

    public Customer updateCustomer(Customer newOne, Long id){
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

    public String deleteCustomer(Long id){
        if(!customerRepository.existsById(id)){
            throw new CustomerNotFoundException(id);
        }
        customerRepository.deleteById(id);
        return  "Customer with id "+ id +" has been deleted success.";
    }
}
