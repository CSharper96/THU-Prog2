package rl.prog2.ss20.training.gui;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class MusicControlButton extends Button {
    public enum Type { PLAY, STOP }

    public MusicControlButton(Type type) {
        final StackPane pane = new StackPane();
        setGraphic(pane);
        switch (type) {
            case PLAY:
                final Polygon polygon = new Polygon();
                pane.getChildren().add(polygon);
                pane.widthProperty().addListener
                        (ev -> updatePolygon(polygon, pane));
                pane.heightProperty().addListener
                        (ev -> updatePolygon(polygon, pane));
                break;
            case STOP:
                Rectangle rect = new Rectangle();
                rect.widthProperty().bind(
                        Bindings.min(pane.heightProperty(),
                                pane.widthProperty()).divide(2));
                rect.heightProperty().bind(
                        Bindings.min(pane.heightProperty(),
                                pane.widthProperty()).divide(2));
                pane.getChildren().add(rect);
                break;
        }
        setPrefSize(90, 30);
        setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    private void updatePolygon(Polygon poly, Pane pane) {
        double size = Math.min(pane.getWidth(), pane.getHeight()) / 2;
        poly.getPoints().clear();
        poly.getPoints().addAll
                (0.0, 0.0, 0.0, size, size, size / 2);
    }

}
