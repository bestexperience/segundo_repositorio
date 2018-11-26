<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Criar Juiz</title>
			<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			<!--  <link rel="stylesheet" href="./css/style.css">-->
			<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
			<link rel="stylesheet" href="./css/style-menubar.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
	<c:import url="MenuUsuario.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Incluir Juiz</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="cadastrar_juiz" method="post">
            <!-- area de campos do form -->
            <div class="row">
            	<div class="form-group col-md-8">
	                    <label for="nome">Nome</label>
	                    <input type="text" class="form-control" name="nomeJuiz" id="nome" required maxlength="100" placeholder="nome do juiz">
	            </div>
	            <div class="form-group col-md-4">
	                    <label for="dataNascimento">Data de Nascimento</label>
	                    <input type="text" class="form-control" name="data_nascimento" id="dataNascimento" placeholder="formato dd/mm/yyyy">
	            </div>
	     
            </div>
            <div class="row">
            	<div class="form-group col-md-6">
                    <label for="cidade">Cidade</label>
                    <select class="form-control" name="cidade.idCidade" id="cidade">
                    		<c:forEach var="cidade" items="${cidades}">
                    		<option value="${cidade.idCidade}">${cidade.nomeCidade}</option>
                    		</c:forEach>
                    </select>
                </div>

                <div class="form-group col-md-6">
                    <label for="estado">Estados</label>
                    <select class="form-control" name="estado.idEstado" id="estado">
                    		<c:forEach var="estado" items="${estados}">
                    		<option value="${estado.idEstado}">${estado.nomeEstado}</option>
                    		</c:forEach>
                    </select>
                </div>
            </div>
            <label for="">Descrição</label>
            <textarea class="form-control" rows="3" name="descricao"></textarea>
    
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="criar">Salvar</button>
                    <a href="#" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>