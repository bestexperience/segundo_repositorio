<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro de Times</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/style-menu-no-border.css">

</head>
<body>
	<c:import url="MenuUsuario.jsp" />

	<div class="container">
		<div class=" col-md-12 text-center">
			<img src="img/co.png" class="rounded" alt="Cinque Terre" width="304"
				height="300">
		</div>
		<hr>
		<br/>
		<br/>
		<form action="efetivar_time" method="post">
			<h1 align="center">Inserir Times</h1>
			<div class="row">
			<div class="form-group col-md-6">
				<label for="nome">Time</label> 
				<input type="text" class="form-control" id="nome" name="nome"/> 
				<small class="form-text text-muted">Informe os times acima</small>
			</div>
			</div>
			<div class="row">
			<div class="form-group col-md-6">
                    <label for="campeonato">Lista de Campeonatos</label>
                    <select class="form-control" name="campeonato.idCampeonato" id="campeonato">
                    			<option value="0" selected>Escolha um campeonato</option>
	                    		<c:forEach var="campeonato" items="${lista2}">
	                    			<option value="${campeonato.idCampeonato}">${campeonato.nome}</option>
	                    		</c:forEach>
                    </select>
             </div>             
             </div>
             <div class="col-md-12" align="center" id="actions">
                    <button type="submit" class="btn btn-primary">Salvar</button>
                    <a href="#" class="btn btn-default">Cancelar</a>
              </div>
		</form>

	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>