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
import dao.ArbitroDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Arbitro;

@WebServlet(name = "ControllerManterArbitro", urlPatterns = {"/ControllerManterArbitro"})
public class ControllerManterArbitro extends HttpServlet {

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
            String operacao = request.getParameter("btnOpArbitro");

            if (operacao.equals("Cadastrar")) {
                String nomeArbitroCad = request.getParameter("cadNomeArbitro");
                String cpfArbitroCad = request.getParameter("cadCpfArbitro");
                String dataNascArbitroCad = request.getParameter("cadDataNascArbitro");
                String telArbitroCad = request.getParameter("cadTelArbitro");
                Arbitro arbitroCad = new Arbitro();
                arbitroCad.setNome(nomeArbitroCad);
                arbitroCad.setCpf(cpfArbitroCad);
                arbitroCad.setDataNasc(dataNascArbitroCad);
                arbitroCad.setTel(telArbitroCad);
                ArbitroDAO arbitroCadDao = new ArbitroDAO();
                arbitroCadDao.CadastrarArbitro(arbitroCad);
                mensagem = "Cadastro de arbitro realizado com sucesso";
            }

            if (operacao.equals("Alterar")) {
                int codArbitroOpAlt = Integer.parseInt(request.getParameter("altCodArbitro"));
                Arbitro arbitroOpAlt = new Arbitro();
                arbitroOpAlt.setCodArbitro(codArbitroOpAlt);
                ArbitroDAO arbitroOpAltDao = new ArbitroDAO();
                List<Arbitro> listArbitroAlt = new ArrayList();
                listArbitroAlt.add(arbitroOpAltDao.consultarById(arbitroOpAlt));
                request.setAttribute("listArbitroAlt", listArbitroAlt);
                request.getRequestDispatcher("/AlterarArbitro.jsp").forward(request, response);
            }

            if (operacao.equals("Remover")) {

                int codArbitroDel = Integer.parseInt(request.getParameter("delCodArbitro"));
                Arbitro arbitroDel = new Arbitro();
                arbitroDel.setCodArbitro(codArbitroDel);
                ArbitroDAO arbitroDeldao = new ArbitroDAO();
                arbitroDeldao.RemoverArbitro(arbitroDel);
                mensagem = "Remoção de arbitro realizada com sucesso";
            }

            if (operacao.equals("Consultar Codigo")) {
                if ("".equals(request.getParameter("cadCodArbitro"))) {
                    mensagem = "INSIRA UM CODIGO DE ARBITRO!";
                } else if (!request.getParameter("cadCodArbitro").substring(1).matches("[0-9]*")) {
                    mensagem = "INSIRA UM CODIGO VALIDO!";
                } else {
                    int codArbitroId = Integer.parseInt(request.getParameter("cadCodArbitro"));
                    Arbitro arbitroId = new Arbitro();
                    arbitroId.setCodArbitro(codArbitroId);
                    ArbitroDAO arbitroIdDao = new ArbitroDAO();
                    List<Arbitro> listArbitroId = new ArrayList();
                    listArbitroId.add(arbitroIdDao.consultarById(arbitroId));
                    request.setAttribute("listArbitroAll", listArbitroId);
                    request.getRequestDispatcher("/ListarArbitro.jsp").forward(request, response);
                }
            }

            if (operacao.equals("Consultar Todos")) {
                ArbitroDAO arbitroAllDao = new ArbitroDAO();
                List<Arbitro> listArbitroAll = arbitroAllDao.consultarArbitros();
                request.setAttribute("listArbitroAll", listArbitroAll);
                request.getRequestDispatcher("/ListarArbitro.jsp").forward(request, response);
            }

            //Operacao para salvar os dados do arbitro dentro do Alterar
            if (operacao.equals("Salvar")) {
                int codArbitroAlt = Integer.parseInt(request.getParameter("altCodArbitro"));
                String nomeArbitroAlt = request.getParameter("altNomeArbitro");
                String cpfArbitroAlt = request.getParameter("altCpfArbitro");
                String dataNascArbitroAlt = request.getParameter("altDataNascArbitro");
                String telArbitroAlt = request.getParameter("altTelArbitro");
                Arbitro arbitroAlt = new Arbitro();
                arbitroAlt.setCodArbitro(codArbitroAlt);
                arbitroAlt.setNome(nomeArbitroAlt);
                arbitroAlt.setCpf(cpfArbitroAlt);
                arbitroAlt.setDataNasc(dataNascArbitroAlt);
                arbitroAlt.setTel(telArbitroAlt);
                ArbitroDAO arbitroAltDao = new ArbitroDAO();
                arbitroAltDao.AtualizarArbitro(arbitroAlt);
                mensagem = "Alteração do cadastro do arbitro atualizado com sucesso";
            }

            if (operacao.equals("Voltar")) {
                request.getRequestDispatcher("/Home.jsp").forward(request, response);
            }
            
            if (operacao.equals("Voltar para cadastro")) {
                request.getRequestDispatcher("/CadastrarArbitro.jsp").forward(request, response);
            }
            
            if (operacao.equals("Voltar para consultas")) {
                request.getRequestDispatcher("/ConsultarArbitro.jsp").forward(request, response);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ClassNotFound " + ex);
        } catch (SQLException ex) {
            System.out.println("Erro SQLException " + ex);
        }

        request.setAttribute("mensagem", mensagem);
        request.getRequestDispatcher("/ResultArbitro.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" NomeArbitro="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
