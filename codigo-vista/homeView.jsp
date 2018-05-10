<%-- 
    Document   : homeView
    Created on : 02-abr-2018, 13:11:04
    Author     : 6001016
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="css/normal.css">
 
        <link rel="stylesheet" type="text/css" href="css/general.css">

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Home Page</title>
        <link rel="shortcut icon" href="img/favicon.png">

    </head>
    <body>

            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <a href="index.jsp"> <h6>volver</h6></a>
                    <h1>PÁGINA INFORMATIVA</h1>

                    <small>Mi aplicación Crud tiene implementada una base de datos de 3 tablas con los usuarios, jugadores y equipos,
                    en la lista están las diferentes páginas que puedes acceder o funcionalidades que tiene esta.</br>
                    Está hecha orientada a objetos toda la parte java y separado el codigo java con el jsp, para darle estilo he usado boostrap
                    y un css hecho a mano. He implementado dos ArrayList y un TreeMap.</small>
                </div>
            </div>
            <div class="jumbotron jumbotron-fluid">
            <iframe width="560" height="315" src="https://www.youtube.com/embed/_qw-1Uop0f4" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
            </div>
        <div class="container">
    <div id="accordion">
    <div class="card">
      <div class="card-header">
        <a class="card-link" data-toggle="collapse" href="#collapseOne">
          Inicio Sesion
        </a>
      </div>
      <div id="collapseOne" class="collapse show" data-parent="#accordion">
        <div class="card-body">
          El inicio de sesión está controlado por una base de datos, tiene la funcionalidad de que te recuerde los datos una vez inicies correctamente sesión
          , una vez hayas iniciado sesión se te abre una pestaña con los datos del Usuario dando la bienvenida.
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
           Listas Principales
      </a>
      </div>
      <div id="collapseTwo" class="collapse" data-parent="#accordion">
        <div class="card-body">
          En la pantalla "Principal" tenemos una visualizacion de los Jugadores y de los equipos. 
          al lado de cada jugador tenemos la funcionalidad de modificar y de eliminar.
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
          Crear Jugador
        </a>
      </div>
      <div id="collapseThree" class="collapse" data-parent="#accordion">
        <div class="card-body">
          En esta pestaña como su titulo dice tenemos la funcionalidad de añadir un nuevo jugador a la base de datos.
        </div>
      </div>
    </div>
            <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseFour">
           Error 404
      </a>
      </div>
      <div id="collapseFour" class="collapse" data-parent="#accordion">
        <div class="card-body">
            Control de los errores 404 cuando te sales de la estructura de páginas te salta esta página.
        </div>
      </div>
    </div>
            <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseFive">
           Plantilla
      </a>
      </div>
      <div id="collapseFive" class="collapse" data-parent="#accordion">
        <div class="card-body">
            He usado una plantilla que ya creé en su día de forma manual para el footer y el head y despues solo 
            con la funcion include se añade donde tu quieres y te da la facilidad de no tener que estar copiando el código varias veces.
        </div>
      </div>
    </div>
  </div>
</div>
           <!-- <ul  class="list-group">
                <li class="list-group-item list-group-item-success">Inicio</li>
                <li class="list-group-item list-group-item-success">Cookies</li>
                <li class="list-group-item list-group-item-success">Lista Jugadores</li>
                <li class="list-group-item list-group-item-success">Nuevo Jugador</li>
                <li class="list-group-item list-group-item-success">Editar Jugador</li>
                <li class="list-group-item list-group-item-success">borrar Jugador</li>
            </ul>-->

        <jsp:include page="_footer.jsp"></jsp:include>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>

</html>
