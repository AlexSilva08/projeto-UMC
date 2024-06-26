/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author 11181502562
 */
import dao.CompeticaoDAO;
import dao.AtletaDAO;
import dao.CategoriaDAO;
import dao.FaseDAO;
import dao.InscricaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Atleta;
import model.Categoria;
import model.Competicao;
import model.Fase;
import model.Inscricao;

@WebServlet(name = "ControllerManterSelecao", urlPatterns = {"/ControllerManterSelecao"})
public class ControllerManterSelecao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mensagem = "";

        try {
            String operacao = request.getParameter("btnOpSelecao");

            if (operacao.equals("Consultar Competicoes")) {
                CompeticaoDAO competicaoAllDao = new CompeticaoDAO();
                List<Competicao> listCompeticaoAll = competicaoAllDao.consultarCompeticoes();
                request.setAttribute("listCompeticaoAll", listCompeticaoAll);
                request.getRequestDispatcher("/TelaSelecionado.jsp").forward(request, response);
            }
            
            if (operacao.equals("Consultar Categorias")) {
                CategoriaDAO categoriaAllDao = new CategoriaDAO();
                List<Categoria> listCategoriaAll = categoriaAllDao.consultarCategorias();
                request.setAttribute("listCategoriaAll", listCategoriaAll);
                request.getRequestDispatcher("/TelaSelecionado.jsp").forward(request, response);
            }
            
            if (operacao.equals("Consultar Fases")) {
                FaseDAO faseAllDao = new FaseDAO();
                List<Fase> listFaseAll = faseAllDao.consultarFases();
                request.setAttribute("listFaseAll", listFaseAll);
                request.getRequestDispatcher("/TelaSelecionado.jsp").forward(request, response);
            }
            
            if (operacao.equals("Consultar Atletas")) {
                AtletaDAO atletaAllDao = new AtletaDAO();
                List<Atleta> listAtletaAll = atletaAllDao.consultarCodAtletas();
                request.setAttribute("listAtletaAll", listAtletaAll);
                request.getRequestDispatcher("/TelaSelecionado.jsp").forward(request, response);
            }
            
            if (operacao.equals("Confirmar Selecionados")) {
                Integer codAtleta = Integer.parseInt(request.getParameter("nomeCompeticao"));
                Integer codFase = Integer.parseInt(request.getParameter("faseCompeticao"));
                Inscricao selectInscricao = new Inscricao();
                selectInscricao.setAtleta_codAtleta(codAtleta);
                selectInscricao.setCompeticao_categoria_codCategoria(codFase);
                InscricaoDAO selecaoDao = new InscricaoDAO();
                selecaoDao.SelecionarInscricao(selectInscricao);
                mensagem = "Selecionado com sucesso";
            }
            
            if (operacao.equals("Confirmar")) {
                String nomeAtletaCad = request.getParameter("cadNomeAtleta");
                String cpfAtletaCad = request.getParameter("cadCpfAtleta");
                String dataNascAtletaCad = request.getParameter("cadDataNascAtleta");
                String telAtletaCad = request.getParameter("cadTelAtleta");
                String graduacaoAtletaCad = request.getParameter("cadGraduacaoAtleta");
                String academiaAtletaCad = request.getParameter("cadAcademiaAtleta");
                Atleta atletaCad = new Atleta();
                atletaCad.setNome(nomeAtletaCad);
                atletaCad.setCpf(cpfAtletaCad);
                atletaCad.setDataNasc(dataNascAtletaCad);
                atletaCad.setTel(telAtletaCad);
                atletaCad.setGraduacao(graduacaoAtletaCad);
                atletaCad.setAcademia(academiaAtletaCad);
                AtletaDAO atletaCadDao = new AtletaDAO();
                atletaCadDao.CadastrarAtleta(atletaCad);
                mensagem = "Cadastro de atleta realizado com sucesso";
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ClassNotFound " + ex);
        } catch (SQLException ex) {
            System.out.println("Erro SQLException " + ex);
        }

        request.setAttribute("mensagem", mensagem);
        request.getRequestDispatcher("/TelaAllNotas.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" NomeSelecao="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
