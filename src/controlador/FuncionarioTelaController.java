/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexao.DBConnection;
import controlador.FuncionarioList;
import controlador.ProdutosTelaController;
import modelo.Funcao;
import modelo.Funcionario;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;


/**
 * FXML Controller class
 *
 * @author bacar
 */
public class FuncionarioTelaController implements Initializable {

    
    private int idFuncao; //atributo para pegar os ids das funcoes

    //conexao
    private Connection conexao = null;
    
    //PREPARED Statment
    private PreparedStatement ps,ps1 = null;
    private ResultSet rs,rs1 = null;
    
    //para pegar todas as funcoes
    private ObservableList<Funcao> funcao;
    private  ObservableList<FuncionarioList> funcionarioList;
    
    //atributos funcionarios
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
    
    
    //componentes da interface do funcionario
    private Button pane_produto_btn_voltar;
    @FXML
    private StackPane stckPane_conteiner_funcionarios;
    @FXML
    private Button pane_btn_voltar;
    @FXML
    private Button pane_btn_fechar;
    @FXML
    private Button btn_func_adicionar;
    
     @FXML
    private ComboBox<Funcao> funcionario_cargo;
     
     // Tabela componentes
         @FXML
    private TableView<FuncionarioList> tabelaFuncionario;
    @FXML
    private TableColumn<FuncionarioList, Integer> col_Cod_Funcionário;
    @FXML
    private TableColumn<FuncionarioList, String> col_Nome;
    @FXML
    private TableColumn<FuncionarioList, String> col_BI;
    @FXML
    private TableColumn<FuncionarioList, String> col_Endereco;
    @FXML
    private TableColumn<FuncionarioList, String> col_Telefone_Principal;
    @FXML
    private TableColumn<FuncionarioList, String> col_Telefone_Opcional;
    @FXML
    private TableColumn<FuncionarioList, Integer> col_Cargo;
    @FXML
    private TableColumn<FuncionarioList, Double> col_Salario;
     
    
    
    Funcionario funcionario = new Funcionario();    
    @FXML
    private TableColumn<?, ?> col_Data_Nascimento;
    @FXML
    private Label hora;
    
    //label que sera visivel quando um campo tiver erro
    @FXML
    private Label erro_pesquisa;
    @FXML
    private Label erro_cargo;
    @FXML
    private Label erro_salario;
    @FXML
    private Label erro_telef1;
    @FXML
    private Label erro_endereco;
    @FXML
    private Label erro_dataNasc;
    @FXML
    private Label erro_bi;
    @FXML
    private Label erro_nome;
    @FXML
    private Label erro_telef2;
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        conexao = DBConnection.getConnection();
        
        
        mudarColunaTabFuncionario();
        funcionarioList = FXCollections.observableArrayList();
          
        funcao = FXCollections.observableArrayList();
        try {
            ps = conexao.prepareStatement("select *from funcao");
            ps1 = conexao.prepareStatement("select *from funcionario ");
            rs1 = ps1.executeQuery();
            rs = ps.executeQuery();
            System.err.println("entrou aqui");
            while (rs1.next()) {     
                System.err.println("entrou ya");
                System.out.println(rs1.getString(2)+" dados");
              funcionarioList.add(new FuncionarioList(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getDate(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getInt(8), rs1.getDouble(9)));
            }
            tabelaFuncionario.setItems(funcionarioList);
            
            while (rs.next()) {
                funcao.add(new Funcao(rs.getInt(1),rs.getString(2))); //adiciona na lista o id da funcao e a funcao
            }
            funcionario_cargo.setItems(funcao); // manda os dados na comboBox de cargos
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioTelaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mudarColunaTabelaParaTextFild();
                
        funcionario_cargo.setConverter(new StringConverter<Funcao>() { //estilizar as funcoes dos funcionarios antes de mandar na comboBox
            @Override
            public String toString(Funcao cargo) {
                return cargo.getDescricao(); //RETORNA APENAS O NOME DAS FUNCAO
                
            }

            @Override
            public Funcao fromString(String string) {
                return null;
            }
        });
        
        //recuperar o id da funcao
        funcionario_cargo.valueProperty().addListener((observable, oldValue, newValue) -> {
           
            if (newValue != null) {
                idFuncao = newValue.getIdFuncao(); // aqui é a parte que o bandido vira artista e recupera o codigo da funcao
            }
            
        });
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
        System.err.println("passou");
        try {
            root = FXMLLoader.load(getClass().getResource("/view/PessoalTela.fxml"));
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

    @FXML
    private void registrarFuncionario(ActionEvent event) throws SQLException {
        
        boolean txtNomeVazio = ValidacaoCampos.textFieldNaoEstaVazia(funcionario_nome, erro_nome, "Preencha o campo nome *");
        boolean txtBiVazio = ValidacaoCampos.textFieldNaoEstaVazia(funcionario_bilheteIdent, erro_bi, "Preencha o campo BI *");
        boolean txtDataNasc = ValidacaoCampos.campoData(funcionario_data_nasc, erro_dataNasc, "Preencha o campo Data Nascimento *");
        boolean txtEndereco = ValidacaoCampos.textFieldNaoEstaVazia(funcionario_endereco, erro_endereco, "Preencha o campo Endereço *");
        boolean txtTelef1 = ValidacaoCampos.isCampoTextoTipoNumero(funcionario_telefone1, erro_telef1 , "Preencha o campo com números *");
        boolean txtCargo = ValidacaoCampos.comboBoxValor(funcionario_cargo, erro_cargo, "Preencha o campo Cargo *");
        boolean txtSalario = ValidacaoCampos.isCampoTextoTipoNumero(funcionario_salario, erro_salario, "Preencha o campo com números *");
        
        if(txtNomeVazio && txtBiVazio && txtDataNasc && txtEndereco && txtTelef1 && txtCargo && txtSalario){
        
        funcionario.setNome(funcionario_nome.getText());
        funcionario.setBi(funcionario_bilheteIdent.getText());
        funcionario.setDataNasc(java.sql.Date.valueOf(funcionario_data_nasc.getValue()));
        funcionario.setEndereco(funcionario_endereco.getText());
        funcionario.setTelefone1(funcionario_telefone1.getText());
        funcionario.setTelefone2(funcionario_telefone2.getText());
        funcionario.setCargo(idFuncao);
        funcionario.setSalario(Double.valueOf(funcionario_salario.getText()));

        
         String sql = "insert into funcionario(nome,bi,dataNascimento,endereco,telefone1,telefone2,cargo,salario) values (?,?,?,?,?,?,?,?)";

        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getBi());
            ps.setDate(3,funcionario.getDataNasc());
            ps.setString(4, funcionario.getEndereco());
            ps.setString(5, funcionario.getTelefone1());
            ps.setString(6, funcionario.getTelefone2());
            ps.setInt(7, funcionario.getCargo());
            ps.setDouble(8, funcionario.getSalario());
            
           
            int i = ps.executeUpdate();          
            
            if (i == 1) {
                mudarColunaTabFuncionario();
                funcionarioList = FXCollections.observableArrayList();
          
        try {
            ps1 = conexao.prepareStatement("select *from funcionario ");
            rs1 = ps1.executeQuery();
           while (rs1.next()) {     
               funcionarioList.add(new FuncionarioList(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getDate(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getInt(8), rs1.getDouble(9)));
            }
            tabelaFuncionario.setItems(funcionarioList);
            controlador.MetodosComuns.mensagem(stckPane_conteiner_funcionarios, "Funcionario adicionado com sucesso no Sistema");
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioTelaController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
            
                    
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioTelaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            ps.close();
            
        }
        } 
        
    }
    
    private void mudarColunaTabFuncionario(){
         //pegar osvalores para listar na tabela funcionario
        col_Cod_Funcionário.setCellValueFactory(new PropertyValueFactory<>("idfun"));
        col_Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        col_BI.setCellValueFactory(new PropertyValueFactory<>("bi"));
        col_Data_Nascimento.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
        col_Endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        col_Telefone_Principal.setCellValueFactory(new PropertyValueFactory<>("telefone1"));
        col_Telefone_Opcional.setCellValueFactory(new PropertyValueFactory<>("telefone2"));
        col_Cargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        col_Salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
    }
    
    private void carregarDadosFuncionarioBaseDados(){
        try {
            
            ps = conexao.prepareStatement("select *from funcionario ");
            rs = ps.executeQuery();
            while (rs.next()) {     
              funcionarioList.add(new FuncionarioList(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getDate(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getInt(8), rs.getDouble(9)));
            }
        } catch (SQLException e) {
            Logger.getLogger(FuncionarioTelaController.class.getName()).log(Level.SEVERE,null,e);
        }
        tabelaFuncionario.setItems(funcionarioList);
    }
    
    
    private void mudarColunaTabelaParaTextFild(){
        tabelaFuncionario.setOnMouseClicked(e -> {
            FuncionarioList funlistagem = tabelaFuncionario.getItems().get(tabelaFuncionario.getSelectionModel().getSelectedIndex());
            funcionario_nome.setText(funlistagem.getNome());
            funcionario_bilheteIdent.setText(funlistagem.getBi());
            funcionario_data_nasc.setValue(funlistagem.getDataNasc().toLocalDate());
            funcionario_endereco.setText(funlistagem.getEndereco());
            funcionario_telefone1.setText(funlistagem.getTelefone1());
            funcionario_telefone2.setText(funlistagem.getTelefone2());
            
            funcionario_salario.setText(String.valueOf(funlistagem.getSalario()));
        });
    }

    @FXML
    private void limparCampos(MouseEvent event) {
        
        String textoNulo ="";
        
            funcionario_idPesquisa.getText();
            funcionario_nome.getText();
            funcionario_bilheteIdent.getText();
            funcionario_endereco.getText();
            funcionario_telefone1.getText();
            funcionario_telefone2.getText();
            funcionario_salario.getText();
            
            funcionario_idPesquisa.setText(textoNulo);
            funcionario_nome.setText(textoNulo);
            funcionario_bilheteIdent.setText(textoNulo);
            funcionario_data_nasc.setValue(null);
            funcionario_endereco.setText(textoNulo);
            funcionario_telefone1.setText(textoNulo);
            funcionario_telefone2.setText(textoNulo);
            funcionario_salario.setText(textoNulo);
            
           
        
    }

    /*
    @FXML
    private void apagarFuncionario(ActionEvent event) throws SQLException {
        
        //RECUPERA O ID DO FUNCIONARIO
        FuncionarioList funlistagem = tabelaFuncionario.getItems().get(tabelaFuncionario.getSelectionModel().getSelectedIndex());
        funcionario.setIdfun(funlistagem.getIdfun());
            
         String sql = "delete from funcionario where idfuncionario = ?";

        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, funcionario.getIdfun());

            int i = ps.executeUpdate();
            if (i == 1) {
                     mudarColunaTabFuncionario();
                funcionarioList = FXCollections.observableArrayList();
          
        try {
            ps1 = conexao.prepareStatement("select *from funcionario ");
            rs1 = ps1.executeQuery();
           while (rs1.next()) {     
          
                System.out.println(rs1.getString(2)+" dados");
              funcionarioList.add(new FuncionarioList(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getDate(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getInt(8), rs1.getDouble(9)));
            }
            tabelaFuncionario.setItems(funcionarioList);
             
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioTelaController.class.getName()).log(Level.SEVERE, null, ex);
        } 
            }
            System.err.println("nada");
                    
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioTelaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            ps.close();
        }
        
    }
*/
    @FXML
    private void pesquisarFuncionario(ActionEvent event) throws SQLException {
         //RECUPERA O ID DO FUNCIONARIO
         boolean txtPesquisaId = ValidacaoCampos.isCampoId(funcionario_idPesquisa, erro_pesquisa, "Preencha o campo com número *");
         
         System.err.println(txtPesquisaId);
         if (txtPesquisaId) {
            
            funcionario.setIdfun(Integer.valueOf(funcionario_idPesquisa.getText()));
            System.err.println(funcionario.getIdfun());
         String sql = "select *from funcionario where idfuncionario = ?";

        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, funcionario.getIdfun());

            rs = ps.executeQuery();
            if (rs.next()) {
                     mudarColunaTabFuncionario();
                funcionarioList = FXCollections.observableArrayList();
          
        try {
            ps1 = conexao.prepareStatement("select *from funcionario where idfuncionario = ?");
            ps1.setInt(1,funcionario.getIdfun());
            rs1 = ps1.executeQuery();
           while (rs1.next()) {     

              funcionarioList.add(new FuncionarioList(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getDate(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getInt(8), rs1.getDouble(9)));
            }
            tabelaFuncionario.setItems(funcionarioList);
             
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioTelaController.class.getName()).log(Level.SEVERE, null, ex);
        } 
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioTelaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            ps.close();
        }
    }
      
                
    }

    @FXML
    private void tabelaClick(MouseEvent event) {
    }

    @FXML
    private void listarFuncionario(ActionEvent event) {
        funcionarioList.clear();
        try {
            ps1 = conexao.prepareStatement("select *from funcionario");
            rs1 = ps1.executeQuery();
           while (rs1.next()) {     
              funcionarioList.add(new FuncionarioList(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getDate(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getInt(8), rs1.getDouble(9)));
            }
            tabelaFuncionario.setItems(funcionarioList);
             
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioTelaController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}

