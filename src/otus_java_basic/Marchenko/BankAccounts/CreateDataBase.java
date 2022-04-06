package otus_java_basic.Marchenko.BankAccounts;
import com.github.javafaker.Faker;

import java.util.*;

public class CreateDataBase {

    public static Map<Client, List<Account>> createBaseClientAndAccount(){
        Map<Client, List<Account>> map = new HashMap<>();
        int numbersOfClients = 5;
        for (int i = 0; i < numbersOfClients; i++) {
            map.put(createClients(), createAccounts());
        }
        return map;
    }

    public static Client createClients() {
        Client client = new Client();
        Faker faker = new Faker();
        String uniqueID = UUID.randomUUID().toString();
        client.setClientID(uniqueID);
        client.setName(faker.name().fullName());
        client.setAge(faker.number().numberBetween(10, 80));
        return client;
    }

    public static List<Account> createAccounts() {
        Random randomNumberAccounts = new Random();
        int count = randomNumberAccounts.nextInt(1, 5);
        List<Account> clientAccounts = new ArrayList<>();
        Random rm = new Random();
        for (int i = 0; i < count; i++) {
            Account tempAccount = new Account();
            StringBuilder card = new StringBuilder("RU");
            for (int j = 0; j < 24; j++) {
                int n = rm.nextInt(10);
                card.append(n);
            } tempAccount.setAccount(card.toString());
            clientAccounts.add(tempAccount);
        }
        return clientAccounts;
    }
}