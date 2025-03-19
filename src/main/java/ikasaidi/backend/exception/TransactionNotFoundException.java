package ikasaidi.backend.exception;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(Long id) {
        super("Could not found the portfolio with the id " + id);
    }
}
