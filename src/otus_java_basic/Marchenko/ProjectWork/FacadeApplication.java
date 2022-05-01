package otus_java_basic.Marchenko.ProjectWork;

import java.util.Locale;

public class FacadeApplication implements ApplicationLauncher {

    public void startApplication() {
        UserInteractionService console = new ConsoleUserInteractionService();
        InputDataHandler convert = new DigitalInputHandler();
        CompilerOfCurrency currency = new CurrencyCompilerForRegionOne();

        while (true) {
            //Ввод с консоли числа
            int intValue = console.selectNumber();
            //Получение списка доступных валют
            String listCurrency = currency.getListTheCurrencies();
            //Ввод с консоли валюты
            String userSelectCurrency = console.selectCurrency(listCurrency).toLowerCase(Locale.ROOT);
            //Перевод числовую запись в строковую
            String convertUserNumberToString = convert.getNumberAsString(intValue);
            //Определение валюты
            String currencyStringOut = currency.getCurrencyBySourceData(intValue, userSelectCurrency);
            //Вывод на косоль результата
            console.outputToConsole(convertUserNumberToString, currencyStringOut);
        }
    }
}


