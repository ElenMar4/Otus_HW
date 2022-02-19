package BankAccounts;

import java.util.Objects;

public class Client {
    String name;
    int age;

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age && name.equals(client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
