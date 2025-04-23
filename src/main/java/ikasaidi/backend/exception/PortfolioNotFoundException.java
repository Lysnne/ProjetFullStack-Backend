package ikasaidi.backend.exception;

public class PortfolioNotFoundException extends RuntimeException{
    public PortfolioNotFoundException(Long id) {
        super("Could not found the portfolio with the id " + id);
    }
}
