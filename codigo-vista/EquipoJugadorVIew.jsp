<%-- 
    Document   : EquipoJugadorVIew
    Created on : 11-abr-2018, 11:38:42
    Author     : 6001016
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/general.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista Equipos Completos</title>
        <link rel="shortcut icon" href="img/favicon.png">
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <div >
            <div class ="grid-container">


                <c:forEach items="${liste}" var="jugador" >
                    <div class=" degradado grid-item">


                        <c:set var= "codigo" scope="session"  value="${jugador.codJug}"/>
                        <c:set var= "nombreJ" scope="session"  value="${jugador.nomJug}"/>
                        <c:set var= "rol" scope="session"  value="${jugador.rol}"/>
                        <c:set var= "nombreE" scope="session"  value="${jugador.equipo.nomEquipo}"/>
                        <c:set var= "telefono" scope="session"  value="${jugador.telefono}"/>
                        <c:set var= "anoNac" scope="session"  value="${jugador.anoNac}"/>

                        <ul><div class="textopegado">
                                <li><h2 class="nombre"><c:out value = "${nombreJ}"/></h2></li>
                                <li class="datos"><c:out value = "${rol}"/></li>
                                <li class="datos"><c:out value = "${anoNac}"/></li>
                                <li class="datos"><c:out value = "${telefono}"/></li>
                            </div></ul>

                                <li class="datos"><c:out value = "${nombreE}"/></li></h4>
                        <div>
                            <img src="<c:out value="${jugador.fotoJug}"/>"  class="photo" >
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
