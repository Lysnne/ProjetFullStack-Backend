package ikasaidi.backend.service;

import ikasaidi.backend.exception.StockNotFoundException;
import ikasaidi.backend.model.Stock;
import ikasaidi.backend.repositories.CustomerRepository;
import ikasaidi.backend.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new StockNotFoundException(id));
    }

    public Stock createStock(Stock stock) {
        stockRepository.save(stock);
        return stock;
    }

    public Stock updateStock(Stock newOne, Long id) {
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

    public String deleteStock(Long id) {
        if(!stockRepository.existsById(id)){
            throw new StockNotFoundException(id);
        }
        stockRepository.deleteById(id);
        return  "Stock with id "+ id +" has been deleted success.";
    }


}
