package ikasaidi.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_portfolio ;
    private Double shares_owned ;
    private Double total_value ;
    private Double total_profit ;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer")
    Customer customer;


    public Long getId_portfolio() {
        return id_portfolio;
    }

    public void setId_portfolio(Long id_portfolio) {
        this.id_portfolio = id_portfolio;
    }

    public Double getShares_owned() {
        return shares_owned;
    }

    public void setShares_owned(Double shares_owned) {
        this.shares_owned = shares_owned;
    }

    public Double getTotal_value() {
        return total_value;
    }

    public void setTotal_value(Double total_value) {
        this.total_value = total_value;
    }

    public Double getTotal_profit() {
        return total_profit;
    }

    public void setTotal_profit(Double total_profit) {
        this.total_profit = total_profit;
    }

}
