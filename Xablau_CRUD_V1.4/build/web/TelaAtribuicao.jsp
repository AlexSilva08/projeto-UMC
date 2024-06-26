<%-- 
    Document   : TelaAtribuicao
    Created on : Oct 16, 2021, 8:06:33 PM
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
        <title>Xablau Poomsae</title>
    </head>
    <body class="img js-fullheight" style="background-color: darkgrey;">
        

        <div class="container">
            <div class="row" style=" text-align: center; display: initial;">
                
                <h3>Xablau Poomsae</h3>
            </div>
            
            <div class="row">
                <div class="col-md-1"> <input type="text" value="0" id="cont03" disabled style=" border: none; width: 22px;">x </div>
                <div class="col-md-3"> <button onClick="reverterclicou03('0.3')" value="0.3" id="cancelar03" class="btn btn-primary btn-lg btn-block">CANCELAR -0.3</button> </div>
                <div class="col-md-4"> <button onClick="window.location.reload();" class="btn btn-primary btn-lg btn-block">RESETAR</button> </div>
                <div class="col-md-3"> <button onClick="reverterclicou01('0.1')" value="0.1" id="cancelar01" class="btn btn-primary btn-lg btn-block">CANCELAR -0.1</button> </div>
                <div class="col-md-1"> <input type="text" value="0" id="cont01" disabled style=" border: none; width: 22px;">x </div>
            </div>
        </div>
        
        <form action="ControllerManterNota"  method="post">
            
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-3"> <br>
                <div class="card" >
                    <div class="card-body" onclick="clicou03('0.3');" style=" background-color: lightcoral;">
                        <h5 class="card-title text-center display-1"> 
                            <input type="text" value="-0.3" id="valor03" disabled style=" border: none; width: -webkit-fill-available; background-color: lightcoral;"></h5>
                    </div>
                </div>
            </div>
            <div class="col-md-4"> <br> 
                <div class="card" >
                    <div class="card-body">
                        <h5 class="card-title text-center display-1"> <input type="text" value="4.0" name="nomeTecnica" id="valor4" readonly="true" style=" border: none; width: 140px;"></h5>
                    </div>
                </div>
            </div>
            <div class="col-md-3"> <br>
                <div class="card" >
                    <div class="card-body" onclick="clicou01('0.1')" style=" background-color: lightcoral;">
                        <h5 class="card-title text-center display-1"> 
                            <input type="text" value="-0.1" id="valor01" disabled style=" border: none; width: -webkit-fill-available; background-color: lightcoral;"></h5>
                    </div>
                </div>
            </div>
            <div class="col-md-1"></div>
         </div>
        <br>
        
        <br>
        <div class="row">
            <div class="col-md-2" Style="margin-left: 5px;">Velocidade e potência</div>
            <div class="col-md-1"> <input type="text" value="0.0" id="1valor" name="apresentacao1"  readonly="true" style=" width: 30px;"></div>
            <div class="btn-group">
            <button type="button" onclick="cliqueApresentacao1('0.5')" value="0.5" id="1btn05" class="btn btn-primary ">0.5</button>
            <button type="button" onclick="cliqueApresentacao1('0.6')" value="0.6" id="1btn06" class="btn btn-primary ">0.6</button>
            <button type="button" onclick="cliqueApresentacao1('0.7')" value="0.7" id="1btn07" class="btn btn-primary ">0.7</button>
            <button type="button" onclick="cliqueApresentacao1('0.8')" value="0.8" id="1btn08" class="btn btn-primary ">0.8</button>
            <button type="button" onclick="cliqueApresentacao1('0.9')" value="0.9" id="1btn09" class="btn btn-primary ">0.9</button>
            <button type="button" onclick="cliqueApresentacao1('1.0')" value="1.0" id="1btn10" class="btn btn-primary ">1.0</button>
            <button type="button" onclick="cliqueApresentacao1('1.1')" value="1.1" id="1btn11" class="btn btn-primary ">1.1</button>
            <button type="button" onclick="cliqueApresentacao1('1.2')" value="1.2" id="1btn12" class="btn btn-primary ">1.2</button>
            <button type="button" onclick="cliqueApresentacao1('1.3')" value="1.3" id="1btn13" class="btn btn-primary ">1.3</button>
            <button type="button" onclick="cliqueApresentacao1('1.4')" value="1.4" id="1btn14" class="btn btn-primary ">1.4</button>
            <button type="button" onclick="cliqueApresentacao1('1.5')" value="1.5" id="1btn15" class="btn btn-primary ">1.5</button>
            <button type="button" onclick="cliqueApresentacao1('1.6')" value="1.6" id="1btn16" class="btn btn-primary ">1.6</button>
            <button type="button" onclick="cliqueApresentacao1('1.7')" value="1.7" id="1btn17" class="btn btn-primary ">1.7</button>
            <button type="button" onclick="cliqueApresentacao1('1.8')" value="1.8" id="1btn18" class="btn btn-primary ">1.8</button>
            <button type="button" onclick="cliqueApresentacao1('1.9')" value="1.9" id="1btn19" class="btn btn-primary ">1.9</button>
            <button type="button" onclick="cliqueApresentacao1('2.0')" value="2.0" id="1btn20" class="btn btn-primary ">2.0</button>
            </div>
            <div class="col-md-1"> </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" Style="margin-left: 5px;">Ritmo e <br>tempo</div>
            <div class="col-md-1"> <input type="text" value="0.0" id="2valor" name="apresentacao2"  readonly="true" style=" width: 30px;"></div>
            <div class="btn-group">
            <button type="button" onclick="cliqueApresentacao2('0.5')" value="0.5" id="2btn05" class="btn btn-primary ">0.5</button>
            <button type="button" onclick="cliqueApresentacao2('0.6')" value="0.6" id="2btn06" class="btn btn-primary ">0.6</button>
            <button type="button" onclick="cliqueApresentacao2('0.7')" value="0.7" id="2btn07" class="btn btn-primary ">0.7</button>
            <button type="button" onclick="cliqueApresentacao2('0.8')" value="0.8" id="2btn08" class="btn btn-primary ">0.8</button>
            <button type="button" onclick="cliqueApresentacao2('0.9')" value="0.9" id="2btn09" class="btn btn-primary ">0.9</button>
            <button type="button" onclick="cliqueApresentacao2('1.0')" value="1.0" id="2btn10" class="btn btn-primary ">1.0</button>
            <button type="button" onclick="cliqueApresentacao2('1.1')" value="1.1" id="2btn11" class="btn btn-primary ">1.1</button>
            <button type="button" onclick="cliqueApresentacao2('1.2')" value="1.2" id="2btn12" class="btn btn-primary ">1.2</button>
            <button type="button" onclick="cliqueApresentacao2('1.3')" value="1.3" id="2btn13" class="btn btn-primary ">1.3</button>
            <button type="button" onclick="cliqueApresentacao2('1.4')" value="1.4" id="2btn14" class="btn btn-primary ">1.4</button>
            <button type="button" onclick="cliqueApresentacao2('1.5')" value="1.5" id="2btn15" class="btn btn-primary ">1.5</button>
            <button type="button" onclick="cliqueApresentacao2('1.6')" value="1.6" id="2btn16" class="btn btn-primary ">1.6</button>
            <button type="button" onclick="cliqueApresentacao2('1.7')" value="1.7" id="2btn17" class="btn btn-primary ">1.7</button>
            <button type="button" onclick="cliqueApresentacao2('1.8')" value="1.8" id="2btn18" class="btn btn-primary ">1.8</button>
            <button type="button" onclick="cliqueApresentacao2('1.9')" value="1.9" id="2btn19" class="btn btn-primary ">1.9</button>
            <button type="button" onclick="cliqueApresentacao2('2.0')" value="2.0" id="2btn20" class="btn btn-primary ">2.0</button>
            </div>
            <div class="col-md-1"> </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" Style="margin-left: 5px;">Expressão de energia</div>
            <div class="col-md-1"> <input type="text" value="0.0" id="3valor" name="apresentacao3"  readonly="true" style=" width: 30px;"></div>
            <div class="btn-group">
            <button type="button" onclick="cliqueApresentacao3('0.5')" value="0.5" id="3btn05" class="btn btn-primary ">0.5</button>
            <button type="button" onclick="cliqueApresentacao3('0.6')" value="0.6" id="3btn06" class="btn btn-primary ">0.6</button>
            <button type="button" onclick="cliqueApresentacao3('0.7')" value="0.7" id="3btn07" class="btn btn-primary ">0.7</button>
            <button type="button" onclick="cliqueApresentacao3('0.8')" value="0.8" id="3btn08" class="btn btn-primary ">0.8</button>
            <button type="button" onclick="cliqueApresentacao3('0.9')" value="0.9" id="3btn09" class="btn btn-primary ">0.9</button>
            <button type="button" onclick="cliqueApresentacao3('1.0')" value="1.0" id="3btn10" class="btn btn-primary ">1.0</button>
            <button type="button" onclick="cliqueApresentacao3('1.1')" value="1.1" id="3btn11" class="btn btn-primary ">1.1</button>
            <button type="button" onclick="cliqueApresentacao3('1.2')" value="1.2" id="3btn12" class="btn btn-primary ">1.2</button>
            <button type="button" onclick="cliqueApresentacao3('1.3')" value="1.3" id="3btn13" class="btn btn-primary ">1.3</button>
            <button type="button" onclick="cliqueApresentacao3('1.4')" value="1.4" id="3btn14" class="btn btn-primary ">1.4</button>
            <button type="button" onclick="cliqueApresentacao3('1.5')" value="1.5" id="3btn15" class="btn btn-primary ">1.5</button>
            <button type="button" onclick="cliqueApresentacao3('1.6')" value="1.6" id="3btn16" class="btn btn-primary ">1.6</button>
            <button type="button" onclick="cliqueApresentacao3('1.7')" value="1.7" id="3btn17" class="btn btn-primary ">1.7</button>
            <button type="button" onclick="cliqueApresentacao3('1.8')" value="1.8" id="3btn18" class="btn btn-primary ">1.8</button>
            <button type="button" onclick="cliqueApresentacao3('1.9')" value="1.9" id="3btn19" class="btn btn-primary ">1.9</button>
            <button type="button" onclick="cliqueApresentacao3('2.0')" value="2.0" id="3btn20" class="btn btn-primary ">2.0</button>
            </div>
            <div class="col-md-1"> </div>
        </div>
        <br>
        
        <br>
        <div class="row">
            <div class="col-md-12"> <br> <button type="submit" name="btnEnviar" value="Cadastrar" class="btn btn-primary btn-lg btn-block">ENVIAR</button> </div>
        </div>
        <input type="hidden" name="idUsuario" value="<%=session.getAttribute("usuario")%>">
        <input type="hidden" name="codNotaFinal" value="<%=session.getAttribute("codNotaFinal")%>">
        </form>
    <script>
        function clicou01(valor) {

            var c01 = document.getElementById("cont01").value;    
            if (c01 >= 0 && c01 <41){
            var total = document.getElementById("valor4").value;
            if (total > '0.0') {
                total = total - valor;
                var arredondado = total.toFixed(1);
                if (arredondado < '0') {
                    arredondado = '0.0';
                }
                document.getElementById("valor4").value = arredondado;
                c01++;
                document.getElementById("cont01").value = c01;
                }
                
            }
        }
        
        function clicou03(valor) {

            var c03 = document.getElementById("cont03").value;    
            if (c03 >= 0 && c03 <14){
            var total = document.getElementById("valor4").value;
            if (total > '0.0') {
                total = total - valor;
                var arredondado = total.toFixed(1);
                if (arredondado < '0') {
                    arredondado = '0.0';
                }
                document.getElementById("valor4").value = arredondado;
                c03++;
                document.getElementById("cont03").value = c03;
                }
            }
        }

        function reverterclicou01(valor) {

        var cr01 = document.getElementById("cont01").value;  
        if (cr01 > 0 && cr01 <41){
            var totalrevert = document.getElementById("valor4").value;
            if (totalrevert < '4.0') {
                totalrevert = parseFloat(totalrevert) + parseFloat(valor);
                var arredonda = totalrevert.toFixed(1);
                if (arredonda > '4.0') {
                    arredonda = '4.0';
                }
                document.getElementById("valor4").value = arredonda;
                cr01--;
                document.getElementById("cont01").value = cr01;
                }
            }
        }
        
        function reverterclicou03(valor) {

        var cr03 = document.getElementById("cont03").value;
        if (cr03 > 0 && cr03 <15){
            var totalrevert = document.getElementById("valor4").value;
            if (totalrevert < '4.0') {
                totalrevert = parseFloat(totalrevert) + parseFloat(valor);
                var arredonda = totalrevert.toFixed(1);
                if (arredonda > '4.0') {
                    arredonda = '4.0';
                }
                document.getElementById("valor4").value = arredonda;
                cr03--;
                document.getElementById("cont03").value = cr03;
                }
            }
        }
        
        function cliqueApresentacao1(valor) {
            document.getElementById("1valor").value = valor;
        }
        
        function cliqueApresentacao2(valor) {
            document.getElementById("2valor").value = valor;
        }
        
        function cliqueApresentacao3(valor) {
            document.getElementById("3valor").value = valor;
        }
        
    </script>
    </body>
</html>
