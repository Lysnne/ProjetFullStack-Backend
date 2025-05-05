package ikasaidi.backend.controllers;


import ikasaidi.backend.model.Portfolio;
import ikasaidi.backend.model.Transaction;
import ikasaidi.backend.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolio")
@CrossOrigin
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @GetMapping("/getPortfolio/{id}")
    public Portfolio getPortfolioById(@PathVariable Long id) {
        return portfolioService.getPortfolioById(id);
    }

    @PostMapping("/createPortfolio/{idcustomer}")
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio, @PathVariable Long idcustomer) {
        return portfolioService.createPortfolio(portfolio, idcustomer);
    }
}
