package ikasaidi.backend.service;


import ikasaidi.backend.model.Transaction;
import ikasaidi.backend.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
        return transaction;
    }
}
