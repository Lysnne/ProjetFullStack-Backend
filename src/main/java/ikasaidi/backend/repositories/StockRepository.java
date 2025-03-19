package ikasaidi.backend.repositories;

import ikasaidi.backend.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "stock", path = "stock")
public interface StockRepository extends JpaRepository<Stock, Long> {

    public Stock findStocksByName(String name);
    public Stock findStocksBySymbol(String symbol);
    public List<Stock> findStocksBySector(String sector);

    @Query("select max(s.price)  from Stock s")
    public Double getMaxPrice();

    @Query("select min(s.price)  from Stock s")
    public Double getMinPrice();

    @Query("select max(s.marketcap)  from Stock s")
    public Double getMaxMarketCap();

    @Query("select min(s.marketcap)  from Stock s")
    public Double getMinMarketCap();

    @Query("select max(s.volume)  from Stock s")
    public Double getMaxVolume();

    @Query("select min(s.volume)  from Stock s")
    public Double getMinVolume();



}
