package ikasaidi.backend.controllers;

import ikasaidi.backend.exception.StockNotFoundException;
import ikasaidi.backend.model.Stock;
import ikasaidi.backend.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@CrossOrigin()
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @GetMapping("/getAllStocks")
    public List<Stock> getAll(){
        return stockRepository.findAll();
    }

    @PostMapping("/createStock")
    public Stock createStock(@RequestBody Stock stock){
        stockRepository.save(stock);
        return stock;
    }

    @GetMapping("/stock/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new StockNotFoundException(id));
    }


    @PutMapping("/stock/{id}")
    Stock updateStock(@RequestBody Stock newOne, @PathVariable Long id) {
        return stockRepository.findById(id)
                .map(stock -> {
                    stock.setSymbol(newOne.getSymbol());
                    stock.setName(newOne.getName());
                    stock.setPrice(newOne.getPrice());
                    stock.setSector(newOne.getSector());
                    stock.setVolume(newOne.getVolume());
                    stock.setMarketcap(newOne.getMarketcap());
                    return stockRepository.save(stock);
                }).orElseThrow(() -> new StockNotFoundException(id));
    }

    @DeleteMapping("/stock/{id}")
    String deleteStock(@PathVariable Long id){
        if(!stockRepository.existsById(id)){
            throw new StockNotFoundException(id);
        }
        stockRepository.deleteById(id);
        return  "Stock with id "+id+" has been deleted success.";
    }
}
