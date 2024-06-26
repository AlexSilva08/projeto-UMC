<%@page import="model.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Login Xablau</title>
        <link rel="shortcut icon" href="/Xablau_CRUD_V1.4/images/favicon.png">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/style.css">

    </head>
    <body style="background-image: url(images/bg.jpg);">
        
        <section class="ftco-section">
            <div style="text-align: center;"><br><img src="images/logo.jpeg" width="100"></div>
            <div class="container">
                
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h2 class="heading-section">Login</h2>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap p-0">
                            <form method="post" action="ControllerLogin" class="signin-form">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="usuario" value="" placeholder="usuario" required>
                                </div>
                                <div class="form-group">
                                    <input id="password-field" type="password" name="senha" value="" class="form-control" placeholder="senha" required>
                                    <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>
                                <div class="form-group">
                                    <button type="submit"  name="BtnOp" value="Login" class="form-control btn btn-primary submit px-3">Logar</button>
                                </div>
                                <div class="form-group d-md-flex">
                                <%
                                    if(request.getParameter("mensagem") != null) {
                                        out.print("<script>alert('Usuário não Cadastrado ou incorreto')</script>");
                                    }
                                %>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>

