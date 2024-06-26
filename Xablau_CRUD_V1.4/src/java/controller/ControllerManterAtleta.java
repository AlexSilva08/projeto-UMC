package controller;

import dao.AtletaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Atleta;

@WebServlet(name = "ControllerManterAtleta", urlPatterns = {"/ControllerManterAtleta"})
public class ControllerManterAtleta extends HttpServlet {

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

            if (operacao.equals("Alterar")) {
                int codAtletaOpAlt = Integer.parseInt(request.getParameter("altCodAtleta"));
                Atleta atletaOpAlt = new Atleta();
                atletaOpAlt.setCodAtleta(codAtletaOpAlt);
                AtletaDAO atletaOpAltDao = new AtletaDAO();
                List<Atleta> listAtletaAlt = new ArrayList();
                listAtletaAlt.add(atletaOpAltDao.consultarById(atletaOpAlt));
                request.setAttribute("listAtletaAlt", listAtletaAlt);
                request.getRequestDispatcher("/AlterarAtleta.jsp").forward(request, response);
            }

            if (operacao.equals("Remover")) {

                int codAtletaDel = Integer.parseInt(request.getParameter("delCodAtleta"));
                Atleta atletaDel = new Atleta();
                atletaDel.setCodAtleta(codAtletaDel);
                AtletaDAO atletaDeldao = new AtletaDAO();
                atletaDeldao.RemoverAtleta(atletaDel);
                mensagem = "Remoção de atleta realizada com sucesso";
            }

            if (operacao.equals("Consultar Codigo")) {
                if ("".equals(request.getParameter("cadCodAtleta"))) {
                    mensagem = "INSIRA UM CODIGO DE ATLETA!";
                } else if (!request.getParameter("cadCodAtleta").substring(1).matches("[0-9]*")) {
                    mensagem = "INSIRA UM CODIGO VALIDO!";
                } else {
                    int codAtletaId = Integer.parseInt(request.getParameter("cadCodAtleta"));
                    Atleta atletaId = new Atleta();
                    atletaId.setCodAtleta(codAtletaId);
                    AtletaDAO atletaIdDao = new AtletaDAO();
                    List<Atleta> listAtletaId = new ArrayList();
                    listAtletaId.add(atletaIdDao.consultarById(atletaId));
                    request.setAttribute("listAtletaAll", listAtletaId);
                    request.getRequestDispatcher("/ListarAtleta.jsp").forward(request, response);
                }
            }
            
            if (operacao.equals("Consultar Atleta")) {
                int codAtlet = Integer.parseInt(request.getParameter("conCodAtleta"));
                Atleta atletaId = new Atleta();
                atletaId.setCodAtleta(codAtlet);
                AtletaDAO atletaIdDao = new AtletaDAO();
                List<Atleta> listaAtleta = new ArrayList();
                listaAtleta.add(atletaIdDao.consultarIdAtleta(atletaId));
                request.setAttribute("listAtletaAll", listaAtleta);
                request.getRequestDispatcher("/AtletaConsultado.jsp").forward(request, response);
            }

            if (operacao.equals("Consultar Historico")) {
                AtletaDAO atletaAllDao = new AtletaDAO();
                List<Atleta> listAtletaAll = atletaAllDao.consultarHistorico();
                request.setAttribute("listAtletaAll", listAtletaAll);
                request.getRequestDispatcher("/AtletaConsultado.jsp").forward(request, response);
            }
            
            if (operacao.equals("Consultar Todos")) {
                AtletaDAO atletaAllDao = new AtletaDAO();
                List<Atleta> listAtletaAll = atletaAllDao.consultarAtletas();
                request.setAttribute("listAtletaAll", listAtletaAll);
                request.getRequestDispatcher("/ListarAtleta.jsp").forward(request, response);
            }

            //Operacao para salvar os dados do atleta dentro do Alterar
            if (operacao.equals("Salvar")) {
                int codAtletaAlt = Integer.parseInt(request.getParameter("altCodAtleta"));
                String nomeAtletaAlt = request.getParameter("altNomeAtleta");
                String cpfAtletaAlt = request.getParameter("altCpfAtleta");
                String dataNascAtletaAlt = request.getParameter("altDataNascAtleta");
                String telAtletaAlt = request.getParameter("altTelAtleta");
                String graduacaoAtletaAlt = request.getParameter("altGraduacaoAtleta");
                String academiaAtletaAlt = request.getParameter("altAcademiaAtleta");
                Atleta atletaAlt = new Atleta();
                atletaAlt.setCodAtleta(codAtletaAlt);
                atletaAlt.setNome(nomeAtletaAlt);
                atletaAlt.setCpf(cpfAtletaAlt);
                atletaAlt.setDataNasc(dataNascAtletaAlt);
                atletaAlt.setTel(telAtletaAlt);
                atletaAlt.setGraduacao(graduacaoAtletaAlt);
                atletaAlt.setAcademia(academiaAtletaAlt);
                AtletaDAO atletaAltDao = new AtletaDAO();
                atletaAltDao.AtualizarAtleta(atletaAlt);
                mensagem = "Alteração do cadastro do atleta atualizado com sucesso";
            }

            if (operacao.equals("Voltar")) {
                request.getRequestDispatcher("/Home.jsp").forward(request, response);
            }
            
            if (operacao.equals("Voltar para cadastro")) {
                request.getRequestDispatcher("/CadastrarAtleta.jsp").forward(request, response);
            }
            
            if (operacao.equals("Voltar para consultas")) {
                request.getRequestDispatcher("/ConsultarAtleta.jsp").forward(request, response);
            }
            
            if (operacao.equals("Nova consulta")) {
                request.getRequestDispatcher("/ConsultarHistorico.jsp").forward(request, response);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ClassNotFound " + ex);
        } catch (SQLException ex) {
            System.out.println("Erro SQLException " + ex);
        }

        request.setAttribute("mensagem", mensagem);
        request.getRequestDispatcher("/ResultAtleta.jsp").forward(request, response);
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
