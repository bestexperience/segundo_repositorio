<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Buscar Jogadores</title>
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
                <form action=listar_jogadores method="post">
                    <div id="top" class="row">
                        <div class="col-md-3">
                            <h2>Jogadores</h2>
                        </div>
	
                        <div class="col-md-6">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Jogador (deixe vazio para trazer todos)">
                                <span class="input-group-btn">
                <button class="btn btn-primary" type="submit" name="acao" value="listar">
                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </div>
                        
                        <div class="col-md-3">
                            <a href="novo_jogador" class="btn btn-primary pull-right h2">Novo Jogador</a>
                        </div>
                        
                    </div>
                    <!-- /#top -->
                </form>
                <hr />
                <c:if test="${not empty lista}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Nascimento</th>
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="jogador" items="${lista}">
                                       <tr>
                                            <td>
                                               ${jogador.idJogador}
                                            </td>
                                            <td>
                                                ${jogador.nomeJogador}
                                            </td>
                                            <td>
                                                <fmt:formatDate value="${jogador.nascimento_jogador}" pattern="dd/MM/yyyy"/>
                                            </td>
                                            <td class="actions">
                                                <!-- <a class="btn btn-success btn-xs" href="visualizar_jogador?chave=${jogador.nomeJogador}">Visualizar</a> -->
                                                <a class="btn btn-success btn-xs" href="alterar_jogador?chave=${jogador.nomeJogador}">Alterar</a>
                                                <a class="btn btn-success btn-xs" href="excluir_jogador?id=${jogador.idJogador}">Excluir</a>
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