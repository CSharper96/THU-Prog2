package rl.prog2.ss20.training.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessingGameApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Guessing Game App");
        GGModel model = new GGModel();
        GGController controller = new GGController(model);
        GGView view = new GGView(primaryStage, controller, model);
        controller.setView(view);
        model.addObserver(view);
        primaryStage.show();
    }

    // Presentation Layer

    public static class GGView implements Observer {
        private Spinner<Integer> guessSpr;
        private TextField feedbackFld;

        private GGControllerI controller;
        private GGModel model;

        public GGView(Stage stage, GGControllerI ctrl, GGModel model) {
            controller = ctrl;
            this.model = model;
            Button newGameBtn = new Button("New Game");
            newGameBtn.setId(Ids.NEW_GAME_BTN);
            newGameBtn.setMaxWidth(Double.MAX_VALUE);
            newGameBtn.setOnAction(ev -> controller.handle(ev));
            Button guessBtn = new Button("Guess");
            guessBtn.setId(Ids.GUESS_BTN);
            guessBtn.setMaxWidth(Double.MAX_VALUE);
            guessBtn.setOnAction(ev -> controller.handle(ev));
            guessSpr = new Spinner(1, GGModel.MAX, 1);
            feedbackFld = new TextField();

            GridPane pane = new GridPane();
            pane.setHgap(10);
            pane.setVgap(10);
            pane.setPadding(new Insets(10, 10, 10, 10));
            pane.setAlignment(Pos.CENTER);
            pane.add(newGameBtn, 0, 0);
            pane.add(guessBtn, 1, 0);
            pane.add(guessSpr, 0, 1, 2, 1);
            pane.add(feedbackFld, 0, 2, 2, 1);

            stage.setScene(new Scene(pane));
        }

        public int getGuessValue() {
            return guessSpr.getValue();
        }

        @Override
        public void update() {
            feedbackFld.setText(model.getFeedback());
        }
    }


    public static class GGController implements GGControllerI {
        private GGView view;
        private GGModel model;

        public GGController(GGModel model) {
            this.model = model;
        }

        public void setView(GGView view) {
            this.view = view;
        }

        public void handle(ActionEvent ev) {
            Node source = (Node) ev.getSource();
            if (Ids.NEW_GAME_BTN.equals(source.getId()))
                model.startGame();
            else if (Ids.GUESS_BTN.equals(source.getId()))
                model.guess(view.getGuessValue());
        }

    }


    public static class Ids {
        public static String NEW_GAME_BTN = "NewGameBtn";
        public static String GUESS_BTN = "GuessBtn";
    }

    // Domain Layer

    public static class GGModel {
        public static int MAX = 10;
        private static Random random = new Random();
        private int myNumber;
        private int guessNumber = 1;
        private String feedback;
        private int numOfTrials;
        private List<Observer> observers = new ArrayList<>();

        public GGModel() {
            startGame();
        }

        public void addObserver(Observer observer) {
            observers.add(observer);
        }

        public void startGame() {
            myNumber = random.nextInt(MAX) + 1;
            feedback = "";
            numOfTrials = 0;
            for (Observer obs : observers)
                obs.update();
        }

        public void guess(int number) {
            guessNumber = number;
            numOfTrials++;
            if (myNumber < number)
                feedback = "My number is smaller!";
            else if (myNumber > number)
                feedback = "My number is greater!";
            else
                feedback = "You got it with " + numOfTrials + " trials!";
            for (Observer obs : observers)
                obs.update();
        }

        public String getFeedback() {
            return feedback;
        }
    }


    // Foundation Layer

    public interface Observer {
        void update();
    }

    public interface GGControllerI {
        void handle(ActionEvent ev);
    }
}
