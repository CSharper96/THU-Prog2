package HornyMerk.prog2.exercises.set10.Utilities;

import java.util.ArrayList;
import java.util.Collections;

public class MemoryGame implements IMemoryGame
{
    public ArrayList<MemoryCard> memoryCards = new ArrayList<>();

    public void newGame()
    {
        createDeck();
        shuffleCards();
    }
    public int getNumOfCards()
    {
        return 0;
    }
    public MemoryCard getCard(int index)
    {
        return null;
    }
    public int GetCardPosition(MemoryCard card)
    {
        return 0;
    }
    public void turnCard(int index)
    {

    }
    public int getCurrPlayer()
    {
        return 0;
    }
    public void shuffleCards()
    {
        Collections.shuffle(memoryCards);
    }
    private void createDeck()
    {
        for(int i = 0; i < 6; i++)
        {
            memoryCards.add(new MemoryCard("Pair " + i, false));
            memoryCards.add(new MemoryCard("Pair " + i, false));
        }
    }
}
