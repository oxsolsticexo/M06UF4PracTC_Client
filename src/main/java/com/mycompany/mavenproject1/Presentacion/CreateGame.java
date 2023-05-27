package com.mycompany.mavenproject1.Presentacion;



import Logica.Logica;
import Logica.LogicaPartida;
import com.mycompany.mavenproject1.WindowsManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CreateGame implements Initializable {

    
    
    public enum dificultades {
        Fácil, Difícil, Normal
    };

    

    @FXML
    private Button cancelButton;

    @FXML
    private Button createButton;

    @FXML
    private ChoiceBox<String> dificultChoiceBox;

    @FXML
    private TextField newGameInputText;

    @FXML
    private Label newGameLabel;

    @FXML
    private ImageView imageLogo;

    @FXML
    private ChoiceBox<String> numberOfPlayersChoiceBox;

    @FXML
    private Label playersLabel;

    @FXML
    private Label selectDificultLabel;
    
    //Global variables
    Logica logicGame = new Logica();
    
    //Gestor de ventanas
    WindowsManager manager = new WindowsManager();
    
    //Logica Partida
    LogicaPartida logicaPartida = new LogicaPartida();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Dificultades
        inicializarDificultades();
        inicializarImagenes();
        

        
    }

    void inicializarDificultades() {
        for (dificultades dificultad : dificultades.values()) {
            dificultChoiceBox.getItems().add(dificultad.toString());
        }
    }

    void inicializarImagenes() {
        Image logo = new Image("/images/Trivial.png");
        imageLogo.setImage(logo);
    }
    
    @FXML
    void startGame(ActionEvent event) {
        
        //Implementar funcion para cambiar de ventana
        System.out.println("Nuevo juego");
        logicaPartida.crearPartida(newGameInputText.getText(),"Juan", dificultChoiceBox.getValue());
        //manager.startGame(createButton);

    }
    
    @FXML
    void cancelButton(ActionEvent event) {
        
        //Implementar funcion para cambiar de ventana
        manager.mainMenu(cancelButton);
        

    }
    

}
