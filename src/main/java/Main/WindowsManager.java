/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Entities.Token;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author carlo
 */
public class WindowsManager {

    private Token token;

    private static WindowsManager manager;

    public static WindowsManager getInstance() {
        if (manager == null) {
            manager = new WindowsManager();
        }

        return manager;

    }

    public void hallOfFame() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void login() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 500));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void disconnect(Button discon) {
        try {
            Stage oldWindow = (Stage) discon.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            oldWindow.close();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createNewGame(Button createGame) {
        try {
            Stage oldWindow = (Stage) createGame.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            oldWindow.close();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void startGame(Button createButton) {
        try {
            Stage oldWindow = (Stage) createButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inGame.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            oldWindow.close();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void mainMenu(Button cancelButton) {
        try {
            Stage oldWindow = (Stage) cancelButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaMain.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            oldWindow.close();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setToken(Token token) {
        this.token = token;

    }

    public Token getToken() {
        return token;

    }
}
