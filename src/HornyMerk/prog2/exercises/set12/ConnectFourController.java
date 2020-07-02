package HornyMerk.prog2.exercises.set12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ConnectFourController implements Initializable
{
    private ConnectFourGame game;
    @FXML
    GridPane gameGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        game = new ConnectFourGame(new ConnectFourView(gameGrid));
    }

    @FXML
    protected void btnPushed(ActionEvent event)
    {
        Button pushedBtn = (Button) event.getSource();
        if(isRowBtn(pushedBtn))
        {
            game.move(Integer.parseInt(pushedBtn.getText()));
        }
        else
        {
            if(pushedBtn.getText() == "clear")
                game.clear();
            else if(pushedBtn.getText() == "")
                game.proposeMove();
        }
    }


    private boolean isRowBtn(Button btn)
    {
        String btnTxt = btn.getText();
        try {
            int row = Integer.parseInt(btnTxt);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}
