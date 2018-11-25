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
		<div class="card">
			<div class="card-header" id="headingTwo">
				<h5 class="mb-0">
					<button class="btn btn-primary btn-lg btn-block"
						data-toggle="collapse" data-target="#jogosMaster"
						aria-expanded="false" aria-controls="jogosMaster">Jogos
						Master</button>
				</h5>
			</div>
			<div id="jogosMaster" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordion">
				<div class="card-body">
					<div class="jumbotron text-center valor">
						<h1>Jogos</h1>
						<h2>Categoria: Master</h2>
						<input class="form-control" id="myInput" type="text" placeholder="Search..">
					</div>
						
						<table class="table">
							<tr class="jumbotron text-center">
								<th>Nº</th>
								<th>Data</th>
								<th>Hora</th>
								<th>Mandante</th>
								<th>Placar</th>
								<th>Visitante</th>
								<th>Cartões Amarelos / Cartões Vermelhos</th>
								<th>TC?</th>
								<th>Árbitro</th>
							</tr>
							
							
							<tbody  id="myTable">
									<tr>
										<td>1</td>
										<td>xx/xx/xxxx</td>
										<td>xx:xx</td>
										<td>Time1</td>
										<td>0 x 1</td>
										<td>Time2</td>
										<td>5 / 0</td>
										<td>??</td>
										<td>NomeArbitro</td>
									</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<script>
			$(document).ready(function(){
			  $("#myInput").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#myTable tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
			});
		</script>


</body>
</html>