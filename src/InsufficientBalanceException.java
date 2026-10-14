public class InsufficientBalanceException extends Exception {
    private final float currentBalance;
    private final float requestedAmount;

    public InsufficientBalanceException(float currentBalance, float requestedAmount) {
        super("The withdrawn amount requested (" + requestedAmount
                + ") exceeds the current balance (" + currentBalance + ")");

        if (currentBalance < 0 || requestedAmount < 0) {
            throw new IllegalArgumentException("Amounts cannot be negative.");
        }

        this.currentBalance = currentBalance;
        this.requestedAmount = requestedAmount;
    }

    public float getDeficit() {
        return requestedAmount - currentBalance;
    }

    public float getCurrentBalance()  { return currentBalance; }
    public float getRequestedAmount() { return requestedAmount; }
}