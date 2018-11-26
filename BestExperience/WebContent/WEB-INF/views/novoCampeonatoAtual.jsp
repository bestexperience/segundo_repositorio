<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Novo Campeonato</title>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="css/form-style.css">
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<c:import url="MenuUsuario.jsp" />

	<div class="container">
		<div class=" col-md-12 text-center">
			<img src="img/screen.jpg" class="rounded" alt="Cinque Terre" width=""
				height="300">
		</div>

		<form id="regForm" action="cadastrar_campeonato"
			method="post">
			<h1>Criar Campeonato</h1>
			<!-- One "tab" for each step in the form: -->
			<div class="tab">
				<label>Dados do Campeonato</label>
				<p>
					<input placeholder="Id..." readonly oninput="this.className = ''"
						name="id" value="${usuario.id}"> <small id="idHelp"
						class="form-text text-muted">Seu ID será incluso como um
						dado do campeonato.</small>
				</p>

				<p>
					<input placeholder="Nome do campeonato"
						oninput="this.className = ''" name="nome">
				</p>
				<p>
					<input type="number" placeholder="Numero de rodadas"
						oninput="this.className = ''" name="numeroRodadas">
				</p>
			</div>

			<div class="tab">
				Configurando os pontos:<br />
				<br />
				<c:forEach var="status" items="${status}">
					<p>
					<label>${status.nome}</label>
						<input placeholder="${status.nome}..." oninput="this.className = ''"
							name="pontos${status.id}">
					</p>
				</c:forEach>
			</div>

			<div style="overflow: auto;">
				<div style="float: right;">
					<button type="button" id="prevBtn" onclick="nextPrev(-1)"
						class="btn btn-secondary">Anterior</button>
					<button type="button" id="nextBtn" onclick="nextPrev(1)"
						class="btn btn-warning">Proximo</button>
				</div>
			</div>
			<!-- Circles which indicates the steps of the form: -->
			<div style="text-align: center; margin-top: 40px;">
				<span class="step"></span> <span class="step"></span>
			</div>
		</form>
	</div>

	<script language="JavaScript" src="js/form-js.js">
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>