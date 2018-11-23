<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Alterar Juiz</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- <link href="css/style.css" rel="stylesheet"> -->
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
	<c:import url="MenuUsuario.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Alterar Juiz</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="_juiz" method="post">
            <!-- area de campos do form -->
            <div class="row">
            	<div class="form-group col-md-8">
	                    <label for="nome">Nome</label>
	                    <input type="text" class="form-control" name="nomeJuiz" id="nome" required maxlength="100" placeholder="nome do juiz" value="${juiz.nomeJuiz}">
	            </div>
	            <div class="form-group col-md-4">
	                    <label for="dataNascimento">Data de Nascimento</label>
	                    <input type="text" class="form-control" name="data_nascimento" id="dataNascimento" placeholder="formato dd/mm/yyyy" value="<fmt:formatDate value="${juiz.data_nascimento}" pattern="dd/MM/yyyy"/>">
	            </div>
	     
            </div>
            <div class="row">
            	<div class="form-group col-md-6">
                    <label for="cidade">Cidade</label>
                    <select class="form-control" name="cidade.idCidade" id="cidade">
          
                    		<c:forEach var="cidade" items="${cidades}">
                    		<c:if test="${juiz.cidade.nomeCidade != cidade.nomeCidade}">
                    			<option value="${cidade.idCidade}">${cidade.nomeCidade}</option>
                    		</c:if>
                    		<c:if test="${juiz.cidade.nomeCidade == cidade.nomeCidade}">
                    			<option value="${cidade.idCidade}" selected>${cidade.nomeCidade}</option>
                    		</c:if>
                    		</c:forEach>
                    </select>
                </div>

                <div class="form-group col-md-6">
                    <label for="estado">Estado</label>
                    <select class="form-control" name="estado.idEstado" id="estado">
                    		<c:forEach var="estado" items="${estados}">
                    		<c:if test="${juiz.estado.nomeEstado != estado.nomeEstado}">
                    		<option value="${estado.idEstado}">${estado.nomeEstado}</option>
                    		</c:if>
                    		<c:if test="${juiz.estado.nomeEstado == estado.nomeEstado}">
                    		<option value="${estado.idEstado}" selected>${estado.nomeEstado}</option>
                    		</c:if>
                    		</c:forEach>
                    </select>
                </div>
            </div>
            <label for="">Descrição</label>
            <textarea class="form-control" rows="3" name="descricao">${juiz.descricao}</textarea>
    
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