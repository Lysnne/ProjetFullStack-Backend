package ikasaidi.backend.StockServiceTest;

import ikasaidi.backend.model.Stock;
import ikasaidi.backend.repositories.StockRepository;
import ikasaidi.backend.service.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StockServiceTest {


    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockService stockService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStocks() {
        Stock s1 = new Stock("amazon",14.33);
        Stock s2 = new Stock("adui",1466.33);

        List<Stock> stocks = Arrays.asList(s1,s2);

        when(stockRepository.findAll()).thenReturn(stocks);

        List<Stock> resultatGetAll = stockService.getAllStocks();

        assertEquals("amazon", resultatGetAll.get(0).getName());
    }

    @Test
    public void testGetStocksSortedByPrice() {
        Stock s1 = new Stock("amazon",14.33);
        Stock s2 = new Stock("adui",1466.33);

        List<Stock> stocks = Arrays.asList(s1,s2);

        when(stockRepository.orderByPrice()).thenReturn(stocks);

        List<Stock> resultatGetAll = stockService.getStocksSortedByPrice();

        //order croissant
        assertEquals(1466.33, resultatGetAll.get(0).getPrice());
    }

    @Test
    public void testGetStocksSortedByName() {
        Stock s1 = new Stock("amazon",14.33);
        Stock s2 = new Stock("cdui",1466.33);

        List<Stock> stocks = Arrays.asList(s1,s2);

        when(stockRepository.orderByPrice()).thenReturn(stocks);

        List<Stock> resultatGetAll = stockService.getStocksSortedByPrice();

        //order croissant
        assertEquals(1466.33, resultatGetAll.get(0).getPrice());
    }




}
