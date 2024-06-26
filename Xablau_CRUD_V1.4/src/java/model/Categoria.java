/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 11181502562
 */
public class Categoria {
    
    private int codCategoria;
    private String descCategoria;
    private String idade;
    private String sexo;
    private Atleta atleta;

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public Categoria() {
    }

    public Categoria(int codCategoria, String descCategoria, String idade, String sexo, Atleta atleta) {
        this.codCategoria = codCategoria;
        this.descCategoria = descCategoria;
        this.idade = idade;
        this.sexo = sexo;
        this.atleta = atleta;
    }
}
