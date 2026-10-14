public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException() {
        super("Required amount not valid.");
    }
}
