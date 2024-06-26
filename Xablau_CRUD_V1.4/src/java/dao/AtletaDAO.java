package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Atleta;
import util.FabricaConexao;

public class AtletaDAO {
    
    public void CadastrarAtleta(Atleta atletaCad) throws ClassNotFoundException, SQLException{
        //Construir string sql bem formada e vinculado com a conexao
        try ( //Carregar drive e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            try{
            //Construir string sql bem formada e vinculado com a conexao
            
            String sql1 = "insert into usuario(login, senha, nivelAcesso) values(?,?,'atleta')";
            PreparedStatement comandoCad1 = con.prepareStatement(sql1);
            comandoCad1.setString(1, atletaCad.getNome());
            comandoCad1.setString(2, atletaCad.getCpf());
            
            comandoCad1.execute();
            
            String sql2 = "select codUsuario from usuario where login = ? and senha = ?";
            PreparedStatement selectById = con.prepareStatement(sql2);
            selectById.setString(1, atletaCad.getNome());
            selectById.setString(2, atletaCad.getCpf());
            //executar e tratar resultados
            ResultSet resultado = selectById.executeQuery();
            
            if (resultado.next()) {
                atletaCad.setCodAtleta(resultado.getInt("codUsuario"));
            }
            
            String sq3 = "insert into atleta(nome, cpf, dataNasc, tel, graduacao, academia, usuario_codUsuario) values(?,?,?,?,?,?,?)";
            PreparedStatement comandoCad3 = con.prepareStatement(sq3);
            comandoCad3.setString(1, atletaCad.getNome());
            comandoCad3.setString(2, atletaCad.getCpf());
            comandoCad3.setString(3, atletaCad.getDataNasc());
            comandoCad3.setString(4, atletaCad.getTel());
            comandoCad3.setString(5, atletaCad.getGraduacao());
            comandoCad3.setString(6, atletaCad.getAcademia());
            comandoCad3.setInt(7, atletaCad.getCodAtleta());
            
            //executar a instrução e tratar resultado
            comandoCad3.execute();
            
            //fecha conexao
            System.out.println("CADASTRADO COM SUCESSO");
            }catch(SQLException e){
                System.out.println("IH MEU PARÇA! ERRO AO CADASTRAR: " + e);
            }
        }
    }

    public Atleta consultarById(Atleta atletaById) throws ClassNotFoundException, SQLException{
        //Construir String sql bem formada e vinculada com a conexao
        try ( //Carregar Driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //Construir String sql bem formada e vinculada com a conexao
            String sql = "select * from atleta where codAtleta = ?";
            PreparedStatement comandoById = con.prepareStatement(sql);
            comandoById.setInt(1, atletaById.getCodAtleta());
            //executar e tratar resultados
            ResultSet resultado = comandoById.executeQuery();
            if (resultado.next()) {
                atletaById.setCodAtleta(resultado.getInt("codAtleta"));
                atletaById.setNome(resultado.getString("nome"));
                atletaById.setCpf(resultado.getString("cpf"));
                atletaById.setDataNasc(resultado.getString("dataNasc"));
                atletaById.setTel(resultado.getString("tel"));
                atletaById.setGraduacao(resultado.getString("graduacao"));
                atletaById.setAcademia(resultado.getString("academia"));
            }
            //fecha conexao
        }
       return atletaById;
    }
    
    
    public Atleta consultarIdAtleta(Atleta atletaById) throws ClassNotFoundException, SQLException{
        //Construir String sql bem formada e vinculada com a conexao
        try ( //Carregar Driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //Construir String sql bem formada e vinculada com a conexao
            String sql = "select atleta.CodAtleta, atleta.nome, competicao.nomeCompeticao, categoria.descCategoria, fase.descricao, notafinal.NotaFinal from atleta, competicao, categoria, fase, inscricao, notafinal, competicao_categoria where atleta.CodAtleta = ? and atleta.CodAtleta = inscricao.atleta_codAtleta and inscricao.notaFinal_codNotaFinal = notafinal.codNotaFinal and notafinal.fase_codFase = fase.codFase and inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and competicao_categoria.categoria_codCategoria = categoria.codCategoria;";
            PreparedStatement comandoById = con.prepareStatement(sql);
            comandoById.setInt(1, atletaById.getCodAtleta());
            //executar e tratar resultados
            ResultSet resultado = comandoById.executeQuery();
            if (resultado.next()) {
                atletaById.setCodAtleta(resultado.getInt("codAtleta"));
                atletaById.setNome(resultado.getString("nome"));
                atletaById.setCpf(resultado.getString("nomeCompeticao"));
                atletaById.setDataNasc(resultado.getString("descCategoria"));
                atletaById.setTel(resultado.getString("descricao"));
                atletaById.setGraduacao(resultado.getString("NotaFinal"));
            }
            
            String verificador = atletaById.getGraduacao();
            
            if (verificador == null){
            String sql2 = "select atleta.CodAtleta, atleta.nome, competicao.nomeCompeticao, categoria.descCategoria from atleta, competicao, categoria, inscricao, competicao_categoria where atleta.CodAtleta = ? and atleta.CodAtleta = inscricao.atleta_codAtleta and inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and competicao_categoria.categoria_codCategoria = categoria.codCategoria;";
            PreparedStatement comandoById2 = con.prepareStatement(sql2);
            comandoById2.setInt(1, atletaById.getCodAtleta());
            //executar e tratar resultados
            ResultSet resultado2 = comandoById2.executeQuery();
            if (resultado2.next()) {
                atletaById.setCodAtleta(resultado2.getInt("CodAtleta"));
                atletaById.setNome(resultado2.getString("nome"));
                atletaById.setCpf(resultado2.getString("nomeCompeticao"));
                atletaById.setDataNasc(resultado2.getString("descCategoria"));
                }
            }
            
            //fecha conexao
        }
       return atletaById;
    }
    
    public List<Atleta> consultarHistorico() throws ClassNotFoundException, SQLException {
        ArrayList<Atleta> listaAtleta;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select atleta.CodAtleta, atleta.nome, competicao.nomeCompeticao, categoria.descCategoria, fase.descricao, notafinal.NotaFinal from atleta, competicao, categoria, fase, inscricao, notafinal, competicao_categoria where atleta.CodAtleta = 1 and atleta.CodAtleta = inscricao.atleta_codAtleta and inscricao.notaFinal_codNotaFinal = notafinal.codNotaFinal and notafinal.fase_codFase = fase.codFase and inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and competicao_categoria.categoria_codCategoria = categoria.codCategoria;";
            PreparedStatement comando = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comando.executeQuery();
            listaAtleta = new ArrayList<>();
            while (resultado.next()) {
                Atleta atletaAll = new Atleta();
                atletaAll.setCodAtleta(resultado.getInt("codAtleta"));
                atletaAll.setNome(resultado.getString("nome"));
                atletaAll.setCpf(resultado.getString("nomeCompeticao"));
                atletaAll.setDataNasc(resultado.getString("descCategoria"));
                atletaAll.setTel(resultado.getString("descricao"));
                atletaAll.setGraduacao(resultado.getString("NotaFinal"));
                listaAtleta.add(atletaAll);
            }
            //fecha conexao
        }
        return listaAtleta;
    }
    
    public List<Atleta> consultarInscritos() throws ClassNotFoundException, SQLException {
        ArrayList<Atleta> listaAtleta;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select atleta.CodAtleta, atleta.nome, competicao.nomeCompeticao, categoria.descCategoria from atleta, competicao, categoria, inscricao, competicao_categoria where inscricao.inscricaoAtiva is null and atleta.CodAtleta = inscricao.atleta_codAtleta and inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and competicao_categoria.categoria_codCategoria = categoria.codCategoria;";
            PreparedStatement comando = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comando.executeQuery();
            listaAtleta = new ArrayList<>();
            while (resultado.next()) {
                Atleta atletaAll = new Atleta();
                atletaAll.setCodAtleta(resultado.getInt("codAtleta"));
                atletaAll.setNome(resultado.getString("nome"));
                atletaAll.setCpf(resultado.getString("nomeCompeticao"));
                atletaAll.setDataNasc(resultado.getString("descCategoria"));
                listaAtleta.add(atletaAll);
            }
            //fecha conexao
        }
        return listaAtleta;
    }
    
    public void RemoverAtleta(Atleta atletaDel) 
    throws ClassNotFoundException, SQLException{
        try (Connection con = FabricaConexao.getConexao()) {
            String sql = "delete from atleta where codAtleta = ?";
            PreparedStatement comandoDel = con.prepareStatement(sql);
            comandoDel.setInt(1, atletaDel.getCodAtleta());
            
            comandoDel.execute();
        }
    }
    
    public void AtualizarAtleta(Atleta atletaAtualiza) throws ClassNotFoundException, SQLException {
        try ( //Carregar Driver  e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            String sql = "update atleta SET nome  = ?, cpf = ?, dataNasc = ?, tel = ?, graduacao = ?, academia = ? WHERE codAtleta = ?;";
            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setString(1, atletaAtualiza.getNome());
            atualizar.setString(2, atletaAtualiza.getCpf());
            atualizar.setString(3, atletaAtualiza.getDataNasc());
            atualizar.setString(4, atletaAtualiza.getTel());
            atualizar.setString(5, atletaAtualiza.getGraduacao());
            atualizar.setString(6, atletaAtualiza.getAcademia());
            atualizar.setInt(7, atletaAtualiza.getCodAtleta());
            //executar a instrução e tratar resultado
            atualizar.execute();
            //Fecha conexao
        }


    }

    public List<Atleta> consultarAtletas() throws ClassNotFoundException, SQLException {
        ArrayList<Atleta> listaAtleta;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select * from atleta order by codAtleta";
            PreparedStatement comando = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comando.executeQuery();
            listaAtleta = new ArrayList<>();
            while (resultado.next()) {
                Atleta atletaAll = new Atleta();
                atletaAll.setCodAtleta(resultado.getInt("codAtleta"));
                atletaAll.setNome(resultado.getString("nome"));
                atletaAll.setCpf(resultado.getString("cpf"));
                atletaAll.setDataNasc(resultado.getString("dataNasc"));
                atletaAll.setTel(resultado.getString("tel"));
                atletaAll.setGraduacao(resultado.getString("graduacao"));
                atletaAll.setAcademia(resultado.getString("academia"));
                listaAtleta.add(atletaAll);
            }
            //fecha conexao
        }
        return listaAtleta;
    }
    
    public List<Atleta> consultarCodAtletas() throws ClassNotFoundException, SQLException {
        ArrayList<Atleta> listaAtleta;
        //construir string sql bem formada e vinculada com a conexao
        try ( //carregar driver e criar conexao
                Connection con = FabricaConexao.getConexao()) {
            //construir string sql bem formada e vinculada com a conexao
            String sql = "select * from atleta order by codAtleta";
            PreparedStatement comando = con.prepareStatement(sql);
            //executar e tratar resultados
            ResultSet resultado = comando.executeQuery();
            listaAtleta = new ArrayList<>();
            while (resultado.next()) {
                Atleta atletaAll = new Atleta();
                atletaAll.setCodAtleta(resultado.getInt("codAtleta"));
                atletaAll.setNome(resultado.getString("nome"));
                listaAtleta.add(atletaAll);
            }
            //fecha conexao
        }
        return listaAtleta;
    }
}