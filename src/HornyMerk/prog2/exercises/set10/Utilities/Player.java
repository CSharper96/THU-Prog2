package HornyMerk.prog2.exercises.set10.Utilities;

import java.util.ArrayList;

public class Player
{
    public String Name;
    public boolean isActive = false;
    public String HtmlColor = "";

    public ArrayList<MemoryCard> PlayerCards = new ArrayList<>();

    public Player(String name)
    {
        Name = name;
    }
}
