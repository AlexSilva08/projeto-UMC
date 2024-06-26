/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Inscricao;
import util.FabricaConexao;

public class InscricaoDAO {
    
    public void CadastrarInscricao(Inscricao inscricaoCad) throws ClassNotFoundException, SQLException{
        //Construir string sql bem formada e vinculado com a conexao
        try ( //Carregar drive e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            try{
            //Construir string sql bem formada e vinculado com a conexao
            
            String sql = "insert into notaFinal(notaFinal, somaApresentacao, somaTecnica, somaNotas) values('0.0','0.0','0.0','0.0');";
            PreparedStatement comandoCad = con.prepareStatement(sql);
            
            //executar a instrução e tratar resultado
            comandoCad.execute();
            
            String sql2 = "select max(codNotaFinal) from notaFinal;";
            PreparedStatement selectById = con.prepareStatement(sql2);
            //executar e tratar resultados
            ResultSet resultado = selectById.executeQuery();
            
            if (resultado.next()) {
                inscricaoCad.setNotaFinal_codNotaFinal(resultado.getInt("max"));
            }
            
            String sql3 = "insert into inscricao(atleta_codAtleta, competicao_categoria_codCategoria, competicao_categoria_codCompeticao, notaFinal_codNotaFinal) values(?,?,?,?);";
            PreparedStatement comandoCad2 = con.prepareStatement(sql3);
            comandoCad2.setInt(1, inscricaoCad.getAtleta_codAtleta());
            comandoCad2.setInt(2, inscricaoCad.getCompeticao_categoria_codCategoria());
            comandoCad2.setInt(3, inscricaoCad.getCompeticao_categoria_codCompeticao());
            comandoCad2.setInt(4, inscricaoCad.getNotaFinal_codNotaFinal());
            
            //executar a instrução e tratar resultado
            comandoCad2.execute();
            
            //fecha conexao
            System.out.println("CADASTRADO COM SUCESSO");
            }catch(SQLException e){
                System.out.println("IH MEU PARÇA! ERRO AO CADASTRAR: " + e);
            }
        }
    }

    public List<Inscricao> consultarInscricao() throws ClassNotFoundException, SQLException {
        ArrayList<Inscricao> listaInscricao;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select * from inscricao;";
            PreparedStatement comando = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comando.executeQuery();
            listaInscricao = new ArrayList<>();
            while (resultado.next()) {
                Inscricao inscricaoAll = new Inscricao();
                inscricaoAll.setAtleta_codAtleta(resultado.getInt("atleta_codAtleta"));
                inscricaoAll.setCompeticao_categoria_codCategoria(resultado.getInt("competicao_categoria_codCategoria"));
                inscricaoAll.setCompeticao_categoria_codCompeticao(resultado.getInt("competicao_categoria_codCompeticao"));
                inscricaoAll.setNotaFinal_codNotaFinal(resultado.getInt("notaFinal_codNotaFinal"));
                listaInscricao.add(inscricaoAll);
            }
            //fecha conexao
        }
        return listaInscricao;
    }
    
    public List<Inscricao> PuxarInscricao() throws ClassNotFoundException, SQLException {
        ArrayList<Inscricao> listaInscricao;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select * from inscricao where inscricaoAtiva = 'ativa';";
            PreparedStatement comando = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comando.executeQuery();
            listaInscricao = new ArrayList<>();
            while (resultado.next()) {
                Inscricao inscricaoAll = new Inscricao();
                inscricaoAll.setAtleta_codAtleta(resultado.getInt("atleta_codAtleta"));
                inscricaoAll.setCompeticao_categoria_codCategoria(resultado.getInt("competicao_categoria_codCategoria"));
                inscricaoAll.setCompeticao_categoria_codCompeticao(resultado.getInt("competicao_categoria_codCompeticao"));
                inscricaoAll.setNotaFinal_codNotaFinal(resultado.getInt("notaFinal_codNotaFinal"));
                listaInscricao.add(inscricaoAll);
            }
            //fecha conexao
        }
        return listaInscricao;
    }
    
    public void SelecionarInscricao(Inscricao inscricaoSelect) throws ClassNotFoundException, SQLException{
        //Construir string sql bem formada e vinculado com a conexao
        try ( //Carregar drive e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            try{
            //Construir string sql bem formada e vinculado com a conexao
            
            String sql = "update inscricao set inscricaoAtiva = 'ativa' where atleta_codAtleta = ? and inscricaoAtiva is null;";
            PreparedStatement comandoSelect = con.prepareStatement(sql);
            comandoSelect.setInt(1, inscricaoSelect.getAtleta_codAtleta());
            
            //executar a instrução e tratar resultado
            comandoSelect.execute();
            //update NotaFinal set fase_codFase = ? where atleta_codAtleta = ? and fase_codFase is null;
            String sql2 = "update NotaFinal set fase_codFase = ? where fase_codFase is null;";
            PreparedStatement comandoSelect2 = con.prepareStatement(sql2);
            comandoSelect2.setInt(1, inscricaoSelect.getCompeticao_categoria_codCategoria());
            
            //executar a instrução e tratar resultado
            comandoSelect2.execute();
            
            //fecha conexao
            }catch(SQLException e){
                System.out.println("IH MEU PARÇA! ERRO AO CADASTRAR: " + e);
            }
        }
    }
    
    public List<Inscricao> consultarAllNotas() throws ClassNotFoundException, SQLException {
        ArrayList<Inscricao> listaInscricao;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select * from inscricao where inscricaoAtiva = 'ativa';";
            PreparedStatement comando = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comando.executeQuery();
            listaInscricao = new ArrayList<>();
            while (resultado.next()) {
                Inscricao inscricaoAll = new Inscricao();
                inscricaoAll.setAtleta_codAtleta(resultado.getInt("atleta_codAtleta"));
                inscricaoAll.setCompeticao_categoria_codCategoria(resultado.getInt("competicao_categoria_codCategoria"));
                inscricaoAll.setNotaFinal_codNotaFinal(resultado.getInt("notaFinal_codNotaFinal"));
                listaInscricao.add(inscricaoAll);
            }
            //fecha conexao
        }
        return listaInscricao;
    }
}