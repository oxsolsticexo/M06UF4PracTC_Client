/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author dolorioUser
 */
public class LoginController {

    @FXML
    private void cambiarPantallaMain() throws IOException {
        App.setRoot("pantallaMainController");
    }
}
