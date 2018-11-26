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
	<c:import url="MenuUsuario.jsp" />
	<!--Jogos Master-->
	<div class="container">
		<div class="card">
			<div class="card-header" id="headingTwo">
			</div>
				<div class="card-body">
					<div class="jumbotron text-center valor">
						<h1>Campeonato</h1>
					</div>
						<table class="table">
							<tr class="jumbotron text-center">
								<th>Nº</th>
								<th>Nome</th>
								<th>Numero de Rodadas</th>
								<th class="actions">Ações</th>
							</tr>

							<tbody>
								<c:forEach var="campeonato" items="${lista}">
									<tr>
										<td>${campeonato.idCampeonato}</td>
										<td>${campeonato.nome}</td>
										<td>${campeonato.numeroRodadas}</td>
										<td class="actions">
                                             <a class="btn btn-success btn-xs" href="listar_resultados_1?id=${campeonato.idCampeonato}">Inserir Resultados</a>
                                        </td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>	
</body>
</html>