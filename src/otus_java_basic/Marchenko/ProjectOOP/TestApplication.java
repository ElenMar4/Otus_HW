package otus_java_basic.Marchenko.ProjectOOP;


import java.util.Scanner;

public class TestApplication {

    //Метод проверяется правильность ответа user
    public static int workingTest(Answer answer, int correctAnswersUser) {

        //boolean user = true;
        do {
            Scanner sc = new Scanner(System.in);
            String temp = sc.nextLine();
            if (isInteger(temp)) {
                int userAnswer = Integer.parseInt(temp);
                if (userAnswer == answer.getCorrectAnswerIndex()) {
                    System.out.println("Верно! Так держать!");
                    correctAnswersUser++;
                    //user = false;
                    break;
                } else {
                    System.out.println("Неверно.");
                    break;
                }
            } else {
                System.out.println("Попробуйте еще раз.");
            }
        } while (true);
        return correctAnswersUser;
    }

    //Метод проверяет, является ли введенная строка - числом
    public static boolean isInteger(String s) {

        if (s == null || s.equals("")) {
            System.out.println("Необходимо ввести число");
            return false;
        }
        try {
            int iVal = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число. Пример ввода: 2");
        }
        return false;
    }

    public static void main(String[] args) {

        Question[] test = {
                new Question(("\nКак называется код между фигурными скобками?\n1. функция\n2. секция\n3. тело\n4. блок\n"), new Answer(4)),
                new Question(("\nКаково значение arr[1].length в следующем массиве? int[][] arr = { {1, 2, 3, 4, 5}, { 6, 7, 8, 9, 10} \n1. 2 \n2. 5 \n3. 10\n"), new Answer(2)),
                new Question(("\nОт какого класса наследуют все классы Java? \n1. Object \n2. List \n3. Runtime \n4. Collection \n5. String\n"), new Answer(1))
        };


        User user = new User();
        System.out.println("Представьтесь пожалуйста");
        user.setName();

        int consent = 1; //переменная задает условие повторения теста
        do {
            int correctAnswersUser = 0;
            for (Question question : test) {
                System.out.println(question.getDescription());
                correctAnswersUser = workingTest(question.getAnswer(), correctAnswersUser);
            }

            if (correctAnswersUser == 1) {
                System.out.println("\n" + user.getName() + ", вы дали " + correctAnswersUser + " правильный ответ");
            } else if (correctAnswersUser == 0) {
                System.out.println("\n" + user.getName() + ", у вас нет правильных ответов");
            } else {
                System.out.println("\n" + user.getName() + ", вы дали " + correctAnswersUser + " правильных ответа");
            }

            System.out.println("Если хотите пройти тест еще раз, нажмите: " + consent + "\nЕсли нет, нажмите любое другое число");
            Scanner consentUser = new Scanner(System.in);
            consent = consentUser.nextInt();

        } while (consent == 1);
        System.out.println("\nДо встречи, " + user.getName() + "\nСпасибо за игру!");
    }
}
