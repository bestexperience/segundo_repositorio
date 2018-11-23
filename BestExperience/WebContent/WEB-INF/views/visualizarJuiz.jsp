<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Visualizar Juiz</title>
			<link rel="stylesheet" href="./css/style-menubar.css">
			
			<link href="css/jumbotron-narrow.css" rel="stylesheet">
    
		    <meta charset="utf-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        </head>

        <body>
            <!-- Barra superior com os menus de navegação -->
			<c:import url="MenuUsuario.jsp"/>
			
	<c:forEach var="juiz" items="${lista}">
	<div class="container">
      <div class="header clearfix" align="center">      
        <h3 class="text-muted">${juiz.nomeJuiz}</h3>
      </div>

      <div class="">
      <div class=" col-md-12 text-center pad">
			<img src="img/images2.jpg" class="" alt="Cinque Terre"
				width="304" height="300">
		</div>
        <h1>Descrição</h1>
        <p class="lead">${juiz.descricao}</p>
      </div>


      <footer class="footer">
        <p>© 2016 Company, Inc.</p>
      </footer>

    </div> <!-- /container -->
    </c:forEach>
		<script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>
</html>