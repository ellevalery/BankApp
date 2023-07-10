import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankApp {
    private final List<User> usersOfBank = new ArrayList<>();

    public List<User> getUsersOfBank() {
        return usersOfBank;
    }
    public void displayUserBalance(User user) {

        System.out.println("Your balance is: " + user.getBalance() + " " + user.getAccountCurrency());
    }
    public void DepositMoney(User user, BigDecimal amountToDeposit) {
        BigDecimal newBalance = user.getBalance().add(amountToDeposit);
        user.setBalance(newBalance);
        System.out.println("Operation successful");
        System.out.println("Your balance is: " + user.getBalance() + " " + user.getAccountCurrency());
    }

    public void WithdrawMoney(User user, BigDecimal amountToWithdraw) {

        if (user.getBalance().compareTo(amountToWithdraw) != -1) {
            BigDecimal newBalance = user.getBalance().subtract(amountToWithdraw);
            user.setBalance(newBalance);
            System.out.println("Operation proceeded successful");
        } else {
            System.out.println("Not enough money in your account");
        }
        System.out.println("Your balance is: " + user.getBalance() + " " + user.getAccountCurrency());
    }
    public User createNewUser(User registeredUser) {

        replaceUser(registeredUser);
        System.out.println("User successfully created.");
        return registeredUser;
    }
    private void replaceUser(User registeredUser) {
        usersOfBank.clear();
        usersOfBank.add(registeredUser);
    }
}