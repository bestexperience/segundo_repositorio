<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Usuário</title>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" href="./css/style.css">

</head>
<body>

	<c:import url="MenuUsuario.jsp" />

	<div class="container">
		<div class=" col-md-12 text-center">
			<img src="img/usuario.png" class="rounded" alt="Cinque Terre"
				width="304" height="300">
		</div>
		<h1 align="center">${usuario.nome}</h1>

		<form id="regForm">

			<div class="form-group">
				<label for="id">ID</label> <input type="text" class="form-control"
					readonly id="id" placeholder="Id" value="${usuario.id}"> <small
					id="idHelp" class="form-text text-muted">Seu ID nunca será
					alterado</small>
			</div>

			<div class="form-group">
				<label for="login">Usuário</label> <input type="text"
					class="form-control" readonly id="login" placeholder="login"
					value="${usuario.login}">
			</div>

			<div class="form-group">
				<label for="name">Nome</label> <input type="text"
					class="form-control" readonly id="name" placeholder="Nome"
					value="${usuario.nome}">
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">E-mail</label> <input type="email"
					class="form-control" readonly id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email"
					value="${usuario.email}">
			</div>
			<div align="center">
				<button type="" class="btn btn-warning">Alterar</button>
			</div>
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
        function openNav() {
            document.getElementById("mySidenav").style.width = "250px";
            document.getElementById("main").style.marginLeft = "250px";
            document.getElementById("navstyle").style.paddingLeft = "250px";
        }

        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
            document.getElementById("main").style.marginLeft= "0";
            document.getElementById("navstyle").style.paddingLeft = "0";
        }
    </script>
</body>
</html>