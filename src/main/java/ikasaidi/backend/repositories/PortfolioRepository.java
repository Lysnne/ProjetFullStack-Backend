package ikasaidi.backend.repositories;

import ikasaidi.backend.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "portfolio", path = "portfolio")
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> { ;
}
