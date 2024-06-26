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
public class Arbitro extends Pessoa{
    private int codArbitro;

    public int getCodArbitro() {
        return codArbitro;
    }

    public void setCodArbitro(int codArbitro) {
        this.codArbitro = codArbitro;
    }

    public Arbitro() {
    }

    public Arbitro(int codArbitro) {
        this.codArbitro = codArbitro;
    }

    public Arbitro(int codArbitro, String nome, String cpf, String dataNasc, String tel) {
        super(nome, cpf, dataNasc, tel);
        this.codArbitro = codArbitro;
    }
    
}
