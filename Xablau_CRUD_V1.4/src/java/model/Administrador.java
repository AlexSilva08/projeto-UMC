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
public class Administrador extends Pessoa{
    private int codAdm;

    public int getCodAdm() {
        return codAdm;
    }

    public void setCodAdm(int codAdm) {
        this.codAdm = codAdm;
    }

    public Administrador() {
    }

    public Administrador(int codAdm) {
        this.codAdm = codAdm;
    }

    public Administrador(int codAdm, String nome, String cpf, String dataNasc, String tel) {
        super(nome, cpf, dataNasc, tel);
        this.codAdm = codAdm;
    }
    
    
}
