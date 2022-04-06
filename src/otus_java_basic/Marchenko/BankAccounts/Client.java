package otus_java_basic.Marchenko.BankAccounts;
import java.util.Locale;
import java.util.Objects;

public class Client {
    private String clientID;
    private String name;
    private int age;

    public Client(String clientID, String name, int age) {
        this.clientID = clientID;
        this.name = name;
        this.age = age;
    }
    public Client(){}

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return name.toLowerCase(Locale.ROOT).equals(client.name.toLowerCase(Locale.ROOT)) && clientID.equals(client.clientID);
    }


    public void printClient() {
        System.out.println("\nID клиента: " + getClientID() + "\nИмя клиента:  " + getName() + "\nВозраст:  " + getAge());
    }
}