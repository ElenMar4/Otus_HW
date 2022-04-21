package otus_java_basic.Marchenko.ProjectWork;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ConsoleSystem {

    public String stringInConsole(){
        System.out.println("enter number to change:");
        Scanner sc = new Scanner(System.in);
        return (sc.nextLine());
    }

    public String selectCurrency(){
        Currency cur = new Currency();
        Map <String, String[]> currency = cur.createCurrency();
        StringBuilder currencys = new StringBuilder();
        for ( String temp : currency.keySet()){
            currencys.append(temp).append(" / ");
        }
        System.out.println("select currency: " + currencys);
        Scanner sc = new Scanner(System.in);
        String userSelectCurrency = sc.nextLine();
        if (isLatin(userSelectCurrency)){
            return userSelectCurrency;
        } else throw new AlphabetExc("use latin");
    }

    public void stringOutConsole(int intValue, String userSelectCurrency){
        ConvertUserEnter cue = new ConvertUserEnter();
        String outMessage = cue.getNumber(intValue) + cue.getString(intValue, userSelectCurrency);
        System.out.println(outMessage);
    }

    public boolean isExit(String string){
        if (string == null || string.equals("")) {
            System.out.println(":( Null");
            return false;
        } else if (string.toLowerCase(Locale.ROOT).equals("exit")) {
            System.out.println("\n Bye!");
            return false;
        }
        return true;
    }

    public boolean isLatin(String str) {
        return str.matches("^[a-zA-Z]+$");
    }

    public boolean isCurrency(String string) {
        try {
            return (string.toLowerCase(Locale.ROOT).equals("rub"))
                    | (string.toLowerCase(Locale.ROOT).equals("usd"))
                    | (string.toLowerCase(Locale.ROOT).equals("eur"));
        } catch (NumberFormatException e) {
            System.err.println("use: RUB, USD, EUR");
        }
        return false;
    }
}