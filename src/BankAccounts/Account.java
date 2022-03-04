package BankAccounts;

import java.util.Objects;

public class Account {
    private int account;
    private String clientName;

    public Account(int account, String clientName) {
        this.account = account;
        this.clientName = clientName;
    }

    public int getAccount() {
        return account;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account1 = (Account) o;
        return account == account1.account;
    }

    @Override
    public int hashCode() {
        return Objects.hash(account);
    }
}
