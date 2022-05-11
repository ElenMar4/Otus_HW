package otus_java_basic.Marchenko.ProjectWork.UnitTest;

import otus_java_basic.Marchenko.ProjectWork.DigitalInputHandler;

public class DigitalInputHandlerTest {

    String strTest;
    int valueTest;

    public DigitalInputHandlerTest(String strTest, int valueTest) {
        this.strTest = strTest;
        this.valueTest = valueTest;
    }

    public void test() {
        DigitalInputHandler digitalInputHandler = new DigitalInputHandler();
        String result = digitalInputHandler.getNumberAsString(valueTest);
        System.out.println("Тестирование метода getNumberAsString");
        System.out.println("Ожидаемый результат: " + strTest);
        System.out.println("Полученный результат: " + result);
        boolean resultBool;
        resultBool = strTest.equals(result);
        System.out.println("Результат тестирования: " + resultBool + "\n");
    }
}
