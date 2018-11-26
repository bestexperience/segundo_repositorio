<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<link rel="stylesheet" href="./css/style.css">

</head>
<body>
	<c:import url="Menu.jsp" />
	<div id="main" class="container">
		<div class=" col-md-12 text-center">
			<img src="img/engrenagem.png" class="rounded" alt="Cinque Terre"
				width="304" height="300">
		</div>

		<form action="buscar_email_login" method="post" id="regForm">
			<div class="form-group">
				<label for="email">E-mail</label> 
				<input type="email"	class="form-control" id="email" name="email" required placeholder="Endereço de E-mail">
			</div>

			<div class="form-group">
				<label for="login">Login</label> 
				<input type="text" class="form-control" id="login" name="login" required placeholder="Defina um login">
			</div>
			<small id="resultado" class="form-text text-muted" >Se esqueceu o seu login é necessário entrar em contato com o administrador para redefinir</small>
			
			<div align="center">
				<button type="submit" class="btn btn-warning" name="acao"
					value="cadastrar">Buscar</button>
				<button type="reset" class="btn btn-warning">Limpar</button>
			</div>
		</form>
	</div>

	<script type="text/javascript">
		function validaSenha(){
			var campo1 = document.getElementById('senha1').value;
			var campo2 = document.getElementById('senha2').value;
			
			if(campo1 == campo2){
				document.getElementById('resultado').style.color = "#008B45";
				document.getElementById('resultado').innerHTML = "As senhas são iguais";
			}else{
				document.getElementById('resultado').style.color = "#FF6347";
				document.getElementById('resultado').innerHTML = "As senhas não correspondem";
			}
		}
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>