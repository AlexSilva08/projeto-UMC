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
public class NotaFinal {
    
    private Nota codNota;
    private double notaFinal;
    private double somaApresentacao;
    private double somaTecnica;
    private double somaNotas;

    public Nota getNota() {
        return codNota;
    }

    public void setNota(Nota codNota) {
        this.codNota = codNota;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public double getSomaApresentacao() {
        return somaApresentacao;
    }

    public void setSomaApresentacao(double somaApresentacao) {
        this.somaApresentacao = somaApresentacao;
    }

    public double getSomaTecnica() {
        return somaTecnica;
    }

    public void setSomaTecnica(double somaTecnica) {
        this.somaTecnica = somaTecnica;
    }

    public double getSomaNotas() {
        return somaNotas;
    }

    public void setSomaNotas(double somaNotas) {
        this.somaNotas = somaNotas;
    }

    public NotaFinal() {
    }

    public NotaFinal(Nota codNota, double notaFinal, double somaApresentacao, double somaTecnica, double somaNotas) {
        this.codNota = codNota;
        this.notaFinal = notaFinal;
        this.somaApresentacao = somaApresentacao;
        this.somaTecnica = somaTecnica;
        this.somaNotas = somaNotas;
    }
    
    
}
