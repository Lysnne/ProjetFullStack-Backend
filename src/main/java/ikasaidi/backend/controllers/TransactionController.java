package ikasaidi.backend.controllers;


import ikasaidi.backend.model.Transaction;
import ikasaidi.backend.service.StockService;
import ikasaidi.backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@CrossOrigin()
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/createTransaction")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }
}
