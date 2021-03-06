/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author bacar
 */
public class ValidacaoCampos {
    
    public static boolean textFieldNaoEstaVazia(TextField tf){
        boolean estado = false;
        if (tf.getText().length() != 0 || !tf.getText().isEmpty())
            estado = true;
        return estado;
    }
    
    public static boolean textFieldNaoEstaVazia(TextField tf,Label lb,String mensagemErro){
        boolean estado = true;
        String mensagem = null;
        //tf.getStyleClass().remove("erro");
        if (!textFieldNaoEstaVazia(tf)){
            estado = false;
            mensagem = mensagemErro;   
            
          //  tf.getStyleClass().add("erro");
        }
        System.err.println(estado);
        lb.setText(mensagem);
        return estado;
    }
    
    public static boolean campoData(DatePicker datepicker){
        
         boolean estado = false;
        if (datepicker.getValue() != null)
            estado = true;
        System.err.println(estado);
        return estado;
        
    }   
    
    public static boolean campoData(DatePicker data,Label lb,String mensagemErro){
        
         boolean estado = true;
        String mensagem = null;
        // data.getStyleClass().remove("erro");
        if (!campoData(data)){
            estado = false;
            mensagem = mensagemErro;  
          //  data.getStyleClass().add("erro");
        }
        System.err.println(estado);
        lb.setText(mensagem);
        return estado;
        
    }
    
    public static boolean comboBoxValor(ComboBox comboBox){
        
         boolean estado = false;
        if (comboBox.getValue() != null)
            estado = true;
        System.err.println(estado);
        return estado;
        
    }   
    
    public static boolean comboBoxValor(ComboBox cb,Label lb,String mensagemErro){
        
         boolean estado = true;
        String mensagem = null;
        //cb.getStyleClass().remove("erro");
        if (!comboBoxValor(cb)){
            estado = false;
            mensagem = mensagemErro;  
         //   cb.getStyleClass().add("erro");
        }
        System.err.println(estado);
        lb.setText(mensagem);
        return estado;
        
    }
    
    public static boolean isCampoTextoTipoNumero(TextField tf){
        
        boolean estado = false;
        if(tf.getText().matches("([0-9]+(\\.[0-9]+)?)+")){
        estado = true;              
        return estado;
        }
        return estado;
        
    }
    
    public static boolean isCampoTextoTipoNumero(TextField tf, Label lb, String mensagemErro){
        
        boolean estado = true;
        String mensagem= null;
       // tf.getStyleClass().remove("erro");
        if(!isCampoTextoTipoNumero(tf)){
            estado = true;              
            mensagem = mensagemErro;
         //   tf.getStyleClass().add("erro");
        }
        lb.setText(mensagem);
        return estado;
    } 
    
    public static boolean isCampoId(TextField tf, Label lb, String mensagemErro){
        
        boolean estado = true;
        String mensagem= null;
       // tf.getStyleClass().remove("erro");
        if(!isCampoTextoTipoNumero(tf)){
            estado = false;              
            mensagem = mensagemErro;
         //   tf.getStyleClass().add("erro");
        }
        lb.setText(mensagem);
        return estado;
    } 
}
