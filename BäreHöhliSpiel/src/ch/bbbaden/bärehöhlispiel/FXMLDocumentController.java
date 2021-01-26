/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.bärehöhlispiel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author flori
 */
public class FXMLDocumentController implements Initializable {

    ArrayList<Würfel> würfels = new ArrayList<>();

    @FXML
    private ImageView dicetopleft;
    @FXML
    private ImageView dicetopright;
    @FXML
    private ImageView dicemiddleleft;
    @FXML
    private ImageView dicemiddleright;
    @FXML
    private ImageView dicedownleft;
    @FXML
    private ImageView dicedownright;
    @FXML
    private Button buttonwuerfel;
    @FXML
    private TextField textbärehöhli;
    @FXML
    private TextField textbäre;
    @FXML
    private Button buttonprüfen;
    @FXML
    private ImageView helppic;
    @FXML
    private Label textfalschbärehöhli;
    @FXML
    private Label textfalschbäre;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wuerfeln();
    }

    @FXML
    private void wuerflen(ActionEvent event) {
        wuerfeln();

    }

    public void setPictureTopLeft(String path) {
        dicetopleft.setImage(new Image(path));
    }

    public void setPictureTopRight(String path) {
        dicetopright.setImage(new Image(path));
    }

    public void setPictureMiddleLeft(String path) {
        dicemiddleleft.setImage(new Image(path));
    }

    public void setPictureMiddleRight(String path) {
        dicemiddleright.setImage(new Image(path));
    }

    public void setPictureDownLeft(String path) {
        dicedownleft.setImage(new Image(path));
    }

    public void setPictureDownRight(String path) {
        dicedownright.setImage(new Image(path));
    }

    public void wuerfeln() {
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int zahl = random.nextInt(6) + 1;
            würfels.add(i, new Würfel(zahl, i));
            setImage(zahl, i);
            

        }
        

    }

    public void setImage(int zahl, int position) {

        switch (position) {
            case 0:
                setPictureTopLeft(getPath(zahl));
                break;
            case 1:
                setPictureTopRight(getPath(zahl));
                break;
            case 2:
                setPictureMiddleLeft(getPath(zahl));
                break;
            case 3:
                setPictureMiddleRight(getPath(zahl));
                break;
            case 4:
                setPictureDownLeft(getPath(zahl));
                break;
            case 5:
                setPictureDownRight(getPath(zahl));
                break;
        }

    }

    public String getPath(int zahl) {
        String path = "";
        switch (zahl) {
            case 1:
                path = "/bilder/würfel1.png";
                break;
            case 2:
                path = "/bilder/würfel2.png";
                break;
            case 3:
                path = "/bilder/würfel3.png";
                break;
            case 4:
                path = "/bilder/würfel4.png";
                break;
            case 5:
                path = "/bilder/würfel5.png";
                break;
            case 6:
                path = "/bilder/würfel6.png";
                break;

        }
        return path;
    }

    @FXML
    private void pruefen(ActionEvent event) {
        int eingabebärehöhli = 0;
        int eingabebäre = 0;
        textfalschbärehöhli.setText("");
        textfalschbäre.setText("");

        try {
            eingabebärehöhli = Integer.parseInt(textbärehöhli.getText());
            try {
                eingabebäre = Integer.parseInt(textbäre.getText());
                if (checkAnzahlBärehöhli() == eingabebärehöhli) {

                    if (checkAnzahlBäre() == eingabebäre) {
                        System.out.println("RICHTIG!");
                        Stage stage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("FXML_WIN.fxml"));

                        Scene scene = new Scene(root);

                        stage.setTitle("Gwonne!");
                        stage.setScene(scene);
                        stage.show();
                        wuerfeln();
                    } else {
                        textfalschbäre.setText("Falsch!");
                    }

                } else {
                    textfalschbärehöhli.setText("Falsch!");
                }
            } catch (Exception e) {
                textfalschbäre.setText("Keine Zahl!");
            }
        } catch (Exception e) {
            textfalschbärehöhli.setText("Keine Zahl!");
        }

    }

    private int checkAnzahlBärehöhli() {
        int anzahlbärehöhli = 0;
        for (int i = 0; i < 6; i++) {

            if (würfels.get(i).getZahl() % 2 == 0) {

            } else {
                anzahlbärehöhli = anzahlbärehöhli + 1;
            }

        }
        return anzahlbärehöhli;

    }

    private int checkAnzahlBäre() {
        int anzahlbäre = 0;
        for (int i = 0; i < 6; i++) {

            if (würfels.get(i).getZahl() % 2 == 0) {

            } else {
                anzahlbäre = anzahlbäre + würfels.get(i).getZahlHinterseite(würfels.get(i).getZahl());;
            }

        }
        return anzahlbäre;

    }

    @FXML
    private void help(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXML_HELP.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Hilfe");
        stage.setScene(scene);
        stage.show();

    }

}
