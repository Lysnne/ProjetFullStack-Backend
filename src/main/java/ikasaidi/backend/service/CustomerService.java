package ikasaidi.backend.service;

import ikasaidi.backend.exception.CustomerNotFoundException;
import ikasaidi.backend.model.Customer;
import ikasaidi.backend.repositories.CustomerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){

        this.customerRepository = customerRepository;
    }

    public Customer login(String username, String password){

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        Customer customer = customerRepository.findCustomerByUsername(username);
        //check id pwds matches
        if (customer != null && customer.getPassword().equals(password)){
            return customer;

        }
        return null;

    }

  /*  public List<Customer> insertListCustomer(List<Customer> list){
        return customerRepository.saveAll(list);
    }*/

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
