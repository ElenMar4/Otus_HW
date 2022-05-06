package otus_java_basic.Marchenko.ProjectWork.UnitTest;

import otus_java_basic.Marchenko.ProjectWork.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FacadeApplicationTest {
    public void startApplicationTest(int valueTest, String currencyTest, String outputStr) {
        UserInteractionService console = new DublerConsoleUserInteractionService(valueTest, currencyTest);
        InputDataHandler convert = new DigitalInputHandler();
        CompilerOfCurrency currency = new CurrencyCompilerOne();

        System.out.println("Тестирование метода startApplication");
        FacadeApplication application = new FacadeApplication(console, convert, currency);
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
        application.startApplication();
        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();
        //Возвращаем все как было
        System.setOut(consoleStream);

        System.out.println("Полученный результат: " + result);
        boolean resultBool = outputStr.equals(result);
        System.out.println("Результат тестирования: " + resultBool + "\n");
    }
}
