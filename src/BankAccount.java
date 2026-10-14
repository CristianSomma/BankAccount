public class BankAccount {
    private float currentBalance;

    public BankAccount(float currentBalance) {
        if (currentBalance < 0)
            throw new IllegalArgumentException("Entered balance not valid.");

        this.currentBalance = currentBalance;
    }

    public boolean withdraw(float amount) throws InsufficientBalanceException, InvalidAmountException {
        if(amount < 0)
            throw new InvalidAmountException();

        if(currentBalance < amount)
            throw new InsufficientBalanceException(currentBalance, amount);

        currentBalance -= amount;
        return true;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }
}
