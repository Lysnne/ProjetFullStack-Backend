package ikasaidi.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TransactionStatus {
    @Id
    private Integer id;
    private String Status;
}
