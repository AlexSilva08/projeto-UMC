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
public class Fase {
    private int codFase;
    private String descricao;

    public int getCodFase() {
        return codFase;
    }

    public void setCodFase(int codFase) {
        this.codFase = codFase;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fase() {
    }

    public Fase(int codFase, String descricao) {
        this.codFase = codFase;
        this.descricao = descricao;
    }
}
