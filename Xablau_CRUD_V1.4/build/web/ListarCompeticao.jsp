<%-- 
    Document   : ListarCompeticao
    Created on : Sep 30, 2021, 2:17:48 AM
    Author     : 11181502562
--%>

<%@page import="java.util.List"%>
<%@page import="model.Competicao"%>

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
        <div class="tabelas">
            <h1>Listar Competições</h1>
        <table class="table table-striped">
            <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Endereço</th>
                    <th>Data</th>
                    <th>Horário</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
              </tr>
        <% 
            List<Competicao> listCompeticaoAll = (List<Competicao>) request.getAttribute("listCompeticaoAll");
            for(Competicao competicaoAll : listCompeticaoAll){
            %>
              <tr><%
                %><td><%out.print(competicaoAll.getCodCompeticao());%></td><%
                %><td><%out.print(competicaoAll.getNomeCompeticao());%></td><%
                %><td><%out.print(competicaoAll.getEndereco());%></td><%
                %><td><%out.print(competicaoAll.getDataCompeticao());%></td><%
                %><td><%out.print(competicaoAll.getHorario());%></td><%
                %><td><a href="http://localhost:8080/Xablau_CRUD_V1.4/ControllerManterCompeticao?altCodCompeticao=<%=competicaoAll.getCodCompeticao()%>&btnOpCompeticao=Alterar"><img src="./images/alterar.png" width="30" height="30"></a></td><%
                %><td><a href="http://localhost:8080/Xablau_CRUD_V1.4/ControllerManterCompeticao?delCodCompeticao=<%=competicaoAll.getCodCompeticao()%>&btnOpCompeticao=Remover"><img src="./images/excluir.png" width="30" height="30"></a></td><%
            %></tr><%
            }
        %>
        </table>
        </div>
        <form action="ControllerManterCompeticao" method="post">
                <input type="submit" name="btnOpCompeticao" value="Voltar para consultas" class="btn btn-light">
            </form>
           </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
