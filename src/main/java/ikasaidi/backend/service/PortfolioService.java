package ikasaidi.backend.service;

import ikasaidi.backend.exception.ModelNotFoundException;
import ikasaidi.backend.model.Customer;
import ikasaidi.backend.model.Portfolio;
import ikasaidi.backend.model.Stock;
import ikasaidi.backend.repositories.CustomerRepository;
import ikasaidi.backend.repositories.PortfolioRepository;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final CustomerRepository customerRepository;

    public PortfolioService(PortfolioRepository portfolioRepository, CustomerRepository customerRepository) {
        this.portfolioRepository = portfolioRepository;
        this.customerRepository = customerRepository;
    }

    public Portfolio getPortfolioById(Long id){
        return portfolioRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Portfolio", id));
    }

    public Portfolio createPortfolio(Portfolio portfolio, Long idcustomer) {
        Customer customer = customerRepository.findByIdcustomer(idcustomer);
        portfolio.setCustomer(customer);
        portfolioRepository.save(portfolio);
        System.out.println(portfolio);
        return portfolio;
    }


}
