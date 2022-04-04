package otus_java_basic.Marchenko.ProjectOOP;

import java.util.Scanner;

public class User {
    private String name;
    private int correctAnswersCount;

    public String getName() {
        return name;
    }

    public int getCorrectAnswersCount() {
        return correctAnswersCount;
    }

    public void setName() {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Здравствуйте, " + name);
        this.name = name;
    }
}
