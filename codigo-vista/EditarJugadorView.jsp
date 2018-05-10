<%-- 
    Document   : EditarJugadorView
    Created on : 09-abr-2018, 13:46:10
    Author     : 6001016
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="img/favicon.png">
        <title>Editar Jugador</title>
    </head>
    <body class="index">
        <jsp:include page="_header.jsp"></jsp:include>
        <p style="color: red;">${errorString}</p>
        <div class="panel panel-danger">
            <div class="panel-heading panel-danger">Modificar Jugador</div>
            
                <c:if test="${not empty jugador}">
                    <form method="POST" action="${pageContext.request.contextPath}/EditarJugadorServlet">
                        <input type="hidden" name="codJug" value="${jugador.codJug}" />
                        <table border="0">
                            <tr>
                                <td>ID Jugador</td>
                                <td style="color:red;">${jugador.codJug}</td>
                            </tr>
                            <tr>
                                <td>Nombre</td>
                                <td><input type="text" name="nomJug" value="${jugador.nomJug}" /></td>
                            </tr>
                            <tr>
                                <td>Rol</td>
                                <td><input type="text" name="rol" value="${jugador.rol}" /></td>
                            </tr>
                            <td>Teléfono</td>
                            <td><input type="text" name="telefono" value="${jugador.telefono}" /></td>
                            </tr>
                            <td>Año de Nacimiento</td>
                            <td><input type="text" name="anoNac" value="${jugador.anoNac}" /></td>
                            </tr>
                            <tr>
                                <td>Equipo</td>
                                <td> <select name="codEquipo">
                                        <c:forEach var="equipo" items="${liste}">
                                            <option value="${equipo.codEquipo}">${equipo.nomEquipo}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan = "2">
                                    <input type="submit" value="Submit" />
                                    <a href="${pageContext.request.contextPath}/JugadorListaServlet">Cancelar</a>
                                </td>
                            </tr>
                        </table>

                    </form>
                </c:if>
            </div>
        <jsp:include page="_footer.jsp"></jsp:include>

    </body>
</html>
