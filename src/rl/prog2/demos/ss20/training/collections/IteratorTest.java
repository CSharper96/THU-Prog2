package rl.prog2.ss20.training.collections;

import java.util.*;

public class IteratorTest {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        HashSet<String> set = new HashSet<>();
        set.add("A");
        set.add("B");


        List<String> list1 = new LinkedList<>();
        list1.add("Alpha");
        list1.add("Beta");


        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Alpha", "Beta", "Gamma"));

        Iterator<String> it = list.iterator();
        // it.remove(); error
        // System.out.println(it.hasNext());
        // System.out.println(it.next());
        //it.remove();
        //while (it.hasNext())
        //    System.out.println(it.next());

        /*
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            list.remove(0);
        }*/



        for (String el : list) {
            System.out.println(el);
            list.remove(0);
        }

    }
}
