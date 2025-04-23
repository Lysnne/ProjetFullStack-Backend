package ikasaidi.backend.dto;

public class TaxResult {
    private double totalIncome;
    private double totalTax;
    private double federalTax;
    private double ProvTax;
    private double AfterTaxIncome;
    private double AvrgTaxRate;
    private double MarginalTaxRate;

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getFederalTax() {
        return federalTax;
    }

    public void setFederalTax(double federalTax) {
        this.federalTax = federalTax;
    }

    public double getProvTax() {
        return ProvTax;
    }

    public void setProvTax(double provTax) {
        ProvTax = provTax;
    }

    public double getAfterTaxIncome() {
        return AfterTaxIncome;
    }

    public void setAfterTaxIncome(double afterTaxIncome) {
        AfterTaxIncome = afterTaxIncome;
    }

    public double getAvrgTaxRate() {
        return AvrgTaxRate;
    }

    public void setAvrgTaxRate(double avrgTaxRate) {
        AvrgTaxRate = avrgTaxRate;
    }

    public double getMarginalTaxRate() {
        return MarginalTaxRate;
    }

    public void setMarginalTaxRate(double marginalTaxRate) {
        MarginalTaxRate = marginalTaxRate;
    }
}

/*
* Données renvoyées en json depuis le backend*/