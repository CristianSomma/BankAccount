void main() {
    BankAccount bankAccount = new BankAccount(100f);

    // 1) Excessive withdrawal -> checked exception + finally
    try {
        System.out.println("Balance before: " + bankAccount.getCurrentBalance());
        bankAccount.withdraw(150f); // > balance
        System.out.println("Withdraw done");
    } catch (InsufficientBalanceException e) {
        System.out.println("Excessive withdrawal: " + e.getMessage());
        System.out.println("Money deficit: " + e.getDeficit());
    } finally {
        System.out.println("End of excessive withdrawal attempt. Current balance: "
                + bankAccount.getCurrentBalance());
        System.out.println("---");
    }

    // 2) Negative withdrawal -> unchecked exception
    try {
        bankAccount.withdraw(-20f);
        System.out.println("Withdraw done");
    } catch (InsufficientBalanceException | IllegalArgumentException e) {
        System.out.println("Withdrawal failed: " + e.getMessage());
    } finally {
        System.out.println("End of negative withdrawal attempt. Current balance: "
                + bankAccount.getCurrentBalance());
        System.out.println("---");
    }

    // 3) Valid withdrawal -> success
    try {
        bankAccount.withdraw(40f);
        System.out.println("Operation completed successfully. New balance: "
                + bankAccount.getCurrentBalance());
    } catch (InsufficientBalanceException e) {
        System.out.println("Excessive withdrawal: " + e.getMessage());
    } finally {
        System.out.println("End of valid withdrawal. Current balance: "
                + bankAccount.getCurrentBalance());
    }
}