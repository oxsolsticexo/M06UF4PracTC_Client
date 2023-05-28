/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1.Presentacion;

import com.mycompany.mavenproject1.WindowsManager;
import common.IPartida;
import common.Lookups;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javax.naming.NamingException;

/**
 *
 * @author Kiwi
 */
public class InGameController implements Initializable {

    IPartida partida;
    WindowsManager windowsManager;
    
    @FXML
    private Pane PreguntaCounter_Pane;

    @FXML
    private Label Pregunta_Label;

    @FXML
    private Label PreguntaCounter_Label;

    @FXML
    private Pane Pregunta_Pane;

    @FXML
    private Pane RespuestaA_Pane;

    @FXML
    private Button Abandonar_Button;

    @FXML
    private Label RespuestaC_Label;

    @FXML
    private Pane RespuestaC_Pane;

    @FXML
    private Button Comenzar_Button;

    @FXML
    private Label RespuestaB_Label;

    @FXML
    private Label Timer_Label;

    @FXML
    private Pane RespuestaB_Pane;

    @FXML
    private Label RespuestaA_Label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        windowsManager = new WindowsManager();
        
        try {
            partida = Lookups.partidaEJBRemoteLookup();
        } catch (NamingException ex) {
            Logger.getLogger(InGameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void onMouseClicked_RespuestaA_Pane(ActionEvent event) {

    }

    @FXML
    void onMouseClicked_RespuestaA_Label(ActionEvent event) {

    }

    @FXML
    void onMouseClicked_RespuestaB_Pane(ActionEvent event) {

    }

    @FXML
    void onMouseClicked_RespuestaB_Label(ActionEvent event) {

    }

    @FXML
    void onMouseClicked_RespuestaC_Pane(ActionEvent event) {

    }

    @FXML
    void onMouseClicked_RespuestaC_Label(ActionEvent event) {

    }

    @FXML
    void onAction_Comenzar_Button(ActionEvent event) {
        
    }

    @FXML
    void onAction_Abandonar_Button(ActionEvent event) {

    }
}
