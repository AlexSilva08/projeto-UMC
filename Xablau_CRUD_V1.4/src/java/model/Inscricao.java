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
public class Inscricao {
    private Integer atleta_codAtleta;
    private Integer competicao_categoria_codCategoria;
    private Integer competicao_categoria_codCompeticao;
    private Integer notaFinal_codNotaFinal;
    private String inscricaoAtiva;

    public Integer getAtleta_codAtleta() {
        return atleta_codAtleta;
    }

    public void setAtleta_codAtleta(Integer atleta_codAtleta) {
        this.atleta_codAtleta = atleta_codAtleta;
    }

    public Integer getCompeticao_categoria_codCategoria() {
        return competicao_categoria_codCategoria;
    }

    public void setCompeticao_categoria_codCategoria(Integer competicao_categoria_codCategoria) {
        this.competicao_categoria_codCategoria = competicao_categoria_codCategoria;
    }

    public Integer getCompeticao_categoria_codCompeticao() {
        return competicao_categoria_codCompeticao;
    }

    public void setCompeticao_categoria_codCompeticao(Integer competicao_categoria_codCompeticao) {
        this.competicao_categoria_codCompeticao = competicao_categoria_codCompeticao;
    }

    public Integer getNotaFinal_codNotaFinal() {
        return notaFinal_codNotaFinal;
    }

    public void setNotaFinal_codNotaFinal(Integer notaFinal_codNotaFinal) {
        this.notaFinal_codNotaFinal = notaFinal_codNotaFinal;
    }

    public String getInscricaoAtiva() {
        return inscricaoAtiva;
    }

    public void setInscricaoAtiva(String inscricaoAtiva) {
        this.inscricaoAtiva = inscricaoAtiva;
    }

    public Inscricao() {
    }

    public Inscricao(Integer atleta_codAtleta, Integer competicao_categoria_codCategoria, Integer competicao_categoria_codCompeticao, Integer notaFinal_codNotaFinal, String inscricaoAtiva) {
        this.atleta_codAtleta = atleta_codAtleta;
        this.competicao_categoria_codCategoria = competicao_categoria_codCategoria;
        this.competicao_categoria_codCompeticao = competicao_categoria_codCompeticao;
        this.notaFinal_codNotaFinal = notaFinal_codNotaFinal;
        this.inscricaoAtiva = inscricaoAtiva;
    }
}
