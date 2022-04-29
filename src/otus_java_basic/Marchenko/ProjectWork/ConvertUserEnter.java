package otus_java_basic.Marchenko.ProjectWork;

import java.util.Map;
import java.util.Stack;

public class ConvertUserEnter implements ConvertUserEnterInterface {

    private final Map<Integer, String[]> matrixNumericFirstExponent;

    public ConvertUserEnter() {
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
            case 1 -> strFinal = numberToOneExponent(exponent.pop());
            case 2 -> strFinal = numberToTwoExponent(exponent.pop());
            case 3 -> strFinal = numberToThreeExponent(exponent.pop());
        }
        return strFinal;
    }

    public String numberToOneExponent(int numberOneExponent){
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

    public String numberToTwoExponent(int temp){
        return "Здесь будет код для чисел от 1000 до 999 999";
    }

    public String numberToThreeExponent(int temp){
        return "Здесь будет код для чисел от 1 000 000 до 999 999 999";
    }
}
