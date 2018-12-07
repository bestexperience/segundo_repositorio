<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Listagem de Juizes</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/style-menu-no-border.css">
</head>
<body>
	<c:import url="Menu.jsp" />
	<!--Jogos Master-->
	<div class="container">
		<div>
			<div id="jogosMaster" aria-labelledby="headingTwo">
				<div >
					<div class="jumbotron text-center valor">
						<h1>Juizes</h1>
						<input class="form-control" id="myInput" type="text" placeholder="Search..">
					</div>
						
						<table class="table">
							<tr class="jumbotron text-center">
								<th>N�</th>
								<th>Nome</th>
								<th>Data de Nascimento</th>
							</tr>
							
							
							<tbody  id="myTable">
								<c:forEach var="juiz" items="${lista}">
									 <td>
                                               ${juiz.idJuiz}
                                            </td>
                                            <td>
                                                ${juiz.nomeJuiz}
                                            </td>
                                            <td>
                                                <fmt:formatDate value="${juiz.data_nascimento}" pattern="dd/MM/yyyy"/>
                                            </td>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		
		<script>
			$(document).ready(function(){
			  $("#myInput").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#myTable tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
			});
		</script>

</body>
</html>