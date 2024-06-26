<%-- 
    Document   : TelaSelecao
    Created on : Nov 18, 2021, 9:19:50 PM
    Author     : 11181502562
--%>
<%@page import="dao.FaseDAO"%>
<%@page import="dao.AtletaDAO"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="model.Competicao"%>
<%@page import="dao.CompeticaoDAO"%>
<%@page import="model.Categoria"%>
<%@page import="model.Fase"%>
<%@page import="model.Atleta"%>
<%@page import="java.util.List"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seleção de atleta</title>
        <link rel="shortcut icon" href="/Xablau_CRUD_V1.4/images/favicon.png">
        <link rel="stylesheet" href="css/nota.css">
    </head>
    <body><div class="selecao">
        <form action ="ControllerManterSelecao" method ="post">
            <ul>
                <label for ="nomeCompeticao" class="selecao">Competição</label>
                <br><select name ="nomeCompeticao" id ="nomeCompeticao"  style=" background:#ccc;padding: 5px;margin-left: 35px; font-size:25px;">
                    <option selected="" id="op1">--Selecione o atleta e a competição--</option>
                        <%
                            AtletaDAO ad = new AtletaDAO();
                            List<Atleta> lc = ad.consultarInscritos();
                            for (Atleta a : lc) {
                        %>
                        <option value=<%=a.getCodAtleta()%>> <%=a.getNome()%> - <%=a.getDataNasc()%> - <%=a.getCpf()%>;</option>
                        <%request.setAttribute("nomeCompeticao", a);%>
                        <%session.setAttribute("atleta", a.getNome());%>
                        <%session.setAttribute("categoria", a.getDataNasc());%>
                        <%}%>
                    </select><br>
                    
                    <br><label for ="faseCompeticao" class="selecao">Fase</label>
                <br><select name ="faseCompeticao" id ="faseCompeticao" style=" background:#ccc;padding: 5px;margin-left: 35px; font-size:25px;">
                        <option selected="" id="op2" onclick="selecionarFase()">--Selecione a fase do competição--</option>
                        <%
                            FaseDAO fd = new FaseDAO();
                            List<Fase> lf = fd.consultarFases();
                            for (Fase f : lf) {
                        %>
                        <option value=<%=f.getCodFase()%>> <%=f.getDescricao()%></option>
                        <%request.setAttribute("faseCompeticao", f);%>
                        <%session.setAttribute("fase", f.getDescricao());%>
                        <%}%>
                    </select>
            </ul>
                    <a><button class="btn" type="submit" name="btnOpSelecao" value="Confirmar Selecionados">Confirmar</button></a>
        </form>
                    </div>
    </body>
    <script>
        function selecionarInscricao(){
            var x = document.getElementById("nomeCompeticao").value;
            document.getElementById("idAtleta").value = x;
        }
        
        function selecionarFase(){
            var y = document.getElementById("faseCompeticao").value;
            document.getElementById("idFase").value = y;
        }
    </script>
</html>
