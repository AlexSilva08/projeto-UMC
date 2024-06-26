<%-- 
    Document   : AtletaConsultado
    Created on : Nov 19, 2021, 11:38:33 PM
    Author     : 11181502562
--%>


<%@page import="java.util.List"%>
<%@page import="model.Atleta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">     
    <link href="css/nota.css" rel="stylesheet" type="text/css"/>
        <title>Atleta</title>
  
    </head>
    <body style="background-image: url(images/bg4.jpg); background-size: cover;">
        <div class="container">
        <div class="tabelas">
            <h1>Atleta Consultado</h1>
        <table class="table table-striped">
            <tr>
                <th>Código</th>
                <th>Atleta</th>
                <th>Competição</th>
                <th>Categoria</th>
                <th>Fase</th>
                <th>Nota final</th>
            </tr> 
        <% 
            List<Atleta> listAtletaAll = (List<Atleta>) request.getAttribute("listAtletaAll");
            for(Atleta atletaAll : listAtletaAll){
            %><tr><%
                %><td><%out.print(atletaAll.getCodAtleta());%></td><%
                %><td><%out.print(atletaAll.getNome());%></td><%
                %><td><%out.print(atletaAll.getCpf());%></td><%
                %><td><%out.print(atletaAll.getDataNasc());%></td><%
                %><td><%out.print(atletaAll.getTel());%></td><%
                %><td><%out.print(atletaAll.getGraduacao());%></td><%
            %></tr><%
            }
        %>
        </table>
        </div>
        <form action="ControllerManterAtleta" method="post">
                <input type="submit" name="btnOp" value="Nova consulta" class="btn btn-light">
            </form>
           </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
