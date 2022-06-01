package com.notepad;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class application extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("NotePad");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/notepad.fxml"));
        Scene scene = new Scene(root);
        Image icon = new Image("/images/icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();

        /* SAVE THE TEXT BY SHORTCUT */
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            final KeyCombination save = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
            final KeyCombination exit = new KeyCodeCombination(KeyCode.ESCAPE, KeyCombination.CONTROL_DOWN);

            @Override
            public void handle(KeyEvent event) {
                Controller controller = new Controller();
                if (save.match(event)) {
                    controller.Save();
                }
                if (exit.match(event)) {
                    controller.Exit();
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
