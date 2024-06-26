/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author 11181502562
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Competicao;
import util.FabricaConexao;

public class CompeticaoDAO {
public void CadastrarCompeticao(Competicao competicaoCad) throws ClassNotFoundException, SQLException{
        //Construir string sql bem formada e vinculado com a conexao
        try ( //Carregar drive e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            try{
            //Construir string sql bem formada e vinculado com a conexao
            String sql = "insert into competicao(nomeCompeticao, endereco, dataCompeticao, horario) values(?,?,?,?);";
            PreparedStatement comandoCad = con.prepareStatement(sql);
            comandoCad.setString(1, competicaoCad.getNomeCompeticao());
            comandoCad.setString(2, competicaoCad.getEndereco());
            comandoCad.setString(3, competicaoCad.getDataCompeticao());
            comandoCad.setString(4, competicaoCad.getHorario());
            //executar a instrução e tratar resultado
            comandoCad.execute();
            
            String sql2 = "select codCompeticao from competicao where nomeCompeticao = ? and endereco = ?";
            PreparedStatement selectById = con.prepareStatement(sql2);
            selectById.setString(1, competicaoCad.getNomeCompeticao());
            selectById.setString(2, competicaoCad.getEndereco());
            //executar e tratar resultados
            ResultSet resultado = selectById.executeQuery();
            
            if (resultado.next()) {
                competicaoCad.setCodCompeticao(resultado.getInt("codCompeticao"));
            }
            
            for(int i = 1; i < 13;){
            String sql3 = "insert into competicao_categoria(categoria_codCategoria, competicao_codCompeticao) values(?,?)";
            PreparedStatement comandoCad2 = con.prepareStatement(sql3);
            comandoCad2.setInt(1, (i));
            comandoCad2.setInt(2, competicaoCad.getCodCompeticao());
            
            //executar a instrução e tratar resultado
            comandoCad2.execute();
            
            //adiciona 1 no contador que eh usado no categoria_codCategoria
            i++;
            }
            //fecha conexao
            System.out.println("CADASTRADO COM SUCESSO");
            }catch(SQLException e){
                System.out.println("IH MEU PARÇA! ERRO AO CADASTRAR: " + e);
            }
        }
    }

    public Competicao consultarById(Competicao competicaoById) throws ClassNotFoundException, SQLException{
        //Construir String sql bem formada e vinculada com a conexao
        try ( //Carregar Driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //Construir String sql bem formada e vinculada com a conexao
            String sql = "select * from competicao where codCompeticao = ?;";
            PreparedStatement comandoById = con.prepareStatement(sql);
            comandoById.setInt(1, competicaoById.getCodCompeticao());
            //executar e tratar resultados
            ResultSet resultado = comandoById.executeQuery();
            if (resultado.next()) {
                competicaoById.setCodCompeticao(resultado.getInt("codCompeticao"));
                competicaoById.setNomeCompeticao(resultado.getString("nomeCompeticao"));
                competicaoById.setEndereco(resultado.getString("endereco"));
                competicaoById.setDataCompeticao(resultado.getString("dataCompeticao"));
                competicaoById.setHorario(resultado.getString("horario"));
            }
            //fecha conexao
        }
       return competicaoById;
    }
    
    public void RemoverCompeticao(Competicao competicaoDel) 
    throws ClassNotFoundException, SQLException{
        try (Connection con = FabricaConexao.getConexao()) {
            String sql = "delete from competicao where codCompeticao = ?;";
            PreparedStatement comandoDel = con.prepareStatement(sql);
            comandoDel.setInt(1, competicaoDel.getCodCompeticao());
            
            comandoDel.execute();
        }
    }
    
    public void AtualizarCompeticao(Competicao competicaoAtualiza) throws ClassNotFoundException, SQLException {
        try ( //Carregar Driver  e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            String sql = "update competicao SET nomeCompeticao  = ?, endereco = ?, dataCompeticao = ?, horario = ? WHERE codCompeticao = ?;";
            PreparedStatement atualizarCompet = con.prepareStatement(sql);
            atualizarCompet.setString(1, competicaoAtualiza.getNomeCompeticao());
            atualizarCompet.setString(2, competicaoAtualiza.getEndereco());
            atualizarCompet.setString(3, competicaoAtualiza.getDataCompeticao());
            atualizarCompet.setString(4, competicaoAtualiza.getHorario());
            atualizarCompet.setInt(5, competicaoAtualiza.getCodCompeticao());
            //executar a instrução e tratar resultado
            atualizarCompet.execute();
            //Fecha conexao
        }


    }
    
    public List<Competicao> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Competicao> listaCompeticao;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select * from competicao order by codCompeticao;";
            PreparedStatement comando = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comando.executeQuery();
            listaCompeticao = new ArrayList<>();
            while (resultado.next()) {
                Competicao competicaoAll = new Competicao();
                competicaoAll.setCodCompeticao(resultado.getInt("codCompeticao"));
                competicaoAll.setNomeCompeticao(resultado.getString("nomeCompeticao"));
                competicaoAll.setEndereco(resultado.getString("endereco"));
                competicaoAll.setDataCompeticao(resultado.getString("dataCompeticao"));
                competicaoAll.setHorario(resultado.getString("horario"));
                listaCompeticao.add(competicaoAll);
            }
            //fecha conexao
        }
        return listaCompeticao;
    }

    
    public List<Competicao> consultarCompeticoes() throws ClassNotFoundException, SQLException {
        ArrayList<Competicao> listaCompeticao;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select codCompeticao, nomeCompeticao from competicao order by codCompeticao;";
            PreparedStatement comando = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comando.executeQuery();
            listaCompeticao = new ArrayList<>();
            while (resultado.next()) {
                Competicao competicaoAll = new Competicao();
                competicaoAll.setCodCompeticao(resultado.getInt("codCompeticao"));
                competicaoAll.setNomeCompeticao(resultado.getString("nomeCompeticao"));
                listaCompeticao.add(competicaoAll);
            }
            //fecha conexao
        }
        return listaCompeticao;
    }
}
