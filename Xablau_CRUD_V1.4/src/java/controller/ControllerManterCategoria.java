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
import dao.CategoriaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;

@WebServlet(name = "ControllerManterCategoria", urlPatterns = {"/ControllerManterCategoria"})
public class ControllerManterCategoria extends HttpServlet {

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
            String operacao = request.getParameter("btnOpCategoria");

            if (operacao.equals("Cadastrar")) {
                String descCategoriaCad = request.getParameter("cadDescCategoria");
                String idadeCategoriaCad = request.getParameter("cadIdadeCategoria");
                String sexoCategoriaCad = request.getParameter("cadSexoCategoria");
                Categoria categoriaCad = new Categoria();
                categoriaCad.setDescCategoria(descCategoriaCad);
                categoriaCad.setIdade(idadeCategoriaCad);
                categoriaCad.setSexo(sexoCategoriaCad);
                CategoriaDAO categoriaCadDao = new CategoriaDAO();
                categoriaCadDao.CadastrarCategoria(categoriaCad);
                mensagem = "Cadastro de categoria realizado com sucesso";
            }

            if (operacao.equals("Alterar")) {
                int codCategoriaOpAlt = Integer.parseInt(request.getParameter("altCodCategoria"));
                Categoria categoriaOpAlt = new Categoria();
                categoriaOpAlt.setCodCategoria(codCategoriaOpAlt);
                CategoriaDAO categoriaOpAltDao = new CategoriaDAO();
                List<Categoria> listCategoriaAlt = new ArrayList();
                listCategoriaAlt.add(categoriaOpAltDao.consultarById(categoriaOpAlt));
                request.setAttribute("listCategoriaAlt", listCategoriaAlt);
                request.getRequestDispatcher("/AlterarCategoria.jsp").forward(request, response);
            }

            if (operacao.equals("Remover")) {

                int codCategoriaDel = Integer.parseInt(request.getParameter("delCodCategoria"));
                Categoria categoriaDel = new Categoria();
                categoriaDel.setCodCategoria(codCategoriaDel);
                CategoriaDAO categoriaDeldao = new CategoriaDAO();
                categoriaDeldao.RemoverCategoria(categoriaDel);
                mensagem = "Remoção de categoria realizada com sucesso";
            }

            if (operacao.equals("Consultar Codigo")) {
                if ("".equals(request.getParameter("cadCodCategoria"))) {
                    mensagem = "INSIRA UM CODIGO DE CATEGORIA!";
                } else if (!request.getParameter("cadCodCategoria").substring(1).matches("[0-9]*")) {
                    mensagem = "INSIRA UM CODIGO VALIDO!";
                } else {
                    int codCategoriaId = Integer.parseInt(request.getParameter("cadCodCategoria"));
                    Categoria categoriaId = new Categoria();
                    categoriaId.setCodCategoria(codCategoriaId);
                    CategoriaDAO categoriaIdDao = new CategoriaDAO();
                    List<Categoria> listCategoriaId = new ArrayList();
                    listCategoriaId.add(categoriaIdDao.consultarById(categoriaId));
                    request.setAttribute("listCategoriaAll", listCategoriaId);
                    request.getRequestDispatcher("/ListarCategoria.jsp").forward(request, response);
                }
            }

            if (operacao.equals("Consultar Todos")) {
                CategoriaDAO categoriaAllDao = new CategoriaDAO();
                List<Categoria> listCategoriaAll = categoriaAllDao.consultarAllCategoria();
                request.setAttribute("listCategoriaAll", listCategoriaAll);
                request.getRequestDispatcher("/ListarCategoria.jsp").forward(request, response);
            }

            //Operacao para salvar os dados do categoria dentro do Alterar
            if (operacao.equals("Salvar")) {
                int codCategoriaAlt = Integer.parseInt(request.getParameter("altCodCategoria"));
                String descCategoriaAlt = request.getParameter("altDescricaoCategoria");
                String idadeCategoriaAlt = request.getParameter("altIdadeCategoria");
                String sexoCategoriaAlt = request.getParameter("altSexoCategoria");
                Categoria categoriaAlt = new Categoria();
                categoriaAlt.setCodCategoria(codCategoriaAlt);
                categoriaAlt.setDescCategoria(descCategoriaAlt);
                categoriaAlt.setIdade(idadeCategoriaAlt);
                categoriaAlt.setSexo(sexoCategoriaAlt);
                CategoriaDAO categoriaAltDao = new CategoriaDAO();
                categoriaAltDao.AtualizarCategoria(categoriaAlt);
                mensagem = "Atualizado com sucesso";
            }

            if (operacao.equals("Voltar")) {
                request.getRequestDispatcher("/Home.jsp").forward(request, response);
            }
            
            if (operacao.equals("Voltar para cadastro")) {
                request.getRequestDispatcher("/CadastrarCategoria.jsp").forward(request, response);
            }
            
            if (operacao.equals("Voltar para consultas")) {
                request.getRequestDispatcher("/ConsultarCategoria.jsp").forward(request, response);
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ClassNotFound " + ex);
        } catch (SQLException ex) {
            System.out.println("Erro SQLException " + ex);
        }

        request.setAttribute("mensagem", mensagem);
        request.getRequestDispatcher("/ResultCategoria.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" NomeCategoria="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
