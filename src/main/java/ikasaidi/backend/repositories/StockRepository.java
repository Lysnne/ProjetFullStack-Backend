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


    @Query("select s from Stock s order by s.price")
    public List<Stock> orderByPrice();

    @Query("select s from Stock s order by s.name")
    public List<Stock> orderByName();

    @Query("select s from Stock s order by s.volume")
    public List<Stock> orderByVolume();

    @Query("select s from Stock s order by s.marketcap")
    public List<Stock> orderByMarketCap();


    public Stock findByIdstock(Long id_stock);

}
