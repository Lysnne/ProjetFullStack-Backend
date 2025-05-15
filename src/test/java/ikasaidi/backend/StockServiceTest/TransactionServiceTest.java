package ikasaidi.backend.StockServiceTest;

import ikasaidi.backend.model.Stock;
import ikasaidi.backend.repositories.StockRepository;
import ikasaidi.backend.repositories.TransactionRepository;
import ikasaidi.backend.service.StockService;
import ikasaidi.backend.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TransactionServiceTest {
    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


}
