package otus_java_basic.Marchenko.Exception;

import java.util.Scanner;

public class ExercisesExc {

    public static void main(String[] args){

        System.out.println("This is a translator program. From English into Russian.\nTo exit the program, type - exit.\nlet's start!\nEnter word:");
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        Dictionary dictionary = new Dictionary();
        while (isExit(string)){
            while (isLatin(string)){
                System.out.println(dictionary.messageOutput(dictionary.getValue(string)));
                break;
            } string = sc.nextLine();
        }
        dictionary.printNewWords();
    }

    public static boolean isLatin(String string){
        if (string.matches("^[a-zA-Z0-9]+$")) {
            return true;
        } else {
            throw new AlphabetEntryException("Input Error. Use latin letters.");
        }
    }

    public static boolean isExit(String string) {
        if (string.equals("exit")) {
            System.out.println("\n See you, bye!");
            System.out.println("\n Don't forget to add new words to the dictionary:");
            return false;
        } else return true;
    }

}
