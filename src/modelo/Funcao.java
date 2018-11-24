/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author bacar
 */
public class Funcao {
    
    private int idFuncao;
    private String descricao;

    public Funcao(int idFuncao, String descricao) {
        this.idFuncao = idFuncao;
        this.descricao = descricao;
    }
    
    

    public int getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
