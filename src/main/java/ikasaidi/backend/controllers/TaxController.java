package ikasaidi.backend.controllers;


import ikasaidi.backend.dto.TaxForm;
import ikasaidi.backend.dto.TaxResult;
import ikasaidi.backend.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tax") //route commence par
@CrossOrigin() //pour autoriser les appels du frontend
public class TaxController {

    @Autowired
    private TaxService taxService;

    //frontend envoie les donner en un post (le form) et sera transformer en objet pour calculer
    @PostMapping("/taxCalculate")
    public TaxResult calcul(@RequestBody TaxForm demande){
        return taxService.calculTax(demande);
    }

}
