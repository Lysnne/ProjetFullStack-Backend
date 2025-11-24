package ikasaidi.backend.StockServiceTest;

import ikasaidi.backend.model.Portfolio;
import ikasaidi.backend.model.Transaction;
import ikasaidi.backend.repositories.PortfolioRepository;
import ikasaidi.backend.repositories.TransactionRepository;
import ikasaidi.backend.service.PortfolioService;
import ikasaidi.backend.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class TransactionServiceTest {
    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private PortfolioRepository portfolioRepository;

    @InjectMocks
    private TransactionService transactionService;

    @InjectMocks
    private PortfolioService portfolioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testgetAllTransactionsById(){

        Portfolio p1 = new Portfolio();
        p1.setIdportfolio(1L);

        Portfolio p2 = new Portfolio();
        p2.setIdportfolio(2L);

        Transaction t1 = new Transaction();
        t1.setId_transaction(1L);
        t1.setNet_amount(15002.2);
        t1.setPrice_per_share(74.25);
        t1.setShares(5.0);
        t1.setTransaction_fee(10.25);
        t1.setPortfolio(p1);

        Transaction t2 = new Transaction();
        t2.setId_transaction(2L);
        t2.setNet_amount(7002.2);
        t2.setPrice_per_share(22.25);
        t2.setShares(4.0);
        t2.setTransaction_fee(1.25);
        t2.setPortfolio(p1);

        Transaction t3 = new Transaction();
        t3.setId_transaction(3L);
        t3.setNet_amount(17002.2);
        t3.setPrice_per_share(252.25);
        t3.setShares(42.0);
        t3.setTransaction_fee(18.25);
        t3.setPortfolio(p2);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        transactions.add(t2);
        transactions.add(t3);

        when(transactionRepository.findAll()).thenReturn(transactions);
        when(portfolioRepository.findByIdportfolio(1L)).thenReturn(p1);

        List<Transaction> resultatGetAll = transactionService.getAllTransactionsById(1L);

        assertEquals(2, resultatGetAll.size());


    }


}
