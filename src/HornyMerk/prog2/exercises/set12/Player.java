package HornyMerk.prog2.exercises.set12;

import javafx.scene.shape.Circle;

import java.util.ArrayList;

public enum Player
{
    RED("#FF0000", "red"),
    BLUE("#0000FF", "blue");
    Player(String color, String name)
    {
        this._Color = color;
        Name = name;
    }
    private String _Color;
    public String Name;

    public String getColor()
    {
        return this._Color;
    }
}
