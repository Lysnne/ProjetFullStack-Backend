package ikasaidi.backend.service;

import ikasaidi.backend.dto.TaxForm;
import ikasaidi.backend.dto.TaxResult;
import org.springframework.stereotype.Service;

@Service
public class TaxService {

    public TaxResult calculTax(TaxForm tF){
        TaxResult tr = new TaxResult();


        double gainBf = tF.getGainCapitalBefore() * 0.5;
        double gainAf = tF.getGainCapitalAfter() * 0.6;

        double totalIncome = tF.getEmploymentIncome() + tF.getSelfEmploymentIncome() +
                gainBf + gainAf + tF.getEligibleDividends()
                + tF.getIneligibleDividends() + tF.getOtherIncome();

        tr.setTotalIncome(Math.round(totalIncome * 100) / 100.0);

        double taxableIncome = totalIncome - tF.getRRSPandFHSADeductions();

        double federalTax = taxableIncome * 0.18; //Fixe au lieu de faire des paliers

        double provincialTax = taxableIncome * 0.15;


        tr.setFederalTax(Math.round(federalTax * 100) / 100.0);
        tr.setProvTax(Math.round(provincialTax * 100) / 100.0);

        double totalTax = federalTax + provincialTax;
        tr.setTotalTax(Math.round(totalTax * 100) / 100.0);

        double afterTax = totalIncome - totalTax;
        tr.setAfterTaxIncome(Math.round(afterTax * 100) / 100.0);

        double avgTaxR = (totalTax / totalIncome) * 100;
        tr.setAvrgTaxRate(Math.round(avgTaxR * 100) / 100.0);

        //Pour que ca soit plus simple, je vais mettre une appro
        double marginalTax = 31.00;
        tr.setMarginalTaxRate(Math.round(marginalTax * 100) / 100.0);



        return tr;
    }
}
