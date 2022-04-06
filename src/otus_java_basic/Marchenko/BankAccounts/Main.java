package otus_java_basic.Marchenko.BankAccounts;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Map<Client, List<Account>> baseClientAndAccount = CreateDataBase.createBaseClientAndAccount();
//        //Меню:
        while (true) {
            System.out.println("\nВыберите действие: ");
            System.out.println("0 - Показать базу клиентов и их счета \n1 - Поиск данных клиента по номеру счета \n2 - Поиск счетов клиента \nexit - Выход");
            Scanner sc = new Scanner(System.in);
            String choiceUserStr = sc.nextLine();

            if (isInteger(choiceUserStr)) {
                int choiceUserInt = Integer.parseInt(choiceUserStr);

                switch (choiceUserInt) {
                    case 0 -> { //Показать базу клиентов и их счета
                        PrintClientAndAccountBase.printClientAndAccountBase(baseClientAndAccount);
                        continue;
                    }
                    case 1 -> { //Поиск данных клиента по номеру счета
                        SearchClientByAccountNumber tempClient = new SearchClientByAccountNumber();
                        tempClient.inputData();
                        tempClient.searchData(baseClientAndAccount);
                        tempClient.outputData();
                        continue;
                    }
                    case 2 -> { //Поиск счетов клиента
                        SearchAccountsByClient tempAccount = new SearchAccountsByClient();
                        tempAccount.inputData();
                        tempAccount.searchData(baseClientAndAccount);
                        tempAccount.outputData();
                        continue;
                    }
                }
                System.out.println("Ooops! Такого в меню нет :(");
            } break;
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