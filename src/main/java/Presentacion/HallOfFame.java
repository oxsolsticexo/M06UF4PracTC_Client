package Presentacion;


import Entities.Jugador;
import Logica.Alerts.Alerts;
import Logica.Logica;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class HallOfFame implements Initializable{
    
    
    Logica logicaGame = new Logica();
    Alerts alert = new Alerts();

    @FXML
    private Button backButton;


    @FXML
    private TableView<Jugador> hallOfFameTable;

    @FXML
    private TableColumn<Jugador, Integer> hallOfFame_GamePoints;

    @FXML
    private TableColumn<Jugador, Integer> hallOfFame_GeneralPoints;

    @FXML
    private TableColumn<Jugador, String> hallOfFame_Nick;

    @FXML
    private TableColumn<Jugador, Integer> hallOfFame_Position;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        createTable();
        //insertTableContent();
        
        
        
    }
    
    void createTable(){
        
        hallOfFame_GeneralPoints.setCellValueFactory(new PropertyValueFactory<>("puntuacion"));
        hallOfFame_Nick.setCellValueFactory(new PropertyValueFactory<>("nick"));
        hallOfFame_Position.setCellValueFactory(new PropertyValueFactory<>("posicion"));
        hallOfFame_GamePoints.setCellValueFactory(new PropertyValueFactory<>("puntuacion_partida"));
    }
    
    void insertTableContent(){
        
        try {
            //hallOfFameTable.setItems(logicaGame.findUsers());
            alert.Info("Se han encontrado resultados");
        } catch (Exception e) {
            alert.Error(e.getMessage());
        }
        
    }

}
