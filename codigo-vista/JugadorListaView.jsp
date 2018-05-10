<%-- 
    Document   : JugadorListaView.jsp
    Created on : 04-abr-2018, 9:40:44
    Author     : Juan David Villena Gil
--%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/normal.css">
<link rel="stylesheet" type="text/css" href="/css/general.css">
<link rel="shortcut icon" href="img/favicon.png">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista Jugadores</title>
    </head>
    <body>

        <jsp:include page="_header.jsp"></jsp:include>

            <p style="color: red;">${errorString}</p>
        
        <div class="nombre">Lista de jugadores</div>
        <table border="1" cellpadding="5" cellspacing="1" class="table table-hover table-dark" >

            <tr>
                <th>ID Juagdor</th>
                <th>Nombre</th>
                <th>Rol</th>
                <th>Año de Nacimiento</th>
                <th>Telefono</th>
                <th>Equipo</th>
            </tr>

            <c:forEach items="${list}" var="jugador" >
                <tr>
                    <c:set var= "codigo" scope="session"  value="${jugador.codJug}"/>
                    <c:set var= "nombreJ" scope="session"  value="${jugador.nomJug}"/>
                    <c:set var= "rol" scope="session"  value="${jugador.rol}"/>
                    <c:set var= "nombreE" scope="session"  value="${jugador.equipo.nomEquipo}"/>
                    <c:set var= "telefono" scope="session"  value="${jugador.telefono}"/>
                    <c:set var= "anoNac" scope="session"  value="${jugador.anoNac}"/>


                    <td><c:out value = "${codigo}"/></td>
                    <td><c:out value = "${nombreJ}"/></td>
                    <td><c:out value = "${rol}"/></td>
                    <td><c:out value = "${anoNac}"/></td>
                    <td><c:out value = "${telefono}"/></td>
                    <td><c:out value = "${nombreE}"/></td>

                    <td>
                        <a href="EditarJugadorServlet?codJug=${codigo}">Modificar</a>
                    </td>
                    <td>
                        <a href="BorrarJugadorServlet?codJug=${codigo}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div class="nombre">Equipos</div>
        <display:table name="liste" id="liste" class="table table-hover table-dark">
            <display:column property="codEquipo" title="ID Equipo"> <c:out value="${liste.codEquipo}"/></display:column>
            <display:column property="nomEquipo" title="Nombre"> <c:out value="${liste.nomEquipo}"/></display:column>
            <display:column property="eSport" title="eSport"> <c:out value="${liste.eSport}"/> </display:column>
            <display:column property="anoCreacion" title="Año de Creacion"> <c:out value="${liste.anoCreacion}"/> </display:column>
        </display:table>

        <jsp:include page="_footer.jsp"></jsp:include>

   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
  </body>
</html>