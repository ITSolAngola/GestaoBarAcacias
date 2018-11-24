/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author bacar
 */
public class LoginScreenController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane stackLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btncancelar(MouseEvent event) {
    }

    @FXML
    private void barcode(KeyEvent event) {
        Stage pessoal = new Stage();
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
            EstiloControlador.efeitoTransacao(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage current = (Stage)stackLogin.getScene().getWindow();
        Scene scene = new Scene(root);
        
        pessoal.setScene(scene);
        pessoal.initStyle(StageStyle.TRANSPARENT);
        
        current.hide();
        pessoal.show();
    }
    
}
