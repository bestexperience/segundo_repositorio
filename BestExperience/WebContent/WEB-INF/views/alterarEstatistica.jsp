<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Definir Estatisticas</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/style-menu-no-border.css">
</head>
<body>
	<c:import url="MenuUsuario.jsp" />
	<!--Jogos Master-->
	<div class="container">
  <h2 align="center">Definindo Estatisticas</h2>
  <form class="form-horizontal" action="alterar_estatistica_pelo_id">
    <div class="form-group">
      <div class="col-sm-10">
        <input type="hidden" class="form-control" id="id_estatistia" placeholder="Insira o nome do time" name="idEstatistica" value="${estatistica.idEstatistica}">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="data">Data do jogo</label>
      <div class="col-sm-3">
        <input type="text" class="form-control" id="data" placeholder="" name="data" value="<fmt:formatDate value="${estatistica.jogos.data}" pattern="dd/MM/yyyy"/>">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="gols">Gols</label>
      <div class="col-sm-3">
        <input type="number" class="form-control" id="gols" placeholder="" name="score" >
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="chuteFora">Chute fora</label>
      <div class="col-sm-3">
        <input type="number" class="form-control" id="chuteFora" placeholder="" name="chute_fora" >
      </div>
    </div>
      <div class="form-group">
      <label class="control-label col-sm-2" for="salvamentos">Salvamentos</label>
      <div class="col-sm-3">
        <input type="number" class="form-control" id="salvamentos" placeholder="" name="saves" >
      </div>
    </div>
      <div class="form-group">
      <label class="control-label col-sm-2" for="escanteios">Escanteios</label>
      <div class="col-sm-3">
        <input type="number" class="form-control" id="escanteios" placeholder="" name="escanteios" >
      </div>
    </div>
      <div class="form-group">
      <label class="control-label col-sm-2" for="faltas">Faltas</label>
      <div class="col-sm-3">
        <input type="number" class="form-control" id="faltas" placeholder="" name="faltas" >
      </div>
    </div>
      <div class="form-group">
      <label class="control-label col-sm-2" for="laterais">Laterais</label>
      <div class="col-sm-3">
        <input type="number" class="form-control" id="laterais" placeholder="" name="laterais" >
      </div>
    </div>
      <div class="form-group">
      <label class="control-label col-sm-2" for="passes_de_bola">Passes de Bola</label>
      <div class="col-sm-3">
        <input type="number" class="form-control" id="passes_de_bola" placeholder="" name="passes_de_bola" >
      </div>
    </div>
      <div class="form-group">
      <label class="control-label col-sm-2" for="laterais">Defesas</label>
      <div class="col-sm-3">
        <input type="number" class="form-control" id="laterais" placeholder="" name="laterais" >
      </div>
      </div>
        <div class="form-group">
      <label class="control-label col-sm-2" for="bola_fora">Bola fora</label>
      <div class="col-sm-3">
        <input type="number" class="form-control" id="bola_fora" placeholder="" name="bola_fora" >
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>