<%-- 
    Document   : loginView
    Created on : 03-abr-2018, 10:17:58
    Author     : 6001016
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
   
    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/normal.css">
        <link rel="stylesheet" type="text/css" href="css/general.css"> 
        <link rel="shortcut icon" href="img/favicon.png">

   </head>
   <body>
      
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" ></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
    


      <p style="color: red;">${errorString}</p>
      <div class="tabla-login">
      <form method="POST" action="${pageContext.request.contextPath}/LoginServlet">
          <h1>Inicia Sesión</h1>
          <div>
          Usuario
          <br />
          <input type="text" name="NomUsu" autocomplete="off" value= "${user.nomUsu}" /> 
          <br />
          Contraseña
          <br />
          <input type="password" name="password" autocomplete="off" value= "${user.password}" />
          <br />
          Recordar datos
          <input type="checkbox" name="rememberMe" value= "Y" />
          <br />
          <br />
          <input type="submit" value= "Aceptar" />
                  <a href="${pageContext.request.contextPath}/"> Cancel </a>
                  <br />
          </div>
      </form>
 
 </div>
      <p style="color:blue;">Usuarios: luis pssd: aprobare_programacion o Usuario : david pssw: 15</p>
 
      <jsp:include page="_footer.jsp"></jsp:include>
   </body>
</html>