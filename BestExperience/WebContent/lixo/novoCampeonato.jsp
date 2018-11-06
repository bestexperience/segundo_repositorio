<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<div id="main">
		<h2>Campeonato</h2>
		<p>Click on the element below to open the side navigation menu,
			and push this content to the right.</p>
		<form action="manterdados.do" method="post">
			<div class="row">

				<div class="form-group col-md-3">
					<label for="nome">Numero do Usuario</label> <input type="text"
						class="form-control" id="nome" name="id" placeholder="Id usuario"
						value="${usuario.id}" />
				</div>

				<div class="form-group col-md-3">
					<label for="nome">Nome do Campeonato</label> <input type="text"
						class="form-control" id="nome" name="nome_campeonato"
						placeholder="Entre com o nome" />
				</div>
			</div>
			<!-- 
          <div class="row">
	          <c:forEach var="status" items="${status}">
	          <div class="form-group col-md-2">
	            <label for="nome" value="${status.id}">${status.nome}</label>
	            <input type="number" class="form-control" id="nome" name="pontos"/>
	          </div>
	          </c:forEach>
          </div>
           -->
			<div class="row">
				<div class="form-group col-md-8">
					<button type="submit" class="btn btn-primary" name="acao"
						value="cadastrarCampeonato">Criar</button>
					<button type="reset" class="btn btn-primary">Limpar</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>