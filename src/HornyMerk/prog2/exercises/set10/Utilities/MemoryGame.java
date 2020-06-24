package HornyMerk.prog2.exercises.set10.Utilities;

import HornyMerk.prog2.exercises.set10.MemoryFxApp;
import javafx.scene.control.Button;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class MemoryGame extends MemoryFxApp
{
    public ArrayList<MemoryCard> memoryCards;

    private Pair<Integer, Button> _FlippedCard;
    private Pair<Integer, Button> _Tmp;
    private final String STD_CARD_IMG = "-fx-background-image: url('file:/C:/Users/thoma/IntelliJ-Workspace/THU-Prog2/src/HornyMerk/prog2/exercises/set10/CardBck.jpg'); -fx-background-size: stretch";
    private final String A_CARD_IMG = "-fx-background-image: url('file:/C:/Users/thoma/IntelliJ-Workspace/THU-Prog2/src/HornyMerk/prog2/exercises/set10/apple.jpg'); -fx-background-size: stretch";
    private final String B_CARD_IMG = "-fx-background-image: url('file:/C:/Users/thoma/IntelliJ-Workspace/THU-Prog2/src/HornyMerk/prog2/exercises/set10/banana.jpg'); -fx-background-size: stretch";
    private final String C_CARD_IMG = "-fx-background-image: url('file:/C:/Users/thoma/IntelliJ-Workspace/THU-Prog2/src/HornyMerk/prog2/exercises/set10/cherry.jpg'); -fx-background-size: stretch";
    private final String K_CARD_IMG = "-fx-background-image: url('file:/C:/Users/thoma/IntelliJ-Workspace/THU-Prog2/src/HornyMerk/prog2/exercises/set10/kiwi.jpg'); -fx-background-size: stretch";
    private final String O_CARD_IMG = "-fx-background-image: url('file:/C:/Users/thoma/IntelliJ-Workspace/THU-Prog2/src/HornyMerk/prog2/exercises/set10/orange.jpg'); -fx-background-size: stretch";
    private final String S_CARD_IMG = "-fx-background-image: url('file:/C:/Users/thoma/IntelliJ-Workspace/THU-Prog2/src/HornyMerk/prog2/exercises/set10/strawberry.jpg'); -fx-background-size: stretch";

    private Player _Player1;
    private Player _Player2;

    public void newGame()
    {
        memoryCards = new ArrayList<>();
        _FlippedCard = null;
        _Tmp = null;

        assignEvents();
        createPlayers();
        createDeck(true);
        shuffleCards();
        for(int i = 0; i < 12; i++)
            assignCard(i);
    }
    private void checkTurn(Button btn) {
        int btnIndex = getButtonIndex(btn);
        System.out.println(btnIndex);

        if(_Tmp != null)
        {
            turnCard(_FlippedCard.getKey(), _FlippedCard.getValue());
            turnCard(_Tmp.getKey(), _Tmp.getValue());
            memoryCards.get(_FlippedCard.getKey()).IsFlipped = false;
            memoryCards.get(_Tmp.getKey()).IsFlipped = false;
            _Tmp = null;
            _FlippedCard = null;
        }

        if(getCard(btnIndex).IsOutOfGame)
        {
            System.out.println("Card already in possession");
        }
        else if(_FlippedCard == null)
        {
            _FlippedCard = new Pair<>(btnIndex, Buttons.get(btnIndex));
            turnCard(btnIndex, _FlippedCard.getValue());
            getCard(btnIndex).IsFlipped = true;
        }
        else if(_FlippedCard.getValue().equals(btn))
        {
            System.out.println("Same Card");
        }
        else
        {
            turnCard(btnIndex, Buttons.get(btnIndex));
            _Tmp = new Pair<>(btnIndex, Buttons.get(btnIndex));
            getCard(btnIndex).IsFlipped = true;
            if(checkCards(_FlippedCard.getKey(), btnIndex))
            {
                addCards();
                paintCard();
            }
            else switchPlayer();
        }
    }
    private boolean checkCards(int flippedIndex, int newIndex)
    {
        String flippedCardTxt = getCard(flippedIndex).getText();
        String newCardTxt = getCard(newIndex).getText();
        if(flippedCardTxt.equals(newCardTxt))
            return true;
        else return false;
    }
    private void paintCard()
    {
        _FlippedCard.getValue().setStyle(getActivePlayer().HtmlColor);
        _Tmp.getValue().setStyle(getActivePlayer().HtmlColor);
    }
    private boolean checkPlayerCards(MemoryCard flippedCard)
    {
        for(MemoryCard playerCard : _Player1.PlayerCards)
            if(playerCard.equals(flippedCard)) return true;
        for(MemoryCard playerCard : _Player2.PlayerCards)
            if(playerCard.equals(flippedCard)) return true;
        return false;
    }
    private void addCards()
    {
        MemoryCard firstCard = getCard(_FlippedCard.getKey());
        MemoryCard secondCard = getCard(_Tmp.getKey());

        firstCard.IsOutOfGame = true;
        secondCard.IsOutOfGame = true;

        getActivePlayer().PlayerCards.add(firstCard);
        getActivePlayer().PlayerCards.add(secondCard);
    }
    private int getButtonIndex(Button btn)
    {
        int index = 0;
        for (Button button : Buttons)
        {
            if (button.equals(btn)) break;
            else index++;
        }
        return index;
    }
    public int getNumOfCards()
    {
        return 0;
    }
    private Player getActivePlayer()
    {
        if(_Player1.isActive) return _Player1;
        else return _Player2;
    }
    public MemoryCard getCard(int index)
    {
        return memoryCards.get(index);
    }
    public int GetCardPosition(MemoryCard card)
    {
        return card.Index;
    }
    public void turnCard(int index, Button btn)
    {
        if(getCard(index).IsFlipped && !getCard(index).IsOutOfGame)
        {
            btn.setStyle(STD_CARD_IMG);
        }
        else if(!getCard(index).IsOutOfGame)
        {
            btn.setStyle(getCard(index).getText());
        }

        //if(btn.getText() == "")
        //    btn.setText(memoryCards.get(index).getText());
        //else
        //    btn.setText("");
    }
    private void createDeck()
    {
        for(int i = 0; i < 6; i++)
        {
            memoryCards.add(new MemoryCard("Pair " + (i + 1)));
            memoryCards.add(new MemoryCard("Pair " + (i + 1)));
        }
    }
    private void createDeck(boolean isImage)
    {
        memoryCards.add(new MemoryCard(A_CARD_IMG));
        memoryCards.add(new MemoryCard(A_CARD_IMG));

        memoryCards.add(new MemoryCard(B_CARD_IMG));
        memoryCards.add(new MemoryCard(B_CARD_IMG));

        memoryCards.add(new MemoryCard(C_CARD_IMG));
        memoryCards.add(new MemoryCard(C_CARD_IMG));

        memoryCards.add(new MemoryCard(K_CARD_IMG));
        memoryCards.add(new MemoryCard(K_CARD_IMG));

        memoryCards.add(new MemoryCard(O_CARD_IMG));
        memoryCards.add(new MemoryCard(O_CARD_IMG));

        memoryCards.add(new MemoryCard(S_CARD_IMG));
        memoryCards.add(new MemoryCard(S_CARD_IMG));
    }
    private void createPlayers()
    {
        _Player1 = new Player("Player Blue");
        _Player1.HtmlColor = "-fx-background-color: #0000FF";
        _Player2 = new Player("Player Red");
        _Player2.HtmlColor = "-fx-background-color: #FF0000";
        _Player1.isActive = true;
    }
    private void switchPlayer()
    {
        if(_Player1.isActive)
        {
            _Player1.isActive = false;
            _Player2.isActive = true;
            StatusLbl.setText("Active Player: " + _Player2.Name);
        }
        else
        {
            _Player2.isActive = false;
            _Player1.isActive = true;
            StatusLbl.setText("Active Player: " + _Player1.Name);
        }
    }
    public void shuffleCards()
    {
        Collections.shuffle(memoryCards);
    }
    public void assignCard(int index)
    {
        memoryCards.get(index).Index = index;

        Buttons.get(index).setStyle(STD_CARD_IMG);
        //Buttons.get(index).setStyle("-fx-background-color: #ffffff");
        //Buttons.get(index).setText("");
        //Buttons.get(index).setText(memoryCards.get(index).getText());
    }
    private void assignEvents()
    {
        ExitItem.setOnAction(e -> System.exit(1));
        NewItem.setOnAction(e -> this.newGame());

        Buttons.forEach(b -> b.setOnAction(e -> checkTurn(b)));
    }
}
