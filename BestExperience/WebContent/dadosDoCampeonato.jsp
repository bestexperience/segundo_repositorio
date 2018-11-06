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
					</div>

					<div class="container">
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

							<tbody>
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

								<tr>
									<td>2</td>
									<td>xx/xx/xxxx</td>
									<td>xx:xx</td>
									<td>Time1</td>
									<td>0 x 1</td>
									<td>Time2</td>
									<td>5 / 0</td>
									<td>??</td>
									<td>NomeArbitro</td>
								</tr>

								<tr>
									<td>3</td>
									<td>xx/xx/xxxx</td>
									<td>xx:xx</td>
									<td>Time1</td>
									<td>0 x 1</td>
									<td>Time2</td>
									<td>5 / 0</td>
									<td>??</td>
									<td>NomeArbitro</td>
								</tr>

								<tr>
									<td>4</td>
									<td>xx/xx/xxxx</td>
									<td>xx:xx</td>
									<td>Time1</td>
									<td>0 x 1</td>
									<td>Time2</td>
									<td>5 / 0</td>
									<td>??</td>
									<td>NomeArbitro</td>
								</tr>

								<tr>
									<td>5</td>
									<td>xx/xx/xxxx</td>
									<td>xx:xx</td>
									<td>Time1</td>
									<td>0 x 1</td>
									<td>Time2</td>
									<td>5 / 0</td>
									<td>??</td>
									<td>NomeArbitro</td>
								</tr>

								<tr>
									<td>6</td>
									<td>xx/xx/xxxx</td>
									<td>xx:xx</td>
									<td>Time1</td>
									<td>0 x 1</td>
									<td>Time2</td>
									<td>5 / 0</td>
									<td>??</td>
									<td>NomeArbitro</td>
								</tr>

								<tr>
									<td>7</td>
									<td>xx/xx/xxxx</td>
									<td>xx:xx</td>
									<td>Time1</td>
									<td>0 x 1</td>
									<td>Time2</td>
									<td>5 / 0</td>
									<td>??</td>
									<td>NomeArbitro</td>
								</tr>

								<tr>
									<td>8</td>
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
		<!--Gols Master-->
		<div class="card">
			<div class="card-header" id="headingTwo">
				<h5 class="mb-0">
					<button class="btn btn-primary btn-lg btn-block"
						data-toggle="collapse" data-target="#golsMaster"
						aria-expanded="false" aria-controls="golsMaster">
						Artilharia Master</button>
				</h5>
			</div>
			<div id="golsMaster" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordion">
				<div class="card-body">
					<div class="jumbotron text-center">
						<h1>Artilharia</h1>
						<h2>Categoria: Master</h2>
					</div>

					<div class="container">
						<table class="table">

							<tr class="jumbotron text-center">
								<th>Nº</th>
								<th>Jogador</th>
								<th>Equipe</th>
								<th>Gols</th>
							</tr>

							<tbody>
								<tr>
									<td>1</td>
									<td>Fulano</td>
									<td>*Equipe*</td>
									<td>xx</td>
								</tr>

								<tr>
									<td>2</td>
									<td>Fulano</td>
									<td>*Equipe*</td>
									<td>xx</td>
								</tr>

								<tr>
									<td>3</td>
									<td>Fulano</td>
									<td>*Equipe*</td>
									<td>xx</td>
								</tr>

								<tr>
									<td>4</td>
									<td>Fulano</td>
									<td>*Equipe*</td>
									<td>xx</td>
								</tr>

								<tr>
									<td>5</td>
									<td>Fulano</td>
									<td>*Equipe*</td>
									<td>xx</td>
								</tr>

								<tr>
									<td>6</td>
									<td>Fulano</td>
									<td>*Equipe*</td>
									<td>xx</td>
								</tr>

								<tr>
									<td>7</td>
									<td>Fulano</td>
									<td>*Equipe*</td>
									<td>xx</td>
								</tr>

								<tr>
									<td>8</td>
									<td>Fulano</td>
									<td>*Equipe*</td>
									<td>xx</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- Cartões Master -->
		<div class="card">
			<div class="card-header" id="headingTwo">
				<h5 class="mb-0">
					<button class="btn btn-primary btn-lg btn-block"
						data-toggle="collapse" data-target="#cartoesMaster"
						aria-expanded="false" aria-controls="golsMaster">Cartões
						Master</button>
				</h5>
			</div>
			<div id="cartoesMaster" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordion">
				<div class="card-body">
					<div class="jumbotron text-center">
						<h1>Artilharia</h1>
						<h2>Categoria: Master</h2>
					</div>

					<div class="container">
						<table class="table">

							<tr class="jumbotron text-center">
								<th>Nº</th>
								<th>Jogador</th>
								<th>Equipe</th>
								<th>Gols</th>
							</tr>

							<tbody>
								<tr>
									<td>1</td>
									<td>Fulano</td>
									<td>*Equipe*</td>
									<td>xx</td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<!--Jogos Senior-->
		<div class="card">
			<div class="card-header" id="headingTwo">
				<h5 class="mb-0">
					<button class="btn btn-primary btn-lg btn-block"
						data-toggle="collapse" data-target="#jogosSenior"
						aria-expanded="false" aria-controls="jogosSenior">Jogos
						Sênior</button>
				</h5>
			</div>
			<div id="jogosSenior" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordion">
				<div class="card-body">
					<div class="jumbotron text-center">
						<h1>Jogos</h1>
						<h2>Categoria: Sênior</h2>
					</div>

					<div class="container">
						<table class="table">

							<tr class="jumbotron text-center">
								<th>Nº</th>
								<th>Jogador</th>
								<th>Hora</th>
								<th>Mandante</th>
								<th>Placar</th>
								<th>Visitante</th>
								<th>Cartões Amarelos / Cartões Vermelhos</th>
								<th>TC?</th>
								<th>Árbitro</th>
							</tr>

							<tbody>
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

								<tr>
									<td>2</td>
									<td>xx/xx/xxxx</td>
									<td>xx:xx</td>
									<td>Time1</td>
									<td>0 x 1</td>
									<td>Time2</td>
									<td>5 / 0</td>
									<td>??</td>
									<td>NomeArbitro</td>
								</tr>

								<tr>
									<td>3</td>
									<td>xx/xx/xxxx</td>
									<td>xx:xx</td>
									<td>Time1</td>
									<td>0 x 1</td>
									<td>Time2</td>
									<td>5 / 0</td>
									<td>??</td>
									<td>NomeArbitro</td>
								</tr>

								<tr>
									<td>4</td>
									<td>xx/xx/xxxx</td>
									<td>xx:xx</td>
									<td>Time1</td>
									<td>0 x 1</td>
									<td>Time2</td>
									<td>5 / 0</td>
									<td>??</td>
									<td>NomeArbitro</td>
								</tr>

								<tr>
									<td>5</td>
									<td>xx/xx/xxxx</td>
									<td>xx:xx</td>
									<td>Time1</td>
									<td>0 x 1</td>
									<td>Time2</td>
									<td>5 / 0</td>
									<td>??</td>
									<td>NomeArbitro</td>
								</tr>

								<tr>
									<td>6</td>
									<td>xx/xx/xxxx</td>
									<td>xx:xx</td>
									<td>Time1</td>
									<td>0 x 1</td>
									<td>Time2</td>
									<td>5 / 0</td>
									<td>??</td>
									<td>NomeArbitro</td>
								</tr>

								<tr>
									<td>7</td>
									<td>xx/xx/xxxx</td>
									<td>xx:xx</td>
									<td>Time1</td>
									<td>0 x 1</td>
									<td>Time2</td>
									<td>5 / 0</td>
									<td>??</td>
									<td>NomeArbitro</td>
								</tr>

								<tr>
									<td>8</td>
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

		<!--Gols Senior-->
		<div class="card">
			<div class="card-header" id="headingTwo">
				<h5 class="mb-0">
					<button class="btn btn-primary btn-lg btn-block"
						data-toggle="collapse" data-target="#golsSenior"
						aria-expanded="false" aria-controls="golsSenior">
						Artilharia Sênior</button>
				</h5>
			</div>
			<div id="golsSenior" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordion">
				<div class="card-body">
					<div class="jumbotron text-center">
						<h1>Artilharia</h1>
						<h2>Categoria: Sênior</h2>
					</div>
					<table class="table">
						<thead>
							<tr class="jumbotron text-center">
								<th>Nº</th>
								<th>Jogador</th>
								<th>Equipe</th>
								<th>Gols</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Fulano</td>
								<td>*Equipe*</td>
								<td>xx</td>
							</tr>

							<tr>
								<td>2</td>
								<td>Fulano</td>
								<td>*Equipe*</td>
								<td>xx</td>
							</tr>

							<tr>
								<td>3</td>
								<td>Fulano</td>
								<td>*Equipe*</td>
								<td>xx</td>
							</tr>

							<tr>
								<td>4</td>
								<td>Fulano</td>
								<td>*Equipe*</td>
								<td>xx</td>
							</tr>

							<tr>
								<td>5</td>
								<td>Fulano</td>
								<td>*Equipe*</td>
								<td>xx</td>
							</tr>

							<tr>
								<td>6</td>
								<td>Fulano</td>
								<td>*Equipe*</td>
								<td>xx</td>
							</tr>

							<tr>
								<td>7</td>
								<td>Fulano</td>
								<td>*Equipe*</td>
								<td>xx</td>
							</tr>

							<tr>
								<td>8</td>
								<td>Fulano</td>
								<td>*Equipe*</td>
								<td>xx</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<!-- Cartões Master -->
		<div class="card">
			<div class="card-header" id="headingTwo">
				<h5 class="mb-0">
					<button class="btn btn-primary btn-lg btn-block"
						data-toggle="collapse" data-target="#cartoesSenior"
						aria-expanded="false" aria-controls="golsMaster">Cartões
						Sênior</button>
				</h5>
			</div>
			<div id="cartoesSenior" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordion">
				<div class="card-body">
					<div class="jumbotron text-center">
						<h1>Artilharia</h1>
						<h2>Categoria: Master</h2>
					</div>

					<div class="container">
						<table class="table">

							<tr class="jumbotron text-center">
								<th>Nº</th>
								<th>Jogador</th>
								<th>Equipe</th>
								<th>Gols</th>
							</tr>

							<tbody>
								<tr>
									<td>1</td>
									<td>Fulano</td>
									<td>*Equipe*</td>
									<td>xx</td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>