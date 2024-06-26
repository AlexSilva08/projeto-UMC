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
import model.Nota;
import model.NotaFinal;
import util.FabricaConexao;

/**
 *
 * @author 11181502562
 */
public class NotaFinalDAO {
    
    public void CadastrarSomaNotas(NotaFinal somaNotaFinalAll) throws ClassNotFoundException, SQLException {
        //Construir string sql bem formada e vinculado com a conexao
        try ( //Carregar drive e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            try {
                //Construir string sql bem formada e vinculado com a conexao
                String sql = "update notaFinal notaFinal set notaFinal = ?, somaApresentacao = ?, somaTecnica = ?, somaNotas = ? where codNotaFinal = '1';";
                PreparedStatement comandoCad = con.prepareStatement(sql);
                comandoCad.setDouble(1, somaNotaFinalAll.getNotaFinal());
                comandoCad.setDouble(2, somaNotaFinalAll.getSomaApresentacao());
                comandoCad.setDouble(3, somaNotaFinalAll.getSomaTecnica());
                comandoCad.setDouble(4, somaNotaFinalAll.getSomaNotas());
                //executar a instrução e tratar resultado
                comandoCad.execute();
                
                //fecha conexao
                System.out.println("CADASTRADO COM SUCESSO");
            } catch (SQLException e) {
                System.out.println("IH MEU PARÇA! ERRO AO CADASTRAR: " + e);
            }
        }
    }
    
     public List<NotaFinal> SelecionarNotaFinal() throws ClassNotFoundException, SQLException {
        ArrayList<NotaFinal> listanotaFinal;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select * from notaFinal where codNotaFinal = '1';";
            PreparedStatement comandoNotaFinal = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comandoNotaFinal.executeQuery();
            listanotaFinal = new ArrayList<>();
            while (resultado.next()) {
                NotaFinal notaAll = new NotaFinal();
                notaAll.setNotaFinal(resultado.getDouble("notaFinal"));
                notaAll.setSomaApresentacao(resultado.getInt("somaApresentacao"));
                notaAll.setSomaTecnica(resultado.getInt("somaTecnica"));
                notaAll.setSomaNotas(resultado.getDouble("somaNotas"));
                listanotaFinal.add(notaAll);
            }
            //fecha conexao
        }
        return listanotaFinal;
    }
    
}
