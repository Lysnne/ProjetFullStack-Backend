package ikasaidi.backend.service;


import ikasaidi.backend.dto.StockInfo;
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


@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    PortfolioRepository portfolioRepository;


    public Transaction createTransaction(Transaction transaction, Long idstock, Long idportfolio) {
        Portfolio portfolio = portfolioRepository.findByIdportfolio(idportfolio);
        Stock stock = stockRepository.findByIdstock(idstock);
        System.out.println(transaction.getStock());

        transaction.setStock(stock);
        transaction.setPortfolio(portfolio);

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

    public List<StockInfo> getQuantityStocksOwned(Long idportfolio) {
        Portfolio portfolio = portfolioRepository.findByIdportfolio(idportfolio);

        List<Transaction> actualList = transactionRepository.findAll();
        List<Transaction> filtredList = new ArrayList<>();

        for (Transaction t : actualList) {
            if (t.getPortfolio().getIdportfolio().equals(portfolio.getIdportfolio()) &&
                    t.getTransaction_status().equals("Completed")) {
                filtredList.add(t);
            }
        }

        List<StockInfo> buy = new ArrayList<>();
        List<StockInfo> sell = new ArrayList<>();
        List<StockInfo> owned = new ArrayList<>();

        for (Transaction t : filtredList) {
            if (t.getOrder_type().equals("SELL")) {
                sell.add(new StockInfo(t.getStock(), t.getShares()));
            } else {
                buy.add(new StockInfo(t.getStock(), t.getShares()));
            }
        }

        for (StockInfo s : buy) {
            owned.add(s);
        }

        for (StockInfo s : sell) {
            for (StockInfo ss : owned) {
                if (s.getStock().getIdstock().equals(ss.getStock().getIdstock())) {
                    owned.remove(ss);
                    break;
                }
            }
        }

        return owned;
    }




}
