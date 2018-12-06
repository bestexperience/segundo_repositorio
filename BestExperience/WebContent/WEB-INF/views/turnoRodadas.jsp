<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Turnos & Rodadas</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<c:import url="Menu.jsp" />

	<div class="jumbotron text-center">
		<h1>Turno 1</h1>
	</div>

	<div class="container">
		<table class="table">

			<tr class="jumbotron text-center">
				<th>Data</th>
				<th>Mandante</th>
				<th>Placar</th>
				<th>Visitante</th>
				<th>Árbitro</th>
			</tr>

			<tbody>
				<c:forEach var="jf" items="${lista}">
				<tr>
					<td><fmt:formatDate value="${jf.data}" pattern="dd/MM/yyyy"/></td>
					<td>${jf.time_mandante.nome}</td>
					<td>${jf.placar_mandante} x ${jf.placar_visitante}</td>
					<td>${jf.time_visitante.nome}</td>
					<td>Fulano</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- 
	<div class="jumbotron text-center">
		<h1>Turno 2</h1>
	</div>

	<div class="container">
		<table class="table">

			<tr class="jumbotron text-center">
				<th>Rodada</th>
				<th>Data</th>
				<th>Hora</th>
				<th>Mandante</th>
				<th>Placar</th>
				<th>Visitante</th>
				<th>Árbitro</th>
			</tr>

			<tbody>
				<tr>
					<td>8</td>
					<td>xx/xx/xxxx</td>
					<td>xx:xx</td>
					<td>Colômbia</td>
					<td>0 x 0</td>
					<td>Bélgica</td>
					<td>Fulano</td>
				</tr>

				<tr>
					<td>8</td>
					<td>xx/xx/xxxx</td>
					<td>xx:xx</td>
					<td>Japão</td>
					<td>0 x 0</td>
					<td>Dinamarca</td>
					<td>Fulano</td>
				</tr>

			</tbody>
		</table>
	</div>
	
	-->
</body>
</html>