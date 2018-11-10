<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro de Times</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/style.css">
<script type="text/javascript" src="js/jquery-1.6.2.js"></script>

<script type="text/javascript">
	      		$(document).ready(function(){
	      			$('#add-btn').click(function(){
	      				var input_val;
	      				var nomes_times = $('#new-opt').val();
	      				$.ajax({
	      					type:'POST',
	      					data: {
	      						
	      						nomes_times: nomes_times,
	      						acao:'inserirTimes'
	      						
	      					},
	      					
	      					url:'manterdados.do',
	      					success: function(result){
	      							$('#mySelect').html(result);
	      							document.getElementById('new-opt').value='';
	      					}
	      					
	      				});
	      			});
	      		});
      		</script>

</head>
<body>
	<c:import url="MenuUsuario.jsp" />

	<div class="container">
		<div class=" col-md-12 text-center">
			<img src="img/co.png" class="rounded" alt="Cinque Terre" width="304"
				height="300">
		</div>

		<form id="regForm" class="regFormMargin" action="manterdados.do"
			method="post">
			<h1 align="center">Inserir Times</h1>
			<div class="form-group">
				<label>Times</label> <input type="text" class="form-control"
					id="new-opt" placeholder=""> <small id="idHelp"
					class="form-text text-muted">Informe os times acima</small>
			</div>

			<div class="form-group">
				<select multiple class="form-control" id="mySelect" size="10">
					<option>Adicione um time aqui</option>
				</select>
			</div>
			<br />
		</form>
		<div align="center">
			<button id="add-btn" class="btn btn-warning">Adicionar time</button>
			<button onclick="myFunction()" class="btn btn-warning">Remover
				time selecionado</button>
		</div>

	</div>
	<script src="js/form-select.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>