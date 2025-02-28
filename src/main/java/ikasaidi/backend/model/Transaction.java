package ikasaidi.backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double shares ;
    private Double price_per_share ;
    private Double transaction_fee ;
    private Double net_amount ;
    private String order_type ;
    private Date transaction_date;
    private String transaction_status;

    public Transaction(){
        transaction_status = "pending";
    }

    @ManyToOne
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransaction_status() {
        return transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public Double getNet_amount() {
        return net_amount;
    }

    public void setNet_amount(Double net_amount) {
        this.net_amount = net_amount;
    }

    public Double getTransaction_fee() {
        return transaction_fee;
    }

    public void setTransaction_fee(Double transaction_fee) {
        this.transaction_fee = transaction_fee;
    }

    public Double getPrice_per_share() {
        return price_per_share;
    }

    public void setPrice_per_share(Double price_per_share) {
        this.price_per_share = price_per_share;
    }

    public Double getShares() {
        return shares;
    }

    public void setShares(Double shares) {
        this.shares = shares;
    }
}
