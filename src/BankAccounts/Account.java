package BankAccounts;

import java.util.Objects;

public class Account {
    private String account;
    private Client client;

    public Account(String account, Client client) {
        this.account = account;
        this.client = client;
    }

    public Account() {
    }

    public String getAccount() {
        return account;
    }

    public Client getClient() {
        return client;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account1 = (Account) o;
        return account.equals(account1.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account);
    }
}
