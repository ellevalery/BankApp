
import java.util.Scanner;
class User {
    public User(String accountNumber) {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        User user = new User(accountNumber);

        int choice;
        double amount;

        do {
        System.out.println("\nBank Application Menu");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
        case 1:
        System.out.print("Enter the deposit amount: $");
        amount = scanner.nextDouble();
        user.deposit(amount);
        break;
        case 2:
        System.out.print("Enter the withdrawal amount: $");
        amount = scanner.nextDouble();
        user.withdraw(amount);
        break;
        case 3:
        user.checkBalance();
        break;
        case 4:
        System.out.println("Thank you for using the bank app. Goodbye!");
        break;
default:
        System.out.println("Invalid choice. Please try again.");
        break;
        }
        } while (choice != 4);

        scanner.close();
        }

    private void withdraw(double amount) {
    }

    private void checkBalance() {
    }

    private void deposit(double amount) {
    }
}
