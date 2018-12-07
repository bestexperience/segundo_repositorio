package br.usjt.ads.best.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.ads.best.model.entity.Campeonato;
import br.usjt.ads.best.model.entity.Cidade;
import br.usjt.ads.best.model.entity.Estado;
import br.usjt.ads.best.model.entity.Estatistica;
import br.usjt.ads.best.model.entity.Jogador;
import br.usjt.ads.best.model.entity.JogoEfetivado;
import br.usjt.ads.best.model.entity.Jogos;
import br.usjt.ads.best.model.entity.Juiz;
import br.usjt.ads.best.model.entity.Resultados_definidos;
import br.usjt.ads.best.model.entity.Status;
import br.usjt.ads.best.model.entity.Time;
import br.usjt.ads.best.model.entity.TimeCampeonato;
import br.usjt.ads.best.model.entity.Usuario;
import br.usjt.ads.best.model.service.CampeonatoService;
import br.usjt.ads.best.model.service.CidadeService;
import br.usjt.ads.best.model.service.EstadoService;
import br.usjt.ads.best.model.service.EstatisticaService;
import br.usjt.ads.best.model.service.JogadorService;
import br.usjt.ads.best.model.service.JogoEfetivadoService;
import br.usjt.ads.best.model.service.JogosService;
import br.usjt.ads.best.model.service.JuizService;
import br.usjt.ads.best.model.service.StatusService;
import br.usjt.ads.best.model.service.TimeCampeonatoService;
import br.usjt.ads.best.model.service.TimeService;
import br.usjt.ads.best.model.service.UsuarioService;

/**
 * Servlet implementation class ManterFilmesController
 */
@Controller
public class ManterDadosController{
	private UsuarioService UService;
	private StatusService sService;
	private TimeService tService;
	private CampeonatoService cService;
	private JogadorService jService;
	private JuizService juService;
	private CidadeService cityService;
	private EstadoService estadoService;
	private EstatisticaService estaService;
	private JogosService jogosService;
	private TimeCampeonatoService timeCampeonatoService;
	private JogoEfetivadoService jeService;
	
	public ManterDadosController(){
		UService = new UsuarioService();
		sService = new StatusService();
		tService = new TimeService();
		cService = new CampeonatoService();
		jService = new JogadorService();
		juService = new JuizService();
		cityService = new CidadeService();
		estadoService = new EstadoService();
		estaService = new EstatisticaService();
		jogosService = new JogosService();
		timeCampeonatoService = new TimeCampeonatoService();
		jeService = new JogoEfetivadoService();
		
	}
	
	
	/*Menu inicial*/
	
	@RequestMapping("home")
	public String home(){
		return "index";
	}
	
	@RequestMapping("/")
	public String login1(){
		return "login";
	}
	
	@RequestMapping("login")
	public String login2(){
		return "login";
	}
	
	@RequestMapping("listar_equipes")
	public String listarEquipes(){
		return "listarEquipes";
	}

	
	@RequestMapping("tabela_time_campeonato")
	public String listarTimeCampeonato(Model model, @RequestParam("id") int id){
		try {
			timeCampeonatoService = new TimeCampeonatoService();
			ArrayList<TimeCampeonato> lista;
			lista = timeCampeonatoService.listarTimeCampeonato();
			Campeonato campeonato = new Campeonato();
			cService = new CampeonatoService();
			campeonato = cService.buscarCampeonatoPeloId(id);
			
			model.addAttribute("id", id);
			model.addAttribute("lista", lista);
			model.addAttribute("campeonato", campeonato);
			return "listarTimeCampeonato";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "login";
	}
	
	
	@RequestMapping("novo_usuario")
	public String novoUsuario(){
		return "novoUsuario";
	}
	/*Menu inicial*/

	
	/*Menu Usuario*/
	
	@RequestMapping("usuario_logado")
	public String usuarioLogado(HttpSession session){
		return "usuario";
	}
	

	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
	
	@RequestMapping("esqueci_minha_senha")
	public String esqueciMinhaSenha(){
		return "esqueciMinhaSenha";
	}
	
	@RequestMapping("buscar_email_login")
	public String buscarSenhaENome(Usuario usuario, Model model){
		
		try {
			UService = new UsuarioService();
			usuario = UService.buscarUsuarioPeloEmail(usuario);
			model.addAttribute(usuario);
			if(usuario.getId() != 0)
			{
				return "redefinirSenha";
			}else{
				return "esqueciMinhaSenha";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "esqueciMinhaSenha";
	}
	
	@RequestMapping("atualizar_esqueci_senha")
	public String atualizarEsqueciSenha(HttpSession session, Usuario usuario){
		UService = new UsuarioService();
		UService.atualizarUsuario(usuario);
		return "login";
	}
	
	@RequestMapping("alterar_usuario")
	public String alterarUsuario(Model model, @RequestParam("id") int id){
		
		try {
			Usuario usuario = new Usuario();
			usuario.setId(id);
			UService = new UsuarioService();
			usuario = UService.buscarUsuarioId2(usuario);
			model.addAttribute("usuario", usuario);
			return "alterarUsuario";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	} 
	
	
	@RequestMapping("efetivar_alterar_usuario")
	public String efetivarAlterarUsuario(Model model, Usuario usuario){
		
		try {
			Usuario usuarioAtualizado = new Usuario();
			UService = new UsuarioService();
			UService.atualizarUsuario(usuario);
			usuarioAtualizado = UService.buscarUsuarioId2(usuario);
			model.addAttribute("usuario", usuarioAtualizado);
			return "usuario";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	/*Carregar status, Cadastrar Campeonatos e Listar Campeonatos*/
	
	@RequestMapping("carregar_status")
	public String carregarStatus(HttpSession session){
		
		try {
			/*Carregando o Status*/
			sService = new StatusService();
			
			ArrayList<Status> status;
			
			status = sService.listarStatus();
			session.setAttribute("status", status);
			/**/
			
			return "novoCampeonatoAtual";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@RequestMapping("cadastrar_campeonato")
	public String cadastrarCampeonato(Model model, Campeonato campeonato, Usuario usuario, HttpSession session,
			@RequestParam("pontos1") String idP1,
			@RequestParam("pontos2") String idP2,
			@RequestParam("pontos3") String idP3,
			@RequestParam("pontos4") String idP4
			){
	
		try {
			int idCampeonato;
			
			idCampeonato = cService.inserirCampeonato(campeonato, usuario);
			
			int id10 = 0; 
			int p1 = Integer.parseInt(idP1);
			id10 = sService.inserirPontos(p1, idCampeonato, 1);
			
			int p2 = Integer.parseInt(idP2);
			id10 = sService.inserirPontos(p2, idCampeonato, 2);
			
			int p3 = Integer.parseInt(idP3);
			id10 = sService.inserirPontos(p3, idCampeonato, 3);
			
			int p4 = Integer.parseInt(idP4);
			id10 = sService.inserirPontos(p4, idCampeonato, 4);
			
			cService = new CampeonatoService();
			
			ArrayList<Campeonato> lista;
			lista = cService.listarCampeonatos(campeonato.getNome());
			model.addAttribute("lista", lista);
			
			return "listarCampeonatos";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@RequestMapping("efetivar_atualizacao")
	public String efetivarAtualizacao(HttpSession session, Campeonato campeonato,
			@RequestParam("pontos1") int idP1,
			@RequestParam("pontos2") int idP2,
			@RequestParam("pontos3") int idP3,
			@RequestParam("pontos4") int idP4
			){
		
			cService = new CampeonatoService();
			cService.atualizarCampeonato(campeonato);
			
			sService = new StatusService();
			sService.atualizarResultados(idP1, 1);
			sService.atualizarResultados(idP2, 2);
			sService.atualizarResultados(idP3, 3);
			sService.atualizarResultados(idP4, 4);
			
		
		return "listarCampeonatos";
	}
	
	@RequestMapping("buscar_campeonatos")
	public String buscarCampeonatos(HttpSession session){
		ArrayList<Campeonato> lista = null;
		session.setAttribute("lista", lista);
		return "listarCampeonatos";
	}
	
	@RequestMapping("listar_campeonatos")
	public String listarCampeonatos(Model model, @RequestParam("data[search]") String chave){
			try {
				cService = new CampeonatoService();
				ArrayList<Campeonato> lista;
				
				if (chave != null && chave.length() > 0) {
				lista = cService.listarCampeonatos(chave);
				
				} else {
					lista = cService.listarCampeonatos();
				}
				model.addAttribute("lista", lista);
				return "listarCampeonatos";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "usuario";
	}
	
	@RequestMapping("excluir_campeonato")
	public String excluirCampeonato(Model model, @RequestParam("id") int id, Campeonato campeonato){
		try {
			cService = new CampeonatoService();
			sService = new StatusService();
			ArrayList<Campeonato> lista;
			
			campeonato.setIdCampeonato(id);
			int resultados_definidos = id;
			sService.excluirCampeonato(resultados_definidos);
			cService.excluirCampeonato(campeonato);
			campeonato = cService.buscarCampeonato(campeonato);
			
			String chave = campeonato.getNome();
			
			if (chave != null && chave.length() > 0) {
				lista = cService.listarCampeonatos(chave);
			} else {
				lista = cService.listarCampeonatos();
			}
			model.addAttribute("lista", lista);
			return "listarCampeonatos";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@RequestMapping("atualizar_campeonato")
	public String prepararAtualizarCampeonatos(Model model,  @RequestParam("nome") String chave, Campeonato campeonato){
		/*O efetivar atualização esta la em cima**/
		try {
			//sService = new StatusService();
			cService = new CampeonatoService();
			
			//ArrayList<Status> status;
			ArrayList<Resultados_definidos> resultados;
			
			//status = sService.listarStatus();
			campeonato.setNome(chave);
			campeonato = cService.buscarCampeonato(campeonato);
			resultados = sService.listarResultadosDefinidos(campeonato.getIdCampeonato());
			model.addAttribute("resultados", resultados);
			model.addAttribute("campeonato", campeonato);
			//model.addAttribute("status", status);
			return "alterarCampeonato";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "listarCampeonatos";
	}
	
	
	
	/*Cadastro de Times*/
	@RequestMapping("cadastrar_times")
	public String papararCadastroDeTimes(HttpSession session){
		try {
			Campeonato campeonato;
			ArrayList<Campeonato> lista2;
			cService = new CampeonatoService();
			
			lista2 = cService.listarCampeonatos();
			session.setAttribute("lista2", lista2);
			return "cadastroDeTimesNovo";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@RequestMapping("efetivar_time")
	public String cadastrarTimes(Model model, Time time){
		try {
				tService = new TimeService();
				
				if(time.getCampeonato().getIdCampeonato() == 0)
				{
					tService.inserirTimeNome(time);
					return "listarEquipes";
				}else if(time.getCampeonato().getIdCampeonato() != 0){
					tService.inserirTime(time);
					return "listarEquipes";
			
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	/*Listar Times*/
	@RequestMapping("buscar_times")
	public String listarTimes(HttpSession session){
		ArrayList<Time> lista = null;
		session.setAttribute("lista", lista);
		
		return "listarEquipes";
	}
	
	@RequestMapping("listar_times")
	public String listarTimes(Model model,@RequestParam("data[search]") String chave){
			try {
				tService = new TimeService();
				ArrayList<Time> lista;
				
				if (chave != null && chave.length() > 0) {
				lista = tService.listarTime(chave);
				
				} else {
					lista = tService.listarTime();
				}
				model.addAttribute("lista", lista);
				return "listarEquipes";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "usuario";
	}
	
	@RequestMapping("visualizar_time")
	public String visualizarTime(Model model, @RequestParam("id") int chave){
		
		try {
			Time time = new Time();
			Jogador jogador = new Jogador();
			ArrayList<Jogador> lista;
			tService = new TimeService();
			jService = new JogadorService();
			
			lista = jService.buscarJogadorPeloTime(chave);
			
			
			time = tService.buscarTime(chave);
			
			model.addAttribute("lista", lista);
			model.addAttribute("time", time);
			return "visualizarTime";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@RequestMapping("atualizar_time")
	public String editarTime(Model model, @RequestParam("id") int id){
		
		try {
			tService = new TimeService();
			Time time = new Time();
			time = tService.buscarTime(id);
			model.addAttribute("time", time);
			return "alterarTime";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "usuario";
	}
	
	@RequestMapping("efetivar_time_atualizacao")
	public String efetivarAlteracaoTime(HttpSession session, Time time){
		tService = new TimeService();
		tService.atualizarTime(time);
		
		return "listarEquipes";
	}
	
	@RequestMapping("excluir_time")
	public String excluirTime(HttpSession session, @RequestParam("id") int id){
		tService = new TimeService();
		Time time = new Time();
		time.setIdTime(id);
		tService.excluirTime(time);
		
		return "listarEquipes";
	}
	
	/*END TIME*/
	
	
	
	/*Jogadores*/
	@RequestMapping("buscar_jogador")
	public String buscarJogador(HttpSession session){
		ArrayList<Jogador> lista = null;
		session.setAttribute("lista", lista);
		return "listarJogadores";
	}
	
	@RequestMapping("listar_jogadores")
	public String listarJogadores(Model model,@RequestParam("data[search]") String chave){
			try {
				jService = new JogadorService();
				ArrayList<Jogador> lista;
				
				if (chave != null && chave.length() > 0) {
				lista = jService.listarJogador(chave);
				
				} else {
					lista = jService.listarJogador();
				}
				model.addAttribute("lista", lista);
				return "listarJogadores";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "usuario";
	}
	
	@RequestMapping("novo_jogador")
	public String novoJogador(HttpSession session){
		
		try {
			ArrayList<Time> lista;
			tService = new TimeService();
			lista = tService.listarTimeECampeonato();
			
			session.setAttribute("lista", lista);
			return "novoJogador";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "novoJogador";
	}
	
	@RequestMapping("cadastrar_jogador")
	public String cadastrarJogador(HttpSession session, Jogador jogador){
		try {
			jService = new JogadorService();
			
			
			if(jogador.getTime().getIdTime() == 0)
			{
				jService.inserirJogador(jogador);
			}
			else{
				jService.inserirJogadorETime(jogador);
			}
			
			
			ArrayList<Jogador> lista = new ArrayList<>();
			
			session.setAttribute("lista", lista);
			return "listarJogadores";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return "usuario";
	}
	
	@RequestMapping("alterar_jogador")
	public String alterarJogador(@RequestParam("chave") String chave, Model model){
		try {
			jService = new JogadorService();
			ArrayList<Jogador> jogador = new ArrayList<>();
			jogador = jService.listarJogador(chave);
			model.addAttribute("jogador", jogador);
			return "alterarJogador";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@RequestMapping("alterar_efetivar")
	public String alterarEfetivarJogador(Model model, Jogador jogador){
		
		try {
			ArrayList<Jogador> lista = new ArrayList<>();
			jService = new JogadorService();
			jService.atualizar(jogador);
			
			lista = jService.listarJogador();
			
			model.addAttribute("lista", lista);
			return "listarJogadores";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@RequestMapping("excluir_jogador")
	public String excluirJogador(Model model, @RequestParam("id") int id, Jogador jogador){
		try {
			ArrayList<Jogador> lista = new ArrayList<>();
			jService = new JogadorService();
			jogador.setIdJogador(id);
			jService.excluirJogador(jogador);

			lista = jService.listarJogador();
			model.addAttribute("lista", lista);
			return "listarJogadores";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@RequestMapping("visualizar_jogador")
	public String visualizarJogador(@RequestParam("chave") String chave, Model model){
		try {
			jService = new JogadorService();
			ArrayList<Jogador> lista = new ArrayList<>();
			lista = jService.listarJogador(chave);
			model.addAttribute("lista", lista);
			return "visualizarJogador";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	
	@RequestMapping("inserir_jogo")
	public String preparaInserirJogo(HttpSession session, @RequestParam("id") int chave){
		try {
			
			cService = new CampeonatoService();
			Campeonato campeonato = new Campeonato();
			campeonato = cService.buscarCampeonatoPeloId(chave);
			
			ArrayList<Time> lista = new ArrayList<>();
			
			lista = tService.listarTime(chave);
			
			session.setAttribute("campeonato", campeonato);
			session.setAttribute("lista", lista);
			
			return "definindoJogos";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@RequestMapping("efetivar_inserir_jogo")
	public String inserirJogo(HttpSession session, JogoEfetivado jogo){
		try {
			tService = new TimeService();
			Time timeMandante = new Time();
			Time timeVisitante = new Time();
			jeService = new JogoEfetivadoService();
			jeService.inserirJogo(jogo);
			TimeCampeonato tCampeonatoMandante = new TimeCampeonato();
			TimeCampeonato tCampeonatoVisitante = new TimeCampeonato();
			
			TimeCampeonato tCampeonatoMandantePos = new TimeCampeonato();
			TimeCampeonato tCampeonatoVisitantePos = new TimeCampeonato();
			
			timeCampeonatoService = new TimeCampeonatoService();
			
			timeMandante = tService.buscarTime(jogo.getTime_mandante().getIdTime());
			timeVisitante = tService.buscarTime(jogo.getTime_visitante().getIdTime());
			
			tCampeonatoMandante = timeCampeonatoService.buscarTimeCampeonato(timeMandante.getIdTime());
			tCampeonatoVisitante = timeCampeonatoService.buscarTimeCampeonato(timeVisitante.getIdTime());
			
			if(tCampeonatoMandante != null)
			{
				tCampeonatoMandantePos.setTime(timeMandante);
				if(jogo.getPlacar_mandante() > jogo.getPlacar_visitante())
				{
					tCampeonatoMandantePos.setPontos(tCampeonatoMandante.getPontos() + 3);
					tCampeonatoMandantePos.setVitorias(tCampeonatoMandante.getVitorias() + 1);
				}else{
					tCampeonatoMandantePos.setPontos(tCampeonatoMandante.getPontos() + 0);
					tCampeonatoMandantePos.setVitorias(tCampeonatoMandante.getVitorias() + 0);
				}
				tCampeonatoMandantePos.setJogos(tCampeonatoMandante.getJogos() + 1);
				
				if(jogo.getPlacar_mandante() == jogo.getPlacar_visitante())
				{
					tCampeonatoMandantePos.setEmpates(tCampeonatoMandante.getEmpates() + 1);
				}
				if(jogo.getPlacar_mandante() < jogo.getPlacar_visitante())
				{
					tCampeonatoMandantePos.setDerrotas(tCampeonatoMandante.getDerrotas() + 1);
				}else{
					tCampeonatoMandantePos.setDerrotas(tCampeonatoMandante.getDerrotas() + 0);
				}
				
				if(jogo.getPlacar_mandante() != 0)
				{
					tCampeonatoMandantePos.setGols_marcados(tCampeonatoMandante.getGols_marcados() + jogo.getPlacar_mandante());
				}else{
					tCampeonatoMandantePos.setGols_marcados(tCampeonatoMandante.getGols_marcados() + 0);
				}
				
				if(jogo.getPlacar_visitante() > 0)
				{
					tCampeonatoMandantePos.setGols_sofridos(tCampeonatoMandante.getGols_sofridos() + jogo.getPlacar_visitante());
				}else{
					tCampeonatoMandantePos.setGols_sofridos(tCampeonatoMandante.getGols_sofridos() + 0);
				}
				
				tCampeonatoMandantePos.setSaldo_de_gols(tCampeonatoMandante.getSaldo_de_gols() + jogo.getPlacar_mandante());
	
				timeCampeonatoService.atualizarTimeCampeonato(tCampeonatoMandantePos);
			}
			
			if(tCampeonatoMandante == null){
				tCampeonatoMandantePos.setTime(timeMandante);
				if(jogo.getPlacar_mandante() > jogo.getPlacar_visitante())
				{
					tCampeonatoMandantePos.setPontos(3);
					tCampeonatoMandantePos.setVitorias(1);
				}else{
					tCampeonatoMandantePos.setPontos(0);
					tCampeonatoMandantePos.setVitorias(0);
				}
				tCampeonatoMandantePos.setJogos(1);
				
				if(jogo.getPlacar_mandante() == jogo.getPlacar_visitante())
				{
					tCampeonatoMandantePos.setEmpates(1);
				}
				if(jogo.getPlacar_mandante() < jogo.getPlacar_visitante())
				{
					tCampeonatoMandantePos.setDerrotas(1);
				}else{
					tCampeonatoMandantePos.setDerrotas(0);
				}
				
				if(jogo.getPlacar_mandante() != 0)
				{
					tCampeonatoMandantePos.setGols_marcados(jogo.getPlacar_mandante());
				}else{
					tCampeonatoMandantePos.setGols_marcados(0);
				}
				
				if(jogo.getPlacar_visitante() > 0)
				{
					tCampeonatoMandantePos.setGols_sofridos(jogo.getPlacar_visitante());
				}else{
					tCampeonatoMandantePos.setGols_sofridos(0);
				}
				
				tCampeonatoMandantePos.setSaldo_de_gols(jogo.getPlacar_mandante());
				
				timeCampeonatoService.inserirTimeCampeonato(tCampeonatoMandantePos);
			}
			
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			if(tCampeonatoVisitante != null)
			{
				tCampeonatoVisitantePos.setTime(timeVisitante);
				if( jogo.getPlacar_visitante()  > jogo.getPlacar_mandante())
				{
					tCampeonatoVisitantePos.setPontos(tCampeonatoVisitante.getPontos() + 3);
					tCampeonatoVisitantePos.setVitorias(tCampeonatoVisitante.getVitorias() + 1);
				}else{
					tCampeonatoVisitantePos.setPontos(tCampeonatoVisitante.getPontos() + 0);
					tCampeonatoVisitantePos.setVitorias(tCampeonatoVisitante.getVitorias() + 0);
				}
				tCampeonatoVisitantePos.setJogos(tCampeonatoVisitante.getJogos() + 1);
				
				if(jogo.getPlacar_mandante() == jogo.getPlacar_visitante())
				{
					tCampeonatoVisitantePos.setEmpates(tCampeonatoVisitante.getEmpates() + 1);
				}
				if(jogo.getPlacar_visitante() < jogo.getPlacar_mandante())
				{
					tCampeonatoVisitantePos.setDerrotas(tCampeonatoVisitante.getDerrotas() + 1);
				}else{
					tCampeonatoVisitantePos.setDerrotas(tCampeonatoVisitante.getDerrotas() + 0);
				}
				
				if(jogo.getPlacar_visitante() != 0)
				{
					tCampeonatoVisitantePos.setGols_marcados(tCampeonatoVisitante.getGols_marcados() + jogo.getPlacar_visitante());
				}else{
					tCampeonatoVisitantePos.setGols_marcados(tCampeonatoVisitante.getGols_marcados() + 0);
				}
				
				if(jogo.getPlacar_mandante() > 0)
				{
					tCampeonatoVisitantePos.setGols_sofridos(tCampeonatoVisitante.getGols_sofridos() + jogo.getPlacar_mandante());
				}else{
					tCampeonatoVisitantePos.setGols_sofridos(tCampeonatoVisitante.getGols_sofridos() + 0);
				}
				
				tCampeonatoVisitantePos.setSaldo_de_gols(tCampeonatoVisitante.getSaldo_de_gols() + jogo.getPlacar_visitante());
	
				timeCampeonatoService.atualizarTimeCampeonato(tCampeonatoVisitantePos);
			}
			
			if(tCampeonatoMandante == null){
				tCampeonatoVisitantePos.setTime(timeVisitante);
				if(jogo.getPlacar_visitante() > jogo.getPlacar_mandante())
				{
					tCampeonatoVisitantePos.setPontos(3);
					tCampeonatoVisitantePos.setVitorias(1);
				}else{
					tCampeonatoVisitantePos.setPontos(0);
					tCampeonatoVisitantePos.setVitorias(0);
				}
				tCampeonatoVisitantePos.setJogos(1);
				
				if(jogo.getPlacar_mandante() == jogo.getPlacar_visitante())
				{
					tCampeonatoVisitantePos.setEmpates(1);
				}
				if(jogo.getPlacar_visitante() < jogo.getPlacar_mandante())
				{
					tCampeonatoVisitantePos.setDerrotas(1);
				}else{
					tCampeonatoVisitantePos.setDerrotas(0);
				}
				
				if(jogo.getPlacar_visitante() != 0)
				{
					tCampeonatoVisitantePos.setGols_marcados(jogo.getPlacar_visitante());
				}else{
					tCampeonatoVisitantePos.setGols_marcados(0);
				}
				
				if(jogo.getPlacar_mandante() > 0)
				{
					tCampeonatoVisitantePos.setGols_sofridos(jogo.getPlacar_mandante());
				}else{
					tCampeonatoVisitantePos.setGols_sofridos(0);
				}
				
				tCampeonatoVisitantePos.setSaldo_de_gols(jogo.getPlacar_visitante());
				
				timeCampeonatoService.inserirTimeCampeonato(tCampeonatoVisitantePos);
			}
			
			if(jogo.getPlacar_mandante() > 0 || jogo.getPlacar_visitante() > 0)
			{
				int quantidade = jogo.getPlacar_mandante() + jogo.getPlacar_visitante();
				
				int idMandante = jogo.getTime_mandante().getIdTime();
				int idVisitante = jogo.getTime_visitante().getIdTime();
				
				////////////////////////////////////////////////////////////
				jService = new JogadorService();
				
				ArrayList<Jogador> listaMandante;
				ArrayList<Jogador> listaVisitante;
				listaMandante = jService.buscarJogadorPeloTime(idMandante);
				listaVisitante = jService.buscarJogadorPeloTime(idVisitante);
				
				if(jogo.getPlacar_mandante() > 0)
				{	
					session.setAttribute("listaMandante", listaMandante);
				}
				if(jogo.getPlacar_visitante() > 0)
				{
					session.setAttribute("listaVisitante", listaVisitante);
				}
				
				session.setAttribute("quantidade", quantidade);
				
				return "golsPorJogador";
			}
			
			
			
			
			
			return "usuario";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	

	@RequestMapping("atualizar_quantidade_gols_jogador")
	public String atualizarQuantidadeDeGols(HttpSession session, Jogador jogador, @RequestParam("quantidade") int quantidade){
		
		try {
			jService = new JogadorService();
			Jogador jogador2 = new Jogador();
			
			jogador2 = jService.buscarJogador(jogador.getIdJogador());
			
			jogador2.setGols(jogador.getGols());
			jService.atualizarGolsJogador(jogador2);
			
			if(quantidade > 0)
			{
				quantidade =  quantidade - jogador.getGols();
				if(quantidade > 0)
				{
					session.setAttribute("quantidade", quantidade);
					return "golsPorJogador";
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "usuario";
		
	}
	
	
	
	
	/*Juizes*/

	@RequestMapping("buscar_juizes")
	public String buscarJuiz(HttpSession session){
		ArrayList<Juiz> lista = null;
		session.setAttribute("lista", lista);
		return "listarJuizes";
	}
	
	@RequestMapping("listar_juizes")
	public String listarJuizes(Model model, @RequestParam("data[search]") String chave){
			try {
				juService = new JuizService();
				ArrayList<Juiz> lista;
				if (chave != null && chave.length() > 0) {
					lista = juService.listarJuiz(chave);
				}else{
					lista = juService.listarJuiz();
				}
				model.addAttribute("lista", lista);
				return "listarJuizes";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "usuario";
	}
	
	@RequestMapping("novo_juiz")
	public String novoJuiz(HttpSession session, Model model){
		try {
			cityService = new CidadeService();
			estadoService = new EstadoService();
			ArrayList<Cidade> cidades;
			ArrayList<Estado> estados;
			
			estados = estadoService.listarEstados();
			cidades = cityService.listarCidades();
			
			session.setAttribute("cidades", cidades);
			session.setAttribute("estados", estados);
			return "novoJuiz";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "usuario";
	}
	
	@RequestMapping("cadastrar_juiz")
	public String cadastrarJuiz(HttpSession session, Juiz juiz){
		try {
			cityService = new CidadeService();
			estadoService = new EstadoService();
			juService = new JuizService();
			
			Estado estado;
			estado = estadoService.buscarCidade(juiz.getEstado().getIdEstado());
			juiz.setEstado(estado);
			Cidade cidade;
			cidade = cityService.buscarCidade(juiz.getCidade().getIdCidade());
			juiz.setCidade(cidade);
			
			int idJuiz = juService.inserirJuiz(juiz);
			
			return "listarJuizes";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "usuario";
	}
	
	@RequestMapping("visualizar_juiz")
	public String visualizarJuiz(Model model, @RequestParam("nome") String chave){
		try {
			juService = new JuizService();
			ArrayList<Juiz> lista;
			lista = juService.listarJuiz(chave);
			model.addAttribute("lista", lista);
			return "visualizarJuiz";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@RequestMapping("editar_juiz")
	public String editarJuiz(Model model, @RequestParam("id") int id){
		try {
			juService = new JuizService();
			cityService = new CidadeService();
			estadoService = new EstadoService();
			Juiz juiz = new Juiz();
			
			ArrayList<Cidade> cidades;
			ArrayList<Estado> estados;
			
			estados = estadoService.listarEstados();
			cidades = cityService.listarCidades();
			
			juiz = juService.buscarJuiz(id);
			
			model.addAttribute("cidades", cidades);
			model.addAttribute("estados", estados);
			model.addAttribute("juiz", juiz);
			return "alterarJuiz";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@RequestMapping("confirmar_editar_juiz")
	public String confirmarEditarJuiz(Model model, Juiz juiz){
		try {
			juService = new JuizService();
			cityService = new CidadeService();
			estadoService = new EstadoService();
			
			Estado estado;
			estado = estadoService.buscarCidade(juiz.getEstado().getIdEstado());
			juiz.setEstado(estado);
			Cidade cidade;
			cidade = cityService.buscarCidade(juiz.getCidade().getIdCidade());
			juiz.setCidade(cidade);
			
			juService.atualizarJuiz(juiz);
			
			//model.addAttribute("lista", lista);
			ArrayList<Juiz> lista;
			lista = juService.listarJuiz(juiz.getNomeJuiz());
			model.addAttribute("lista", lista);
			
			return "visualizarJuiz";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@RequestMapping("excluir_juiz")
	public String excluirJuiz(Model model, @RequestParam("id") int id) throws IOException{
		juService = new JuizService();
		Juiz juiz = new Juiz();
		juiz.setIdJuiz(id);
		juService.excluirJuiz(juiz);
		return "listarJuizes";
	}
	
	
	/*Menu Usuario*/
	
	@RequestMapping("fazer_login")
	public String logar(Usuario usuario, HttpSession session){
		
		try {
			UService = new UsuarioService();
			Usuario usuAutenticado;
			
			usuAutenticado = UService.consultarLogin(usuario);
			
			if(usuAutenticado != null)
			{
				usuario = UService.buscarUsuarioId(usuario);
				
				session.setAttribute("usuario", usuario);
				return "usuario";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "errorLogin";
	}
	
	@RequestMapping("efetuar_cadastro")
	public String cadastrarUsuario(Usuario usuario, HttpSession session){
		
		try {
			UService = new UsuarioService();
			int id1 = UService.inserirUsuario(usuario);
			
			Usuario usuAutenticado;
			usuAutenticado = UService.consultarLogin(usuario);
			
			if(usuAutenticado != null)
			{
				/*HttpSession sessao = request.getSession();
				sessao.setAttribute("uauAutenticado", validacao);*/
				usuario = UService.buscarUsuarioId(usuario);
				
				session.setAttribute("usuario", usuario);
				return "usuario";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "errorLogin";
	}
	
	

	@RequestMapping("turno_rodadas")
	public String turnoRodadas(Model model, @RequestParam("id") int id) throws IOException{
		try {
			
			JogoEfetivado jf = new JogoEfetivado();
			jeService = new JogoEfetivadoService();
			ArrayList<JogoEfetivado> lista;
			
			
			
			lista = jeService.listarJogosEfetivado(id);
			jf = lista.get(lista.size()-1);
			int contador = jf.getTurno();
			model.addAttribute("contador", contador);
			model.addAttribute("lista", lista);
			
			return "turnoRodadas";
			
		} catch (IOException e) {
			return "index";
			// TODO Auto-generated catch block
		}
	}
	
	@RequestMapping("listar_times_visitante")
	public String listarTimesVisitante(Model model, @RequestParam("id") int id){
		try {
			
			tService = new TimeService();
			Time time = new Time();
			ArrayList<Time> lista = new ArrayList<>();
			lista = tService.listarTime(id);
			Campeonato c = new Campeonato();
			cService = new CampeonatoService();
			c = cService.buscarCampeonatoId(id);
			
			model.addAttribute("campeonato", c);
			model.addAttribute("lista", lista);
			
			return "listarTimesVisitante";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "turnoRodadas";
	}
	
	@RequestMapping("listar_juizes_visitante")
	public String listarJuizesVisitante(Model model){
		try {
			
			ArrayList<Juiz> lista = new ArrayList<>();
			juService = new JuizService();
			lista = juService.listarJuiz();
			
			model.addAttribute("lista", lista);
			
			return "listarJuizVisitante";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "turnoRodadas";
	}
	
	@RequestMapping("listar_jogadores_visitante")
	public String listarJogadoresVisitante(Model model){
		try {
			
			ArrayList<Jogador> lista = new ArrayList<>();
			jService = new JogadorService();
			lista = jService.listarJogadorETime();
			
			model.addAttribute("lista", lista);
			
			return "listarJogadoresVisitante";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "turnoRodadas";
	}
	
	@RequestMapping("listar_jogos_efetivado_excluir")
	public String listar_jogos_efetivado_excluir(Model model){
		
		try {
			JogoEfetivado jf = new JogoEfetivado();
			jeService = new JogoEfetivadoService();
			ArrayList<JogoEfetivado> lista;
			ArrayList<JogoEfetivado> lista2;
			
			int id = 1;
			
			lista = jeService.listarJogosEfetivado(id);
			
			
			int id2 = 2;
			lista2 = jeService.listarJogosEfetivado(id2);
			
			jf = lista.get(lista.size()-1);
			int contador = jf.getTurno();
			
			model.addAttribute("contador", contador);
			model.addAttribute("lista", lista);
			model.addAttribute("lista2", lista2);
			
			return "listarJogosEfetivadosExcluir";
		} catch (IOException e) {
			return "usuario";
		}
		
	}
	
	@RequestMapping("listar_jogos_efetivado_excluir_efetivar")
	public String listar_jogos_efetivado_excluir_efetivar(Model model, @RequestParam("id") int id0){
		
			jeService = new JogoEfetivadoService();
			jeService.excluirJogo(id0);
			
			
			return "usuario";

	
	
	
}
}
