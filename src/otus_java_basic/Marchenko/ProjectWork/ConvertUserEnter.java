package otus_java_basic.Marchenko.ProjectWork;

import java.util.HashMap;
import java.util.Map;

public class ConvertUserEnter {

    public String getNumber (int intValue){

        Map<Integer, String[]> matrixNumeric = new HashMap<>();
        matrixNumeric.put(0, new String[]{"", "", "", ""});
        matrixNumeric.put(1, new String[]{"один", "", "сто", "одна тысяча"});
        matrixNumeric.put(2, new String[]{"два", "двадцать", "двести", "две тысячи"});
        matrixNumeric.put(3, new String[]{"три", "тридцать", "триста", "три тысячи"});
        matrixNumeric.put(4, new String[]{"четыре", "сорок", "четыреста", "четыре тысячи"});
        matrixNumeric.put(5, new String[]{"пять", "пятьдесят", "пятьсот", "пять тысяч"});
        matrixNumeric.put(6, new String[]{"шесть", "шестьдесят", "шестьсот", "шесть тысяч"});
        matrixNumeric.put(7, new String[]{"семь", "семьдесят", "семьсот", "семь тысяч"});
        matrixNumeric.put(8, new String[]{"восемь", "восемьдесят", "восемьсот", "восемь тысяч"});
        matrixNumeric.put(9, new String[]{"девять", "девяносто", "девятьсот", "девять тысяч"});

        Map<Integer, String> matrixNumericEleven = new HashMap<>();
        matrixNumericEleven.put(0, "десять");
        matrixNumericEleven.put(1, "одиннадцать");
        matrixNumericEleven.put(2, "двенадцать");
        matrixNumericEleven.put(3, "тринадцать");
        matrixNumericEleven.put(4, "четырнадцать");
        matrixNumericEleven.put(5, "пятнадцать");
        matrixNumericEleven.put(6, "шестнадцать");
        matrixNumericEleven.put(7, "семнадцать");
        matrixNumericEleven.put(8, "восемнадцать");
        matrixNumericEleven.put(9, "девятнадцать");

        String string = String.valueOf(intValue);
        char[] array = string.toCharArray();
        int temp = array.length;
        StringBuilder outString = new StringBuilder();
        for (int k = 0; k < array.length; k++){
            int key = array[k]-'0';
            if ((temp == 2) & (key == 1)){
                key = array[k + 1]-'0';
                outString.append(matrixNumericEleven.get(key)).append(" ");
                break;
            } else {
                outString.append(matrixNumeric.get(key)[temp - 1]).append(" ");
                temp--;
            }
        }
        return outString.toString();
    }

    public String getString (int intValue, String userSelectCurrency){
        Currency currency = new Currency();
        String[] currencyTemp = currency.getCurrency(userSelectCurrency);
        return ( switch (intValue % 10) {
            case 1 -> currencyTemp[0];
            case 2, 3, 4 -> currencyTemp[1];
            case 5, 6, 7, 8, 9, 0 -> currencyTemp[2];
            default -> throw new IllegalStateException("Unexpected value: " + intValue % 10);
        });
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
