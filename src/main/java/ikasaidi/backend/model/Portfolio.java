package ikasaidi.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idportfolio ;
    private Double shares_owned ;
    private Double total_value ;
    private Double total_profit ;

    @ManyToOne
    @JoinColumn(name = "idcustomer", referencedColumnName = "idcustomer")
    Customer customer;

    public Portfolio() {
        shares_owned = 0.0;
        total_value = 0.0;
        total_profit = 0.0;
    }


    public Long getIdportfolio() {
        return idportfolio;
    }

    public void setIdportfolio(Long idportfolio) {
        this.idportfolio = idportfolio;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return  "Portfolio: " + "\n" +
                "Id: " + idportfolio + "\n" +
                "Shares owned: " + shares_owned + "\n" +
                "Total value: " + total_value + "\n" +
                "Total profit" + total_profit + "\n" +
                "Customer: " + customer + "}";
    }
}
