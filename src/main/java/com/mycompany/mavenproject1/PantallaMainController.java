package com.mycompany.mavenproject1;

import common.ISessionManager;
import common.Lookups;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javax.naming.NamingException;

public class PantallaMainController {

    private WindowsManager wm = new WindowsManager();

    private static ISessionManager sm;

    @FXML
    private Button disconnectBut;

    @FXML
    private Button generarPartBut;

    @FXML
    private Button halfOfFameBut;

    @FXML
    void cambiarGenerarPartida(ActionEvent event) {
        wm.createNewGame(generarPartBut);
    }

    @FXML
    void cambiarHallOfFame(ActionEvent event) {
        wm.hallOfFame();
    }

    @FXML
    void desconectarse(ActionEvent event) throws NamingException {
        sm = Lookups.sessionManagerEJBRemoteLookup();
        sm.cerrarSesion(LoginController.token);
        wm.disconnect(disconnectBut);

    }

}
