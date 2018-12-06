<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav id="navstyle" class="navbar navbar-inverse">
	<!--Cor do menu será preta-->
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="#">Home</a></li>
				<li><a href="listar_times_visitante">Equipes</a></li>
				<li><a href="tabela_time_campeonato">Classificação</a></li>
				<li class="dropdown"><a class="dropdown-toggle"	data-toggle="dropdown" href="#">Turnos<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="turno_rodadas?id=1">Master</a></li>
						<li><a href="turno_rodadas?id=2">Senior</a></li>
					</ul></li>
				
				<!-- <li><a href="comissao_executiva">Comissão Executiva</a></li> -->
				<li><a href="#">Seções</a></li>
				<li><a href="#">Anos Anteriores</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="novo_usuario"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</div>
</nav>
