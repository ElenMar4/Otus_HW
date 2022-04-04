package otus_java_basic.Marchenko.BankAccounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Client {
    private String name;
    private String clientID;
    private int age;
    private List<Account> account = new ArrayList<>();

    public Client(String name, String clientID, int age, List<Account> account) {
        this.name = name;
        this.age = age;
        this.account = account;
        this.clientID = clientID;
    }

    public Client() {
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

    public String getClientID() {
        return clientID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Имя клиента:  " + name + "\nВозраст:  " + age + "\nID:  " + clientID + "\n Счет(а): \n" + account.toString() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age && name.toLowerCase(Locale.ROOT).equals(client.name.toLowerCase(Locale.ROOT)) && clientID.equals(client.clientID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
