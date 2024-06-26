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
import dao.FaseDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fase;

@WebServlet(name = "ControllerManterFase", urlPatterns = {"/ControllerManterFase"})
public class ControllerManterFase extends HttpServlet {

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
            String operacao = request.getParameter("btnOpFase");

            if (operacao.equals("Cadastrar")) {
                String descricaoFaseCad = request.getParameter("cadDescricaoFase");
                Fase faseCad = new Fase();
                faseCad.setDescricao(descricaoFaseCad);
                FaseDAO faseCadDao = new FaseDAO();
                faseCadDao.CadastrarFase(faseCad);
                mensagem = "Cadastro de fase realizado com sucesso";
            }

            if (operacao.equals("Alterar")) {
                int codFaseOpAlt = Integer.parseInt(request.getParameter("altCodFase"));
                Fase faseOpAlt = new Fase();
                faseOpAlt.setCodFase(codFaseOpAlt);
                FaseDAO faseOpAltDao = new FaseDAO();
                List<Fase> listFaseAlt = new ArrayList();
                listFaseAlt.add(faseOpAltDao.consultarById(faseOpAlt));
                request.setAttribute("listFaseAlt", listFaseAlt);
                request.getRequestDispatcher("/AlterarFase.jsp").forward(request, response);
            }

            if (operacao.equals("Remover")) {

                int codFaseDel = Integer.parseInt(request.getParameter("delCodFase"));
                Fase faseDel = new Fase();
                faseDel.setCodFase(codFaseDel);
                FaseDAO faseDeldao = new FaseDAO();
                faseDeldao.RemoverFase(faseDel);
                mensagem = "Remoção de fase realizada com sucesso";
            }

            if (operacao.equals("Consultar Codigo")) {
                if ("".equals(request.getParameter("cadCodFase"))) {
                    mensagem = "INSIRA UM CODIGO DE FASE!";
                } else if (!request.getParameter("cadCodFase").substring(1).matches("[0-9]*")) {
                    mensagem = "INSIRA UM CODIGO VALIDO!";
                } else {
                    int codFaseId = Integer.parseInt(request.getParameter("cadCodFase"));
                    Fase faseId = new Fase();
                    faseId.setCodFase(codFaseId);
                    FaseDAO faseIdDao = new FaseDAO();
                    List<Fase> listFaseId = new ArrayList();
                    listFaseId.add(faseIdDao.consultarById(faseId));
                    request.setAttribute("listFaseAll", listFaseId);
                    request.getRequestDispatcher("/ListarFase.jsp").forward(request, response);
                }
            }

            if (operacao.equals("Consultar Todos")) {
                FaseDAO faseAllDao = new FaseDAO();
                List<Fase> listFaseAll = faseAllDao.consultarFases();
                request.setAttribute("listFaseAll", listFaseAll);
                request.getRequestDispatcher("/ListarFase.jsp").forward(request, response);
            }

            //Operacao para salvar os dados do fase dentro do Alterar
            if (operacao.equals("Salvar")) {
                int codFaseAlt = Integer.parseInt(request.getParameter("altCodFase"));
                String nomeFaseAlt = request.getParameter("altDescricaoFase");
                Fase faseAlt = new Fase();
                faseAlt.setCodFase(codFaseAlt);
                faseAlt.setDescricao(nomeFaseAlt);
                FaseDAO faseAltDao = new FaseDAO();
                faseAltDao.AtualizarFase(faseAlt);
                mensagem = "Atualizado com sucesso";
            }

            if (operacao.equals("Voltar")) {
                request.getRequestDispatcher("/Home.jsp").forward(request, response);
            }
            
            if (operacao.equals("Voltar para cadastro")) {
                request.getRequestDispatcher("/CadastrarFase.jsp").forward(request, response);
            }
            
            if (operacao.equals("Voltar para consultas")) {
                request.getRequestDispatcher("/ConsultarFase.jsp").forward(request, response);
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ClassNotFound " + ex);
        } catch (SQLException ex) {
            System.out.println("Erro SQLException " + ex);
        }

        request.setAttribute("mensagem", mensagem);
        request.getRequestDispatcher("/ResultFase.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" NomeFase="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
