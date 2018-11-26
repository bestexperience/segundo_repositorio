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
			<!--<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">-->
			<!--  <link rel="stylesheet" href="./css/style.css">-->
			<!-- <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet"> -->
			<link rel="stylesheet" href="./css/style-menubar.css">
			
			<link href="css/jumbotron-narrow.css" rel="stylesheet">
    
		    <meta charset="utf-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
			<!-- 
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style1.css" rel="stylesheet"> -->

        </head>

        <body>
            <!-- Barra superior com os menus de navegação -->
			<c:import url="MenuUsuario.jsp"/>
			<!-- <div class="container">
			<div class="row">
		        <div class="col-lg-4">
		          <img class="img-circle col-md-offset-1" src="img/screen.jpg" alt="Generic placeholder image" width="300" height="300">
		          <h2 align="center">${campeonato.nome}</h2>
		          <p>O campeonato ${campeonato.nome} ainda não contem seus turnos. Clique no botão abaixo para gerar os turnos.</p>
		          <p align="center"><a class="btn btn-default" href="gerando_turnos" role="button">Gerar Turnos</a></p>
		        </div>
		      </div>
			</div> -->
			
	<div class="container">
      <div class="header clearfix" align="center">      
        <h3 class="text-muted">${campeonato.nome}</h3>
      </div>
	  
	  <c:if test="${jogos == null}">
	      <div class="jumbotron">
	        <h1>Campeonato</h1>
	        <p class="lead">O campeonato ${campeonato.nome} ainda não contem seus turnos. Clique no botão abaixo para gerar os turnos.</p>
	        <p><a class="btn btn-lg btn-success" href="efetivar_gerar_turnos?nome=${campeonato.nome}" role="button">Gerar Turnos</a></p>
	      </div>
		</c:if>
		
		<c:if test="${not empty jogos}">
	      <div class="jumbotron">
	        <h1>Campeonato</h1>
	        <p class="lead">O campeonato ${campeonato.nome} ainda não contem seus turnos. Clique no botão abaixo para gerar os turnos.</p>
	        <p>Os turnos ja foram gerados</p>
	      </div>
		</c:if>
		
      <div class="row marketing">
        <div class="col-lg-6">
          <h4>Dados</h4>
          <p>O campeonato ${campeonato.nome} tem ${campeonato.numeroRodadas} turnos.</p>

        </div>
      </div>

      <footer class="footer">
        <p>© 2016 Company, Inc.</p>
      </footer>

    </div> <!-- /container -->
			
			
		<script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>
</html>