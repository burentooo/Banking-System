import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        User user = new User(1, 1234, 1000);

        if (id == user.getId() && pin == user.getPin()) {
            menu(user);
        } else {
            System.out.println("Invalid login.");
        }
    }

    public static void menu(User user) {
        Transaction t = new Transaction();

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    t.deposit(user, sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    t.withdraw(user, sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Balance: " + user.getBalance());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}