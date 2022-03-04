package BankAccounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Client {
    private String name;
    private int age;
    private List<Account> account = new ArrayList<>();

    public Client(String name, int age, List<Account> account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Account> getAccount() {
        return account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;

        return age == client.age && name.toLowerCase(Locale.ROOT).equals(client.name.toLowerCase(Locale.ROOT));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
