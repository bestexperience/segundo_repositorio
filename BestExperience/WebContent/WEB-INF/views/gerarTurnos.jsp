<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Buscar Time</title>
			<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			<!--  <link rel="stylesheet" href="./css/style.css">-->
			<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
			<link rel="stylesheet" href="./css/style-menubar.css">
			<!-- 
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style1.css" rel="stylesheet"> -->

        </head>

        <body>
            <!-- Barra superior com os menus de navegação -->
			<c:import url="MenuUsuario.jsp"/>
			<div class="container">
			<div class="row">
		        <div class="col-lg-4">
		          <img class="img-circle col-md-offset-1" src="img/screen.jpg" alt="Generic placeholder image" width="300" height="300">
		          <h2>${campeonato.nome}</h2>
		          <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>
		          <p align="center"><a class="btn btn-default" href="gerar_turnos" role="button">Gerar Turnos</a></p>
		        </div>
		      </div>
			</div>
			
		<script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>
</html>