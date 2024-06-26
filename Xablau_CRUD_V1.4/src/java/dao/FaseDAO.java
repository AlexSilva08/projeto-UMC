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
import model.Fase;
import util.FabricaConexao;

public class FaseDAO {
public void CadastrarFase(Fase faseCad) throws ClassNotFoundException, SQLException{
        //Construir string sql bem formada e vinculado com a conexao
        try ( //Carregar drive e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            try{
            //Construir string sql bem formada e vinculado com a conexao
            String sql = "insert into fase(descricao) values(?);";
            PreparedStatement cadFase = con.prepareStatement(sql);
            cadFase.setString(1, faseCad.getDescricao());
            //executar a instrução e tratar resultado
            cadFase.execute();
            //fecha conexao
            System.out.println("CADASTRADO COM SUCESSO");
            }catch(SQLException e){
                System.out.println("IH MEU PARÇA! ERRO AO CADASTRAR: " + e);
            }
        }
    }

    public Fase consultarById(Fase faseByID) throws ClassNotFoundException, SQLException{
        //Construir String sql bem formada e vinculada com a conexao
        try ( //Carregar Driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //Construir String sql bem formada e vinculada com a conexao
            String sql = "select * from fase where codFase = ?;";
            PreparedStatement comandoById = con.prepareStatement(sql);
            comandoById.setInt(1, faseByID.getCodFase());
            //executar e tratar resultados
            ResultSet resultado = comandoById.executeQuery();
            if (resultado.next()) {
                faseByID.setCodFase(resultado.getInt("codFase"));
                faseByID.setDescricao(resultado.getString("descricao"));
            }
            //fecha conexao
        }
       return faseByID;
    }
    
    public void RemoverFase(Fase faseDel) 
    throws ClassNotFoundException, SQLException{
        try (Connection con = FabricaConexao.getConexao()) {
            String sql = "delete from fase where codFase = ?;";
            PreparedStatement delFase = con.prepareStatement(sql);
            delFase.setInt(1, faseDel.getCodFase());
            
            delFase.execute();
        }
    }
    
    public void AtualizarFase(Fase faseAtualiza) throws ClassNotFoundException, SQLException {
        try ( //Carregar Driver  e criar conexao
                Connection con = FabricaConexao.getConexao()) {
                String sql = "update fase SET descricao  = ? WHERE codFase = ?;";
                PreparedStatement atualizarFaze = con.prepareStatement(sql);
                atualizarFaze.setString(1, faseAtualiza.getDescricao());
                atualizarFaze.setInt(2, faseAtualiza.getCodFase());
                //executar a instrução e tratar resultado
                atualizarFaze.execute();
                //Fecha conexao
        }


    }
    
    public List<Fase> consultarFases() throws ClassNotFoundException, SQLException {
        ArrayList<Fase> listaFase;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select * from fase order by codFase;";
            PreparedStatement comando = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comando.executeQuery();
            listaFase = new ArrayList<>();
            while (resultado.next()) {
                Fase faseAll = new Fase();
                faseAll.setCodFase(resultado.getInt("codFase"));
                faseAll.setDescricao(resultado.getString("descricao"));
                listaFase.add(faseAll);
            }
            //fecha conexao
        }
        return listaFase;
    }
}
