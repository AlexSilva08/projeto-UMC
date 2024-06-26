/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 11181502562
 */
public class FabricaConexao {
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        //Carregar Driver  e criar conexao com o banco
        try{
            Class.forName("org.postgresql.Driver");
            conn =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbxablau", "postgres", "postgres");       
            System.out.println("Conectado");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Conexao: " + e);
        }
        return conn;
    }    
}