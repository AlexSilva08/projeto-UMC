
<%@page import="java.util.List"%>
<%@page import="model.Atleta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">     
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Xablau</title>
    </head>
        <body style="background-image: url(images/bg4.jpg); background-size: cover;">


  <div class="container"> 
      
      <div class="box2">
          <h1>Alterar Atleta</h1>   
   
           <% 
            List<Atleta> listAtletaAlt = (List<Atleta>) request.getAttribute("listAtletaAlt");
            for(Atleta atletalter : listAtletaAlt){
            %><form action="ControllerManterAtleta" method="post"><%
                %><input type="hidden" name="altCodAtleta" value="<%out.print(atletalter.getCodAtleta());%>"><%
                %>Nome: <input type="text" name="altNomeAtleta" class="form-control" value="<%out.print(atletalter.getNome());%>"><br><%
                %>CPF: <input type="text" name="altCpfAtleta" class="form-control" value="<%out.print(atletalter.getCpf());%>"><br><%
                %>Data de Nascimento: <input type="date" name="altDataNascAtleta" class="form-control" value="<%out.print(atletalter.getDataNasc());%>"><br><%
                %>Telefone: <input type="text" name="altTelAtleta" class="form-control" value="<%out.print(atletalter.getTel());%>"><br><%
                %>Graduacao: <input type="text" name="altGraduacaoAtleta" class="form-control" value="<%out.print(atletalter.getGraduacao());%>"><br><%
                %>Academia: <input type="text" name="altAcademiaAtleta" class="form-control" value="<%out.print(atletalter.getAcademia());%>"><br><%
                %><input type="submit" name="btnOp" value="Salvar"  class="btn btn-light"> <%
                %><input type="submit" name="btnOp" value="Voltar para consultas"  class="btn btn-light"><%
                %><br><br><%
                %><a href="Home.jsp"><button type="button" class="btn btn-primary btn-lg">Menu principal</button></a><%
            %></form><%
            }
        %>
    
    </div>
      </div>
          

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>