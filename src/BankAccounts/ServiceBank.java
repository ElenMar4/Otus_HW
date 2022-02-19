package BankAccounts;

import java.util.*;

public class ServiceBank implements Bank {

    @Override
    public List<Account> getAccounts(Client needClient, HashMap<Client, List<Account>> map) {

        List<Account> listAccountsClient = new ArrayList<>();
        for (Client client : map.keySet()) {
            if (needClient.equals(client)) {
                for (Account account : map.get(client)) {
                    Collections.addAll(listAccountsClient, account);
                }
            }
        }
        return listAccountsClient;
    }

    @Override
    public Client findClient(Account needAccount, HashMap<Client, List<Account>> map) {

        String nameClient = null;
        int ageClient = 0;
        for (Client client : map.keySet()) {
            for (Account account : map.get(client)) {
                if (needAccount.equals(account)) {
                    nameClient = client.name;
                    ageClient = client.age;
                    break;
                }
            }
        }
        return (new Client(nameClient, ageClient));
    }

    public static void main(String[] args) {

        HashMap<Client, List<Account>> map = new HashMap<>();

        map.put(new Client("Антон", 25), Arrays.asList(new Account(123), new Account(147), new Account(159)));
        map.put(new Client("Борис", 23), Arrays.asList(new Account(258), new Account(213)));
        map.put(new Client("Виктор", 14), List.of(new Account(321)));
        map.put(new Client("Генадий", 20), Arrays.asList(new Account(456), new Account(471)));
        map.put(new Client("Дмитрий", 18), List.of(new Account(582)));
        map.put(new Client("Егор", 40), Arrays.asList(new Account(654), new Account(693), new Account(681)));

        ServiceBank serviceBank = new ServiceBank();
        //Меню:
        System.out.println("Выберите действие: ");
        System.out.println("0 - Показать базу клиентов и их счета \n1 - Поиск данных клиента по номеру счета \n2 - Поиск счетов клиента \n3 - Выход");
        Scanner sc = new Scanner(System.in);
        int userNumber = sc.nextInt();

        switch (userNumber) {

            case 0: //Показать базу клиентов и их счета
                for (Client client : map.keySet()) {
                    System.out.println("\nКлиент: " + client.name + "\nСчета: ");
                    for (Account account : map.get(client)) {
                        System.out.println(account.account);
                    }
                }
                break;

            case 1: //Поиск данных клиента по номеру счета
                System.out.println("Введите счет: ");
                Scanner scAccount = new Scanner(System.in);
                Account needAccount = new Account(scAccount.nextInt());

                Client desiredClient = serviceBank.findClient(needAccount, map);
                if (desiredClient.name == null) {
                    System.out.println("Счет свободен.");
                } else {
                    System.out.println("Счет " + needAccount.account + " принадлежит клиенту: " + desiredClient.name + ", " + desiredClient.age + " лет");
                }
                break;

            case 2: //Поиск счетов клиента
                System.out.println("Введите имя клиента:");
                Scanner scName = new Scanner(System.in);
                String nameNeedClient = scName.nextLine();

                System.out.println("Введите возраст клиета:");
                Scanner scAge = new Scanner(System.in);
                int ageNeedClient = scAge.nextInt();

                Client needClient = new Client(nameNeedClient, ageNeedClient);
                System.out.println(needClient.name + " , " + needClient.age + " лет");

                List<Account> listAccountClient;
                listAccountClient = serviceBank.getAccounts(needClient, map);

                if (listAccountClient.size() == 0) {
                    System.out.println("Клиент не зарегистрирован.");
                } else {
                    System.out.println(needClient.name + " имеет счет(a): ");
                    for (Account account : listAccountClient) {
                        System.out.println(account.account);
                    }
                }
                break;

            case 3: //Выход
                System.out.println("Работа завершена.");
                break;
        }
    }
}
