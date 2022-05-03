package otus_java_basic.Marchenko.ProjectWork.UnitTest;

import otus_java_basic.Marchenko.ProjectWork.ApplicationLauncher;
import otus_java_basic.Marchenko.ProjectWork.ConsoleUserInteractionService;
import otus_java_basic.Marchenko.ProjectWork.CurrencyCompilerForRegionOne;
import otus_java_basic.Marchenko.ProjectWork.DigitalInputHandler;

public class TestFacadeApplication implements ApplicationLauncher {

    public static void main(String[] args) {
        new TestFacadeApplication().startApplication();
    }

    @Override
    public void startApplication() {

        String currencyTest = "rub";
        String strTest = "сорок пять ";
        int valueTest = 45;
        String strCurrencyTest = "рублей";

//         тестирование метода, который считывает с консоли ввод пользователя
        System.out.println("\nДля тестирования выберите цифру: " + valueTest);
        System.out.println("\nРезультат тестирования метода selectNumber: " + testSelectNumber(valueTest));

            //проверка правильно ли выводится список валют
        String listCurrencies = "eur / usd / rub / ";
        System.out.println("\nРезультат тестирования метода getListTheCurrencies: " + testGetListTheCurrencies(listCurrencies));

            //проверка, что какая валюта на входе, та же и выводе
        System.out.println("\nДля тестирования выберите валюту: " + currencyTest);
        System.out.println("\nРезультат тестирования метода selectCurrency: " + testSelectCurrency(currencyTest));

            //проверка, что тестовая строка(число прописью) и строка определенная с помощью метода идентичны
        System.out.println("\nРезультат тестирования метода getNumberAsString: " + testGetNumberAsString(strTest, valueTest));

            //проверка, что тестовая строка(валюта прописью) и строка определенная с помощью метода идентичны
        System.out.println("\nРезультат тестирования метода getNumberAsString: " + testGetCurrencyBySourceData(valueTest, currencyTest, strCurrencyTest));

    }

    public boolean testSelectNumber(int temp) {
        return temp == new ConsoleUserInteractionService().selectNumber();
    }

    public boolean testGetListTheCurrencies(String listCurrencies) {
        return listCurrencies.equals(new CurrencyCompilerForRegionOne().getListTheCurrencies());
    }

    public boolean testSelectCurrency(String currencyTest) {
        return currencyTest.equals(new ConsoleUserInteractionService().selectCurrency(new CurrencyCompilerForRegionOne().getListTheCurrencies()));
    }

    public boolean testGetNumberAsString(String str, int value) {
        return str.equals(new DigitalInputHandler().getNumberAsString(value));
    }

    public boolean testGetCurrencyBySourceData(int value, String currency, String currencyStr) {
        return currencyStr.equals(new CurrencyCompilerForRegionOne().getCurrencyBySourceData(value, currency));
    }
}


