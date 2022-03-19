package Exception;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ExercisesExc {

    public static void main(String[] args) throws FileNotFoundException {

        FileOutputStream fos = new FileOutputStream("/home/alex/JB_2021_29/src/Exception/NewWords.txt");
        System.out.println("Если захотите остановиться, введите - exit");
        System.out.println("Enter word:");
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        Dictionary dictionary = new Dictionary();

        while (isExit(string)) {
            try {
                String translationWord = dictionary.getValue(string);
                if (translationWord == null) {
                    System.out.println("Word isn't found" + "\n");
                    newWords(string, fos);
                } else System.out.println(translationWord + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Enter word:");
                string = sc.nextLine();
            }
        }
        printNewWords();
    }

    //Проверка ввода латинских букв, и выход из программы
    public static boolean isExit(String string) {

        if (string.matches("^[a-zA-Z0-9]+$")) {
            if (string.equals("exit")) {
                System.out.println("\n До встречи!");
                System.out.println("\n Не забудь обновить словарь:");
                return false;
            } else {
                return true;
            }
        } else throw new AlphabetEntryException("Input Error. Use latin letters.");
    }

    //запись в файл слов, которых нет в словаре
    public static void newWords(String string, FileOutputStream fos) throws IOException {
        PrintStream printStream = new PrintStream(fos);
        printStream.println(string);
        System.out.println("Запись в файл выполнена\n");
    }

    //чтение из файла, вывод новых слов для добавления в словарь
    public static void printNewWords() {
        try (FileReader reader = new FileReader("/home/alex/JB_2021_29/src/Exception/NewWords.txt")) {
            char[] buf = new char[256];
            int count;
            while ((count = reader.read(buf)) > 0) {
                if (count < 256) {
                    buf = Arrays.copyOf(buf, count);
                }
                System.out.print(buf);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
