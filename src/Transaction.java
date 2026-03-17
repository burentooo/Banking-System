public class Transaction {

    public void deposit(User user, double amount) {
        user.setBalance(user.getBalance() + amount);
        System.out.println("Deposit successful!");
    }

    public void withdraw(User user, double amount) {
        if (amount <= user.getBalance()) {
            user.setBalance(user.getBalance() - amount);
            System.out.println("Withdraw successful!");
            System.out.println("Balance: " + user.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}