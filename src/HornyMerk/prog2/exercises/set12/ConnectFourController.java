package HornyMerk.prog2.exercises.set12;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class ConnectFourController implements Initializable
{
    private ConnectFourGame game;
    @FXML
    GridPane gameGrid;
    @FXML
    Label infoLbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        game = new ConnectFourGame(new ConnectFourView(infoLbl), initCircleArray());
        initCbBoxes();
    }

    @FXML
    protected void btnPushed(ActionEvent event) throws InterruptedException {
        Button pushedBtn = (Button) event.getSource();
        if(isRowBtn(pushedBtn))
        {
            game.move(Integer.parseInt(pushedBtn.getText()) - 1);
        }
        else
        {
            if(pushedBtn.getText().equals("Clear"))
                game.clear();
            else if(pushedBtn.getText().equals("Propose Move")) {
                game.proposeMove();
            }
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
    private Circle[][] initCircleArray()
    {
        Circle[][] circles = new Circle[6][7];
        ObservableList<Node> childrens = gameGrid.getChildren();
        for(int col = 0; col < 8; col++)
        {
            for(int row = 1; row < 7; row++)
            {
                for (Node node : childrens) {
                    int nodeRow = GridPane.getRowIndex(node);
                    int nodeCol = GridPane.getColumnIndex(node);
                    if (nodeRow == row && nodeCol == col)
                        circles[row - 1][col] = (Circle) node;
                }
            }
        }
        return circles;
    }
    @FXML
    ComboBox<String> cb1;
    @FXML
    ComboBox<String> cb2;
    private void initCbBoxes()
    {
        cb1.setItems(FXCollections.observableArrayList("Some", "cool", "stuff"));
        cb1.getSelectionModel().selectFirst();
        cb2.setItems(FXCollections.observableArrayList("Not", "so", "cool", "stuff"));
        cb2.getSelectionModel().selectLast();
    }
}
