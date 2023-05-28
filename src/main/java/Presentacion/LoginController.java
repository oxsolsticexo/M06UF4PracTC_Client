/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package com.mycompany.mavenproject1;
//
//import common.ISessionManager;
//import common.Lookups;
//import common.Token;
//import javafx.scene.control.TextField;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//import javax.naming.NamingException;
//import main.SessionManagerEJB;
//
///**
// *
// * @author dolorioUser
// */
//public class LoginController {
//
//    private static ISessionManager sm;
//
//    public static Token token = null;
//
//    @FXML
//    private TextField userLogin, UserRegistro, emailRegistro;
//
//    @FXML
//    private void registroToPantallaMain() throws IOException, NamingException {
//        sm = Lookups.sessionManagerEJBRemoteLookup();
//
//        String usuario = UserRegistro.getText();
//        String correo = emailRegistro.getText();
////        String usuario = "hola";
////        String correo = "hola@hola.com";
//        if (usuario != null && emailRegistro != null) {
//            sm.registrarJugador(UserRegistro.getText(), emailRegistro.getText());
//        }
//
//    }
//
////        System.out.println("el usuario y el correo son : " + usuario + correo);
////        FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaMain.fxml"));
////        Parent root = loader.load();
////        PantallaMainController controller = loader.getController();
////
////        // Realiza cualquier configuraciÃ³n adicional en el controlador PantallaMainController si es necesario
////        // ObtÃ©n la escena actual y cÃ¡mbiala por la nueva escena con la pantalla "PantallaMainController"
////        Scene scene = userTextField.getScene();
////        scene.setRoot(root);
////        App.setRoot("pantallaMain.fxml");
//    @FXML
//    private void loginToPantallaMain() throws IOException, NamingException {
//        sm = Lookups.sessionManagerEJBRemoteLookup();
//
//        String mailLogin = userLogin.getText();
//        if (mailLogin != null) {
//            token = sm.loginJugador(userLogin.getText());
//        }
//
//        System.out.println("el correo es : " + mailLogin);
//
////        FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaMain.fxml"));
////        Parent root = loader.load();
////        PantallaMainController controller = loader.getController();
////        Scene scene = mailLogin.getScene();
////        scene.setRoot(root);
////        App.setRoot("pantallaMain.fxml");
//        if (token != null) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaMain.fxml"));
//            Parent root = loader.load();
//            WindowsManager wm = new WindowsManager();
////            wm.mainMenu(botonLogin);
////            PantallaMainController controller = loader.getController();
////            Scene scene = mailLogin.getScene();
////            scene.setRoot(root);
//            // Si es necesario, puedes pasar el token al controlador de la pantallaMain
////            controller.setToken(token);
//        }
//    }
package Presentacion;

import Entities.Lookups;
import Entities.Token;
import Logica.Interfaces.ISessionManager;
import Main.WindowsManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.naming.NamingException;




public class LoginController {

    private static ISessionManager sm;

    WindowsManager wm = new WindowsManager();

    public static Token token = null;

    @FXML
    private Button botonLogin;

    @FXML
    private Button botonRegistrar;

    @FXML
    private TextField emailRegistro;

    @FXML
    private TextField userLogin;

    @FXML
    private TextField userRegistro;

    @FXML
    void loginToPantallaMain(ActionEvent event) throws NamingException {
        sm = Lookups.sessionManagerEJBRemoteLookup();

        String mailLogin = userLogin.getText();
        
        if (mailLogin != null) {
            token = sm.loginJugador(userLogin.getText());
        }

        System.out.println("el correo es : " + mailLogin);

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaMain.fxml"));
//        Parent root = loader.load();
//        PantallaMainController controller = loader.getController();
//        Scene scene = mailLogin.getScene();
//        scene.setRoot(root);
//        App.setRoot("pantallaMain.fxml");
        if (token != null) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaMain.fxml"));
//            Parent root = loader.load();
//            WindowsManager wm = new WindowsManager();
//            wm.mainMenu(botonLogin);
//            PantallaMainController controller = loader.getController();
//            Scene scene = mailLogin.getScene();
//            scene.setRoot(root);
            // Si es necesario, puedes pasar el token al controlador de la pantallaMain
//            controller.setToken(token);
            wm.mainMenu(botonLogin);
        }
    }

    @FXML
    void registroToPantallaMain(ActionEvent event) throws NamingException {
        sm = Lookups.sessionManagerEJBRemoteLookup();

        String usuario = userRegistro.getText();
        String correo = emailRegistro.getText();
//        String usuario = "hola";
//        String correo = "hola@hola.com";
        if (usuario != null && emailRegistro != null) {
            token = sm.registrarJugador(userRegistro.getText(), emailRegistro.getText());
        }

        if (token != null) {
            wm.mainMenu(botonRegistrar);
        } else {
            System.out.println("EL DIABLo");
        }

    }

}
