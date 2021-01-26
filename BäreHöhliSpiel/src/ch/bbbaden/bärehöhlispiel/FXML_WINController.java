/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.bärehöhlispiel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author flori
 */
public class FXML_WINController implements Initializable {

    @FXML
    private Button buttonplay;
    @FXML
    private Button buttonclose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void playAgain(ActionEvent event) {
       Stage stage = (Stage) buttonplay.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void closeProgram(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
}
