package otus_java_basic.Marchenko.BankAccounts;
import java.util.Scanner;

public class InputOfInitialData {

    public static String inputOfInitialData(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}