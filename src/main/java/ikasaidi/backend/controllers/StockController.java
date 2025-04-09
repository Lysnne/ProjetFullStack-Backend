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

    @GetMapping("/getstock/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @PostMapping("/createStock")
    public Stock createStock(@RequestBody Stock stock){
        return stockService.createStock(stock);
    }


    @PutMapping("/stock/{id}")
    Stock updateStock(@RequestBody Stock newOne, @PathVariable Long id) {
       return stockService.updateStock(newOne, id);
    }


    @DeleteMapping("/stock/{id}")
    String deleteStock(@PathVariable Long id){
       return stockService.deleteStock(id);
    }

}
