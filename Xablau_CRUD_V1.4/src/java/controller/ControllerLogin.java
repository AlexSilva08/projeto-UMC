
package controller;

import dao.LoginDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name = "ControllerLogin", urlPatterns = {"/ControllerLogin"})
public class ControllerLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mensagem;

        try {
            String operacao = request.getParameter("BtnOp");

        if (operacao.equals("Login")) {
        String usuario = request.getParameter("usuario"); 
 
        String senha = request.getParameter("senha"); 

        Usuario usuarioGet = new Usuario();
        usuarioGet.setLogin(usuario);
        usuarioGet.setSenha(senha);
        
        LoginDAO usuarioGetDao = new LoginDAO();
        usuarioGetDao.consultUserById(usuarioGet);
        
        String resultado = usuarioGet.getNivelAcesso();
        int codUsuario = usuarioGet.getCodUsuario();
        if("atleta".equals(resultado)){
            
            request.setAttribute("idUsuario",codUsuario);
            //request.setAttribute("nivelAcesso", resultado);
            request.getRequestDispatcher("ConsultarHistorico.jsp").forward(request, response);
            
        } else if ("arbitro".equals(resultado)){
            
            //Chamada de método para trocar o código do usuário para o código do Árbitro
            usuarioGetDao.consultArbitroById(usuarioGet);
            codUsuario = usuarioGet.getCodUsuario();
            
            request.setAttribute("idUsuario",codUsuario);
            //request.setAttribute("nivelAcesso", resultado);
            request.getRequestDispatcher("TelaLogo.jsp").forward(request, response);
            
        } else if ("administrador".equals(resultado)){
            
            request.setAttribute("idUsuario",codUsuario);
            //request.setAttribute("nivelAcesso", resultado);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
            
        } else if ("mesario".equals(resultado)){
            
            request.setAttribute("idUsuario",codUsuario);
            //request.setAttribute("nivelAcesso", resultado);
            request.getRequestDispatcher("TelaSelecao.jsp").forward(request, response);
            
        } else{
            mensagem="0";
            response.sendRedirect("index.jsp?mensagem=" + mensagem);
        }
    }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ClassNotFound " + ex);
        } catch (SQLException ex) {
            System.out.println("Erro SQLException " + ex);
        }
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
