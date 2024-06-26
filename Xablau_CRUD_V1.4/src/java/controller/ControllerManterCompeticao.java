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
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Competicao;

@WebServlet(name = "ControllerManterCompeticao", urlPatterns = {"/ControllerManterCompeticao"})
public class ControllerManterCompeticao extends HttpServlet {

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
            String operacao = request.getParameter("btnOpCompeticao");

            if (operacao.equals("Cadastrar")) {
                String nomeCompeticaoCad = request.getParameter("cadNomeCompeticao");
                String enderecoCompeticaoCad = request.getParameter("cadEnderecoCompeticao");
                String dataCompeticaoCad = request.getParameter("cadDataCompeticao");
                String horarioCompeticaoCad = request.getParameter("cadHorarioCompeticao");
                Competicao competicaoCad = new Competicao();
                competicaoCad.setNomeCompeticao(nomeCompeticaoCad);
                competicaoCad.setEndereco(enderecoCompeticaoCad);
                competicaoCad.setDataCompeticao(dataCompeticaoCad);
                competicaoCad.setHorario(horarioCompeticaoCad);
                CompeticaoDAO competicaoCadDao = new CompeticaoDAO();
                competicaoCadDao.CadastrarCompeticao(competicaoCad);
                mensagem = "Cadastro de competicao realizado com sucesso";
            }

            if (operacao.equals("Alterar")) {
                int codCompeticaoOpAlt = Integer.parseInt(request.getParameter("altCodCompeticao"));
                Competicao competicaoOpAlt = new Competicao();
                competicaoOpAlt.setCodCompeticao(codCompeticaoOpAlt);
                CompeticaoDAO competicaoOpAltDao = new CompeticaoDAO();
                List<Competicao> listCompeticaoAlt = new ArrayList();
                listCompeticaoAlt.add(competicaoOpAltDao.consultarById(competicaoOpAlt));
                request.setAttribute("listCompeticaoAlt", listCompeticaoAlt);
                request.getRequestDispatcher("/AlterarCompeticao.jsp").forward(request, response);
            }

            if (operacao.equals("Remover")) {

                int codCompeticaoDel = Integer.parseInt(request.getParameter("delCodCompeticao"));
                Competicao competicaoDel = new Competicao();
                competicaoDel.setCodCompeticao(codCompeticaoDel);
                CompeticaoDAO competicaoDeldao = new CompeticaoDAO();
                competicaoDeldao.RemoverCompeticao(competicaoDel);
                mensagem = "RemoÃ§Ã£o de competicao realizada com sucesso";
            }

            if (operacao.equals("Consultar Codigo")) {
                if ("".equals(request.getParameter("cadCodCompeticao"))) {
                    mensagem = "INSIRA UM CODIGO DE COMPETIÇÃO!";
                } else if (!request.getParameter("cadCodCompeticao").substring(1).matches("[0-9]*")) {
                    mensagem = "INSIRA UM CODIGO VALIDO!";
                } else {
                    int codCompeticaoId = Integer.parseInt(request.getParameter("cadCodCompeticao"));
                    Competicao competicaoId = new Competicao();
                    competicaoId.setCodCompeticao(codCompeticaoId);
                    CompeticaoDAO competicaoIdDao = new CompeticaoDAO();
                    List<Competicao> listCompeticaoId = new ArrayList();
                    listCompeticaoId.add(competicaoIdDao.consultarById(competicaoId));
                    request.setAttribute("listCompeticaoAll", listCompeticaoId);
                    request.getRequestDispatcher("/ListarCompeticao.jsp").forward(request, response);
                }
            }

            if (operacao.equals("Consultar Todos")) {
                CompeticaoDAO competicaoAllDao = new CompeticaoDAO();
                List<Competicao> listCompeticaoAll = competicaoAllDao.consultarTodos();
                request.setAttribute("listCompeticaoAll", listCompeticaoAll);
                request.getRequestDispatcher("/ListarCompeticao.jsp").forward(request, response);
            }

            //Operacao para salvar os dados do competicao dentro do Alterar
            if (operacao.equals("Salvar")) {
                int codCompeticaoAlt = Integer.parseInt(request.getParameter("altCodCompeticao"));
                String nomeCompeticaoAlt = request.getParameter("altNomeCompeticao");
                String enderecoCompeticaoAlt = request.getParameter("altEnderecoCompeticao");
                String dataCompeticaoAlt = request.getParameter("altDataCompeticao");
                String horarioCompeticaoAlt = request.getParameter("altHorarioCompeticao");
                Competicao competicaoAlt = new Competicao();
                competicaoAlt.setCodCompeticao(codCompeticaoAlt);
                competicaoAlt.setNomeCompeticao(nomeCompeticaoAlt);
                competicaoAlt.setEndereco(enderecoCompeticaoAlt);
                competicaoAlt.setDataCompeticao(dataCompeticaoAlt);
                competicaoAlt.setHorario(horarioCompeticaoAlt);
                CompeticaoDAO competicaoAltDao = new CompeticaoDAO();
                competicaoAltDao.AtualizarCompeticao(competicaoAlt);
                mensagem = "Atualizado com sucesso";
            }

            if (operacao.equals("Voltar")) {
                request.getRequestDispatcher("/Home.jsp").forward(request, response);
            }
            
            if (operacao.equals("Voltar para cadastro")) {
                request.getRequestDispatcher("/CadastrarCompeticao.jsp").forward(request, response);
            }
            
            if (operacao.equals("Voltar para consultas")) {
                request.getRequestDispatcher("/ConsultarCompeticao.jsp").forward(request, response);
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ClassNotFound " + ex);
        } catch (SQLException ex) {
            System.out.println("Erro SQLException " + ex);
        }

        request.setAttribute("mensagem", mensagem);
        request.getRequestDispatcher("/ResultCompeticao.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" NomeCompeticao="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
