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
public class Competicao {
    
    private int codCompeticao;
    private String nomeCompeticao;
    private String endereco;
    private String dataCompeticao;
    private String horario;
    private Atleta atleta;
    private Categoria categoria;

    public int getCodCompeticao() {
        return codCompeticao;
    }

    public void setCodCompeticao(int codCompeticao) {
        this.codCompeticao = codCompeticao;
    }

    public String getNomeCompeticao() {
        return nomeCompeticao;
    }

    public void setNomeCompeticao(String nomeCompeticao) {
        this.nomeCompeticao = nomeCompeticao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataCompeticao() {
        return dataCompeticao;
    }

    public void setDataCompeticao(String dataCompeticao) {
        this.dataCompeticao = dataCompeticao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Competicao() {
    }

    public Competicao(int codCompeticao, String nomeCompeticao, String endereco, String dataCompeticao, String horario, Atleta atleta, Categoria categoria) {
        this.codCompeticao = codCompeticao;
        this.nomeCompeticao = nomeCompeticao;
        this.endereco = endereco;
        this.dataCompeticao = dataCompeticao;
        this.horario = horario;
        this.atleta = atleta;
        this.categoria = categoria;
    }

    
}
