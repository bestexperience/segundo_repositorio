<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/style.css">
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
</head>
<body>

	<c:import url="Menu.jsp" />
	<!--Jogos Master-->
	<div class="container">
		<div class=" col-md-12 text-center pad">
			<img src="img/screen.jpg" class="img-circle" alt="Cinque Terre"
				width="304" height="300">
		</div>

		<form action="fazer_login" method="post" id="regForm">

			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-user"></i>
					</span> 
					<input type="text" class="form-control" id="exampleInputEmail1"	name="login" placeholder="Nome de Usuario" required>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-lock"></i>
					</span> 
					<input type="password" class="form-control"	id="exampleInputPassword1" name="senha" placeholder="Senha"	required>
				</div>
			</div>
			<small id="resultado" class="form-text text-muted" ><a href="esqueci_minha_senha">Esqueci a minha senha</a></small>
			<div align="center">
				<button type="submit" class="btn btn-warning" name="acao"
					value="logar">Acessar</button>
				<button type="reset" class="btn btn-warning" value="resetar">Limpar</button>
			</div>
		</form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>