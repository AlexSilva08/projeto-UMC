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
import model.Arbitro;
import util.FabricaConexao;

public class ArbitroDAO {
    
    public void CadastrarArbitro(Arbitro arbitroCad) throws ClassNotFoundException, SQLException{
        //Construir string sql bem formada e vinculado com a conexao
        try ( //Carregar drive e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            try{
            //Construir string sql bem formada e vinculado com a conexao
            
            String sql1 = "insert into usuario(login, senha, nivelAcesso) values(?,?,'arbitro')";
            PreparedStatement arbitroCad1 = con.prepareStatement(sql1);
            arbitroCad1.setString(1, arbitroCad.getNome());
            arbitroCad1.setString(2, arbitroCad.getCpf());
            
            arbitroCad1.execute();
            
            
            String sql2 = "select codUsuario from usuario where login = ? and senha = ?";
            PreparedStatement selectById = con.prepareStatement(sql2);
            selectById.setString(1, arbitroCad.getNome());
            selectById.setString(2, arbitroCad.getCpf());
            //executar e tratar resultados
            ResultSet resultado = selectById.executeQuery();
            
            if (resultado.next()) {
                arbitroCad.setCodArbitro(resultado.getInt("codUsuario"));
            }
            
            //arbitroCad.setCodArbitro(comandoById.getInt("codUsuario"));
            
            String sql3 = "insert into arbitro(nome, cpf, dataNasc, tel, usuario_codUsuario) values(?,?,?,?,?)";
            PreparedStatement comandoCad = con.prepareStatement(sql3);
            comandoCad.setString(1, arbitroCad.getNome());
            comandoCad.setString(2, arbitroCad.getCpf());
            comandoCad.setString(3, arbitroCad.getDataNasc());
            comandoCad.setString(4, arbitroCad.getTel());
            comandoCad.setInt(5, arbitroCad.getCodArbitro());
            
            //executar a instrução e tratar resultado
            comandoCad.execute();
            
            //fecha conexao
            System.out.println("CADASTRADO COM SUCESSO");
            }catch(SQLException e){
                System.out.println("IH MEU PARÇA! ERRO AO CADASTRAR: " + e);
            }
        }
    }

    public Arbitro consultarById(Arbitro arbitroById) throws ClassNotFoundException, SQLException{
        //Construir String sql bem formada e vinculada com a conexao
        try ( //Carregar Driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //Construir String sql bem formada e vinculada com a conexao
            String sql = "select * from arbitro where codArbitro = ?";
            PreparedStatement comandoById = con.prepareStatement(sql);
            comandoById.setInt(1, arbitroById.getCodArbitro());
            //executar e tratar resultados
            ResultSet resultado = comandoById.executeQuery();
            if (resultado.next()) {
                arbitroById.setCodArbitro(resultado.getInt("codArbitro"));
                arbitroById.setNome(resultado.getString("nome"));
                arbitroById.setCpf(resultado.getString("cpf"));
                arbitroById.setDataNasc(resultado.getString("dataNasc"));
                arbitroById.setTel(resultado.getString("tel"));
            }
            //fecha conexao
        }
       return arbitroById;
    }
    
    public void RemoverArbitro(Arbitro arbitroDel) 
    throws ClassNotFoundException, SQLException{
        try (Connection con = FabricaConexao.getConexao()) {
            String sql = "delete from arbitro where codArbitro = ?";
            PreparedStatement comandoDel = con.prepareStatement(sql);
            comandoDel.setInt(1, arbitroDel.getCodArbitro());
            
            comandoDel.execute();
        }
    }
    
    public void AtualizarArbitro(Arbitro arbitroAtualiza) throws ClassNotFoundException, SQLException {
        try ( //Carregar Driver  e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            String sql = "update arbitro SET nome  = ?, cpf = ?, dataNasc = ?, tel = ? WHERE codArbitro = ?;";
            PreparedStatement atualizarArb = con.prepareStatement(sql);
            atualizarArb.setString(1, arbitroAtualiza.getNome());
            atualizarArb.setString(2, arbitroAtualiza.getCpf());
            atualizarArb.setString(3, arbitroAtualiza.getDataNasc());
            atualizarArb.setString(4, arbitroAtualiza.getTel());
            atualizarArb.setInt(5, arbitroAtualiza.getCodArbitro());
            //executar a instrução e tratar resultado
            atualizarArb.execute();
            //Fecha conexao
        }


    }

    public List<Arbitro> consultarArbitros() throws ClassNotFoundException, SQLException {
        ArrayList<Arbitro> listaArbitro;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select * from arbitro order by codArbitro";
            PreparedStatement comando = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comando.executeQuery();
            listaArbitro = new ArrayList<>();
            while (resultado.next()) {
                Arbitro arbitroAll = new Arbitro();
                arbitroAll.setCodArbitro(resultado.getInt("codArbitro"));
                arbitroAll.setNome(resultado.getString("nome"));
                arbitroAll.setCpf(resultado.getString("cpf"));
                arbitroAll.setDataNasc(resultado.getString("dataNasc"));
                arbitroAll.setTel(resultado.getString("tel"));
                listaArbitro.add(arbitroAll);
            }
            //fecha conexao
        }
        return listaArbitro;
    }
}
