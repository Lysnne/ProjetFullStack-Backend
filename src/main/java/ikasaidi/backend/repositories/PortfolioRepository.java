package ikasaidi.backend.repositories;

import ikasaidi.backend.model.Portfolio;
import ikasaidi.backend.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "portfolio", path = "portfolio")
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    Portfolio findByIdportfolio(Long idportfolio);
}
