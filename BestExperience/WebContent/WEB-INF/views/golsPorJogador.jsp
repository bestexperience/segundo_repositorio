<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Gols</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="./css/style-menu-no-border.css">
</head>
<body>
	<c:import url="MenuUsuario.jsp" />
<div class="container">
  <h2>Abaixo colocar</h2>
  <p>The form below contains two dropdown menus (select lists):</p>
	<form action="atualizar_quantidade_gols_jogador" method="post">
 
    <input type="text" class="form-control" id="contador" name="quantidade" value="${quantidade}"/>
    <div class="form-group col-md-5">
                    <label for="time">Jogadores</label>
                    <select class="form-control" name="jogador.idJogador" id="time">
                    		<option selected>Escolha um jogador</option>
                    		<c:forEach var="jogador" items="${listaMandante}">
                    		<option value="${jogador.idJogador}">${jogador.nomeJogador}</option>
                    		</c:forEach>
                    		<c:forEach var="jogador" items="${listaVisitante}">
                    		<option value="${jogador.idJogador}">${jogador.nomeJogador}</option>
                    		</c:forEach>
                    </select>
            </div>
      
    <div class="form-group col-md-5">
      <label for="gols">Quantidade de gols feitos</label>
        <input type="number" class="form-control" id="gols" name="gols" required>
      <br>
    </div>
    
    <div class="col-md-12" align="" id="actions">
                    <button type="submit" class="btn btn-primary">Salvar</button>
                    <a href="#" class="btn btn-default">Cancelar</a>
    </div>
      <br>
  </form>
  </div>
</body>
</html>