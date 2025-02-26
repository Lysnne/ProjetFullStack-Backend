package ikasaidi.backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transaction_id;
    private Double shares ;
    private Double price_per_share ;
    private Double transaction_fee ;
    private Double net_amount ;
    private String order_type ;
    private Date transaction_date;

    //A mettre dans une table
    private enum transaction_type {
        buy,
        sell
    }
    private enum transaction_status {
        completed,
        failed,
        pending
    }

    @OneToOne
    Stock stock_symbol;

    @OneToOne
    Customer customer_id ;

    @OneToOne
    Stock stock_id;

}
