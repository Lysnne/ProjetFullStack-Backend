package ikasaidi.backend.controllers;


import ikasaidi.backend.model.Stock;
import ikasaidi.backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@CrossOrigin()
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/getAllStocks")
    public List<Stock> getAll(){
        return stockService.getAllStocks();
    }

    @GetMapping("/getAllStocksSortedByPrice")
    public List<Stock> getAllStocksSortedByPrice(){
        return stockService.getStocksSortedByPrice();
    }

    @GetMapping("/getAllStocksSortedByName")
    public List<Stock> getAllStocksSortedByName(){
        return stockService.getStocksSortedByName();
    }

    @GetMapping("/getAllStocksSortedByVolume")
    public List<Stock> getAllStocksSortedByVolume(){
        return stockService.getStocksSortedByVolume();
    }

    @GetMapping("/getAllStocksSortedByMarketCap")
    public List<Stock> getAllStocksSortedByMarketCap(){
        return stockService.getStocksSortedByMarketCap();
    }

}
