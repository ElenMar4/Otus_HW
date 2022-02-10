package SortingNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HeapSort {

    public static void main(String args[]) {

        List <Integer> array = new ArrayList<>();
        for (int i = 0 ; i < 100000; i++) {
            array.add(new Double(Math.random()*Integer.MAX_VALUE).intValue());
        }

        int size = array.size();
        HeapSort object = new HeapSort();
        Date startDate = new Date();

        object.sort(array);

        Long durationHeapSort = startDate.getTime() - new Date().getTime();

        System.out.println(array);
        System.out.println();

        System.out.println("Время пирамидальной сортировки : " + durationHeapSort);
    }

    public void sort(List <Integer> array) {
        int size = array.size();
        for (int i = size / 2 - 1; i >= 0; i--) {
            restructure(array, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {       // Перемещаем текущий корень в конец
            int temp = array.get(0);
            array.set(0, array.get(i));
            array.set(i, temp);
            restructure(array, i, 0);
        }
    }

    private void restructure(List<Integer> array, int size, int i){
        int big = i;                                // Инициализируем наибольший элемент как корень
        int left = 2*i + 1;                         // левый = 2*i + 1
        int right = 2*i + 2;                        // правый = 2*i + 2

        // Если левый элемент больше корня
        if (left < size && array.get(left) > array.get(big)) {
            big = left;
        }

        // Если правый  элемент больше корня
        if (right < size && array.get(right) > array.get(big)) {
            big = right;
        }
        // Если самый большой элемент не корень
        if (big != i){
            int change = array.get(i);
            array.set(i, array.get(big));
            array.set(big, change);

            restructure(array, size, big);
        }
    }

}
