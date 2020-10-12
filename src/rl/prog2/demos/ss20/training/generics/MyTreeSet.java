package rl.prog2.ss20.training.generics;


public class MyTreeSet<T extends Comparable<? super T> > {

    private MyTreeSetNode<T> root;

    public boolean add(T key) {
        MyTreeSetNode<T> node = new MyTreeSetNode<>(key);
        if (root == null) {
            root = node;
            return true;
        } else {
            MyTreeSetNode<T> curr = root;
            while (true) {
                int result = curr.getKey().compareTo(key);
                if (result < 0) {
                    if (curr.getRight() != null)
                        curr = curr.getRight();
                    else {
                        curr.setRight(node);
                        return true;
                    }
                } else if (result > 0) {
                    if (curr.getLeft() != null)
                        curr = curr.getLeft();
                    else {
                        curr.setLeft(node);
                        return true;
                    }
                } else if (curr.getKey().equals(key)) {
                    return false;
                } else {
                    throw new IllegalStateException("Total order needed.");
                }
            }
        }

        //return false;
    }

    public boolean contains(T key) {
        MyTreeSetNode<T> curr = root;
        while (curr != null) {
            int result = curr.getKey().compareTo(key);
            if (result < 0)
                curr = curr.getRight();
            else if (result > 0)
                curr = curr.getLeft();
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyTreeSet<String> set = new MyTreeSet<>();
        set.add("B");
        set.add("A");
        set.add("C");
        System.out.println(set.contains("C"));
        System.out.println(set.contains("D"));

        MyTreeSet<Integer> set2 = new MyTreeSet<>();
        set2.add(2);
        set2.add(3);

        MyTreeSet<Person> set3 = new MyTreeSet<>();
        MyTreeSet<Studierender> set4 = new MyTreeSet<>();

        // MyTreeSet<Object> set3; // error!
    }


    static class Person implements Comparable<Person> {
        String name;

        @Override
        public int compareTo(Person o) {
            return name.compareTo(o.name);
        }
    }

    static class Studierender extends Person {
        int matrNr;

        @Override
        public int compareTo(Person o) {
            if (o instanceof Studierender)
                return Integer.compare(matrNr, ((Studierender) o).matrNr);
            else
                return super.compareTo(o);
        }
    }


}
