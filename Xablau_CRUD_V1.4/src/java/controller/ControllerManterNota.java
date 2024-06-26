
package controller;

import dao.AtletaDAO;
import dao.NotaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Atleta;
import model.Arbitro;
import model.Inscricao;
import model.Nota;

@WebServlet(name = "ControllerManterNota", urlPatterns = {"/ControllerManterNota"})
public class ControllerManterNota extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mensagem = "";

        try {
            String operacao = request.getParameter("btnEnviar");

                if (operacao.equals("Cadastrar")) {
                double tecnicaNotaCad = Double.parseDouble(request.getParameter("nomeTecnica"));
                double apresent1 = Double.parseDouble(request.getParameter("apresentacao1"));
                double apresent2 = Double.parseDouble(request.getParameter("apresentacao2"));
                double apresent3 = Double.parseDouble(request.getParameter("apresentacao3"));
                Integer idUser = Integer.parseInt(request.getParameter("idUsuario"));
                
                double apresentacao;
                apresentacao = apresent1 + apresent2 + apresent3;
                
                Nota notaCad = new Nota();
                notaCad.setTecnica(tecnicaNotaCad);
                notaCad.setApresentacao(apresentacao);
                notaCad.setCodNota(idUser);
                
                Integer idNotaFinal = Integer.parseInt(request.getParameter("codNotaFinal"));
                
                Inscricao inscricaoCad = new Inscricao();
                inscricaoCad.setNotaFinal_codNotaFinal(idNotaFinal);
                
                NotaDAO notaCadDao = new NotaDAO();
                
                notaCadDao.CadastrarNota(notaCad, inscricaoCad);
                mensagem = "Cadastro de nota realizado com sucesso";
                }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ClassNotFound " + ex);
        } catch (SQLException ex) {
            System.out.println("Erro SQLException " + ex);
        }

        request.setAttribute("mensagem", mensagem);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" NomeAtleta="HttpServlet methods. Click on the + sign on the left to edit the code.">
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