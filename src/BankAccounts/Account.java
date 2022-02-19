package BankAccounts;

import java.util.Objects;

public class Account {
    int account;

    public Account(int account) {
        this.account = account;
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
