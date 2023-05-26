/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import common.ISessionManagerEJB;
import common.Lookups;
import common.Token;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.naming.NamingException;
import main.SessionManagerEJB;

/**
 *
 * @author dolorioUser
 */
public class LoginController {

    private static ISessionManagerEJB sm;

    Token token = null;

    @FXML
    private TextField userLogin, UserRegistro, emailRegistro;

    @FXML
    private void registroToPantallaMain() throws IOException, NamingException {
        sm = Lookups.sessionManagerEJBRemoteLookup();

//        String usuario = UserRegistro.getText();
//        String correo = emailRegistro.getText();
//        String usuario = "hola";
//        String correo = "hola@hola.com";
//        if (usuario != null && emailRegistro != null) {
//            sm.registrarJugador(usuario, correo);
//        }
            sm.registrarJugador("hola", "hola@hola.com");

    }

//        System.out.println("el usuario y el correo son : " + usuario + correo);
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaMain.fxml"));
//        Parent root = loader.load();
//        PantallaMainController controller = loader.getController();
//
//        // Realiza cualquier configuraciÃ³n adicional en el controlador PantallaMainController si es necesario
//        // ObtÃ©n la escena actual y cÃ¡mbiala por la nueva escena con la pantalla "PantallaMainController"
//        Scene scene = userTextField.getScene();
//        scene.setRoot(root);
//        App.setRoot("pantallaMain.fxml");
    @FXML
    private void loginToPantallaMain() throws IOException, NamingException {
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
}
