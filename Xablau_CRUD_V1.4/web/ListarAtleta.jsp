
<%@page import="java.util.List"%>
<%@page import="model.Atleta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">     
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Xablau</title>
  
    </head>
    <body style="background-image: url(images/bg4.jpg);  background-size: cover;">
        <div class="container">
        <div class="tabelas">
            <h1>Listar Atletas</h1>
        <table class="table table-striped">
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Nascimento <br> Ano-Mes-Dia</th>
                    <th>Telefone</th>
                    <th>Graduação</th>
                    <th>Academia</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
              </tr>   
            <% 
            List<Atleta> listAtletaAll = (List<Atleta>) request.getAttribute("listAtletaAll");
            for(Atleta atletaAll : listAtletaAll){
            %>
              <tr><%
                %><td><%out.print(atletaAll.getCodAtleta());%></td><%
                %><td><%out.print(atletaAll.getNome());%></td><%
                %><td><%out.print(atletaAll.getCpf());%></td><%
                %><td><%out.print(atletaAll.getDataNasc());%></td><%
                %><td><%out.print(atletaAll.getTel());%></td><%
                %><td><%out.print(atletaAll.getGraduacao());%></td><%
                %><td><%out.print(atletaAll.getAcademia());%></td><%
                %><td><a href="http://localhost:8080/Xablau_CRUD_V1.4/ControllerManterAtleta?altCodAtleta=<%=atletaAll.getCodAtleta()%>&btnOp=Alterar"><img src="./images/alterar.png" width="30" height="30"></a></td><%
                %><td><a href="http://localhost:8080/Xablau_CRUD_V1.4/ControllerManterAtleta?delCodAtleta=<%=atletaAll.getCodAtleta()%>&btnOp=Remover"><img src="./images/excluir.png" width="30" height="30"></a></td><%
            %></tr><%
            }
        %>
        </table>
        </div>
        <form action="ControllerManterAtleta" method="post">
                <input type="submit" name="btnOp" value="Voltar para consultas" class="btn btn-light">
            </form>
           </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
