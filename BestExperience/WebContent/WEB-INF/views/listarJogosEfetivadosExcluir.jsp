<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Buscar Jogos</title>
			<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			<!--  <link rel="stylesheet" href="./css/style.css">-->
			<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
			<link rel="stylesheet" href="./css/style-menubar.css">
			
			<!-- 
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style1.css" rel="stylesheet"> -->

        </head>

        <body>
            <!-- Barra superior com os menus de navegação -->
			<c:import url="MenuUsuario.jsp"/>
            <!-- Container Principal -->
            <div id="main" class="container">
                    <div id="top" class="row">
                        <div class="col-md-3">
                            <h2>Jogos</h2>
                   </div></div>
                
                <c:if test="${not empty lista}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                        
                        <tr class="jumbotron text-center">
					<th>Data</th>
					<th>Mandante</th>
					<th>Placar</th>
					<th>Visitante</th>
					 <th class="actions">Ações</th>
				</tr>
	
				<tbody>
					<c:forEach var="jf" items="${lista}">
					<tr>
						<td><fmt:formatDate value="${jf.data}" pattern="dd/MM/yyyy"/></td>
						<td>${jf.time_mandante.nome}</td>
						<td>${jf.placar_mandante} x ${jf.placar_visitante}</td>
						<td>${jf.time_visitante.nome}</td>
						
						<td class="actions">
                               <a class="btn btn-success btn-xs" href="listar_jogos_efetivado_excluir_efetivar?id=${jf.id_sumula}">Excluir</a>
                        </td>
					</tr>
					</c:forEach>
					
					<c:forEach var="jf" items="${lista2}">
					<tr>
						<td><fmt:formatDate value="${jf.data}" pattern="dd/MM/yyyy"/></td>
						<td>${jf.time_mandante.nome}</td>
						<td>${jf.placar_mandante} x ${jf.placar_visitante}</td>
						<td>${jf.time_visitante.nome}</td>
						
						<td class="actions">
                               <a class="btn btn-success btn-xs" href="listar_jogos_efetivado_excluir_efetivar?id=${jf.id_sumula}">Excluir</a>
                        </td>
					</tr>
					</c:forEach>
				</tbody>
                        
                 </table>

                    </div>
                </div>
                <!-- /#list -->

                <div id="bottom" class="row">
                    <div class="col-md-12">
                        <!-- paginação ainda não foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
                            </li>
                        </ul>
                        <!-- /.pagination -->
                    </div>
                </div>
                </c:if>
                <!-- /#bottom -->
            </div>
            <!-- /#main -->
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script type="text/javascript">
                $("#delete-modal").on('show.bs.modal', function(event) {
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.data('filme');
                    $("#id_excluir").val(recipient);
                });
            </script>
        </body>

        </html>