<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Alterar Campeonato</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="MenuUsuario.jsp"/>
	<div class="container">
	  <h2>Alteração de Campeonato</h2>
	  <form class="form-horizontal" action="">
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="nome">Nome</label>
	      <div class="col-sm-10">
	     	<input type="hidden" class="form-control" id="nome" name="idCampeonato" value="${campeonato.idCampeonato}">
	        <input type="text" class="form-control" id="nome" placeholder="Insira o nome do time" name="nome" value="${campeonato.nome}">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="nome">Numero de rodadas</label>
	      <div class="col-sm-10">
	        <input type="number" class="form-control" id="numeroRodadas" placeholder="Numero de rodadas" name="numeroRodadas" value="${campeonato.numeroRodadas}">
	      </div>
	    </div>
	    
	    <hr />
	    
	    <div class="form-group">
			<label class="control-label col-sm-2" for="nome">Configuração de Pontos</label>
				<div class="col-sm-10">
					<c:forEach var="status" items="${status}">
						<p>
							<label class="control-label col-sm-2" for="nome">${status.nome}</label>
							<input type="text" name="pontos${status.id}">
						</p>
					</c:forEach>
				</div>
		</div>
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default">Atualizar</button>
	      </div>
	    </div>
	  </form>
	</div>
</body>
</html>