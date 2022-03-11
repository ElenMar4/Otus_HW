package BankAccounts;

import java.util.ArrayList;
import java.util.List;

public class BankSearchService {
//Поиск клиента по номеру счета
    public Client findClient(Account account, List<Account> accountsList) {
        for (Account accountCount : accountsList) {
            if (accountCount.getAccount().equals(account.getAccount())) {
                return accountCount.getClient();
            }
        }
        return null;
    }
//Поиск счетов по клиенту
    public List<Account> getAccounts(Client client, List<Client> clientsList) {
        for (Client clientCount : clientsList) {
            if (client.equals(clientCount)) {
                return clientCount.getAccount();
            }
        }
        return null;
    }
//Печать списка данных всех клиентов банка
    public void printClients(List<Client> clientsList) {
        for (Client clientPrint : clientsList) {
            System.out.println(clientPrint.toString());
        }
    }
//Печать списка всех счетов банка
    public void printAccounts(List<Account> accountsList) {
        System.out.println("\n Все счета: \n");
        for (Account accountPrint : accountsList) {
            System.out.println(accountPrint.toString());
        }
    }
}
