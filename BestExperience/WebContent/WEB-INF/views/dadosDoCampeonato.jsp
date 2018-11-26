<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="./css/style.css">
</head>
<body>
<c:import url="Menu.jsp" />
<div class="container">
  <h2 align="center">Lista de Jogos</h2>
  <div class="col-md-12" align="center"><h2></h2></div>
  <c:forEach var="time" items="${lista}" varStatus="idDado">
  <div class="col-md-5">
      <div class="thumbnail">
          <img src="img/screen.jpg" alt="Lights" style="width:30%">
          <div class="caption">
            <p align="center">${time.nome}</p>
          </div>
      </div>
   </div>
   	<c:if test="${idDado.count % 2 != 0}">
    	<div class="col-md-2" align="center"><h2>VS</h2></div>
    </c:if>
    </c:forEach>
</div>

</body>
</html>