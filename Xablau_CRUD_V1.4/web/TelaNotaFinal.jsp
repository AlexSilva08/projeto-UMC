<%-- 
    Document   : TelaNotaFinal
    Created on : Oct 20, 2021, 11:19:09 PM
    Author     : 11181502562
--%>

<%@page import="model.NotaFinal"%>
<%@page import="java.util.List"%>
<%@page import="dao.NotaFinalDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
        NotaFinalDAO nf = new NotaFinalDAO();
        List<NotaFinal> lnf = nf.SelecionarNotaFinal();
        session.setAttribute("listanotaFinal", lnf);
        
        List<NotaFinal> listNotaFinAll = (List<NotaFinal>) session.getAttribute("listanotaFinal");
        for (NotaFinal nf1 : listNotaFinAll) {
        session.setAttribute("notaFinal", nf1.getNotaFinal());
        session.setAttribute("apresentacao", nf1.getSomaApresentacao());
        session.setAttribute("somaNotas", nf1.getSomaNotas());
        }
    %>
    
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Nota Final</title>
  <link rel="stylesheet" href="css/nota.css">
</head>
<body>

<h3 align="center" style="color:lightgrey;">Xablau Poomsae</h3>
<hr size=5>
<table style="width:100%">
  
    <th><input type="text" value="<%=session.getAttribute("categoria")%>" id="categoria" readonly="true" style=" font-size:30px; border: none; width: 140px;"></th>
    <th><input type="text" value="<%=session.getAttribute("fase")%>" id="fase" readonly="true" style=" font-size:30px; border: none; width: 80px;"></th>
  
</table>
  <hr size = 5>
  
  
	<table align=left style="width:60%; height:350px; margin-bottom: 55px;" class="n">
            <tr>
                <th class="tecnica"><input type="text" value="<%=session.getAttribute("atleta")%>" id="atleta" readonly="true" style=" background-color:CornflowerBlue; font-size:45px; border: none; width: 60%;"></th>
            </tr>
	</table>

	<table align=right style="width:40%" class="n" >
            <tr>
                <th class="arbitro">NOTA FINAL</th>
            </tr>
            <tr>
                <td class="arbitro"><input type="text" value="<%=session.getAttribute("notaFinal")%>" id="notafinal" readonly="true" style=" background-color:yellow; font-size:100px; border: none; width: 40%;"></td>
            </tr>
	</table>

	<table align=right style="width:40%;" class="n">
		<tr>
			<td class="apresentacao">Apresentação</td>
			<td class="apresentacao">Soma das Notas</td>
		</tr>
		<tr>
			<td style="width:20%;"><input type="text" value="<%=session.getAttribute("apresentacao")%>" id="somaapresentacaol" readonly="true" style=" font-size:40px; border: none; width: 40%;"></td>
			<td style="width:20%;"><input type="text" value="<%=session.getAttribute("somaNotas")%>" id="somanotas" readonly="true" style=" font-size:40px; border: none; width: 40%; "></td>
		</tr>
	</table>

</body>
</html>