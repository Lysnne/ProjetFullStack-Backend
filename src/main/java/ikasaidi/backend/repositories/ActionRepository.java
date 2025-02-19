package ikasaidi.backend.repositories;

import ikasaidi.backend.entity.TblAction;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ActionRepository extends JpaRepository<TblAction, Integer> {
}
