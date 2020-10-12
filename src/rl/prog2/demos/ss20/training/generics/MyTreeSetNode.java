package rl.prog2.ss20.training.generics;

public class MyTreeSetNode<E> {
    private final E key;
    private MyTreeSetNode<E> left;
    private MyTreeSetNode<E> right;

    public MyTreeSetNode(E key) {
        this.key = key;
    }

    public E getKey() {
        return key;
    }

    public MyTreeSetNode<E> getLeft() {
        return left;
    }

    public MyTreeSetNode<E> getRight() {
        return right;
    }

    public void setLeft(MyTreeSetNode<E> left) {
        this.left = left;
    }

    public void setRight(MyTreeSetNode<E> right) {
        this.right = right;
    }
}
