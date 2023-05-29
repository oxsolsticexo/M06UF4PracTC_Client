package Presentacion;

import Entities.Jugador;
import Entities.Lookups;
import Logica.Alerts.Alerts;
import Logica.Interfaces.IHallOfFame;
import Logica.Logica;
import Main.WindowsManager;
import Utils.Converts;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import singleton.DataConvert;

public class HallOfFame implements Initializable {

    Logica logicaGame = new Logica();
    Alerts alert = new Alerts();
    IHallOfFame hallOfFame;
    WindowsManager manager  = WindowsManager.getInstance();

    @FXML
    private ImageView hallOfFameBackground;
    
    @FXML
    private Button backButton;

    @FXML
    private TableView<Jugador> hallOfFameTable;
    
    @FXML
    private ImageView hallOfFameTitle;

    @FXML
    private TableColumn<Jugador, Integer> hallOfFame_GamePoints;

    @FXML
    private TableColumn<Jugador, Integer> hallOfFame_GeneralPoints;

    @FXML
    private TableColumn<Jugador, String> hallOfFame_Nick;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        insertImages();
        createTable();
        insertTableContent();

    }

    void createTable() {

        hallOfFame_GeneralPoints.setCellValueFactory(new PropertyValueFactory<>("puntuacionTotal"));
        hallOfFame_Nick.setCellValueFactory(new PropertyValueFactory<>("nickJugador"));
        hallOfFame_GamePoints.setCellValueFactory(new PropertyValueFactory<>("maxPuntuacionPartida"));
    }

    void insertTableContent() {

        try {
            hallOfFame = Lookups.DAOHallOfFameLookup();
            String[] listado = hallOfFame.getUsers().split("\n");            
            ObservableList<Jugador> newList = DataConvert.getJugadores(listado);
            hallOfFameTable.setItems(newList);
            //alert.Info("Se han encontrado resultados");
        } catch (Exception e) {
            e.printStackTrace();
            //alert.Error(e.getMessage());
        }

    }

    @FXML
    void returnToMainMenu(ActionEvent event) {
       manager.mainMenu(backButton);
    }
    
    public void insertImages(){
        Image imgTitle = new Image("/images/hallOfFameTitle.png");
        Image imgBackground = new Image("/images/hallOfFame.jpg");
        
        hallOfFameBackground.setImage(imgBackground);
        hallOfFameTitle.setImage(imgTitle);
    }

}
