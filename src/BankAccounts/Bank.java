package BankAccounts;

import java.util.*;

public class Bank {

    public static String findClient(int account, List<List<Account>> listAccounts) {
        String nameClient = null;
        for (List<Account> count : listAccounts) {
            for (Account count1 : count) {
                if (count1.getAccount() == account) {
                    nameClient = count1.getClientName();
                }
            }
        }
        return nameClient;
    }

    public static List<Account> getAccounts(Client client, List<Client> listAllClient) {
        List<Account> clientAccount = new ArrayList<>();
        for (Client clientCount : listAllClient) {
            if (client.equals(clientCount)) {
                clientAccount = clientCount.getAccount();
            }
        }
        return clientAccount;
    }

    public static void main(String[] args) {

        List<Account> listAccountIvan = new ArrayList<>();
        listAccountIvan.add(new Account(11, "Ivan"));
        listAccountIvan.add(new Account(12, "Ivan"));
        listAccountIvan.add(new Account(13, "Ivan"));

        List<Account> listAccountAnton = new ArrayList<>();
        listAccountAnton.add(new Account(21, "Anton"));
        listAccountAnton.add(new Account(22, "Anton"));

        List<Account> listAccountElena = new ArrayList<>();
        listAccountElena.add(new Account(31, "Elena"));
        listAccountElena.add(new Account(32, "Elena"));
        listAccountElena.add(new Account(33, "Elena"));

        List<Account> listAccountMary = new ArrayList<>();
        listAccountMary.add(new Account(41, "Mary"));

        List<List<Account>> listAllAccounts = new ArrayList<>();
        listAllAccounts.add(listAccountIvan);
        listAllAccounts.add(listAccountAnton);
        listAllAccounts.add(listAccountElena);
        listAllAccounts.add(listAccountMary);

        Client clientIvan = new Client("Ivan", 25, listAccountIvan);
        Client clientAnton = new Client("Anton", 30, listAccountAnton);
        Client clientElena = new Client("Elena", 27, listAccountElena);
        Client clientMary = new Client("Mary", 15, listAccountMary);

        List<Client> listAllClient = new ArrayList<>();
        listAllClient.add(clientAnton);
        listAllClient.add(clientIvan);
        listAllClient.add(clientElena);
        listAllClient.add(clientMary);

        int menu = 9;
        do {
            //Меню:
            System.out.println("Выберите действие: ");
            System.out.println("0 - Показать базу клиентов и их счета \n1 - Поиск данных клиента по номеру счета \n2 - Поиск счетов клиента \n3 - Выход");
            Scanner sc = new Scanner(System.in);
            int userNumber = sc.nextInt();

            switch (userNumber) {

                case 0: //Показать базу клиентов и их счета

                    for (Client client : listAllClient) {
                        System.out.println("\n" + client.getName() + "; " + client.getAge() + " лет" + "\nСчета клиента:");
                        for (Account account : client.getAccount()) {
                            System.out.println(account.getAccount());
                        }
                    }
                    break;
                case 1: //Поиск данных клиента по номеру счета

                    System.out.println("Введите счет: ");
                    Scanner scAccount = new Scanner(System.in);
                    int count = scAccount.nextInt();
                    String currentClientOfAccount = findClient(count, listAllAccounts);

                    if (currentClientOfAccount == null) {
                        System.out.println("Счет свободен.");
                    } else {
                        System.out.println("Счет " + count + " принадлежит клиенту: " + currentClientOfAccount);
                    }
                    break;

                case 2: //Поиск счетов клиента

                    System.out.println("Введите имя клиента");
                    Scanner scName = new Scanner(System.in);
                    String currentClientName = scName.nextLine();

                    System.out.println("Введите возраст клиента");
                    Scanner scAge = new Scanner(System.in);
                    int currentClientAge = scAge.nextInt();

                    Client currentClient = new Client(currentClientName, currentClientAge);

                    List<Account> currentAccountOfClient = getAccounts(currentClient, listAllClient);

                    if (currentAccountOfClient.size() == 0) {
                        System.out.println("У клиента нет счетов");
                    } else {
                        System.out.println("Счета клиента: " + currentClient.getName() + ":\n");
                        for (Account countAccount : currentAccountOfClient) {
                            System.out.println(countAccount.getAccount());
                        }
                    }
                    break;

                case 3: //Выход
                    System.out.println("Работа завершена.");
                    break;
            }

            System.out.println("\nЕсли хотите открыть меню, нажмите: " + menu + "\nЕсли нет, нажмите любое другое число");
            Scanner menuStart = new Scanner(System.in);
            menu = menuStart.nextInt();

        } while (menu == 9);

        System.out.println("До встречи!");
    }
}
