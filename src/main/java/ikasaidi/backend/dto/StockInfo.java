package ikasaidi.backend.dto;

import ikasaidi.backend.model.Stock;

public class StockInfo {
    private Stock stock;
    private double quantity;
    private double totalValue;

    public StockInfo(Stock stock, double quantity) {
        this.stock = stock;
        this.quantity = quantity;
        this.totalValue = stock.getPrice() * quantity;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
