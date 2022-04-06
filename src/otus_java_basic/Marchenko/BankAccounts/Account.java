package otus_java_basic.Marchenko.BankAccounts;
import java.util.Objects;

public class Account {
    private String account;

    public Account(String account) {
        this.account = account;
    }

    public Account() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account1 = (Account) o;
        return account.equals(account1.account);
    }

    public void printAccount() {
        System.out.println("Счет: " + getAccount());
    }
}
