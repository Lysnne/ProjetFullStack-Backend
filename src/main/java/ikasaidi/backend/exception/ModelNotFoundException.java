package ikasaidi.backend.exception;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(String model, Long id) {
        super("Could not found the " + model + " with the id ---> " + id);
    }
}
