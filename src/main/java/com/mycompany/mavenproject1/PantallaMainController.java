/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author dolorioUser
 */
public class PantallaMainController {

    @FXML
    private void cambiarGenerarPartida() throws IOException {
        App.setRoot("generarPartida");
    }

    @FXML
    private void cambiarHallOfFame() throws IOException {
        App.setRoot("hallOfFame");
    }
}
