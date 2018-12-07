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
				<li><a href="home">Home</a></li>
				<li><a href="listar_juizes_visitante">Juizes</a></li>
				<li><a href="listar_jogadores_visitante">Jogadores</a></li>
				<li class="dropdown"><a class="dropdown-toggle"	data-toggle="dropdown" href="#">Equipes<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="listar_times_visitante?id=1">Master</a></li>
						<li><a href="listar_times_visitante?id=2">Senior</a></li>
					</ul></li>
				
				
				<li class="dropdown"><a class="dropdown-toggle"	data-toggle="dropdown" href="#">Classificação<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="tabela_time_campeonato?id=1">Master</a></li>
						<li><a href="tabela_time_campeonato?id=2">Senior</a></li>
					</ul></li>
				
				<li class="dropdown"><a class="dropdown-toggle"	data-toggle="dropdown" href="#">Turnos<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="turno_rodadas?id=1">Master</a></li>
						<li><a href="turno_rodadas?id=2">Senior</a></li>
					</ul></li>
				
				<!-- <li><a href="comissao_executiva">Comissão Executiva</a></li> -->
				<li><a href="#">Seções</a></li>
				
				<li class="dropdown"><a class="dropdown-toggle"	data-toggle="dropdown" href="#">Anos Anteriores<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="http://www.futeboldospais.com.br/campeonato2018/index.php">9 - 2018</a></li>
						<li><a href="http://www.futeboldospais.com.br/campeonato2017/main.php">8 - 2017</a></li>
						<li><a href="http://www.futeboldospais.com.br/campeonato2016/main.php">7 - 2016</a></li>
						<li><a href="http://www.futeboldospais.com.br/campeonato2015/main.php">6 - 2015</a></li>
						<li><a href="http://www.futeboldospais.com.br/campeonato2014/main.php">5 - 2014</a></li>
						<li><a href="http://www.futeboldospais.com.br/campeonato2013/main.php">4 - 2013</a></li>
						<li><a href="http://www.futeboldospais.com.br/campeonato2012/main.php">3 - 2012</a></li>
						<li><a href="http://www.futeboldospais.com.br/campeonato2011/main.php">2 - 2011</a></li>
						<li><a href="http://www.futeboldospais.com.br/campeonato2010/main.php">1 - 2010</a></li>
						
					</ul></li>
				
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
