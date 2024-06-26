<%-- 
    Document   : Home
    Created on : Sep 19, 2021, 11:18:14 PM
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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">     
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <title>Xablau</title>
    </head>
    <body style="background-image: url(images/bg4.jpg); background-size: cover;">
 
  <div class="container"> 
      <div class="box">
      <h1>Gerenciamento de atletas</h1>    
      <div class="one"> 
          <a href="CadastrarAtleta.jsp"><button type="button" class="btn btn-primary btn-lg">Cadastrar</button></a>
          <a href="ConsultarAtleta.jsp"><button type="button" class="btn btn-primary btn-lg">Consultar</button></a>
      </div>
    </div>
      <div class="box">
      <h1>Gerenciamento de arbitros</h1>    
      <div class="one"> 
          <a href="CadastrarArbitro.jsp"><button type="button" class="btn btn-primary btn-lg">Cadastrar</button></a>
          <a href="ConsultarArbitro.jsp"><button type="button" class="btn btn-primary btn-lg">Consultar</button></a>
      </div>
    </div>
      <div class="box">
      <h1>Gerenciamento de competições</h1>    
      <div class="one"> 
          <a href="CadastrarCompeticao.jsp"><button type="button" class="btn btn-primary btn-lg">Cadastrar</button></a>
          <a href="ConsultarCompeticao.jsp"><button type="button" class="btn btn-primary btn-lg">Consultar</button></a>
      </div>
    </div>
      <div class="box">
      <h1>Gerenciamento de categorias</h1>    
      <div class="one"> 
          <a href="CadastrarCategoria.jsp"><button type="button" class="btn btn-primary btn-lg">Cadastrar</button></a>
          <a href="ConsultarCategoria.jsp"><button type="button" class="btn btn-primary btn-lg">Consultar</button></a>
      </div>
    </div>
      <div class="box">
      <h1>Gerenciamento de fases</h1>    
      <div class="one"> 
          <a href="CadastrarFase.jsp"><button type="button" class="btn btn-primary btn-lg">Cadastrar</button></a>
          <a href="ConsultarFase.jsp"><button type="button" class="btn btn-primary btn-lg">Consultar</button></a>
      </div>
    </div>
      <div class="box">
      <h1>Gerenciamento de inscrições</h1>    
      <div class="one"> 
          <a href="CadastrarInscricao.jsp"><button type="button" class="btn btn-primary btn-lg">Cadastrar</button></a>
          <a href="ConsultarInscricao.jsp"><button type="button" class="btn btn-primary btn-lg">Consultar</button></a>
      </div>
    </div>
      </div>


     
	</form>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
