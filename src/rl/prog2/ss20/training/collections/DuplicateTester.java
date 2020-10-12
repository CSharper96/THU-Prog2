package rl.prog2.ss20.training.collections;

import java.util.*;

public class DuplicateTester {

    public boolean containsDuplicates(List<Object> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++)
                if (list.get(i).equals(list.get(j)))
                    return true;
        }
        return false;
    }

    public boolean containsDuplicates1(List<Object> list) {
        Set<Object> set = new HashSet<>(list);
        return set.size() < list.size();
    }


    public boolean containsDuplicates2(List<Object> list) {
        Set<Object> set = new HashSet<>();
        for (Object item : list)
//            if (set.contains(item))
//                return true;
//            else
//                set.add(item);
            if (!set.add(item))
                return true;
        return false;
    }


    private static void printObjects(/*final*/ List<Object> list) {
        // list = null;
        list.remove(0);

    }


    public static void main(String[] args) {
        List<Object> l = new ArrayList<>(Arrays.asList("A", "B", "A"));
        printObjects(Collections.unmodifiableList(l));
        DuplicateTester tester = new DuplicateTester();
        System.out.println(tester.containsDuplicates2(Arrays.asList("A", "B", "A")));
        System.out.println(tester.containsDuplicates2(Arrays.asList("A", "B", "C")));
    }
}
