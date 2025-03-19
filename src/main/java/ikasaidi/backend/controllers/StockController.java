package ikasaidi.backend.controllers;

import ikasaidi.backend.model.Stock;
import ikasaidi.backend.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
@CrossOrigin()
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @GetMapping
    public List<Stock> getAll(){
        return stockRepository.findAll();
    }


}
