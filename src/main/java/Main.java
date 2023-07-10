import javax.swing.JOptionPane;
import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static User user = new User("name", "surname", "female", 12345566L, "EUR", new BigDecimal("22500.20"));
    private static final BankApp bankApp = new BankApp();

    public static void main(String[] args) {
        bankApp.getUsersOfBank().add(user);

        JOptionPane.showMessageDialog(null, "Welcome to Our bank. Please choose an option:");
        printAMenu();

        while (true) {
            String choice = JOptionPane.showInputDialog("Enter your choice:");
            if (choice == null) {
                // User clicked on cancel or closed the dialog
                System.exit(0);
            }

            switch (choice) {
                case "1" -> registerNewUser();
                case "2" -> displayUserBalance();
                case "3" -> depositMoney();
                case "4" -> withdrawMoney();
                case "5" -> {
                    JOptionPane.showMessageDialog(null, "Thank you for using our service");
                    System.exit(0);
                }
                default -> JOptionPane.showMessageDialog(null, "Please choose one from the menu");
            }
        }
    }

    private static void printAMenu() {
        JOptionPane.showMessageDialog(null, """
                Bank menu:\s
                1 - to register as a new user\s
                2 - to see your balance\s
                3 - to deposit money
                4 - to withdraw money
                5 - to end the program\s""");
    }

    private static void registerNewUser() {
        String name = JOptionPane.showInputDialog("Enter your name");
        String surname = JOptionPane.showInputDialog("Enter your surname");
        String gender = JOptionPane.showInputDialog("Enter your gender");

        String[] options = {"1 - EUR", "2 - USD"};
        int currencyChoice = JOptionPane.showOptionDialog(
                null,
                "Select your account currency:",
                "Currency Selection",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        String currency;
        switch (currencyChoice) {
            case 0 -> currency = "EUR";
            case 1 -> currency = "USD";
            default -> currency = "EUR"; // Default currency is EUR
        }

        long min = 1000000000L;
        long max = 9999999999L;
        Random random = new Random();
        long accountNumber = random.nextLong() % (max - min) + max;
        User registeredUser = new User(name, surname, gender, accountNumber, currency, BigDecimal.ZERO);
        user = bankApp.createNewUser(registeredUser);
        JOptionPane.showMessageDialog(null, user.toString());
        printAMenu();
    }

    private static void displayUserBalance() {
        if (user == null) {
            JOptionPane.showMessageDialog(null, "There is no registered user in our system");
        } else {
            bankApp.displayUserBalance(user);
        }
        printAMenu();
    }

    private static void withdrawMoney() {
        if (user == null) {
            JOptionPane.showMessageDialog(null, "There is no registered user in our system");
        } else {
            BigDecimal number;
            do {
                String input = JOptionPane.showInputDialog("Please enter the amount you want to withdraw:");
                if (input == null) {
                    // User clicked on cancel or closed the dialog
                    return;
                }
                try {
                    number = new BigDecimal(input);
                } catch (NumberFormatException e) {
                    number = BigDecimal.ZERO;
                }
                if (number.compareTo(BigDecimal.ZERO) <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a positive number!");
                }
            } while (number.compareTo(BigDecimal.ZERO) <= 0);
            bankApp.WithdrawMoney(user, number);
            printAMenu();
        }
    }

    private static void depositMoney() {
        if (user == null) {
            JOptionPane.showMessageDialog(null, "There is no registered user in our system");
        } else {
            BigDecimal number;
            do {
                String input = JOptionPane.showInputDialog("Please enter the amount you want to deposit:");
                if (input == null) {
                    // User clicked on cancel or closed the dialog
                    return;
                }
                try {
                    number = new BigDecimal(input);
                } catch (NumberFormatException e) {
                    number = BigDecimal.ZERO;
                }
                if (number.compareTo(BigDecimal.ZERO) <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a positive number!");
                }
            } while (number.compareTo(BigDecimal.ZERO) <= 0);
            bankApp.DepositMoney(user, number);
            printAMenu();
        }
    }
}
