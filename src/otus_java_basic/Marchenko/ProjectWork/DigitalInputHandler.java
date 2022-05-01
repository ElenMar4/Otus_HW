package otus_java_basic.Marchenko.ProjectWork;

import java.util.Map;
import java.util.Stack;

public class DigitalInputHandler implements InputDataHandler {

    private final Map<Integer, String[]> matrixNumericFirstExponent;

    public DigitalInputHandler() {
        matrixNumericFirstExponent = Map.ofEntries(Map.entry(0, new String[]{"", "десять ", "", ""}),
                Map.entry(1, new String[]{"один ", "одиннадцать ", "", "сто "}),
                Map.entry(2, new String[]{"два ", "двенадцать ", "двадцать ", "двести "}),
                Map.entry(3, new String[]{"три ", "тринадцать ", "тридцать ", "триста "}),
                Map.entry(4, new String[]{"четыре ", "четырнадцать ", "сорок ", "четыреста "}),
                Map.entry(5, new String[]{"пять ", "пятнадцать ", "пятьдесят ", "пятьсот "}),
                Map.entry(6, new String[]{"шесть ", "шестнадцать ", "шестьдесят ", "шестьсот "}),
                Map.entry(7, new String[]{"семь ", "семнадцать ", "семьдесят ", "семьсот "}),
                Map.entry(8, new String[]{"восемь ", "восемнадцать ", "восемьдесят ", "восемьсот "}),
                Map.entry(9, new String[]{"девять ", "девятнадцать ", "девяносто ", "девятьсот "}));
    }

    public String getNumberAsString(int intValue) {

        Stack<Integer> exponent = new Stack<>();
        int tempNumber = intValue;
        while (tempNumber != 0){
            exponent.push(tempNumber % 1000);
            tempNumber = tempNumber / 1000;
        }
        String strFinal = "";
        switch (exponent.size()){
            case 1 -> strFinal = getClassTheUnit(exponent.pop());
            case 2 -> strFinal = getClassTheThousands(exponent.pop());
            case 3 -> strFinal = getClassTheMillions(exponent.pop());
        }
        return strFinal;
    }

    public String getClassTheUnit(int numberOneExponent){
        StringBuilder stringOut = new StringBuilder();
        Stack<Integer> digit = new Stack<>();
        int temp = numberOneExponent;
        while (temp != 0) {
            digit.push(temp % 10);
            temp = temp / 10;
        }
        while (digit.size() != 0) {
            switch (digit.size()) {
                case 1 -> stringOut.append(matrixNumericFirstExponent.get(digit.pop())[0]);
                case 2 -> {
                    int dozens = digit.pop();
                    if (dozens == 1) {
                        stringOut.append(matrixNumericFirstExponent.get(digit.pop())[1]);
                    } else {
                        stringOut.append(matrixNumericFirstExponent.get(dozens)[2]);
                    }
                }
                case 3 -> stringOut.append(matrixNumericFirstExponent.get(digit.pop())[3]);
            }
        }
        return stringOut.toString();
    }

    public String getClassTheThousands(int temp) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("method under development");
    }

    public String getClassTheMillions(int temp)throws UnsupportedOperationException {
        throw new UnsupportedOperationException("method under development");
    }
}
