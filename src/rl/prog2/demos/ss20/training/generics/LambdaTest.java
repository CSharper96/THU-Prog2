package rl.prog2.ss20.training.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {

    public static void main(String[] args) {
        List<ZooTier> list = new ArrayList<>();
        list.add(new ZooTier("Wali", "Schwertwal", "Norwegen"));
        list.add(new ZooTier("Aki", "Husky", "Finnland"));
        list.add(new ZooTier("Heather", "Hochlandrind", "Schottland"));
        list.add(new ZooTier("Karaghu", "Steinbock", "Schweiz"));

        class MyComparatorLocal implements Comparator<ZooTier> {
            @Override
            public int compare(ZooTier o1, ZooTier o2) {
                return -o1.getName().compareTo(o2.getName());
            }
        }
        // verschachtelte Top-Level-Klasse
        // Collections.sort(list, new MyComparator());
        // innere lokale Klasse
        // Collections.sort(list, new MyComparatorLocal());
        // annonyme Klasse
        Collections.sort(list, new Comparator<ZooTier>() {
            @Override
            public int compare(ZooTier o1, ZooTier o2) {
                return -o1.getName().compareTo(o2.getName());
            }
        });
        // mit Lambda-Ausdruck
        Collections.sort(list, (tier1, tier2) -> tier1.getName().compareTo(tier2.getName()));
        // mit Methoden-Referenzen
        Collections.sort(list, Comparator.comparing(ZooTier::getName));

        //for (ZooTier tier : list)
        //    System.out.println(tier.getName());

        //list.forEach(tier -> System.out.println(tier.getName()));

        List<String> l2 = list.stream().map(ZooTier::getName).sorted().collect(Collectors.toList());

        list.stream().map(ZooTier::getName).sorted((s1, s2) -> s2.compareTo(s1))
                .forEach(System.out::println);

        // Lambda-Ausdruck                   Kurzform mit Methodenreferenz:
        // (x, y) -> Math.max(x, y)          Math::max
        // tier -> tier.getName()            ZooTier::getName
        // str -> System.out.println(str)    System.out::println
        //
    }

    // q(3) = 9;
    // q(4) = 16;
    // als Lambda-Ausdruck: x -> x*x

    static double q(double x) {
        return x*x;
    }
    // als Lambda-Ausdruck: str -> { System.out.println(str); }
    static void print(String str) {
        System.out.println(str);
    }


    private static class MyComparator implements Comparator<ZooTier> {
        @Override
        public int compare(ZooTier o1, ZooTier o2) {
            return -o1.getName().compareTo(o2.getName());
        }
    }



    private static class ZooTier {
        private String name;
        private String art;
        private String herkunft;

        public ZooTier(String name, String art, String herkunft) {
            this.name = name;
            this.art = art;
            this.herkunft = herkunft;
        }

        public String getName() {
            return name;
        }

        public String getArt() {
            return art;
        }

        public String getHerkunft() {
            return herkunft;
        }
    }

}