package otus_java_basic.Marchenko.ProjectWork.UnitTest;

import otus_java_basic.Marchenko.ProjectWork.ConsoleUserInteractionService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleUserInteractionServiceTest {
    int valueTest;
    String currencyTest;
    String strValueTest;
    String strCurrencyTest;
    String listCurrencies;
    String outputStr;

    public ConsoleUserInteractionServiceTest(int valueTest, String currencyTest, String strTest, String strCurrencyTest, String listCurrencies, String outputStr) {
        this.valueTest = valueTest;
        this.currencyTest = currencyTest;
        this.strValueTest = strTest;
        this.strCurrencyTest = strCurrencyTest;
        this.listCurrencies = listCurrencies;
        this.outputStr = outputStr;
    }

    public void test() {
        ConsoleUserInteractionService consoleUserInteractionService = new ConsoleUserInteractionService();
        selectNumberTest(consoleUserInteractionService);
        selectCurrencyTest(consoleUserInteractionService);
        outputToConsoleTest(consoleUserInteractionService);
    }

    public void selectNumberTest(ConsoleUserInteractionService consoleUserInteractionService) {
        System.out.println("Тестирование метода selectNumber");
        System.out.println("Ожидаемый результат: " + valueTest);
        int result = consoleUserInteractionService.selectNumber();
        System.out.println("Полученный результат: " + result);
        boolean resultBool;
        resultBool = result == valueTest;
        System.out.println("Результат тестирования: " + resultBool + "\n");
    }

    public void selectCurrencyTest(ConsoleUserInteractionService consoleUserInteractionService) {
        System.out.println("Тестирование метода selectCurrency");
        System.out.println("Ожидаемый результат: " + currencyTest);
        String result = consoleUserInteractionService.selectCurrency(listCurrencies);
        System.out.println("Полученный результат: " + result);
        boolean resultBool = currencyTest.equals(result);
        System.out.println("Результат тестирования: " + resultBool + "\n");
    }

    public void outputToConsoleTest(ConsoleUserInteractionService consoleUserInteractionService) {
        System.out.println("Тестирование метода outputToConsole");
        System.out.println("Ожидаемый результат: " + outputStr);

        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;
        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);
        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        consoleUserInteractionService.outputToConsole(strValueTest, strCurrencyTest);
        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();
        //Возвращаем все как было
        System.setOut(consoleStream);

        System.out.println("Полученный результат: " + result);
        boolean resultBool = outputStr.equals(result);
        System.out.println("Результат тестирования: " + resultBool + "\n");
    }
}
