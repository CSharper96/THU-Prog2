package rl.prog2.ss20.training.collections;

public class StringTreeSet {

    private StringTreeSetNode root;

    public boolean add(String key) {
        StringTreeSetNode node = new StringTreeSetNode(key);
        if (root == null) {
            root = node;
            return true;
        } else {
            StringTreeSetNode curr = root;
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

    public boolean contains(String key) {
        StringTreeSetNode curr = root;
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
        StringTreeSet set = new StringTreeSet();
        set.add("B");
        set.add("A");
        set.add("C");
        System.out.println(set.contains("C"));
        System.out.println(set.contains("D"));
    }
}
