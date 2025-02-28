package ikasaidi.backend.repositories;

import ikasaidi.backend.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StockRepository extends JpaRepository<Stock, Integer> {
}
