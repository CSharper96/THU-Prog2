package rl.prog2.ss20.training.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GenericsTest {

    public static boolean hasEvenSize(List<?> list) {
        return list.size() % 2 == 0;
    }

    //public static int find(List<?> list, Object element) {
    public static <T> int find(List<T> list, T element) {
        //for (int i = 0; i < list.size(); i++) {
        //    Object curr = list.get(i);
        int i = 0;
        for (T curr : list) {
            if (Objects.equals(element, curr))
            // if (element == null ? curr == null : element.equals(curr)) {
                return i;
            i++;
        }
        return -1;
    }



    public static <T extends Comparable<? super T>>
        int binarySearch(List<T> list, T element) {

        int min = 0;
        int max = list.size() - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            int result = element.compareTo(list.get(mid));
            if (result < 0)
                max = mid - 1;
            else if (result > 0)
                min = mid + 1;
            else
                return mid;
        }
        return -1;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 7, 20, 42, 100));
        System.out.println(binarySearch(list, 42));
        List l2 = new ArrayList();

    }
}
