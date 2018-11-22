<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Alterar Jogador</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- <link href="css/style.css" rel="stylesheet"> -->
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
	<c:import url="MenuUsuario.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Alterar Jogador</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="alterar_efetivar" method="post">
        <c:forEach var="jogador" items="${jogador}">
            <!-- area de campos do form -->
            <div class="row">
            	<div class="form-group col-md-6">
	                    <label for="idJogador">Nome</label>
	                    <input type="hidden" class="form-control" name="idJogador" id="idJogador" value="${jogador.idJogador}">
	                    <input type="text" class="form-control" name="nomeJogador" id="nome" required maxlength="100" placeholder="nome do jogador" value="${jogador.nomeJogador}">
	            </div>
	            <div class="form-group col-md-6">
	                    <label for="dataNascimento">Data de Nascimento</label>
	                    <input type="text" class="form-control" name="nascimento_jogador" id="dataNascimento" placeholder="formato dd/mm/yyyy" value="<fmt:formatDate value="${jogador.nascimento_jogador}" pattern="dd/MM/yyyy"/>"/>
	            </div>
            </div>
    
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="criar">Salvar</button>
                    <a href="#" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </c:forEach>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>