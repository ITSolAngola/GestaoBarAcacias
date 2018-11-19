/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaobaracacias;

import gestaobaracacias.estiloControlador.EstiloControlador;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import metodosComuns.MetodosComuns;

/**
 * FXML Controller class
 *
 * @author bacar
 */
public class FuncionarioTelaController implements Initializable {

    @FXML
    private TextField funcionario_nome;
    @FXML
    private TextField funcionario_bilheteIdent;
    @FXML
    private TextField funcionario_endereco;
    @FXML
    private TextField funcionario_telefone1;
    @FXML
    private TextField funcionario_salario;
    @FXML
    private DatePicker funcionario_data_nasc;
    @FXML
    private TextField funcionario_telefone2;
    @FXML
    private TextField funcionario_idPesquisa;
    private Button pane_produto_btn_voltar;
    @FXML
    private StackPane stckPane_conteiner_funcionarios;
    @FXML
    private Button pane_btn_voltar;
    @FXML
    private Button pane_btn_fechar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fechar(MouseEvent event) {
        
        MetodosComuns.mensagemFecharSair(stckPane_conteiner_funcionarios);
        
    }

    @FXML
    private void realceCampoNome(MouseEvent event) {
        funcionario_nome.setStyle(EstiloControlador.realceCampo);
    }

    @FXML
    private void realceCampo_bilheteIdent(MouseEvent event) {
        funcionario_bilheteIdent.setStyle(EstiloControlador.realceCampo);
    }

    @FXML
    private void realceCampo_endereco(MouseEvent event) {
        funcionario_endereco.setStyle(EstiloControlador.realceCampo);
    }

    @FXML
    private void realceCampo_telefone1(MouseEvent event) {
        funcionario_telefone1.setStyle(EstiloControlador.realceCampo);
    }

    @FXML
    private void realceCampoSalario(MouseEvent event) {
        funcionario_salario.setStyle(EstiloControlador.realceCampo);
    }

    @FXML
    private void realceCampo_dataNasc(MouseEvent event) {
        funcionario_data_nasc.setStyle(EstiloControlador.realceCampo);
    }

    @FXML
    private void realceCampo_telefone2(MouseEvent event) {
        funcionario_telefone2.setStyle(EstiloControlador.realceCampo);
    }

    @FXML
    private void realceCampo_idPesquisa(MouseEvent event) {
        funcionario_idPesquisa.setStyle(EstiloControlador.realceCampo);
    }

    @FXML
    private void realceCampoNome_ext(MouseEvent event) {
        funcionario_nome.setStyle(EstiloControlador.realceDefault);
    }

    @FXML
    private void realceCampo_bilheteIdent_ext(MouseEvent event) {
        funcionario_bilheteIdent.setStyle(EstiloControlador.realceDefault);
    }

    @FXML
    private void realceCampo_endereco_ext(MouseEvent event) {
        funcionario_endereco.setStyle(EstiloControlador.realceDefault);
    }

    @FXML
    private void realceCampo_telefone1_ext(MouseEvent event) {
        funcionario_telefone1.setStyle(EstiloControlador.realceDefault);
    }

    @FXML
    private void realceCampoSalario_ext(MouseEvent event) {
        funcionario_salario.setStyle(EstiloControlador.realceDefault);
    }

    @FXML
    private void realceCampo_dataNasc_ext(MouseEvent event) {
        funcionario_data_nasc.setStyle(EstiloControlador.realceDefault);
    }

    @FXML
    private void realceCampo_telefone2_ext(MouseEvent event) {
        funcionario_telefone2.setStyle(EstiloControlador.realceDefault);
    }

    @FXML
    private void realceCampo_idPesquisa_ext(MouseEvent event) {
        funcionario_idPesquisa.setStyle(EstiloControlador.realceDefault);
    }

    @FXML
    private void mouse_exit_btn_voltar(MouseEvent event) {
        pane_btn_voltar.setStyle(EstiloControlador.btnNormalDefault);
    }

    @FXML
    private void mouse_hover_btn_voltar(MouseEvent event) {
        pane_btn_voltar.setStyle(EstiloControlador.btnMarcadoNormala);
    }

    @FXML
    private void mouse_exit_btn_fechar(MouseEvent event) {
        pane_btn_fechar.setStyle(EstiloControlador.btnFecharDefault);
    }

    @FXML
    private void mouse_hover_btn_fechar(MouseEvent event) {
        pane_btn_fechar.setStyle(EstiloControlador.btnMarcadoSair);
    }

    @FXML
    private void voltarBtn(MouseEvent event) {
        
         Stage home = new Stage();
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource("PessoalTela.fxml"));
            EstiloControlador.efeitoTransacao(root);
        } catch (IOException ex) {
            Logger.getLogger(ProdutosTelaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage current = (Stage)stckPane_conteiner_funcionarios.getScene().getWindow();
        Scene scene = new Scene(root);
       
        
        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        home.show();
        
    }
    
}