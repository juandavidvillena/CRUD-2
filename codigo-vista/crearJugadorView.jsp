<%-- 
    Document   : crearJugadorView
    Created on : 05-abr-2018, 8:57:52
    Author     : 6001016
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Crear Jugador</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="shortcut icon" href="http://leaderabogados.com/wp-content/uploads/2017/08/favicon.png">

    </head>
    <body class="index">

        <jsp:include page="_header.jsp"></jsp:include>
        
            <form method="POST" action="${pageContext.request.contextPath}/CrearJugadorServlet">
            <div >
            <div class="panel panel-primary">
               <div class="panel-heading panel-info">Nuevo Jugador</div>
                <table class="table table-hover  table-striped">
                <tr>
                    <td>Nombre</td>
                    <td>
                        <input type="text" name="nomJug" value="${jugador.NomJug}" />
                    </td>
                    </tr>
                    <tr>
                        <td>Rol</td>
                        <td>
                            <input type="text" name="rol" value="${jugador.Rol}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Télefono</td>
                        <td>
                            <input type="text" name="telefono" value="${jugador.Telefono}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Año de Nacimiento</td>
                        <td><input type="text" name="anoNac" value="${jugador.AnoNac}" /></td>
                    </tr>
                    <tr>
                        <td>Equipo</td> 
                        <td>
                            <div class="input-group input-group-lg">
                                <select name="codEquipo">
                                <c:forEach var="equipo" items="${liste}">
                                    <option value="${equipo.codEquipo}">${equipo.nomEquipo}</option>
                                </c:forEach>
                            </select> 
                            </div>
                            <!-- getnoomEquipo jugador.equipo.nomEquipo
                        </td>
                        <!--<input class="form-control" type="text" name="CodEquipo" required/>-->
                    </tr>    
                    <tr>
                        <td colspan="2">                   
                            <input type="submit" value="Submit" />
                            <a href="JugadorListaServlet">Cancel</a>
                        </td>
                    </tr>
                </table>
            </form>
</div>
            <jsp:include page="_footer.jsp"></jsp:include>

    </body>
</html>