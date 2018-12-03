<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Dados do Campeonato</title>
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
	<!--Jogos Master-->
	<div class="container">
	 	<h2>Tabela</h2>
                 <div class="table-responsive col-md-12">
						<table class="table table-striped" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th>Classificação</th>
						        <th>P</th>
						        <th>J</th>
						        <th>V</th>
						        <th>E</th>
						        <th>D</th>
						        <th>GP</th> <!--Gol pró(marcados)-->
						        <th>GC</th> <!--Gol sofridos, gols contra-->
						        <th>SG</th> <!--Saldo de gols (GP - GC)-->
						        <th>%</th>  <!--Aproveitamento-->
							</tr>
						</thead>
							<tbody>
								<c:forEach var="timeCampeonato" items="${lista}">
									<tr>
										<td>${timeCampeonato.classificacao} - ${timeCampeonato.time.nome}</td>
								        <td>${timeCampeonato.pontos}</td>
								        <td>${timeCampeonato.jogos}</td>
								        <td>${timeCampeonato.vitorias}</td>
								        <td>${timeCampeonato.empates}</td>
								        <td>${timeCampeonato.derrotas}</td>
								        <td>${timeCampeonato.gols_marcados}</td>
								        <td>${timeCampeonato.gols_sofridos}</td>
								        <td>${timeCampeonato.saldo_de_gols}</td>
								        <td>${timeCampeonato.aproveitamento}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>
			</div>	
</body>
</html>