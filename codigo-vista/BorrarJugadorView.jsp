<%-- 
    Document   : BorrarJugadorView
    Created on : 09-abr-2018, 17:05:49
    Author     : 6001016
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<link rel="shortcut icon" href="http://leaderabogados.com/wp-content/uploads/2017/08/favicon.png">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Borrar Jugador</title>
 </head>
 
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
        
    <h3>Borrar Producto</h3>
    
    <p style="color: red;">${errorString}</p>
    <a href="JugadorListaServlet">Lista Principal</a>
    
    <jsp:include page="_footer.jsp"></jsp:include>
    
 </body>
</html>