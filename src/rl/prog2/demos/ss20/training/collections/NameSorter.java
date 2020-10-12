package rl.prog2.ss20.training.collections;

import java.util.*;

public class NameSorter {

    private final ArrayList<String> names = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void readNames() {
        // names.addAll(Arrays.asList("Bert", "Alfred", "Uta"));
        System.out.println("Geben Sie Namen ein (leere Zeile am Ende):");

        while (true) {
            String name = scanner.nextLine();
            if (name.isEmpty())
                break;
            names.add(name);
        }
    }

    public void sortNames() {
        // ArrayList<String> l2 = new ArrayList<>(names);
        Collections.sort(names);
    }

    public void printNames() {
        for (String name : names)
            System.out.println(name);
    }

    public static void main(String[] args) {
        NameSorter sorter = new NameSorter();
        sorter.readNames();
        sorter.sortNames();
        sorter.printNames();
        //sorter.readNames();

        // just for testing...
        String[] sArr = new String[] {"ab", "b"};
        Object[] oArr = new Object[3];

        // sArr = oArr;
        oArr = sArr;
        // System.out.println(oArr[0].hashCode());
        // oArr[0] = new Object(); // Exception!!


        ArrayList<String> sList = new ArrayList<>();
        ArrayList<Object> oList = new ArrayList<>();
        List<String> l = sList;
        //ArrayList<int> iList;

        // sList = oList;
        // oList = sList; Error zur Compilezeit!

    }
}
