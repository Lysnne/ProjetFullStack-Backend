package ikasaidi.backend.service;


import ikasaidi.backend.model.Portfolio;
import ikasaidi.backend.model.Stock;
import ikasaidi.backend.model.Transaction;
import ikasaidi.backend.repositories.PortfolioRepository;
import ikasaidi.backend.repositories.StockRepository;
import ikasaidi.backend.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    PortfolioRepository portfolioRepository;


    public Transaction createTransaction(Transaction transaction, Long idstock) {
        Stock stock = stockRepository.findByIdstock(idstock);
        System.out.println(transaction.getStock());
        transaction.setStock(stock);
        transactionRepository.save(transaction);
        System.out.println(transaction.getStock());
        return transaction;
    }

    public List<Transaction> getAllTransactionsById(Long idportfolio) {
        Portfolio portfolio = portfolioRepository.findByIdportfolio(idportfolio);
        System.out.println(portfolio);

        List<Transaction> actualList = transactionRepository.findAll();
        List<Transaction> newList = new ArrayList<>();

        for(Transaction t : actualList) {
            if(t.getPortfolio().getIdportfolio() == portfolio.getIdportfolio()) {
                System.out.println(t);
                newList.add(t);
            }
        }
        return newList;
    }

    public List<Stock> getQuantityStocksOwned(Long idportfolio) {
        Portfolio portfolio = portfolioRepository.findByIdportfolio(idportfolio);
        System.out.println(portfolio);

        List<Transaction> actualList = transactionRepository.findAll();
        List<Transaction> filtredList = new ArrayList<>();

        List<Stock> buy = new ArrayList<>();
        List<Stock> sell = new ArrayList<>();


        for(Transaction t : actualList) {
            if(t.getPortfolio().getIdportfolio() == portfolio.getIdportfolio()) {
                if(t.getTransaction_status().equals("Completed")){
                    filtredList.add(t);
                }
            }
        }

        for(Transaction t : filtredList) {
            if(t.getOrder_type().equals("SELL")){
                sell.add(t.getStock());
            }
            else {
                buy.add(t.getStock());
            }
        }

        List<Stock> owned = new ArrayList<>();

        for(Stock s : buy) {
            owned.add(s);
        }

        for (Stock s : sell) {
            for(Stock ss: owned){
                if(s.getIdstock() == ss.getIdstock()) {
                    owned.remove(ss);
                    break;
                }

            }
        }

        return owned;
    }



}
