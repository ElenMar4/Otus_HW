package SystemTest;
import java.util.Scanner;

public class SystemTest {

    public static void main(String[] args) {

        String [] questions = {
                " Как называется код между фигурными скобками?",
                " Каково значение arr[1].length в следующем массиве? int[][] arr = { {1, 2, 3, 4, 5}, { 6, 7, 8, 9, 10} }",
                " От какого класса наследуют все классы Java?"
        };
        String [][] answers = {
                {"1. функция", "2. секция", "3. тело", "4. блок"},
                {"1. 2", "2. 5", "3. 10"},
                {"1. Object", "2. List", "3. Runtime", "4. Collection", "5. String"},
        };
        Integer [] rightAnswers = {4, 2, 1};

        int allCorrectAnswers = 0;

        System.out.println("Добрый день! Отвечайте на вопросы и пишите варианты ответа. " +
                "Внимание! есть только один правильный ответ.");
        System.out.println("Начинаем!");

        for (int i = 0 ; i < questions.length ; i++) {
            System.out.println(questions[i]);

            for (int j = 0 ; j < answers[i].length ; j++) {
                System.out.println(answers[i][j]);
            }
            System.out.println("Введите число:");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int digit = sc.nextInt();

                if (digit == rightAnswers[i]) {
                    allCorrectAnswers++;
                    System.out.println("Верно!");
                } else
                    System.out.println("Сожалеем,Вы ошиблись.");
            } else {
                System.out.println("Ошибка ввода. Необходимо вводить число!");
                break;}
        }
        System.out.println();
        System.out.println("Тест завершен.");
        if (allCorrectAnswers == 0) {
            System.out.println("У вас нет правильных ответов.");
        } else
            System.out.println("Всего правильных ответов: " + allCorrectAnswers);
    }
}
