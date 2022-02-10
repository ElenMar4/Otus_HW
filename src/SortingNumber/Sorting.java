package SortingNumber;

import java.util.*;

public class Sorting {
    public static void main(String[] args) {

        List <Integer> array = new ArrayList<>();
        for (int i = 0 ; i < 100000; i++) {
            array.add(new Double(Math.random()*Integer.MAX_VALUE).intValue());

        }

        List<Integer> bubbleSortArray = array;
        List<Integer> sortArray = array;

        Date startDate = new Date();

        for (int k = array.size() - 1; k > 0 ; k--) {
            for (int i = 0 ; i < k ; i++) {
                if (bubbleSortArray.get(i) > bubbleSortArray.get(i + 1)){
                    int temp = bubbleSortArray.get(i);
                    bubbleSortArray.set(i, bubbleSortArray.get(i + 1));
                    bubbleSortArray.set(i + 1, temp);
                }
            }
        }
        Long durationBubbleSort = startDate.getTime() - new Date().getTime(); //Время сортировки BubbleSort : -88042

        startDate = new Date();
        Collections.sort(sortArray);
        Long duration = startDate.getTime() - new Date().getTime(); //Время сортировки Collections: -6

        System.out.println("Время сортировки BubbleSort : " + durationBubbleSort);
        System.out.println("Время сортировки Collections: " + duration);

    }

}
