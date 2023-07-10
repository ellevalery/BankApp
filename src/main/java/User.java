import java.math.BigDecimal;

public class User {
    private final String name;
    private final String surname;
    private final String gender;
    private final long accountNumber;
    private final String accountCurrency;
    private BigDecimal balance;

    public User(String name, String surname, String gender, long accountNumber, String accountCurrency, BigDecimal balance) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.accountNumber = accountNumber;
        this.accountCurrency = accountCurrency;
        this.balance = balance;
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
    @Override
    public String toString() {
        return "User " +
                "name: '" + name + '\'' +
                ", surname: '" + surname + '\'' +
                ", gender: '" + gender + '\'' +
                ", accountNumber: " + accountNumber +
                ", mainCurrency: " + accountCurrency + '\'' +
                ", balance: " + balance;
    }
}

