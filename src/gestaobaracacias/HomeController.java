/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaobaracacias;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import gestaobaracacias.estiloControlador.EstiloControlador;


/**
 *
 * @author bacar
 */
public class HomeController implements Initializable {
    

    @FXML
    private Pane pane_vendas;
    @FXML
    private Pane pane_faturacao;
    @FXML
    private Pane pane_produtos;
    @FXML
    private Pane pane_estatisticas;
    @FXML
    private Pane pane_definicoes;
    @FXML
    private Pane pane_seguranca;
    @FXML
    private Pane pane_monitoracao;
    private Pane pane_funcionarios;
    @FXML
    private Pane pane_pessoal;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mouse_hover_vendas(MouseEvent event) {
        pane_vendas.setStyle(EstiloControlador.corHover);
        
    }

    @FXML
    private void mouse_exit__vendas(MouseEvent event) {
        pane_vendas.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_faturacao(MouseEvent event) {
        pane_faturacao.setStyle(EstiloControlador.corHover);
        
    }

    @FXML
    private void mouse_exit_faturacao(MouseEvent event) {
        pane_faturacao.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_produtos(MouseEvent event) {
        pane_produtos.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_produtos(MouseEvent event) {
        pane_produtos.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_estatisticas(MouseEvent event) {
        pane_estatisticas.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_estatisticas(MouseEvent event) {
        pane_estatisticas.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_definicoes(MouseEvent event) {
        pane_definicoes.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_definicoes(MouseEvent event) {
        pane_definicoes.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_seguranca(MouseEvent event) {
        pane_seguranca.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_seguranca(MouseEvent event) {
        pane_seguranca.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_monitoracao(MouseEvent event) {
        pane_monitoracao.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_monitoracao(MouseEvent event) {
        pane_monitoracao.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void telaProduto(MouseEvent event) {
        
        Stage produto = new Stage();
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource("ProdutosTela.fxml"));
            EstiloControlador.efeitoTransacao(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage current = (Stage)pane_produtos.getScene().getWindow();
        Scene scene = new Scene(root);
        
        produto.setScene(scene);
        produto.initStyle(StageStyle.TRANSPARENT);
        
        current.hide();
        produto.show();
    }

    private void mouse_exit_funcionario(MouseEvent event) {
        pane_funcionarios.setStyle(EstiloControlador.corExit);
    }

    private void mouse_hover_funcionario(MouseEvent event) {
        pane_funcionarios.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_pessoal(MouseEvent event) {
        pane_pessoal.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_pessoal(MouseEvent event) {
        pane_pessoal.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void telaPessoal(MouseEvent event) {
        

        Stage pessoal = new Stage();
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource("PessoalTela.fxml"));
            EstiloControlador.efeitoTransacao(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage current = (Stage)pane_pessoal.getScene().getWindow();
        Scene scene = new Scene(root);
        
        pessoal.setScene(scene);
        pessoal.initStyle(StageStyle.TRANSPARENT);
        
        current.hide();
        pessoal.show();
        
    }
    
}
