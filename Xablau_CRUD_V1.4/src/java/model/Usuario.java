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
public class Usuario {
    
    private int codUsuario;
    private String login;
    private String senha;
    private String nivelAcesso;

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public Usuario() {
    }

    public Usuario(int codUsuario, String login, String senha, String nivelAcesso) {
        this.codUsuario = codUsuario;
        this.login = login;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }
}
