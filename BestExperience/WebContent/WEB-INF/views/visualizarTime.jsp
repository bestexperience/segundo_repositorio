<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
            <title>Visualizar Time</title>
			<link rel="stylesheet" href="./css/style-menubar.css">
		
		    <meta charset="utf-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

			 <style>
        		img{
          			border-radius:10px;
        		}
    </style>
        </head>
		
        <body>
            <!-- Barra superior com os menus de navegação -->
			<c:import url="MenuUsuario.jsp"/>
			<div class="container">
    <div class="header clearfix" align="center">      
        <h3 class="text-muted"></h3>
      </div>

      <div class="">
      <div class=" col-md-12 text-center pad">
			<img src="./img/soccer.jpg" class="" alt="Cinque Terre" width="800" height="400">
        </div>
        <br />
        <h1 align="center">${time.nome}</h1>
          <hr>
      </div>
    </div>
	<div class="container">
	    
	  <h2>Jogadores</h2>
	  <p></p>                                                                                      
	  <div class="table-responsive">          
	  <table class="table">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>Nome</th>
	        <th>Nascimento</th>
	        <th>Gols</th>
	      </tr>
	    </thead>
	    <tbody>
	    <c:forEach var="jogador" items="${lista}">
	      <tr>
	        <td>${jogador.idJogador}</td>
	        <td>${jogador.nomeJogador}</td>
	        <td>${jogador.nascimento_jogador}</td>
	        <td>${jogador.gols}</td>
	      </tr>
	     </c:forEach>
	    </tbody>
	  </table>
	  </div>
	    
	</div>
</body>
</html>