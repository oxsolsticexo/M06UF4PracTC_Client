/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import common.IJugador;
import common.Lookups;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.naming.NamingException;

/**
 *
 * @author dolorioUser
 */
public class LoginController {

    static IJugador jugador;

    @FXML
    private TextField mailTextField, userTextField, mailLoginTextField;

    @FXML
    private void registroToPantallaMain() throws IOException, NamingException {
        jugador = Lookups.jugadorEJBRemoteLookup();
        boolean bol = false;

        String usuario = userTextField.getText();
        String correo = mailTextField.getText();
        if (usuario != null && mailTextField != null) {

            bol = jugador.registrarJugador(usuario, correo);
        }

        System.out.println("el usuario y el correo son : " + usuario + correo);
        if (bol) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaMain.fxml"));
            Parent root = loader.load();
            PantallaMainController controller = loader.getController();

            // Realiza cualquier configuraciÃ³n adicional en el controlador PantallaMainController si es necesario
            // ObtÃ©n la escena actual y cÃ¡mbiala por la nueva escena con la pantalla "PantallaMainController"
            Scene scene = userTextField.getScene();
            scene.setRoot(root);

//        App.setRoot("pantallaMain.fxml");
        }

    }

//    @FXML
//    private void loginToPantallaMain() throws IOException, NamingException {
//        jugador = Lookups.jugadorEJBRemoteLookup();
//
//        String mailLogin = mailLoginTextField.getText();
//        if (mailLogin != null) {
//            jugador.verificarExistenciaCorreo(mailLogin);
//        }
//
//        System.out.println("el correo es : " + mailLogin);
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaMain.fxml"));
//        Parent root = loader.load();
//        PantallaMainController controller = loader.getController();
//        jugador.get
//
//        // Realiza cualquier configuraciÃ³n adicional en el controlador PantallaMainController si es necesario
//        // ObtÃ©n la escena actual y cÃ¡mbiala por la nueva escena con la pantalla "PantallaMainController"
//        Scene scene = userTextField.getScene();
//        scene.setRoot(root);
//
////        App.setRoot("pantallaMain.fxml");
//    }
}
