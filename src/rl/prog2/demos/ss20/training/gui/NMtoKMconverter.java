package rl.prog2.ss20.training.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.Locale;


public class NMtoKMconverter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private TextField nmFld;
    private TextField kmFld;

    public void start(Stage stage) {
        Locale.setDefault(Locale.ENGLISH);
        Label nmLabel = new Label("nautical miles: ");
        nmFld = new TextField();
        nmFld.setPrefColumnCount(6);
        Button convertBtn = new Button("convert");
        convertBtn.setOnAction(ev -> convert());
        Label kmLabel = new Label("kilometers: ");
        kmFld = new TextField();
        kmFld.setPrefColumnCount(6);

        HBox box = new HBox(10);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(15, 15, 15, 15));
        box.getChildren().addAll(nmLabel, nmFld, convertBtn, kmLabel, kmFld);
        Scene scene = new Scene(box);
        scene.getStylesheets().add(getClass().getResource
                ("NMtoKMconverter.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("NM to KM converter");
        stage.show();
    }

    private void convert() {
        try {
            double nm = Double.parseDouble(nmFld.getText());
            double km = nm * 1.852;
            kmFld.setText(new DecimalFormat("0.##").format(km));
            nmFld.setStyle("-fx-text-fill: black");
        } catch (NumberFormatException ex) {
            nmFld.setStyle("-fx-text-fill: red");
            // nmFld.setText("");
        }
    }

}
