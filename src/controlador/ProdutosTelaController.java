/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author bacar
 */
public class ProdutosTelaController implements Initializable {

    @FXML
    private Pane pane_produto_bebida;
    @FXML
    private Pane pane_produto_comida;
    @FXML
    private Pane pane_produto_alimentos;
    @FXML
    private Button pane_produto_btn_voltar;
    @FXML
    private Button pane_produto_btn_fechar;
    @FXML
    private StackPane stackPane_produto;
    @FXML
    private AnchorPane ancorpane_conteiner;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mouse_exit_bebidas(MouseEvent event) {
        pane_produto_bebida.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_bebidas(MouseEvent event) {
        pane_produto_bebida.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_comidas(MouseEvent event) {
        pane_produto_comida.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_comidas(MouseEvent event) {
        pane_produto_comida.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_alimentos(MouseEvent event) {
        pane_produto_alimentos.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_alimentos(MouseEvent event) {
        pane_produto_alimentos.setStyle(EstiloControlador.corHover);
    }


    @FXML
    private void botaoFechar(MouseEvent event) {
        
    MetodosComuns.mensagemFecharSair(stackPane_produto);
    }

    @FXML
    private void botaoDefault(MouseEvent event) {
       pane_produto_btn_voltar.setStyle(EstiloControlador.btnNormalDefault);
    }

    @FXML
    private void botaoNormalRealce(MouseEvent event) {
       pane_produto_btn_voltar.setStyle(EstiloControlador.btnMarcadoNormala);
    }

    @FXML
    private void botaoFecharDefault(MouseEvent event) {
        pane_produto_btn_fechar.setStyle(EstiloControlador.btnFecharDefault);
    }

    @FXML
    private void botaoFecharRealce(MouseEvent event) {
        pane_produto_btn_fechar.setStyle(EstiloControlador.btnMarcadoSair);
    }

    @FXML
    private void botaoVoltar(MouseEvent event) {
        
        Stage home = new Stage();
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
            EstiloControlador.efeitoTransacao(root);
        } catch (IOException ex) {
            Logger.getLogger(ProdutosTelaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage current = (Stage)pane_produto_btn_voltar.getScene().getWindow();
        Scene scene = new Scene(root);
       
        
        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        home.show();
    }



    
}
