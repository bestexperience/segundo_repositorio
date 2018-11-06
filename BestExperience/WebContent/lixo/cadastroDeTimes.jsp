<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Cadastro de Times</title>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap-tagsinput.css">

<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<c:import url="MenuUsuario.jsp" />

	<div class="jumbotron text-center">
		<h1>Digite os nomes dos times no campo abaixo</h1>
		<p>Não apertar enter. Após o nome de um time utilize barra de
			espaço e virgula para inserir.</p>
	</div>

	<div class="container">
		<form action="manterdados.do" method="post" id="regForm">
			<label>Nome dos Times</label> <br /> <input type="text"
				data-role="tagsinput" name="nomes_times" required><br />
			<br />
			<button type="submit" class="btn btn-warning" name="acao"
				value="inserirTimes">Cadastrar</button>
		</form>
	</div>
	<!-- 
     	Parte do controler 
     	
     	String arrayTimes[] = times.split(Pattern.quote(","));
			tService = new TimeService();
			time = new Time();
			
			String nomeTime = null;
			for(int i=0; i < arrayTimes.length; i++ )
			{
				nomeTime = arrayTimes[i];
				time.setNome(nomeTime);
				tService.inserirUsuario(time);
			}
     
     
      -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
	</script>
	<script src="js/bootstrap.min.js">
	</script>
	<script src="js/bootstrap-tagsinput.min.js">
	</script>
</body>
</html>