package Presentacion;

import Entities.Lookups;
import Entities.Token;
import Logica.Interfaces.ISessionManager;
import Main.WindowsManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.naming.NamingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Label;

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
    private Label validationLabel;


    @FXML
    void loginToPantallaMain(ActionEvent event) throws NamingException {
        sm = Lookups.sessionManagerEJBRemoteLookup();
        //userLogin es el textField de Login.fxml
        String mailLogin = userLogin.getText();
        //si el campo login no es nulo y el correo es válido
        if (mailLogin != null && validarCorreo(mailLogin)) {
            //buscamos que el usuario exista y devolvemos su token
            token = sm.loginJugador(userLogin.getText());
            //en caso del token no ser nulo pasamos a la siguiente pantalla
            if (token != null) {
                validationLabel.setText(" ");
                wm.mainMenu(botonLogin);
            } else {
                validationLabel.setText("Error en la consulta\t(es posible que el usuario o el mail ya existan)");
            }
        } else {
            validationLabel.setText("El email no es válido");

        }

        System.out.println("el correo es : " + mailLogin);
        //en caso de tener un token para el cliente accedemos a la siguiente pantalla "pantallaMain"
    }

    @FXML
    void registroToPantallaMain(ActionEvent event) {
        try {
            //instanciamos el session manager ejb del archivo Lookups
            sm = Lookups.sessionManagerEJBRemoteLookup();
            //obtenemos el valor del registro
            String usuario = userRegistro.getText();
            String correo = emailRegistro.getText();
            //validamos los datos introducidos por el usuario
            if (validarCorreo(correo) && validarNickname(usuario)) {
                //comprobamos que los usuarios no sean nulos
                if (usuario != null && emailRegistro != null) {
                    token = sm.registrarJugador(userRegistro.getText(), emailRegistro.getText());
                    //en caso de que el token no sea nulo avanzamos al usuario a la siguiente pantalla
                    //ya que se habrá generado una sesión y el jugador se encuentra en la BD
                    if (token != null) {
                        validationLabel.setText(" ");
                        wm.mainMenu(botonRegistrar);
                    } else {
                        validationLabel.setText("Error en la consulta");
                    }
                }
            } else {
                validationLabel.setText("El nickname o email no es válido");
            }
        } catch (NamingException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean validarCorreo(String correo) {
        String patronCorreo = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
        Pattern pattern = Pattern.compile(patronCorreo, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    private boolean validarNickname(String nickname) {
        // permite letras mayúsculas, minúsculas, números y guiones bajos
        String patronNickname = "^[A-Za-z0-9_]+$";
        Pattern pattern = Pattern.compile(patronNickname);
        Matcher matcher = pattern.matcher(nickname);
        return matcher.matches();
    }

}
