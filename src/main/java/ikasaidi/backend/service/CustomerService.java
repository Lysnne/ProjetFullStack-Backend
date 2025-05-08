package ikasaidi.backend.service;

import ikasaidi.backend.dto.EditCustomer;
import ikasaidi.backend.exception.CustomerNotFoundException;
import ikasaidi.backend.model.Customer;
import ikasaidi.backend.repositories.CustomerRepository;
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


    public Customer updateCustomer(Customer newOne, Long id) {
        System.out.println(id);
        return customerRepository.findById(id)
            .map(customer -> {
                    customer.setIdcustomer(newOne.getIdcustomer());
                    customer.setFirst_name(newOne.getFirst_name());
                    customer.setLast_name(newOne.getLast_name());
                    customer.setDate_of_birth(newOne.getDate_of_birth());
                    customer.setEmail(newOne.getEmail());
                    customer.setPhone(newOne.getPhone());
                    customer.setPassword(newOne.getPassword());
                    customer.setBalance(newOne.getBalance());
                System.out.println(customer);
                return customerRepository.save(customer);
            }).orElseThrow(() -> new CustomerNotFoundException(id));


    }

    /*Ikram*/
    public Customer editCusto(EditCustomer newOne, Long id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setFirst_name(newOne.getFirst_name());
                    customer.setLast_name(newOne.getLast_name());
                    customer.setEmail(newOne.getEmail());
                    customer.setPhone(newOne.getPhone());
                    customer.setPassword(newOne.getPassword());
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new CustomerNotFoundException(id));
    }


}
