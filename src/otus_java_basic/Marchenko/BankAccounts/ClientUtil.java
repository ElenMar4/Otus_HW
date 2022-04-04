package otus_java_basic.Marchenko.BankAccounts;


import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ClientUtil {

    public List<Account> accountsList = new ArrayList<>();
//Создаем fake-клиентов
    public List<Client> createClients(int numbersOfClients) {
        List<Client> clientsList = new ArrayList<>();
        for (int i = 0; i < numbersOfClients; i++) {
            Client client = new Client();
            Faker faker = new Faker();
            String uniqueID = UUID.randomUUID().toString();
            client.setClientID(uniqueID);
            client.setName(faker.name().fullName());
            client.setAge(faker.number().numberBetween(10, 80));
            client.setAccount(createAccounts(faker.random().nextInt(1, 3), client));
            accountsList.addAll(client.getAccount());
            clientsList.add(client);
        }
        return clientsList;
    }
//создаем fake-счета
    public List<Account> createAccounts(int count, Client client) {
        List<Account> clientAccounts = new ArrayList<>();
        Random rm = new Random();
        for (int i = 0; i < count; i++) {
            StringBuilder card = new StringBuilder("RU");
            for (int j = 0; j < 24; j++) {
                int n = rm.nextInt(10);
                card.append(n);
            }
            Account fakerAccount = new Account(card.toString(), client);
            clientAccounts.add(fakerAccount);
        }
        return clientAccounts;
    }
//Создание тест-клиента и тест-счета для проверки методов
    public Client createClientTest(Client client) {
        Client clientTest = new Client();
        clientTest.setClientID(client.getClientID());
        clientTest.setName(client.getName());
        clientTest.setAge(client.getAge());
        return clientTest;
    }

    public Account createAccountTest(Account account) {
        Account accountTest = new Account();
        accountTest.setAccount(account.getAccount());
        return accountTest;
    }

}
