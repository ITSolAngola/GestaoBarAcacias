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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author bacar
 */
public class PessoalTelaController implements Initializable {

    private Pane pessoal_funcionario;
    @FXML
    private Pane pessoal_fornecedor;
    @FXML
    private Button pane_pessoal_btn_fechar;
    @FXML
    private Button pane_pessoal_btn_voltar;
    @FXML
    private StackPane pane_pessoal_conteiner;
    @FXML
    private Pane pessoal_funcionarioTela;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void mouse_exit_funcionario(MouseEvent event) {
       pessoal_funcionarioTela.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_funcionario(MouseEvent event) {
        
        pessoal_funcionarioTela.setStyle(EstiloControlador.corHover);
        
    }    

    @FXML
    private void mouse_exit_fornecedor(MouseEvent event) {
        pessoal_fornecedor.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_fornecedor(MouseEvent event) {
        pessoal_fornecedor.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void botaoFecharDefault(MouseEvent event) {
        pane_pessoal_btn_fechar.setStyle(EstiloControlador.btnFecharDefault);
    }

    @FXML
    private void botaoFecharRealce(MouseEvent event) {
        pane_pessoal_btn_fechar.setStyle(EstiloControlador.btnMarcadoSair);
    }

    @FXML
    private void botaoDefault(MouseEvent event) {
        pane_pessoal_btn_voltar.setStyle(EstiloControlador.btnNormalDefault);
    }

    @FXML
    private void botaoNormalRealce(MouseEvent event) {
        pane_pessoal_btn_voltar.setStyle(EstiloControlador.corHover);
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
        
        Stage current = (Stage)pane_pessoal_conteiner.getScene().getWindow();
        Scene scene = new Scene(root);
        
        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        home.show();
        
    }
    
    @FXML
    private void botaoFechar(MouseEvent event) {
        
        MetodosComuns.mensagemFecharSair(pane_pessoal_conteiner);
        
    }

    @FXML
    private void funcionarioTela(MouseEvent event) {
    }

    @FXML
    private void telaFuncionario(MouseEvent event) {
        
        
        Stage produto = new Stage();
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource("/view/FuncionarioTela.fxml"));
            EstiloControlador.efeitoTransacao(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage current = (Stage)pessoal_funcionarioTela.getScene().getWindow();
        Scene scene = new Scene(root);
        
        produto.setScene(scene);
        produto.initStyle(StageStyle.TRANSPARENT);
        
        current.hide();
        produto.show();
        
    }

    
}
