/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.InscricaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Inscricao;

/**
 *
 * @author 11181502562
 */
@WebServlet(name = "ControllerManterInscricao", urlPatterns = {"/ControllerManterInscricao"})
public class ControllerManterInscricao extends HttpServlet {

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
            String operacao = request.getParameter("btnOp");

            if (operacao.equals("Cadastrar")) {
                int atleta_codAtletaCad = Integer.parseInt(request.getParameter("codAtleta"));
                int competicao_categoria_codCategoriaCad = Integer.parseInt(request.getParameter("codCategoria"));
                int competicao_categoria_codCompeticaoCad = Integer.parseInt(request.getParameter("codCompeticao"));
                Inscricao inscricaoCad = new Inscricao();
                inscricaoCad.setAtleta_codAtleta(atleta_codAtletaCad);
                inscricaoCad.setCompeticao_categoria_codCategoria(competicao_categoria_codCategoriaCad);
                inscricaoCad.setCompeticao_categoria_codCompeticao(competicao_categoria_codCompeticaoCad);
                InscricaoDAO inscricaoCadDao = new InscricaoDAO();
                inscricaoCadDao.CadastrarInscricao(inscricaoCad);
                mensagem = "Cadastro de inscricao realizado com sucesso";
            }

            if (operacao.equals("Consultar")) {
                InscricaoDAO inscricaoAllDao = new InscricaoDAO();
                List<Inscricao> listInscricaoAll = inscricaoAllDao.consultarInscricao();
                request.setAttribute("listInscricaoAll", listInscricaoAll);
                request.getRequestDispatcher("/ListarInscricao.jsp").forward(request, response);
            }
            
            if (operacao.equals("Puxar inscricao")) {
                InscricaoDAO inscricaoAllDao = new InscricaoDAO();
                List<Inscricao> listInscricaoAll = inscricaoAllDao.PuxarInscricao();
                request.setAttribute("listInscricaoAll", listInscricaoAll);
                request.getRequestDispatcher("/TelaLogo.jsp").forward(request, response);
            }
            
            if (operacao.equals("Voltar")) {
                request.getRequestDispatcher("/Home.jsp").forward(request, response);
            }
            
            if (operacao.equals("Voltar para cadastro")) {
                request.getRequestDispatcher("/CadastrarInscricao.jsp").forward(request, response);
            }
            
            if (operacao.equals("Voltar para consulta")) {
                request.getRequestDispatcher("/ConsultarInscricao.jsp").forward(request, response);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ClassNotFound " + ex);
        } catch (SQLException ex) {
            System.out.println("Erro SQLException " + ex);
        }

        request.setAttribute("mensagem", mensagem);
        request.getRequestDispatcher("/ResultInscricao.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" NomeInscricao="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
