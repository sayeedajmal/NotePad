package com.notepad;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller implements Initializable {
    Stage primaryStage = new Stage();
    public JFXTextArea textarea = new JFXTextArea();
    JFXButton Save = new JFXButton();
    public static File FileUrl;

    /* THIS WILL EXECUTE FILECHOOSER */
    public void Save() {
        String inputText = textarea.getText();
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Save File: ");
        // Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        FileUrl= fileChooser.showSaveDialog(primaryStage);

        if (FileUrl != null) {
            saveTextToFile(inputText, FileUrl);
        }

    }

    public void Open() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt");
        chooser.getExtensionFilters().add(filter);
        FileUrl = chooser.showOpenDialog(primaryStage);

    }

    /* saving the test by printing the text into the file */
    private void saveTextToFile(String inputText, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(inputText);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /* Exiting */
    public void Exit() {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void New() {
    }
}
