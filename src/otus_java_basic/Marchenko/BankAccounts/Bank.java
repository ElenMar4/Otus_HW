package otus_java_basic.Marchenko.BankAccounts;

import java.util.List;
import java.util.Scanner;

public class Bank {

    public static void main(String[] args) { //Приложение

        ClientUtil clientUtil = new ClientUtil();
        BankSearchService search = new BankSearchService();

        int numberOfClients = 4;
        List<Client> clientsList = clientUtil.createClients(numberOfClients);
        List<Account> accountsList = clientUtil.accountsList;

        Client clientTest = clientUtil.createClientTest(clientsList.get(0));
        Account accountTest = clientUtil.createAccountTest(accountsList.get(2));

        while (true) {
            //Меню:
            System.out.println("Выберите действие: ");
            System.out.println("0 - Показать базу клиентов и их счета \n1 - Показать все счета банка \n2 - Поиск данных клиента по номеру счета \n3 - Поиск счетов клиента \nexit - Выход");
            Scanner sc = new Scanner(System.in);
            String choiceUserStr = sc.nextLine();

            if (isInteger(choiceUserStr)) {
                int choiceUserInt = Integer.parseInt(choiceUserStr);
                switch (choiceUserInt) {
                    case 0 -> { //Показать базу клиентов и их счета
                        search.printClients(clientsList);
                        continue;
                    }
                    case 1 -> { // Показать все счета банка
                        search.printAccounts(accountsList);
                        continue;
                    }
                    case 2 -> { // Поиск данных клиента по номеру счета
                        Client a = search.findClient(accountTest, accountsList);
                        System.out.println("\nID: " + a.getClientID() + "\nИмя: " + a.getName() + "\nВозраст: " + a.getAge() + "\n");
                        continue;
                    }
                    case 3 -> { // Поиск счетов клиента
                        System.out.println("\n" + "Счета клиента: " + search.getAccounts(clientTest, clientsList).toString() + "\n");
                        continue;
                    }
                }
                System.out.println("Ooops! Такого в меню нет :(");
            }
            break;
        }
    }
//Проверка ввода
    public static boolean isInteger(String s) {
        if (s == null || s.equals("")) {
            System.out.println(":( Ничего");
            return false;
        } else if (s.equals("exit")) {
            System.out.println("\n До встречи!");
        } else {
            try {
                int iVal = Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                System.out.println("Используется числовое меню. Пример ввода: 2");
            }
        }
        return false;
    }
}

