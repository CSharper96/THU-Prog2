package rl.prog2.ss20.training.gui;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PropertyBasedAdder {

    private IntegerProperty x = new SimpleIntegerProperty();
    private IntegerProperty y = new SimpleIntegerProperty();
    private IntegerProperty z = new SimpleIntegerProperty();

    public int getX() {
        return x.get();
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public int getY() {
        return y.get();
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public int getZ() {
        return z.get();
    }

    public void setZ(int z) {
        this.z.set(z);
    }

    public IntegerProperty zProperty() {
        return z;
    }

    public PropertyBasedAdder() {
        z.bind(Bindings.add(x, y));
        z.addListener((obs, ov, nv)
                -> System.out.println("Changed to " + nv));
    }


    public static void main(String[] args) {
        PropertyBasedAdder adder = new PropertyBasedAdder();
        adder.setX(7);
        adder.setY(3);
        System.out.println(adder.getZ()); // output: 10
        adder.setX(3);
        System.out.println(adder.getZ()); // output: 6
    }
}
