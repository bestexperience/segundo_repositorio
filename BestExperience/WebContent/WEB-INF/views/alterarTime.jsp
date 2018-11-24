<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Alterar Time</title>
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
  <h2>Alterar Time</h2>
  <form class="form-horizontal" action="efetivar_time_atualizacao">
    <div class="form-group">
      <label class="control-label col-sm-2" for="nome">Nome</label>
      <div class="col-sm-10">
       	<input type="hidden" class="form-control" id="idTime" name="idTime" value="${time.idTime}">
        <input type="text" class="form-control" id="nome" placeholder="Insira o nome do time" name="nome" value="${time.nome}">
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