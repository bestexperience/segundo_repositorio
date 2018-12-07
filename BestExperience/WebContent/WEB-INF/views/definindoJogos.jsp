<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="./css/style-menubar.css">
</head>
<body>
	<c:import url="MenuUsuario.jsp"/>
<div class="container">
  <h2>#${campeonato.idCampeonato}: ${campeonato.nome}</h2>
  <p>Abaixo diga os times que irão jogar</p>
  	
  <form action="efetivar_inserir_jogo" method="post">
  	<input type="hidden" class="form-control" name="campeonato.idCampeonato" id="campeonato" value="${campeonato.idCampeonato}">
    <div class="form-group col-md-5">
      <label for="time">Time Mandante</label>
      <select class="form-control" name="time_mandante.idTime" id="time">
      <option>Escolha um time...</option>
      	<c:forEach var="time" items="${lista}">
        <option value="${time.idTime}">${time.nome}</option>
       </c:forEach>
      </select>
      <br>
    </div>
      
      <div class="col-md-2" align="center">X</div>
      
    <div class="form-group col-md-5" >
      <label for="time">Time Visitante</label>
      <select class="form-control" name="time_visitante.idTime" id="time">
      	<option>Escolha um time...</option>
      	<c:forEach var="time" items="${lista}">
        	<option value="${time.idTime}">${time.nome}</option>
        </c:forEach>
      </select>
      <br>
    </div>
    <br />
    <div class="col-md-12" align="center">Indique a quantidade de pontos respectivamente.</div>
    <div class="col-md-12" align="center"></div>
    <div class="col-md-12" align="center"></div>
    <div class="col-md-12" align="center"></div>
    
    <div class="form-group col-md-5">
      <label for="placar_mandante">Pontos Time mandante</label>
      <input type="number" class="form-control" name=placar_mandante id="placar_mandante" placeholder="pontos">
      <br>
    </div>
    
     <div class="col-md-2" align="center">X</div>
    
    <div class="form-group col-md-5">
      <label for="placar_visitante">Pontos Time Visitante</label>
      <input type="number" class="form-control" name="placar_visitante" id="placar_visitante" placeholder="pontos">
      <br>
    </div>
    
    <div class="form-group col-md-6">
      <label for="tim">Data do Jogo</label>
      <input type="text" class="form-control" name="data" id="data" placeholder="Formato dd/mm/yyyy">
      <br>
    </div>
    
    <div class="form-group col-md-6">
      <label for="turno">Digite o numero do turno</label>
      <input type="number" class="form-control" name="turno" id="turno" placeholder="Em qual turno estamos?" required>
      <br>
    </div>
   
   	 <div id="actions" class="row" align="center">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="criar">Salvar</button>
                    <a href="#" class="btn btn-default">Cancelar</a>
                </div>
     </div>
   
  </form>
</div>

</body>
</html>
