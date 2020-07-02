package HornyMerk.prog2.exercises.set12;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class ConnectFourView
{
    private Label _Label;

    public ConnectFourView(Label label)
    {
        this._Label = label;
    }
    public void setLblTxt(String txt)
    {
        _Label.setText(txt);
    }
    public void setCircleColor(Circle circle, String color)
    {
        circle.setFill(Paint.valueOf(color));
    }

    public String getCircleRGB(Circle circle)
    {
        Color c = (Color) circle.getFill();
        String color = String.format( "#%02X%02X%02X",
                (int)( c.getRed() * 255 ),
                (int)( c.getGreen() * 255 ),
                (int)( c.getBlue() * 255 ) );
        return color;
    }
}
