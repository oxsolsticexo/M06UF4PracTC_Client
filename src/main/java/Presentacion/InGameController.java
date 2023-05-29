/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Presentacion;

import Entities.Jugador;
import Entities.Pregunta;
import Logica.Exceptions.SesionException;
import Logica.Interfaces.IPartida;
import Main.WindowsManager;
import java.net.URL;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javax.naming.NamingException;

/**
 *
 * @author Kiwi
 */
public class InGameController implements Initializable {
    
    private Timeline timeline;
    private static Logger logger;
    private IPartida iPartida;
    private Pregunta preguntaActual;
    private Float puntuacionJugador;
    private int numeroPregunta;
    private int numPreguntasAcertadas;
    private int numPreguntasFallidas;
    private Jugador jugador;
    
    WindowsManager windowsManager;
    
    @FXML
    private Label NombreJugador_Label, PuntuacionTotal_Label, Fallidas_Label, Acertadas_Label, PuntuacionPartida_Label;
    
    @FXML
    private Pane RespuestaA_Pane, RespuestaB_Pane, RespuestaC_Pane;
    
    @FXML
    private TextArea Pregunta_TextArea;
    
    @FXML
    private Label PreguntaCounter_Label;
    
    @FXML
    private Label RespuestaA_Label, RespuestaB_Label, RespuestaC_Label;
    
    @FXML
    private Button Comenzar_Button, Abandonar_Button;
    
    @FXML
    private Label Timer_Label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        puntuacionJugador = 0f;
        
        logger = LogManager.getLogger(InGameController.class);
        
        numeroPregunta = 1;
        
        iPartida = CreateGame.partida;
        windowsManager = WindowsManager.getInstance();
        
    }
    
    @FXML
    void onMouseClicked_RespuestaA_Pane(MouseEvent event) {
        
        System.out.println("click A");
        
        if (preguntaActual.getRespuestaCorrecta().contentEquals("A")) {
            
            this.puntuacionJugador += iPartida.calculaPuntuacion(iPartida.getTiempoRestante());
            
            PuntuacionPartida_Label.setText("" + puntuacionJugador);
            numPreguntasAcertadas++;
            Acertadas_Label.setText("" + numPreguntasAcertadas);
            
            System.out.println(puntuacionJugador);
        } else {
            
            numPreguntasFallidas++;
            Fallidas_Label.setText("" + numPreguntasFallidas);
            
        }
        
        obtenerNuevaPregunta();
        //Reiniciamos el temporizador
        iPartida.detenerTiempo();
        iPartida.iniciarTiempo();
    }
    
    @FXML
    void onMouseClicked_RespuestaB_Pane(MouseEvent event) {
        System.out.println("click B");
        
        if (preguntaActual.getRespuestaCorrecta().contentEquals("B")) {
            
            this.puntuacionJugador += iPartida.calculaPuntuacion(iPartida.getTiempoRestante());
            System.out.println(puntuacionJugador);
            
            PuntuacionPartida_Label.setText("" + puntuacionJugador);
            
            numPreguntasAcertadas++;
            Acertadas_Label.setText("" + numPreguntasAcertadas);
            
        } else {
            numPreguntasFallidas++;
            Fallidas_Label.setText("" + numPreguntasFallidas);
        }
        
        obtenerNuevaPregunta();
        //Reiniciamos el temporizador
        iPartida.detenerTiempo();
        iPartida.iniciarTiempo();
    }
    
    @FXML
    void onMouseClicked_RespuestaC_Pane(MouseEvent event) {
        System.out.println("click C");
        
        if (preguntaActual.getRespuestaCorrecta().contentEquals("C")) {
            
            this.puntuacionJugador += iPartida.calculaPuntuacion(iPartida.getTiempoRestante());
            System.out.println(puntuacionJugador);
            
            PuntuacionPartida_Label.setText("" + puntuacionJugador);
            numPreguntasAcertadas++;
            Acertadas_Label.setText("" + numPreguntasAcertadas);
        } else {
            numPreguntasFallidas++;
            Fallidas_Label.setText("" + numPreguntasFallidas);
        }
        
        obtenerNuevaPregunta();
        //Reiniciamos el temporizador
        iPartida.detenerTiempo();
        iPartida.iniciarTiempo();
    }
    
    @FXML
    void onAction_Comenzar_Button(ActionEvent event) {
        
        obtenerNuevaPregunta(); //TODO Controlar posibles errores
        try {

            //Obtenemos los marcadores del jugador            
            NombreJugador_Label.setText(iPartida.getNickJugador(LoginController.token));
            PuntuacionTotal_Label.setText(String.valueOf(iPartida.getPuntuacionJugador(LoginController.token)));
            
        } catch (SesionException ex) {
            logger.error("Error al obtener el token del jugador: " + ex.getMessage());
        } catch (NamingException ex) {
            logger.error("Error al obtener la instancia del EJB: " + ex.getMessage());
        }

        //Empezamos el timer y seteamos el valor del Timer en cada segundo.
        iPartida.iniciarTiempo();
        lineaTemporal();
        
        Comenzar_Button.setDisable(true);
    }
    
    @FXML
    void onAction_Abandonar_Button(ActionEvent event) {
        
        windowsManager.mainMenu(Abandonar_Button);
    }

    /**
     * Lógica para obtener una nueva pregunta
     */
    private void obtenerNuevaPregunta() {
        
        System.out.println("Numero pregunta: " + numeroPregunta);
        if (numeroPregunta > 10) {
            
            try {
                //Llevamos el token al servidor junto a los datos de la partida
                iPartida.persistirDatosPartida(LoginController.token, puntuacionJugador);
            } catch (SesionException ex) {
                logger.error("Error al obtener el token del jugador: " + ex.getMessage());
            } catch (NamingException ex) {
                logger.error("Error al obtener la instancia del EJB: " + ex.getMessage());
            }

            //Detenemos el timer
            timeline.stop();
            Timer_Label.setText("Timer: --");
            
            Pregunta_TextArea.setText("Partida Finalizada");

            //Limpiamos los textos
            RespuestaA_Label.setText("");
            RespuestaB_Label.setText("");
            RespuestaC_Label.setText("");

            //Ocultamos los paneles.
            RespuestaA_Pane.setVisible(false);
            RespuestaB_Pane.setVisible(false);
            RespuestaC_Pane.setVisible(false);
        } else {
            try {
                this.preguntaActual = iPartida.asignaPregunta();

                //Seteamos el contenido de la pregunta.
                Pregunta_TextArea.setText(preguntaActual.getPregunta());

                //Seteamos el contenido de las respuestas.
                RespuestaA_Label.setText(preguntaActual.getRespuestaA());
                RespuestaB_Label.setText(preguntaActual.getRespuestaB());
                RespuestaC_Label.setText(preguntaActual.getRespuestaC());

                //Cambiamos el contador de preguntas
                PreguntaCounter_Label.setText("Pregunta " + numeroPregunta + "/10");
                numeroPregunta += 1;
                
            } catch (Exception ex) {
                logger.error("Error al obtener nueva pregunta: " + ex.getMessage());
            }
        }
    }

    /**
     * Obtiene el Bean "Partida" para gestionar el temporizador de la capa de
     * presentación
     *
     * @param partida
     */
    private void lineaTemporal() {

        // Crea el Timeline con un evento que se ejecuta cada segundo
        this.timeline = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            // Aquí puedes actualizar el tiempo restante en tu componente visual
            int tiempoRestante = iPartida.getTiempoRestante(); // Obtiene el tiempo restante del EJB
            Timer_Label.setText("Timer: " + String.valueOf(tiempoRestante));
            
            if (tiempoRestante <= 0) {
                
                obtenerNuevaPregunta(); // Detiene el Timeline cuando se alcanza 0
                iPartida.detenerTiempo();
                iPartida.iniciarTiempo();
            }

            // Verifica si se ha alcanzado el tiempo restante inicial
        }));
        // Configura el Timeline para que se repita N segundos
        timeline.setCycleCount(Timeline.INDEFINITE); //TODO parar el temporizador cuando no queden preguntas

        // Inicia el Timeline
        timeline.play();
    }
}
