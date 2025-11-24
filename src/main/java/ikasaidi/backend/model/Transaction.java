package ikasaidi.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class Transaction {
    public static int cpt = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transaction;
    private Double shares ;
    private Double price_per_share ;
    private Double transaction_fee ;
    private Double net_amount ;
    private String order_type ;
    private LocalDateTime transaction_date;
    private String transaction_status;

    @ManyToOne
    @JoinColumn(name = "idportfolio", referencedColumnName = "idportfolio")
    private Portfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "idstock", referencedColumnName = "idstock")
    private Stock stock;

    public Transaction(){
        transaction_status = "Completed";
        transaction_date = LocalDateTime.now();
    }



    public Long getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(Long id_transaction) {
        this.id_transaction = id_transaction;
    }

    public Double getShares() {
        return shares;
    }

    public void setShares(Double shares) {
        this.shares = shares;
    }

    public Double getPrice_per_share() {
        return price_per_share;
    }

    public void setPrice_per_share(Double price_per_share) {
        this.price_per_share = price_per_share;
    }

    public Double getTransaction_fee() {
        return transaction_fee;
    }

    public void setTransaction_fee(Double transaction_fee) {
        this.transaction_fee = transaction_fee;
    }

    public Double getNet_amount() {
        return net_amount;
    }

    public void setNet_amount(Double net_amount) {
        this.net_amount = net_amount;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public LocalDateTime getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(LocalDateTime transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getTransaction_status() {
        return transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return  "{Transaction: " + "\n" +
                "Id: " + id_transaction + "\n" +
                "Shares: " + shares + "\n" +
                "Price per share: " + price_per_share + "\n" +
                "Transaction fee: " + transaction_fee + "\n" +
                "Net_amount: " + net_amount + "\n" +
                "Order Type: " + order_type + "\n" +
                "Date: " + transaction_date + "\n" +
                "Status: " + transaction_status + "\n" +
                "Portfolio: " + portfolio + "\n" +
                "Stock: " + stock + "}" ;
    }
}


