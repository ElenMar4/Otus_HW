package otus_java_basic.Marchenko.ProjectWork.UnitTest;

import otus_java_basic.Marchenko.ProjectWork.*;

public class MainApplicationTest implements ApplicationLauncher {

    public static void main(String[] args) {
        new MainApplicationTest().startApplication();
    }

    @Override
    public void startApplication() {
        String[][] dataSource = {
                {"45", "сорок пять ", "rub", "рублей"},
                {"45", "сорок пять ", "usd", "долларов"},
                {"104", "сто четыре ", "rub", "рубля"},
                {"221", "двести двадцать один ", "rub", "рубль"},
                {"4", "четыре ", "usd", "доллара"},
                {"11", "одиннадцать ", "eur", "евро"}
        };
        String listCurrencies = "eur / usd / rub / ";

        for (String[] strings : dataSource) {
            int valueTest = Integer.parseInt(strings[0]);
            String strValueTest = strings[1];
            String currencyTest = strings[2];
            String strCurrencyTest = strings[3];
            String outputStr = strValueTest + strCurrencyTest + "\n";

            System.out.println("\n**********Следующий тест***************\n");

            //тестирование класса FacadeApplication - приложение
            FacadeApplicationTest facadeApplicationTest = new FacadeApplicationTest();
            facadeApplicationTest.startApplicationTest(valueTest, currencyTest, outputStr);

            //тестирование класса CurrencyCompilerOne
            CurrencyCompilerOneTest currencyCompilerTest = new CurrencyCompilerOneTest(currencyTest, valueTest, strCurrencyTest, listCurrencies);
            currencyCompilerTest.test();

            //тестирование класса DigitalInputHandler
            DigitalInputHandlerTest digitalHandler = new DigitalInputHandlerTest(strValueTest, valueTest);
            digitalHandler.test();

            //тестирование класса ConsoleUserInteractionService
            ConsoleUserInteractionServiceTest consoleService = new ConsoleUserInteractionServiceTest(valueTest, currencyTest, strValueTest, strCurrencyTest, listCurrencies, outputStr);
            consoleService.test();

        }
    }
}


