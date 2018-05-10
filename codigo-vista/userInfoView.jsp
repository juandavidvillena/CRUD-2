<%-- 
    Document   : userInfoView
    Created on : 03-abr-2018, 10:23:12
    Author     : 6001016
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Informacion de usuario</title>
        <link rel="shortcut icon" href="img/favicon.png">

    </head>
    <body>

        <jsp:include page="_header.jsp"></jsp:include>
        <c:set var= "nomUsuCom" scope="session"  value="${usuario.nomUsu}"/>
            <h3>Bienvenido a mi Crud (Avanzado):<c:out value = "${nomUsuCom}"/></h3>

            <h3> Usuario: <b><c:out value = "${nomUsuCom}"/></b></h3>
        <br />
        <img src="img/gif.gif">
        <jsp:include page="_footer.jsp"></jsp:include>

    </body>
</html>