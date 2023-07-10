import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BankApp {
    private final List<User> usersOfBank = new ArrayList<>();

    public List<User> getUsersOfBank() {
        return usersOfBank;
    }

    public void displayUserBalance(User user) {
        String message = "Your balance is: " + user.getBalance() + " " + user.getAccountCurrency();
        JOptionPane.showMessageDialog(null, message, "Account Balance", JOptionPane.INFORMATION_MESSAGE);
    }

    public void DepositMoney(User user, BigDecimal amountToDeposit) {
        BigDecimal newBalance = user.getBalance().add(amountToDeposit);
        user.setBalance(newBalance);
        String message = "Operation successful\nYour balance is: " + user.getBalance() + " " + user.getAccountCurrency();
        JOptionPane.showMessageDialog(null, message, "Deposit Successful", JOptionPane.INFORMATION_MESSAGE);
    }

    public void WithdrawMoney(User user, BigDecimal amountToWithdraw) {
        if (user.getBalance().compareTo(amountToWithdraw) != -1) {
            BigDecimal newBalance = user.getBalance().subtract(amountToWithdraw);
            user.setBalance(newBalance);
            JOptionPane.showMessageDialog(null, "Operation proceeded successfully", "Withdrawal Successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Not enough money in your account", "Withdrawal Failed", JOptionPane.ERROR_MESSAGE);
        }
        String message = "Your balance is: " + user.getBalance() + " " + user.getAccountCurrency();
        JOptionPane.showMessageDialog(null, message, "Account Balance", JOptionPane.INFORMATION_MESSAGE);
    }

    public User createNewUser(User registeredUser) {
        replaceUser(registeredUser);
        JOptionPane.showMessageDialog(null, "User successfully created.", "User Creation", JOptionPane.INFORMATION_MESSAGE);
        return registeredUser;
    }

    private void replaceUser(User registeredUser) {
        usersOfBank.clear();
        usersOfBank.add(registeredUser);
    }
}
