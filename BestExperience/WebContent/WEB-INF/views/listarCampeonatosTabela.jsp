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
	 <div id="top" class="row">
                        <div class="col-md-3">
                            <h2>Campeonatos</h2>
                        </div>
                        </div>
                <hr />
                 <div class="table-responsive col-md-12">
						<table class="table table-striped" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th>Nº</th>
								<th>Nome</th>
								<th>Numero de Rodadas</th>
								<th class="actions">Ações</th>
							</tr>
						</thead>
							<tbody>
								<c:forEach var="campeonato" items="${lista}">
									<tr>
										<td>${campeonato.idCampeonato}</td>
										<td>${campeonato.nome}</td>
										<td>${campeonato.numeroRodadas}</td>
										<td class="actions">
                                             <a class="btn btn-success btn-xs" href="listar_resultados_1?id=${campeonato.idCampeonato}">Listar Resultados</a>
                                        </td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>
			</div>	
</body>
</html>