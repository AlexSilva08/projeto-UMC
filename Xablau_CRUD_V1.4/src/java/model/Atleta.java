package model;

public class Atleta extends Pessoa {

    private int codAtleta;
    private String graduacao;
    private String academia;

    public int getCodAtleta() {
        return codAtleta;
    }

    public void setCodAtleta(int codAtleta) {
        this.codAtleta = codAtleta;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public Atleta() {
    }

    public Atleta(int codAtleta, String graduacao, String academia) {
        this.codAtleta = codAtleta;
        this.graduacao = graduacao;
        this.academia = academia;
    }

    public Atleta(int codAtleta, String graduacao, String academia, String nome, String cpf, String dataNasc, String tel) {
        super(nome, cpf, dataNasc, tel);
        this.codAtleta = codAtleta;
        this.graduacao = graduacao;
        this.academia = academia;
    }

    

}
