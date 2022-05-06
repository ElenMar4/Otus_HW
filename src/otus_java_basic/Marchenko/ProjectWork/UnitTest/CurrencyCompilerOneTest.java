package otus_java_basic.Marchenko.ProjectWork.UnitTest;

import otus_java_basic.Marchenko.ProjectWork.CurrencyCompilerOne;

public class CurrencyCompilerOneTest {
    String currencyTest;
    int valueTest;
    String strCurrencyTest;
    String listCurrencies;

    public CurrencyCompilerOneTest(String currencyTest, int valueTest, String strCurrencyTest, String listCurrencies) {
        this.currencyTest = currencyTest;
        this.valueTest = valueTest;
        this.strCurrencyTest = strCurrencyTest;
        this.listCurrencies = listCurrencies;
    }

    public void test() {
        CurrencyCompilerOne currencyCompilerOne = new CurrencyCompilerOne();
        getListTheCurrenciesTest(currencyCompilerOne);
        getCurrencyBySourceDataTest(currencyCompilerOne, valueTest, currencyTest, strCurrencyTest);
    }

    public void getListTheCurrenciesTest(CurrencyCompilerOne currencyCompilerOne) {
        String result = currencyCompilerOne.getListTheCurrencies();
        System.out.println("Тестирование метода getListTheCurrencies");
        System.out.println("Ожидаемый результат: " + listCurrencies);
        System.out.println("Полученный результат: " + result);
        boolean resultBool;
        resultBool = listCurrencies.equals(result);
        System.out.println("Результат тестирования: " + resultBool + "\n");
    }

    public void getCurrencyBySourceDataTest(CurrencyCompilerOne currencyCompilerOne, int value, String currency, String currencyStr) {
        String result = currencyCompilerOne.getCurrencyBySourceData(value, currency);
        System.out.println("Тестирование метода getCurrencyBySourceData");
        System.out.println("Ожидаемый результат: " + currencyStr);
        System.out.println("Полученный результат: " + result);
        boolean resultBool;
        resultBool = currencyStr.equals(result);
        System.out.println("Результат тестирования: " + resultBool + "\n");
    }
}

