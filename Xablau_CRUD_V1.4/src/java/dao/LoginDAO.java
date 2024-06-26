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
import model.Nota;
import model.Usuario;
import util.FabricaConexao;

/**
 *
 * @author 11181502562
 */
public class LoginDAO {
/*
    public void CadastrarLogin(Usuario loginCad) throws ClassNotFoundException, SQLException {
        //Construir string sql bem formada e vinculado com a conexao
        try ( //Carregar drive e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            try {
                //Construir string sql bem formada e vinculado com a conexao
                String sql = "insert into usuario(login, senha, nivelAcesso) values(?,?,'administrador')";
                PreparedStatement comandoCad = con.prepareStatement(sql);
                comandoCad.setString(1, loginCad.getLogin());
                comandoCad.setString(2, loginCad.getSenha());
                //executar a instrução e tratar resultado
                comandoCad.execute();
                //fecha conexao
                System.out.println("CADASTRADO COM SUCESSO");
            } catch (SQLException e) {
                System.out.println("IH MEU PARÇA! ERRO AO CADASTRAR: " + e);
            }
        }
    }
*/
    public Usuario consultUserById(Usuario usuarioById) throws ClassNotFoundException, SQLException {
        //Construir String sql bem formada e vinculada com a conexao
        try ( //Carregar Driver e criar conexao
            Connection con = FabricaConexao.getConexao()) {
            //Construir String sql bem formada e vinculada com a conexao
            String sql = "select * from usuario where login = ? and senha = ?";
            PreparedStatement comandoById = con.prepareStatement(sql);
            comandoById.setString(1, usuarioById.getLogin());
            comandoById.setString(2, usuarioById.getSenha());
            //executar e tratar resultados
            ResultSet resultado = comandoById.executeQuery();

            if (resultado.next()) {
                usuarioById.setCodUsuario(resultado.getInt("codUsuario"));
                usuarioById.setLogin(resultado.getString("login"));
                usuarioById.setNivelAcesso(resultado.getString("nivelAcesso"));
            } else{
                usuarioById.setLogin("");
                usuarioById.setNivelAcesso("");
            }
            //fecha conexao
        }
        
        return usuarioById;
    }
    
    public Usuario consultArbitroById(Usuario arbitroById) throws ClassNotFoundException, SQLException {
        //Construir String sql bem formada e vinculada com a conexao
        try ( //Carregar Driver e criar conexao
            Connection con = FabricaConexao.getConexao()) {
            //Construir String sql bem formada e vinculada com a conexao
            String sql = "select arbitro.codArbitro, usuario.login, usuario.senha, usuario.nivelAcesso from arbitro, usuario where usuario.login = ? and usuario.senha = ? and usuario.codUsuario = arbitro.usuario_codUsuario;";
            PreparedStatement comandoById = con.prepareStatement(sql);
            comandoById.setString(1, arbitroById.getLogin());
            comandoById.setString(2, arbitroById.getSenha());
            //executar e tratar resultados
            ResultSet resultado = comandoById.executeQuery();

            if (resultado.next()) {
                arbitroById.setCodUsuario(resultado.getInt("codArbitro"));
                arbitroById.setLogin(resultado.getString("login"));
                arbitroById.setNivelAcesso(resultado.getString("nivelAcesso"));
            } else{
                arbitroById.setLogin("");
                arbitroById.setNivelAcesso("");
            }
            //fecha conexao
        }
        
        return arbitroById;
    }
    
}
