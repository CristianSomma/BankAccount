void main() {
    BankAccount bankAccount = new BankAccount(100f);

    // 1) Excessive withdrawal -> checked exception + finally
    try {
        System.out.println("\nBalance before:\n" + bankAccount.getCurrentBalance());
        bankAccount.withdraw(150f); // > balance
        System.out.println("\nWithdraw done");
    } catch (InsufficientBalanceException e) {
        System.out.println("\nExcessive withdrawal:\n" + e.getMessage());
        System.out.println("\nMoney deficit: " + e.getDeficit());
    } finally {
        System.out.println("\nEnd of excessive withdrawal attempt. Current balance: "
                + bankAccount.getCurrentBalance());
        System.out.println("---");
    }

    // 2) Negative withdrawal -> unchecked exception
    try {
        bankAccount.withdraw(-20f);
        System.out.println("\nWithdraw done");
    } catch (InsufficientBalanceException | IllegalArgumentException | InvalidAmountException e) {
        System.out.println("\nWithdrawal failed:\n" + e.getMessage());
    } finally {
        System.out.println("End of negative withdrawal attempt. Current balance: "
                + bankAccount.getCurrentBalance());
        System.out.println("---");
    }

    // 3) Valid withdrawal -> success
    try {
        bankAccount.withdraw(40f);
        System.out.println("\nOperation completed successfully. New balance: "
                + bankAccount.getCurrentBalance());
    } catch (InsufficientBalanceException e) {
        System.out.println("\nExcessive withdrawal: " + e.getMessage());
    } finally {
        System.out.println("\nEnd of valid withdrawal. Current balance: "
                + bankAccount.getCurrentBalance());
    }
}