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
import model.Categoria;
import util.FabricaConexao;

/**
 *
 * @author 11181502562
 */
public class CategoriaDAO {

    public void CadastrarCategoria(Categoria categoriaCad) throws ClassNotFoundException, SQLException {
        //Construir string sql bem formada e vinculado com a conexao
        try ( //Carregar drive e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            try {
                //Construir string sql bem formada e vinculado com a conexao
                String sql = "insert into categoria(descCategoria, idade, sexo) values(?,?,?);";
                PreparedStatement comandoCad = con.prepareStatement(sql);
                comandoCad.setString(1, categoriaCad.getDescCategoria());
                comandoCad.setString(2, categoriaCad.getIdade());
                comandoCad.setString(3, categoriaCad.getSexo());
                //executar a instrução e tratar resultado
                comandoCad.execute();
                //fecha conexao
                System.out.println("CADASTRADO COM SUCESSO");
            } catch (SQLException e) {
                System.out.println("IH MEU PARÇA! ERRO AO CADASTRAR: " + e);
            }
        }
    }

    public Categoria consultarById(Categoria categoriaById) throws ClassNotFoundException, SQLException {
        //Construir String sql bem formada e vinculada com a conexao
        try ( //Carregar Driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //Construir String sql bem formada e vinculada com a conexao
            String sql = "select * from categoria where codCategoria = ?;";
            PreparedStatement comandoById = con.prepareStatement(sql);
            comandoById.setInt(1, categoriaById.getCodCategoria());
            //executar e tratar resultados
            ResultSet resultado = comandoById.executeQuery();
            if (resultado.next()) {
                categoriaById.setCodCategoria(resultado.getInt("codCategoria"));
                categoriaById.setDescCategoria(resultado.getString("descCategoria"));
                categoriaById.setIdade(resultado.getString("idade"));
                categoriaById.setSexo(resultado.getString("sexo"));
            }
            //fecha conexao
        }
        return categoriaById;
    }

    public void RemoverCategoria(Categoria categoriaDel)
            throws ClassNotFoundException, SQLException {
        try (Connection con = FabricaConexao.getConexao()) {
            String sql = "delete from categoria where codCategoria = ?;";
            PreparedStatement comandoDel = con.prepareStatement(sql);
            comandoDel.setInt(1, categoriaDel.getCodCategoria());

            comandoDel.execute();
        }
    }

    public void AtualizarCategoria(Categoria categoriaAtualiza) throws ClassNotFoundException, SQLException {
        try ( //Carregar Driver  e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            String sql = "update categoria SET descCategoria = ?, idade = ?, sexo = ? WHERE codCategoria = ?;";
            PreparedStatement atualizarCategoria = con.prepareStatement(sql);
            atualizarCategoria.setString(1, categoriaAtualiza.getDescCategoria());
            atualizarCategoria.setString(2, categoriaAtualiza.getIdade());
            atualizarCategoria.setString(3, categoriaAtualiza.getSexo());
            atualizarCategoria.setInt(4, categoriaAtualiza.getCodCategoria());
            //executar a instrução e tratar resultado
            atualizarCategoria.execute();
            //Fecha conexao
        }

    }

    public List<Categoria> consultarAllCategoria() throws ClassNotFoundException, SQLException {
        ArrayList<Categoria> listaCategoria;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select * from categoria order by codCategoria;";
            PreparedStatement comando = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comando.executeQuery();
            listaCategoria = new ArrayList<>();
            while (resultado.next()) {
                Categoria categoriaAll = new Categoria();
                categoriaAll.setCodCategoria(resultado.getInt("codCategoria"));
                categoriaAll.setDescCategoria(resultado.getString("descCategoria"));
                categoriaAll.setIdade(resultado.getString("idade"));
                categoriaAll.setSexo(resultado.getString("sexo"));
                listaCategoria.add(categoriaAll);
            }
            //fecha conexao
        }
        return listaCategoria;
    }

    public List<Categoria> consultarCategorias() throws ClassNotFoundException, SQLException {
        ArrayList<Categoria> listaCategoria;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select codCategoria, descCategoria from categoria order by codCategoria;";
            PreparedStatement comando = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comando.executeQuery();
            listaCategoria = new ArrayList<>();
            while (resultado.next()) {
                Categoria categoriaAll = new Categoria();
                categoriaAll.setCodCategoria(resultado.getInt("codCategoria"));
                categoriaAll.setDescCategoria(resultado.getString("descCategoria"));
            }
            //fecha conexao
        }
        return listaCategoria;
    }
}
