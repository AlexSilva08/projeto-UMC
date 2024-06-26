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
public class Pessoa {
    private String nome;
    private String cpf;
    private String dataNasc;
    private String tel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String dataNasc, String tel) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.tel = tel;
    }
    
    
}
