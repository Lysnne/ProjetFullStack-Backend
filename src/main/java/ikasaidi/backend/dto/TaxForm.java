package ikasaidi.backend.dto;

public class TaxForm {
    private double employmentIncome;
    private double selfEmploymentIncome;
    private double RRSPandFHSADeductions;
    private double gainCapitalBefore;
    private double gainCapitalAfter;
    private double eligibleDividends;
    private double ineligibleDividends;
    private double otherIncome;
    private double incomeTaxesPaid;

    /*
    * Une classe qui permet de prendre les données depuis le frontEnd.
    * */


    public double getEmploymentIncome() {
        return employmentIncome;
    }

    public void setEmploymentIncome(double employmentIncome) {
        this.employmentIncome = employmentIncome;
    }

    public double getSelfEmploymentIncome() {
        return selfEmploymentIncome;
    }

    public void setSelfEmploymentIncome(double selfEmploymentIncome) {
        this.selfEmploymentIncome = selfEmploymentIncome;
    }

    public double getRRSPandFHSADeductions() {
        return RRSPandFHSADeductions;
    }

    public void setRRSPandFHSADeductions(double RRSPandFHSADeductions) {
        this.RRSPandFHSADeductions = RRSPandFHSADeductions;
    }

    public double getGainCapitalBefore() {
        return gainCapitalBefore;
    }

    public void setGainCapitalBefore(double gainCapitalBefore) {
        this.gainCapitalBefore = gainCapitalBefore;
    }

    public double getGainCapitalAfter() {
        return gainCapitalAfter;
    }

    public void setGainCapitalAfter(double gainCapitalAfter) {
        this.gainCapitalAfter = gainCapitalAfter;
    }

    public double getEligibleDividends() {
        return eligibleDividends;
    }

    public void setEligibleDividends(double eligibleDividends) {
        this.eligibleDividends = eligibleDividends;
    }

    public double getIneligibleDividends() {
        return ineligibleDividends;
    }

    public void setIneligibleDividends(double ineligibleDividends) {
        this.ineligibleDividends = ineligibleDividends;
    }

    public double getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(double otherIncome) {
        this.otherIncome = otherIncome;
    }

    public double getIncomeTaxesPaid() {
        return incomeTaxesPaid;
    }

    public void setIncomeTaxesPaid(double incomeTaxesPaid) {
        this.incomeTaxesPaid = incomeTaxesPaid;
    }
}
