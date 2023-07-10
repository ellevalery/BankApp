import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static User user = new User("name", "surname", "female", 12345566L, "EUR", new BigDecimal("22500.20"));
    private static final BankApp bankApp = new BankApp();
    public static void main(String[] args) {

        bankApp.getUsersOfBank().add(user);

        System.out.println("Welcome to Our bank. Please choose the option:");
        printAMenu();

        while (true) {
            char choice = scanner.next().charAt(0);
            switch (choice) {
                case '1' -> registerNewUser();
                case '2' -> displayUserBalance();
                case '3' -> depositMoney();
                case '4' -> withdrawMoney();
                case 'x' -> {
                    System.out.println("Thank you for using our service");
                    System.exit(0);
                }
                default -> System.out.println("Please choose one from a menu");
            }
        }
    }
    private static void printAMenu() {
        System.out.println("""
        Bank menu:\s
        1 - to register as a new user\s
        2 - to see your balance\s
        3 - to deposit money
        4 - to withdraw money
        x - to end a program\s""");
    }
    private static void registerNewUser() {
        System.out.println("Enter your name");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter your surname");
        String surname = scanner.nextLine();
        System.out.println("Enter your gender");
        String gender = scanner.nextLine();
        System.out.println("Select your account currency: 1-EUR, 2-USD");
        String currency = "EUR";

        char option = scanner.next().charAt(0);
        while (!(option == '1' || option == '2')) {
            System.out.println("Choose a number from 1 to 2!");

            option = scanner.next().charAt(0);
            switch (option) {
                case '1' -> currency = "EUR";
                case '2' -> currency = "USD";
            }
        }

        long min = 1000000000L;
        long max = 9999999999L;
        Random random = new Random();
        long accountNumber = random.nextLong() % (max - min) + max;
        User registeredUser = new User(name, surname, gender, accountNumber, currency, BigDecimal.ZERO);
        user = bankApp.createNewUser(registeredUser);
        System.out.println(user);
        printAMenu();
    }

    private static void displayUserBalance() {
        if (user == null) {
            System.out.println("There is no registered user in our system");
        } else {
            bankApp.displayUserBalance(user);
        }
        printAMenu();
    }

    private static void withdrawMoney(){
        if (user == null) {
            System.out.println("There is no registered user in our system");
        } else {
            BigDecimal number;
            do {
                System.out.println("Please enter amount you want to withdraw: ");
                while (!scanner.hasNextBigDecimal()) {
                    System.out.println("Please enter a positive number!");
                    scanner.next();
                }
                number = scanner.nextBigDecimal();
            } while (number.compareTo(BigDecimal.ZERO) != 1);
            bankApp.WithdrawMoney(user, number);
            printAMenu();
        }
    }
    private static void depositMoney(){
        if (user == null) {
            System.out.println("There is no registered user in our system");
        } else {
            BigDecimal number;
            do {
                System.out.println("Please enter amount you want to deposit: ");
                while (!scanner.hasNextBigDecimal()) {
                    System.out.println("Please enter a positive number!");
                    scanner.next();
                }
                number = scanner.nextBigDecimal();
            } while (number.compareTo(BigDecimal.ZERO) != 1);
            bankApp.DepositMoney(user, number);
            printAMenu();
        }
    }
}

