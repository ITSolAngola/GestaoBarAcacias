/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosComuns;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 *
 * @author bacar
 */
public class MetodosComuns {
    
    public static void mensagemFecharSair(Pane dialogoPane) {
        
            JFXDialogLayout mensagemLayout = new JFXDialogLayout();
        mensagemLayout.setHeading(new Text("Saida do Sistema"));
        mensagemLayout.setBody(new Text("Tens a certeza que pretendes fechar ?"));
        
        JFXButton sim = new JFXButton("Sim");
        JFXButton cancelar = new JFXButton("Cancelar");
        
        JFXDialog dialog = new JFXDialog((StackPane) dialogoPane,mensagemLayout,JFXDialog.DialogTransition.CENTER);
        
        sim.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               System.exit(0);
            }
        });
        
        cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               dialog.close();
            }
        });
        
        mensagemLayout.setActions(sim,cancelar);
        dialog.show();
    
        
    }
    
}
