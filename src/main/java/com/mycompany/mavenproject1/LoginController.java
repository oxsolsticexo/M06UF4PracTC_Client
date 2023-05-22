/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author dolorioUser
 */
public class LoginController {

    @FXML
    private TextField userTextField;

    @FXML
    private TextField mailTextField;

    @FXML
    private void cambiarPantallaMain() throws IOException {
        String usuario = userTextField.getText();
        String correo = mailTextField.getText();
        
        System.out.println("el usuario y el correo son : " + usuario + correo);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaMain.fxml"));
        Parent root = loader.load();
        PantallaMainController controller = loader.getController();

        // Realiza cualquier configuración adicional en el controlador PantallaMainController si es necesario
        // Obtén la escena actual y cámbiala por la nueva escena con la pantalla "PantallaMainController"
        Scene scene = userTextField.getScene();
        scene.setRoot(root);

//        App.setRoot("pantallaMain.fxml");
    }
}
