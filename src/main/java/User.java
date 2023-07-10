import java.math.BigDecimal;
import javax.swing.JOptionPane;

public class User {
    private final String name;
    private final String surname;
    private Integer age;
    private final String gender;
    private final long accountNumber;
    private final String accountCurrency;
    private BigDecimal balance;

    public User(String name, String surname, String gender, long accountNumber, String accountCurrency, BigDecimal balance) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.accountNumber = accountNumber;
        this.accountCurrency = accountCurrency;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User " +
                "name: '" + name + '\'' +
                ", surname: '" + surname + '\'' +
                ", age=" + age +
                ", gender: '" + gender + '\'' +
                ", accountNumber: " + accountNumber +
                ", mainCurrency: " + accountCurrency + '\'' +
                ", balance: " + balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "Enter your name:");
        String surname = JOptionPane.showInputDialog(null, "Enter your surname:");
        String gender = JOptionPane.showInputDialog(null, "Enter your gender:");
        long accountNumber = Long.parseLong(JOptionPane.showInputDialog(null, "Enter your account number:"));
        String accountCurrency = JOptionPane.showInputDialog(null, "Enter your account currency:");
        BigDecimal balance = new BigDecimal(JOptionPane.showInputDialog(null, "Enter your balance:"));

        User user = new User(name, surname, gender, accountNumber, accountCurrency, balance);
        JOptionPane.showMessageDialog(null, user.toString());
    }
}
