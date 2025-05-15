package ikasaidi.backend.controllers;


import ikasaidi.backend.dto.StockInfo;
import ikasaidi.backend.model.Customer;
import ikasaidi.backend.model.Stock;
import ikasaidi.backend.model.Transaction;
import ikasaidi.backend.service.StockService;
import ikasaidi.backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin()
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/createTransaction/{idportfolio}/{idstock}")
    public Transaction createTransaction(@RequestBody Transaction transaction, @PathVariable Long idstock, @PathVariable Long idportfolio) {
        return transactionService.createTransaction(transaction, idstock, idportfolio);
    }

    @GetMapping("/getAllTransactionsById/{idportfolio}")
    public List<Transaction> getAllTransactionsById(@PathVariable Long idportfolio) {
        return transactionService.getAllTransactionsById(idportfolio);
    }

    @GetMapping("/getQuantityStocksOwned/{idportfolio}")
    public List<StockInfo> getQuantityStocksOwned(@PathVariable Long idportfolio) {
        return transactionService.getQuantityStocksOwned(idportfolio);
    }



}
