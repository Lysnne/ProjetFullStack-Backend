package ikasaidi.backend.model;

import jakarta.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idstock;
    private String symbol;
    private String name;
    private Double price;
    private String sector;
    private Double volume;
    private Double marketcap ;

    //Pour les test unitaire
    public Stock() {}

    public Stock(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Long getIdstock() {
        return idstock;
    }

    public void setIdstock(Long idstock) {
        this.idstock = idstock;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getMarketcap() {
        return marketcap;
    }

    public void setMarketcap(Double marketcap) {
        this.marketcap = marketcap;
    }

    @Override
    public String toString() {
        return "{Stock: " +
                "Id: " + idstock + "\n" +
                "Symbol: " + symbol + "\n" +
                "Name: " + name +  "\n" +
                "Price: " + price + "\n" +
                "Sector: " + sector +  "\n" +
                "Volume: " + volume + "\n" +
                "Market cap: " + marketcap + "}";
    }
}
