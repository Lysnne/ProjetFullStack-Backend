package ikasaidi.backend.exception;

public class StockNotFoundException extends RuntimeException {

    public StockNotFoundException(Long id) {
        super("Could not found the stock with the id  " + id);
    }
}
