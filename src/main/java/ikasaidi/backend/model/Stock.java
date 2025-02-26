package ikasaidi.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stock_id;
    private String symbol;
    private String name;
    private Double price;
    private String sector;
    private Double interval_1h;
    private Double interval_4h;
    private Double interval_12h;
    private Double interval_24h ;
    private Double volume;
    private Double marketcap ;
    private Double dividend ;

    public Integer getStock_id() {
        return stock_id;
    }

    public void setStock_id(Integer stock_id) {
        this.stock_id = stock_id;
    }

    public Double getDividend() {
        return dividend;
    }

    public void setDividend(Double dividend) {
        this.dividend = dividend;
    }

    public Double getMarketcap() {
        return marketcap;
    }

    public void setMarketcap(Double marketcap) {
        this.marketcap = marketcap;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getInterval_24h() {
        return interval_24h;
    }

    public void setInterval_24h(Double interval_24h) {
        this.interval_24h = interval_24h;
    }

    public Double getInterval_12h() {
        return interval_12h;
    }

    public void setInterval_12h(Double interval_12h) {
        this.interval_12h = interval_12h;
    }

    public Double getInterval_4h() {
        return interval_4h;
    }

    public void setInterval_4h(Double interval_4h) {
        this.interval_4h = interval_4h;
    }

    public Double getInterval_1h() {
        return interval_1h;
    }

    public void setInterval_1h(Double interval_1h) {
        this.interval_1h = interval_1h;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
