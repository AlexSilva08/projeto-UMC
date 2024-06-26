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
import model.Nota;
import util.FabricaConexao;

/**
 *
 * @author 11181502562
 */
public class NotaDAO {

    public void CadastrarNota(Nota notaCad, Inscricao inscricaoCad) throws ClassNotFoundException, SQLException {
        //Construir string sql bem formada e vinculado com a conexao
        try ( //Carregar drive e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            try {
                //Construir string sql bem formada e vinculado com a conexao
                String sql = "insert into nota(tecnica, apresentacao, situacaoTecnica, situacaoApresentacao, arbitro_codArbitro, notaFinal_codNotaFinal) values(?,?,'Computada','Computada',?,?);";
                PreparedStatement comandoCad = con.prepareStatement(sql);
                comandoCad.setDouble(1, notaCad.getTecnica());
                comandoCad.setDouble(2, notaCad.getApresentacao());
                comandoCad.setInt(3, notaCad.getCodNota());
                comandoCad.setInt(4, inscricaoCad.getNotaFinal_codNotaFinal());
                //executar a instrução e tratar resultado
                comandoCad.execute();
                
                //fecha conexao
                System.out.println("CADASTRADO COM SUCESSO");
            } catch (SQLException e) {
                System.out.println("IH MEU PARÇA! ERRO AO CADASTRAR: " + e);
            }
        }
    }

    public Nota consultNotaById(Nota notaById) throws ClassNotFoundException, SQLException {
        //Construir String sql bem formada e vinculada com a conexao
        try ( //Carregar Driver e criar conexao
            Connection con = FabricaConexao.getConexao()) {
            //Construir String sql bem formada e vinculada com a conexao
            String sql = "select * from nota where ?";
            PreparedStatement comandoById = con.prepareStatement(sql);
            comandoById.setInt(1, notaById.getCodNota());
            //comandoById.setDouble(2, notaById.getTecnica());
            //comandoById.setDouble(2, notaById.getApresentacao());
            
            //executar e tratar resultados
            ResultSet resultado = comandoById.executeQuery();

            notaById.setCodNota(resultado.getInt("codNota"));
            notaById.setTecnica(resultado.getDouble("tecnica"));
            notaById.setApresentacao(resultado.getDouble("apresentacao"));
            notaById.setSituacaoTecnica(resultado.getInt("situacaoTecnica"));
            notaById.setSituacaoApresentacao(resultado.getInt("situacaoApresentacao"));
            //fecha conexao
        }
        
        return notaById;
    }
    
    public List<Nota> PuxarNota1() throws ClassNotFoundException, SQLException {
        ArrayList<Nota> listanotaAll1;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select tecnica, apresentacao from nota where codNota = '1';";
            PreparedStatement comandoNota1 = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comandoNota1.executeQuery();
            listanotaAll1 = new ArrayList<>();
            while (resultado.next()) {
                Nota notaAll = new Nota();
                notaAll.setTecnica(resultado.getDouble("tecnica"));
                notaAll.setApresentacao(resultado.getDouble("apresentacao"));
                listanotaAll1.add(notaAll);
            }
            //fecha conexao
        }
        return listanotaAll1;
    }

    public List<Nota> PuxarNota2() throws ClassNotFoundException, SQLException {
        ArrayList<Nota> listanotaAll2;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select tecnica, apresentacao from nota where codNota = '2';";
            PreparedStatement comandoNota2 = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comandoNota2.executeQuery();
            listanotaAll2 = new ArrayList<>();
            while (resultado.next()) {
                Nota notaAll = new Nota();
                notaAll.setTecnica(resultado.getDouble("tecnica"));
                notaAll.setApresentacao(resultado.getDouble("apresentacao"));
                listanotaAll2.add(notaAll);
            }
            //fecha conexao
        }
        return listanotaAll2;
    }

    public List<Nota> PuxarNota3() throws ClassNotFoundException, SQLException {
        ArrayList<Nota> listanotaAll3;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select tecnica, apresentacao from nota where codNota = '3';";
            PreparedStatement comandoNota3 = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comandoNota3.executeQuery();
            listanotaAll3 = new ArrayList<>();
            while (resultado.next()) {
                Nota notaAll = new Nota();
                notaAll.setTecnica(resultado.getDouble("tecnica"));
                notaAll.setApresentacao(resultado.getDouble("apresentacao"));
                listanotaAll3.add(notaAll);
            }
            //fecha conexao
        }
        return listanotaAll3;
    }

    public List<Nota> PuxarNota4() throws ClassNotFoundException, SQLException {
        ArrayList<Nota> listanotaAll4;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select tecnica, apresentacao from nota where codNota = '4';";
            PreparedStatement comandoNota4 = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comandoNota4.executeQuery();
            listanotaAll4 = new ArrayList<>();
            while (resultado.next()) {
                Nota notaAll = new Nota();
                notaAll.setTecnica(resultado.getDouble("tecnica"));
                notaAll.setApresentacao(resultado.getDouble("apresentacao"));
                listanotaAll4.add(notaAll);
            }
            //fecha conexao
        }
        return listanotaAll4;
    }

    public List<Nota> PuxarNota5() throws ClassNotFoundException, SQLException {
        ArrayList<Nota> listanotaAll5;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select tecnica, apresentacao from nota where codNota = '5';";
            PreparedStatement comandoNota5 = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comandoNota5.executeQuery();
            listanotaAll5 = new ArrayList<>();
            while (resultado.next()) {
                Nota notaAll = new Nota();
                notaAll.setTecnica(resultado.getDouble("tecnica"));
                notaAll.setApresentacao(resultado.getDouble("apresentacao"));
                listanotaAll5.add(notaAll);
            }
            //fecha conexao
        }
        return listanotaAll5;
    }
    
    public void alterarAtributoTec(Nota mudarSituacaoTecnica) throws ClassNotFoundException, SQLException {
        //Construir string sql bem formada e vinculado com a conexao
        try ( //Carregar drive e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            try {
                //Construir string sql bem formada e vinculado com a conexao
                String sql = "update notaFinal set situacaoTecnica = 'Descartada' where tecnica = ?;";
                PreparedStatement comandoAlt = con.prepareStatement(sql);
                comandoAlt.setDouble(1, mudarSituacaoTecnica.getTecnica());
                //executar a instrução e tratar resultado
                comandoAlt.execute();
                
                String sql2 = "update notaFinal set situacaoTecnica = 'Descartada' where tecnica = ?;";
                PreparedStatement comandoAlt2 = con.prepareStatement(sql2);
                comandoAlt2.setDouble(1, mudarSituacaoTecnica.getApresentacao());
                //executar a instrução e tratar resultado
                comandoAlt2.execute();
                
                //fecha conexao
                System.out.println("ALTERADO COM SUCESSO");
            } catch (SQLException e) {
                System.out.println("IH MEU PARÇA! ERRO AO ALTERAR: " + e);
            }
        }
    }
    
    public void alterarAtributoApres(Nota mudarSituacaoApresentacao) throws ClassNotFoundException, SQLException {
        //Construir string sql bem formada e vinculado com a conexao
        try ( //Carregar drive e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            try {
                //Construir string sql bem formada e vinculado com a conexao
                String sql = "update notaFinal set situacaoApresentacao = 'Descartada' where tecnica = ?;";
                PreparedStatement comandoAlt = con.prepareStatement(sql);
                comandoAlt.setDouble(1, mudarSituacaoApresentacao.getTecnica());
                
                //executar a instrução e tratar resultado
                comandoAlt.execute();
                
                String sql2 = "update notaFinal set situacaoApresentacao = 'Descartada' where tecnica = ?;";
                PreparedStatement comandoAlt2 = con.prepareStatement(sql2);
                comandoAlt2.setDouble(1, mudarSituacaoApresentacao.getApresentacao());
                //executar a instrução e tratar resultado
                comandoAlt2.execute();
                
                //fecha conexao
                System.out.println("CADASTRADO COM SUCESSO");
            } catch (SQLException e) {
                System.out.println("IH MEU PARÇA! ERRO AO ALTERAR: " + e);
            }
        }
    }
}