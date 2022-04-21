package otus_java_basic.Marchenko.ProjectWork;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        ConsoleSystem sin = new ConsoleSystem();
        while (true) {
            String strValue = sin.stringInConsole();
            if (sin.isExit(strValue)) {
                int intValue = Integer.parseInt(strValue);
                String userSelectCurrency = sin.selectCurrency().toLowerCase(Locale.ROOT);
                if (sin.isCurrency(userSelectCurrency)){
                    sin.stringOutConsole(intValue, userSelectCurrency);
                }
            } else break;
        }
    }
}

