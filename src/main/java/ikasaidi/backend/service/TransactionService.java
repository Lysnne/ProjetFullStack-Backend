package ikasaidi.backend.service;


import ikasaidi.backend.model.Stock;
import ikasaidi.backend.model.Transaction;
import ikasaidi.backend.repositories.StockRepository;
import ikasaidi.backend.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    StockRepository stockRepository;



    public Transaction createTransaction(Transaction transaction, Long idstock) {
        Stock stock = stockRepository.findByIdstock(idstock);
        System.out.println(transaction.getStock());
        transaction.setStock(stock);
        transactionRepository.save(transaction);
        System.out.println(transaction.getStock());
        return transaction;
    }

    public List<Transaction> getAllTransactionsById(Long idtransaction) {
        List<Transaction> actualList = transactionRepository.findAll();
        List<Transaction> newList = new ArrayList<>();

        for(Transaction t : actualList) {
            if(t.getId_transaction() == idtransaction) {
                newList.add(t);
            }
        }
        return newList;
    }
}
