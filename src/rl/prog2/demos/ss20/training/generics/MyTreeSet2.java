package rl.prog2.ss20.training.generics;


public class MyTreeSet2<T extends Comparable<? super T> > {

    private Node<T> root;

    public boolean add(T key) {
        Node<T> node = new Node<>(key);
        if (root == null) {
            root = node;
            return true;
        } else {
            Node<T> curr = root;
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
        Node<T> curr = root;
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
        MyTreeSet2<String> set = new MyTreeSet2<>();
        set.add("B");
        set.add("A");
        set.add("C");
        System.out.println(set.contains("C"));
        System.out.println(set.contains("D"));

        MyTreeSet2<Integer> set2 = new MyTreeSet2<>();
        set2.add(2);
        set2.add(3);

        MyTreeSet2<Person> set3 = new MyTreeSet2<>();
        MyTreeSet2<Studierender> set4 = new MyTreeSet2<>();

        // MyTreeSet<Object> set3; // error!
    }


    // keine gute Idee!
    private class Node2 {
        T m1() {
            return MyTreeSet2.this.root.getKey();
        }
    }


    private static class Node<E> {
        private final E key;
        private Node<E> left;
        private Node<E> right;

        public Node(E key) {
            this.key = key;
        }

        public E getKey() {
            return key;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
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
