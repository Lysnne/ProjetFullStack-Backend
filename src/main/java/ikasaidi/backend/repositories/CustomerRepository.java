package ikasaidi.backend.repositories;

import ikasaidi.backend.model.Customer;
import ikasaidi.backend.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findCustomerByUsername(String username);
}
