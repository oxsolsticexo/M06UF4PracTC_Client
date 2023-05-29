/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Presentacion;

import Entities.Lookups;
import Entities.Pregunta;
import Logica.Interfaces.IPartida;
import Logica.Interfaces.IPregunta;
import Main.WindowsManager;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javax.naming.NamingException;

/**
 *
 * @author Kiwi
 */
public class InGameController implements Initializable {

    IPartida partida;
    IPregunta pregunta;

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
    private Pane RespuestaA_Pane, RespuestaB_Pane, RespuestaC_Pane;

    @FXML
    private Label RespuestaA_Label, RespuestaB_Label, RespuestaC_Label;

    @FXML
    private Button Comenzar_Button, Abandonar_Button;

    @FXML
    private Label Timer_Label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partida = CreateGame.partida;
        windowsManager = new WindowsManager();

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

        try {
            Pregunta p = partida.asignaPregunta();

            System.out.println("2 - " + p);
            System.out.println("3 - " + p.getPregunta());

            //Seteamos el contenido de la pregunta.
            Pregunta_Label.setText(p.getPregunta());

            //Seteamos el contenido de las respuestas.
            RespuestaA_Label.setText(p.getRespuestaA());
            RespuestaB_Label.setText(p.getRespuestaB());
            RespuestaC_Label.setText(p.getRespuestaC());

            //Empezamos el timer y seteamos el valor del Timer en cada segundo.
            partida.iniciarTiempo();
            lineaTemporal(partida);

            Comenzar_Button.setDisable(true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void onAction_Abandonar_Button(ActionEvent event) {

    }

    private void lineaTemporal(IPartida partida) {

        int tiempoRestanteInicial = partida.getTiempoRestante();

        // Crea el Timeline con un evento que se ejecuta cada segundo
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            // Aquí puedes actualizar el tiempo restante en tu componente visual
            int tiempoRestante = partida.getTiempoRestante(); // Obtiene el tiempo restante del EJB
            Timer_Label.setText(String.valueOf(tiempoRestante));

            // Verifica si se ha alcanzado el tiempo restante inicial
            if (tiempoRestante <= 0) {
                partida.detenerTiempo(); // Detiene el Timeline cuando se alcanza 0
            }

        }));
        // Configura el Timeline para que se repita indefinidamente
        timeline.setCycleCount(tiempoRestanteInicial);

        // Inicia el Timeline
        timeline.play();
    }
}
