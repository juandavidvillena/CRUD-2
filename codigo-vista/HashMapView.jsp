<%-- 
    Document   : HashMapView
    Created on : 23-abr-2018, 8:48:36
    Author     : 6001016
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Map Equipos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/normal.css">
        <link rel="stylesheet" type="text/css" href="css/general.css">
        <link rel="shortcut icon" href="img/favicon.png">
       <script src="js/HashMap.js"></script>

    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
            <h1>Jugadores por equipo</h1>
            <div class="nombre"> Equipo</div>
           <form action="HashMap" method="POST">
                 <select name="codEquipo">
                                <c:forEach var="equipo" items="${liste}">
                                    <option value="${equipo.codEquipo}">${equipo.nomEquipo}</option>
                                </c:forEach>
                            </select>
            <input type="submit">
        </form>

  <c:forEach items="${listaJugadorMap}" var="jugador" >
                    <div>
                        <%-- <c:set var= "codigo" scope="session"  value="${jugador.codJug}"/> --%>
                        <c:set var= "nombreJ" scope="session"  value="${jugador.nomJug}"/>
                        <c:set var= "rol" scope="session"  value="${jugador.rol}"/>
                        <c:set var= "telefono" scope="session"  value="${jugador.telefono}"/>
                        <c:set var= "anoNac" scope="session"  value="${jugador.anoNac}"/>
                        <ul><div class="">
                                <li><h2 class="nombre"><c:out value = "${nombreJ}"/></h2></li>
                                <li class="datos"><c:out value = "${rol}"/></li>
                                <li class="datos"><c:out value = "${anoNac}"/></li>
                            </div></ul>
                    </div>
                </c:forEach>

 <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
