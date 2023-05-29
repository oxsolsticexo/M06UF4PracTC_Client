package Presentacion;

import Entities.Jugador;
import Entities.Lookups;
import Logica.Alerts.Alerts;
import Logica.Interfaces.IHallOfFame;
import Logica.Logica;
import Utils.Converts;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import singleton.SerializableObject;

public class HallOfFame implements Initializable {

    Logica logicaGame = new Logica();
    Alerts alert = new Alerts();
    IHallOfFame hallOfFame;

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
        insertTableContent();

    }

    void createTable() {

        hallOfFame_GeneralPoints.setCellValueFactory(new PropertyValueFactory<>("puntuacionTotal"));
        hallOfFame_Nick.setCellValueFactory(new PropertyValueFactory<>("nickJugador"));
        hallOfFame_Position.setCellValueFactory(new PropertyValueFactory<>("email"));
        hallOfFame_GamePoints.setCellValueFactory(new PropertyValueFactory<>("maxPuntuacionPartida"));
    }

    void insertTableContent() {

        try {
            hallOfFame = Lookups.DAOHallOfFameLookup();
           
            System.out.println("");
            SerializableObject<Jugador> listado = hallOfFame.getUsers();
            //hallOfFameTable.setItems(listado);
            //alert.Info("Se han encontrado resultados");
        } catch (Exception e) {
            e.printStackTrace();
            //alert.Error(e.getMessage());
        }

    }

}
