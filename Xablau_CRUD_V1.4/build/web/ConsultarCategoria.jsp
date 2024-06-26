<%-- 
    Document   : CadastrarCategoria
    Created on : Nov 26, 2021, 5:23:19 PM
    Author     : 11181502562
--%>

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
          <h1>Categoria</h1>   

          <form action="ControllerManterCategoria" method="post">
              Codigo da Categoria: <input type="text" name="cadCodCategoria" class="form-control"><br>
              
              <input type="submit" name="btnOpCategoria" value="Consultar Codigo" class="btn btn-light">
              <input type="submit" name="btnOpCategoria" value="Consultar Todos" class="btn btn-light">
              
          </form>
          <br><br>
          <a href="Home.jsp"><button type="button" class="btn btn-primary btn-lg">Menu principal</button></a>
      </div>
  </div>
          

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>