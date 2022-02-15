package ProjectOOP;


import java.util.Scanner;

public class TestApplication {
    public static void main(String[] args) {

        //Создаем тест жестким кодом

        OrderTest one = new OrderTest("Как называется код между фигурными скобками?", new String[]{"1. функция", "2. секция", "3. тело", "4. блок"}, 4);
        OrderTest second = new OrderTest("Каково значение arr[1].length в следующем массиве? int[][] arr = { {1, 2, 3, 4, 5}, { 6, 7, 8, 9, 10} }", new String[]{"1. 2", "2. 5", "3. 10"}, 2);
        OrderTest third = new OrderTest("От какого класса наследуют все классы Java?", new String[]{"1. Object", "2. List", "3. Runtime", "4. Collection", "5. String"}, 1);

        System.out.println("Выберите меню: 1 - создать тест; 2 - пройти тест; 0 - выход");

        Scanner sc = new Scanner(System.in);
        int enter = sc.nextInt();

        switch (enter) {
            case 1:
                System.out.println(":( \n В разработке.");
                break;

            case 2:
                TestApplication testJava = new TestApplication();
                System.out.println("Пройди тест по java");

                System.out.println(testJava.workingTest(one));
                System.out.println(testJava.workingTest(second));
                System.out.println(testJava.workingTest(third));
                break;

            case 0:
                System.out.println("Выход");
                break;
        }
    }

    public String workingTest(OrderTest test) {

        System.out.println(test.question);
        System.out.println("Выберите вариант ответа: ");
        for (int i = 0; i < test.answers.length; i++) {
            System.out.println(test.answers[i]);
        }
        String reply;

        Scanner sc = new Scanner(System.in);
        int userAnswer = sc.nextInt();
        if (userAnswer == test.rightAnswer) {
            reply = "Верно! Так держать! \n";
        } else {
            reply = "Неверно. \n";
        }
        return reply;
    }
}
