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
public class Nota {
    
    private int codNota;
    private double tecnica;
    private double apresentacao;
    private int situacaoTecnica;
    private int situacaoApresentacao;
    private String codArbitro;
    private int notaFinal_codNotaFinal;

    public int getCodNota() {
        return codNota;
    }

    public void setCodNota(int codNota) {
        this.codNota = codNota;
    }
    
    public double getTecnica() {
        return tecnica;
    }

    public void setTecnica(double tecnica) {
        this.tecnica = tecnica;
    }

    public double getApresentacao() {
        return apresentacao;
    }

    public void setApresentacao(double apresentacao) {
        this.apresentacao = apresentacao;
    }

    public int getSituacaoTecnica() {
        return situacaoTecnica;
    }

    public void setSituacaoTecnica(int situacaoTecnica) {
        this.situacaoTecnica = situacaoTecnica;
    }

    public int getSituacaoApresentacao() {
        return situacaoApresentacao;
    }

    public void setSituacaoApresentacao(int situacaoApresentacao) {
        this.situacaoApresentacao = situacaoApresentacao;
    }

    public String getCodArbitro() {
        return codArbitro;
    }

    public void setCodArbitro(String codArbitro) {
        this.codArbitro = codArbitro;
    }

    public int getNotaFinal_codNotaFinal() {
        return notaFinal_codNotaFinal;
    }

    public void setNotaFinal_codNotaFinal(int notaFinal_codNotaFinal) {
        this.notaFinal_codNotaFinal = notaFinal_codNotaFinal;
    }

    public Nota() {
    }

    public Nota(int codNota, double tecnica, double apresentacao, int situacaoTecnica, int situacaoApresentacao, String codArbitro, int notaFinal_codNotaFinal) {
        this.codNota = codNota;
        this.tecnica = tecnica;
        this.apresentacao = apresentacao;
        this.situacaoTecnica = situacaoTecnica;
        this.situacaoApresentacao = situacaoApresentacao;
        this.codArbitro = codArbitro;
        this.notaFinal_codNotaFinal = notaFinal_codNotaFinal;
    }
}
