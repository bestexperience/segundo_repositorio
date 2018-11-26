<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- - 
<div id="mySidenav" class="sidenav">
      <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
      <a href="#">Perfil</a>
      <a href="#" class="valor">Novo Campeonato</a>
      <a href="#">Campeonatos</a>
      <a href="#">Inserir Resultados</a>
    </div>
    -->
<nav id="navstyle" class="navbar navbar-inverse">
	<!--Cor do menu será preta-->
	<div class="container-fluid">
		<div class="navbar-header">
			<span class="span-no-display">${usuario.id}</span>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="usuario_logado">Perfil</a></li>
				<li><a href="listar_campeonatos_tabela">Campeonatos</a></li>
				
				<li class="dropdown"><a class="dropdown-toggle"	data-toggle="dropdown" href="#">Listagem de Dados<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="buscar_campeonatos">Campeonatos</a></li>
						<li><a href="buscar_times">Times</a></li>
						<li><a href="buscar_jogador">Jogadores</a></li>
						<li><a href="buscar_juizes">Juizes</a></li>
						<li><a href="buscar_estadios">Estadios</a></li>
					</ul></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logout"><span
						class="glyphicon glyphicon-log-out"></span> Sair</a></li>
			</ul>
		</div>
	</div>
</nav>
