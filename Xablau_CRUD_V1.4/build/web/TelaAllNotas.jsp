<%-- 
    Document   : TelaTimerNota
    Created on : Oct 20, 2021, 3:59:08 AM
    Author     : 11181502562
--%>

<%@page import="model.Nota"%>
<%@page import="dao.NotaDAO"%>
<%@page import="model.Inscricao"%>
<%@page import="java.util.List"%>
<%@page import="dao.InscricaoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
        double var = 0.0;
        
        NotaDAO nd1 = new NotaDAO();
        List<Nota> ln1 = nd1.PuxarNota1();
        session.setAttribute("nota1", ln1);
        
        NotaDAO nd2 = new NotaDAO();
        List<Nota> ln2 = nd2.PuxarNota2();
        session.setAttribute("nota2", ln2);
        
        NotaDAO nd3 = new NotaDAO();
        List<Nota> ln3 = nd3.PuxarNota3();
        session.setAttribute("nota3", ln3);
        
        NotaDAO nd4 = new NotaDAO();
        List<Nota> ln4 = nd4.PuxarNota4();
        session.setAttribute("nota4", ln4);
        
        NotaDAO nd5 = new NotaDAO();
        List<Nota> ln5 = nd5.PuxarNota5();
        session.setAttribute("nota5", ln5);
        
    
    List<Nota> listNotaAll1 = (List<Nota>) session.getAttribute("nota1");
    for (Nota n1 : listNotaAll1) {
    session.setAttribute("tecnica1", n1.getTecnica());
    session.setAttribute("apresentacao1", n1.getApresentacao());
    }
    
    List<Nota> listNotaAll2 = (List<Nota>) session.getAttribute("nota2");
    for (Nota n2 : listNotaAll2) {
    session.setAttribute("tecnica2", n2.getTecnica());
    session.setAttribute("apresentacao2", n2.getApresentacao());
    }
    
    List<Nota> listNotaAll3 = (List<Nota>) session.getAttribute("nota3");
    for (Nota n3 : listNotaAll3) {
    session.setAttribute("tecnica3", n3.getTecnica());
    session.setAttribute("apresentacao3", n3.getApresentacao());
    }
    
    List<Nota> listNotaAll4 = (List<Nota>) session.getAttribute("nota4");
    for (Nota n4 : listNotaAll4) {
    session.setAttribute("tecnica4", n4.getTecnica());
    session.setAttribute("apresentacao4", n4.getApresentacao());   
    }
    
    List<Nota> listNotaAll5 = (List<Nota>) session.getAttribute("nota5");
    for (Nota n5 : listNotaAll5) {
    session.setAttribute("tecnica5", n5.getTecnica());
    session.setAttribute("apresentacao5", n5.getApresentacao());
    }
%>
    
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Notas</title>
  <link rel="stylesheet" href="css/nota.css">
</head>
<body onload="autoRefreshPage()">


<h3 align="center" style="color:lightgrey;">Xablau Poomsae</h3>
<hr size="5">
<table style="width:100%">
  <tbody><tr>
    <th><input type="text" value="<%=session.getAttribute("categoria")%>" id="categoria" readonly="true" style=" font-size:30px; border: none; width: 140px;"></th>
    <th><input type="text" value="<%=session.getAttribute("fase")%>" id="fase" readonly="true" style=" font-size:30px; border: none; width: 80px;"></th>
  </tr>
</tbody></table>
  <hr size="5">

<form action ="ControllerManterNotaFinal" method ="post">  
  <table align="right" style="width:30%">
  <tbody><tr>
    <th class="arbitro">Árb.</th>
    <th class="tecnica">Téc.</th>
    <th class="apresentacao">Apr.</th>
  </tr>
  <tr>
    <td class="arbitro">1</td>
    <td class="tecnica"><input type="text" value="<%=session.getAttribute("tecnica1")%>" id="tec1" name="tec1" readonly="true" style="background-color:CornflowerBlue; font-size:40px; border: none; width: 55px;"></td>
    <td class="apresentacao"><input type="text" value="<%=session.getAttribute("apresentacao1")%>" id="apr1" name="apr1" readonly="true" style="background-color:FireBrick; font-size:40px; border: none; width: 55px;"></td>
  </tr>
  <tr>
    <td class="arbitro">2</td>
    <td class="tecnica"><input type="text" value="<%=session.getAttribute("tecnica2")%>" id="tec2" name="tec2" readonly="true" style="background-color:CornflowerBlue; font-size:40px; border: none; width: 55px;"></td>
    <td class="apresentacao"><input type="text" value="<%=session.getAttribute("apresentacao2")%>" id="apr2" name="apr2" readonly="true" style="background-color:FireBrick; font-size:40px; border: none; width: 55px;"></td>
  </tr>
  <tr>
    <td class="arbitro">3</td>
    <td class="tecnica"><input type="text" value="<%=session.getAttribute("tecnica3")%>" id="tec3" name="tec3" readonly="true" style="background-color:CornflowerBlue; font-size:40px; border: none; width: 55px;"></td>
    <td class="apresentacao"><input type="text" value="<%=session.getAttribute("apresentacao3")%>" id="apr3" name="apr3" readonly="true" style="background-color:FireBrick; font-size:40px; border: none; width: 55px;"></td>
  </tr>
  <tr>
    <td class="arbitro">4</td>
    <td class="tecnica"><input type="text" value="<%=session.getAttribute("tecnica4")%>" id="tec4" name="tec4" readonly="true" style="background-color:CornflowerBlue; font-size:40px; border: none; width: 55px;"></td>
    <td class="apresentacao"><input type="text" value="<%=session.getAttribute("apresentacao4")%>" id="apr4" name="apr4" readonly="true" style="background-color:FireBrick; font-size:40px; border: none; width: 55px;"></td>
  </tr>
  <tr>
    <td class="arbitro">5</td>
    <td class="tecnica"><input type="text" value="<%=session.getAttribute("tecnica5")%>" id="tec5" name="tec5" readonly="true" style="background-color:CornflowerBlue; font-size:40px; border: none; width: 55px;"></td>
    <td class="apresentacao"><input type="text" value="<%=session.getAttribute("apresentacao5")%>" id="apr5" name="apr5" readonly="true" style="background-color:FireBrick; font-size:40px; border: none; width: 55px;"></td>
  </tr>
</tbody></table>

<fieldset style="height:410px;">
    <br><br><h1><input type="text" value="<%=session.getAttribute("atleta")%>" id="atleta" readonly="true" style="font-size:60px; border: none; align:center;"></h1><br><br><br>
</fieldset>


<a href="TelaNotaFinal.jsp"><button class="btn" type="submit" name="btnOpSelecao" value="Confirmar Notas" style="width:100%">Poomsae</button></a>

</form>
</body>

<script>
    function autoRefreshPage() {
        setInterval(function () {location.reload();}, 7000);
    }
</script>
</html>
