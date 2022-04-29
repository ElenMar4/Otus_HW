package otus_java_basic.Marchenko.ProjectWork;

import java.util.Locale;

public class DataTransfer implements DataTransferInterface {
    public DataTransfer() {
        startApplication();
    }

    public void startApplication() {
        WorkWithConsole console = new WorkWithConsole();
        ConvertUserEnter convert = new ConvertUserEnter();
        WorkWithCurrency currency = new WorkWithCurrency();

        while (true) {
            //Ввод с консоли числа
            int intValue = console.selectNumber();
            //Получение списка доступных валют
            String listCurrency = currency.getListCurrency();
            //Ввод с консоли валюты
            String userSelectCurrency = console.selectCurrency(listCurrency).toLowerCase(Locale.ROOT);
            //Перевод числовую запись в строковую
            String convertUserNumberToString = convert.getNumberAsString(intValue);
            //Определение валюты
            String currencyStringOut = currency.getUserCurrency(intValue, userSelectCurrency);
            //Вывод на косоль результата
            console.stringOutConsole(convertUserNumberToString, currencyStringOut);
        }
    }
}


