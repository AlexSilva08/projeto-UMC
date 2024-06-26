
package controller;

import dao.NotaDAO;
import dao.NotaFinalDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Nota;
import model.NotaFinal;

@WebServlet(name = "ControllerManterNotaFinal", urlPatterns = {"/ControllerManterNotaFinal"})
public class ControllerManterNotaFinal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mensagem = "";

        try {
            String operacao = request.getParameter("btnOpSelecao");

                if (operacao.equals("Confirmar Notas")) {
                double tecnica1 = Double.parseDouble(request.getParameter("tec1"));
                double tecnica2 = Double.parseDouble(request.getParameter("tec2"));
                double tecnica3 = Double.parseDouble(request.getParameter("tec3"));
                double tecnica4 = Double.parseDouble(request.getParameter("tec4"));
                double tecnica5 = Double.parseDouble(request.getParameter("tec5"));
                
                double somaAllTecnica = tecnica1 + tecnica2 + tecnica3 + tecnica4 + tecnica5;
                
                NotaFinal somaNotaFinalAll = new NotaFinal();
                somaNotaFinalAll.setSomaTecnica(somaAllTecnica);
                
                double apresentacao1 = Double.parseDouble(request.getParameter("apr1"));
                double apresentacao2 = Double.parseDouble(request.getParameter("apr2"));
                double apresentacao3 = Double.parseDouble(request.getParameter("apr3"));
                double apresentacao4 = Double.parseDouble(request.getParameter("apr4"));
                double apresentacao5 = Double.parseDouble(request.getParameter("apr5"));
                
                double somaAllApresentacao = apresentacao1 + apresentacao2 + apresentacao3 + apresentacao4 + apresentacao5;
                
                somaNotaFinalAll.setSomaApresentacao(somaAllApresentacao);
                
                double somaAllNotas = tecnica1 + tecnica2 + tecnica3 + tecnica4 + tecnica5 + apresentacao1 + apresentacao2 + apresentacao3 + apresentacao4 + apresentacao5;
                
                somaNotaFinalAll.setSomaNotas(somaAllNotas);
                
                double maiorTec = tecnica1;
                if(maiorTec < tecnica2){maiorTec = tecnica2;}
                if(maiorTec < tecnica3){maiorTec = tecnica3;}
                if(maiorTec < tecnica4){maiorTec = tecnica4;}
                if(maiorTec < tecnica5){maiorTec = tecnica5;}
                double menorTec = tecnica1;
                if(menorTec > tecnica2){menorTec = tecnica2;}
                if(menorTec > tecnica3){menorTec = tecnica3;}
                if(menorTec > tecnica4){menorTec = tecnica4;}
                if(menorTec > tecnica5){menorTec = tecnica5;}
                
                double maiorApres = apresentacao1;
                if(maiorApres < apresentacao2){maiorApres = apresentacao2;}
                if(maiorApres < apresentacao3){maiorApres = apresentacao3;}
                if(maiorApres < apresentacao4){maiorApres = apresentacao4;}
                if(maiorApres < apresentacao5){maiorApres = apresentacao5;}
                double menorApres = apresentacao1;
                if(menorApres > apresentacao2){menorApres = apresentacao2;}
                if(menorApres > apresentacao3){menorApres = apresentacao3;}
                if(menorApres > apresentacao4){menorApres = apresentacao4;}
                if(menorApres > apresentacao5){menorApres = apresentacao5;}
                
                Nota mudarSituacaoTecnica = new Nota();
                mudarSituacaoTecnica.setTecnica(maiorTec);
                mudarSituacaoTecnica.setApresentacao(menorTec);
                
                NotaDAO AltSituacaoTecDao = new NotaDAO();
                AltSituacaoTecDao.alterarAtributoTec(mudarSituacaoTecnica);
                
                Nota mudarSituacaoApresentacao = new Nota();
                mudarSituacaoApresentacao.setTecnica(maiorApres);
                mudarSituacaoApresentacao.setApresentacao(menorApres);
                
                NotaDAO AltSituacaoApresDao = new NotaDAO();
                AltSituacaoApresDao.alterarAtributoApres(mudarSituacaoApresentacao);
                
                double NotaMaster = (somaAllNotas - maiorTec - menorTec - maiorApres - menorApres)/3;
                somaNotaFinalAll.setNotaFinal(NotaMaster);
                
                
                NotaFinalDAO somaNotaFinalDao = new NotaFinalDAO();
                somaNotaFinalDao.CadastrarSomaNotas(somaNotaFinalAll);
                
                }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ClassNotFound " + ex);
        } catch (SQLException ex) {
            System.out.println("Erro SQLException " + ex);
        }

        request.setAttribute("mensagem", mensagem);
        request.getRequestDispatcher("/TelaNotaFinal.jsp").forward(request, response);
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