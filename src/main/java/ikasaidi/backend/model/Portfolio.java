package ikasaidi.backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer portfolio_id ;
    private Double shares_owned ;
    private Date DATE;
    private Double total_value ;
    private Double total_profit ;
    @OneToOne
    Customer customer_id ;

    @OneToOne
    Stock stock_id;
}
