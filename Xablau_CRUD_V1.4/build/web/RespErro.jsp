
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
    </head>
    <body>
        <h1>Result page!</h1>
        <%
            String msg = (String) request.getAttribute("mensagem");
            out.print(msg);
            %>
    </body>
</html>
