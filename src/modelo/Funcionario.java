/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author bacar
 */
public class Funcionario {
    
    private int idfun;
    private String nome;
    private String bi;
    private Date dataNasc;
    private String endereco;
    private String telefone1;
    private String telefone2;
    private int cargo;
    private double salario;

    public Funcionario(String nome, String bi,Date dataNasc , String endereco, String telefone1, String telefone2, int cargo, double salario) {
        this.nome = nome;
        this.bi = bi;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Funcionario() {
        
    }

    public Funcionario(int idfun, String nome, String bi, String endereco, String telefone1, String telefone2, int cargo, double salario) {
        this.idfun = idfun;
        this.nome = nome;
        this.bi = bi;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cargo = cargo;
        this.salario = salario;
    }


    public int getIdfun() {
        return idfun;
    }

    public void setIdfun(int idfun) {
        this.idfun = idfun;
    }

   
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    
}
