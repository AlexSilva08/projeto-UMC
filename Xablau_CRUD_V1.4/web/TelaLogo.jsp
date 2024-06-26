<%-- 
    Document   : TelaLogo
    Created on : Nov 12, 2021, 2:15:54 AM
    Author     : 11181502562
--%>
<%
    if(request.getAttribute("idUsuario") != null) {
        if (session.getAttribute("usuario") == null){
        session.setAttribute("usuario", request.getAttribute("idUsuario"));
        //session.setAttribute("nivelacesso", request.getAttribute("nivelAcesso"));
        out.println(session.getAttribute("usuario"));
        } else {
            out.print(session.getAttribute("usuario"));
            //out.print(session.getAttribute("nivelacesso"));
        }
    } else {
        //String mensagem= "0";
        //response.sendRedirect("index.jsp?mensagem=" + mensagem);
    }
%>

<%@page import="dao.InscricaoDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Inscricao"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
        InscricaoDAO ad = new InscricaoDAO();
        List<Inscricao> li = ad.PuxarInscricao();
        session.setAttribute("listInscricaoAll", li);
    %>
    
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Logo</title>
  <link rel="stylesheet" href="css/nota.css">
</head>

<body onload="autoRefreshPage()">
    
<input type="hidden" id="reload" name="btnOp" value="Puxar inscricao">

<% 
    if(session.getAttribute("listInscricaoAll").equals(null)){
        %>
        <a><img type="button" id="botao" src="images/logo.jpeg" class="logo" class="media-object  img-responsive img-thumbnail"></a>
        <%
    } else
                {
                List<Inscricao> listInscricaoAll = (List<Inscricao>) session.getAttribute("listInscricaoAll");
                for(Inscricao InscricaoAll : listInscricaoAll){
                session.setAttribute("codUsuario", InscricaoAll.getAtleta_codAtleta());
                session.setAttribute("codCategoria", InscricaoAll.getCompeticao_categoria_codCategoria());
                session.setAttribute("codCompeticao", InscricaoAll.getCompeticao_categoria_codCompeticao());
                session.setAttribute("codNotaFinal", InscricaoAll.getNotaFinal_codNotaFinal());
                %>
                    <a href="TelaAtribuicao.jsp"><img type="button" id="botao"  src="images/logo.jpeg" class="logo" class="media-object  img-responsive img-thumbnail"></a><%
                }        
            }
%>

</body>

<script>
function autoRefreshPage() {
    setInterval(function () {location.reload(); document.getElementById("reload").click();}, 3000);
}
</script>

</html>