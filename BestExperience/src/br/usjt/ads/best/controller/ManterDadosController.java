package br.usjt.ads.best.controller;

import java.io.IOException;
import java.util.ArrayList;

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
import br.usjt.ads.best.model.entity.Jogos;
import br.usjt.ads.best.model.entity.Juiz;
import br.usjt.ads.best.model.entity.Resultados_definidos;
import br.usjt.ads.best.model.entity.Status;
import br.usjt.ads.best.model.entity.Time;
import br.usjt.ads.best.model.entity.Usuario;
import br.usjt.ads.best.model.service.CampeonatoService;
import br.usjt.ads.best.model.service.CidadeService;
import br.usjt.ads.best.model.service.EstadoService;
import br.usjt.ads.best.model.service.EstatisticaService;
import br.usjt.ads.best.model.service.JogadorService;
import br.usjt.ads.best.model.service.JogosService;
import br.usjt.ads.best.model.service.JuizService;
import br.usjt.ads.best.model.service.StatusService;
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
		
	}
	
	
	/*Menu inicial*/
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
	
	
	@RequestMapping("listar_times_visitante")
	public String listarTimesVisitante(Model model){
		
		try {
			tService = new TimeService();
			ArrayList<Time> lista;
			lista = tService.listarTime();
			model.addAttribute("lista", lista);
			return "listarTimesVisitante";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "listarTimesVisitante";
	}
	
	@RequestMapping("listar_campeonatos_tabela")
	public String listar_resultados(Model model){
		
		try {
			ArrayList<Campeonato> lista;
			cService = new CampeonatoService();
			lista = cService.listarCampeonatos();
			model.addAttribute("lista", lista);
			return "listarCampeonatosTabela";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "listarCampeonatosTabela";
	}
	///////////////////////////////////////////////

	@RequestMapping("listar_resultados_1")
	public String listarResultados(Model model, @RequestParam("id") int id){

		try {
			Campeonato campeonato = new Campeonato();
			campeonato.setIdCampeonato(id);
			estaService = new EstatisticaService();
			Estatistica estatistica = new Estatistica();
			ArrayList<Estatistica> lista;
			lista = estaService.listarEstatistica(id);
			
			model.addAttribute("campeonato", campeonato);
			model.addAttribute("lista", lista);
			return "inserirResultados";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "inserirResultados";
	}
	
	@RequestMapping("atualizar_estatistica")
	public String inserirResultados(Model model, @RequestParam("id") int id){

		try {
			estaService = new EstatisticaService();
			Estatistica estatistica = new Estatistica();
			estatistica = estaService.listarEstatistica2(id);
			
			model.addAttribute("estatistica", estatistica);
			return "alterarEstatistica";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "alterarEstatistica";
	}
	
	
	@RequestMapping("dados_campeonato")
	public String dadosDoCampeonato(Model model){
		
		try {
			Estatistica estatistica = new Estatistica();
			ArrayList<Estatistica> lista1;
			
			estaService = new EstatisticaService();
			
			lista1 = estaService.listarEstatistica();
			
			model.addAttribute("lista", lista1);
			return "dadosDoCampeonato";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "dadosDoCampeonato";
	}
	
	@RequestMapping("turno_rodadas")
	public String turnoRodadas(){
		return "turnoRodadas";
	}
	
	@RequestMapping("comissao_executiva")
	public String comissaoExecutiva(){
		return "comissaoExecutiva";
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
		return "cadastroDeTimesNovo";
	}
	
	@RequestMapping("efetivar_time")
	public String cadastrarTimes(HttpSession session){
		return "cadastroDeTimesNovo";
	}
	
	/*Listar Times*/
	@RequestMapping("buscar_times")
	public String listarTimes(HttpSession session){
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
	public String visualizarTime(Model model, @RequestParam("nome") String chave){
		
		try {
			tService = new TimeService();
			ArrayList<Time> lista;
			lista = tService.listarTime(chave);
			model.addAttribute("lista", lista);
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
		return "novoJogador";
	}
	
	@RequestMapping("cadastrar_jogador")
	public String cadastrarJogador(HttpSession session, Jogador jogador){
		try {
			jService = new JogadorService();
			jService.inserirJogador(jogador);
			
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
	
	
	
	/*Juizes*/

	@RequestMapping("buscar_juizes")
	public String buscarJuiz(HttpSession session){
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
	
	
	
	@RequestMapping("/gerar_turnos")
	public String gerarTurnos(HttpSession session, @RequestParam("nome") String nome, Campeonato campeonato){
		try {
			cService = new CampeonatoService();
			campeonato.setNome(nome);
			campeonato = cService.buscarCampeonato(campeonato);
			session.setAttribute("campeonato", campeonato);
			return "gerarTurnos";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "errorLogin";
		
	}
	
	@RequestMapping("efetivar_gerar_turnos")
	public String efetivarGerarTurnos(HttpSession session, Campeonato campeonato, @RequestParam("nome") String nome) throws IOException{
		Time time = new Time();
		Jogos jogos = new Jogos();
		Estatistica esta = new Estatistica();
		ArrayList<Time> lista;
		
		tService = new TimeService();
		cService = new CampeonatoService();
		estaService = new EstatisticaService();
		jogosService = new JogosService();
		
		campeonato = cService.buscarCampeonato(campeonato);
		jogos.setCampeonato(campeonato);
		lista = tService.listarTime();
		int id1 = 0;
		int id2 = 0;
		for(int iRodadas=0; iRodadas < campeonato.getNumeroRodadas(); iRodadas++)
		{
			for(Time t : lista){
				if(id2 == 0)
				{
					id1 = jogosService.inserirJogos(jogos);
				}
				
				if(id2 == 2)
				{
					id2 = 0; 
					id1 = jogosService.inserirJogos(jogos);
				}
				//int idTime = t.getIdTime();
				//tService.buscarTime(idTime);
				jogos.setIdJogos(id1);
				esta.setJogos(jogos);
				esta.setTime(t);
				estaService.inserirEstatistica(esta);
				id2++;
			}
		}
		
		return "gerarTurnos";
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
	
	
	/*Código incompleto*/
	@RequestMapping("gerando_turnos")
	public String gerandoTurnos(Usuario usuario, HttpSession session){
			try {
				/*pegando os times*/
				tService = new TimeService();
				ArrayList<Time> lista;
				lista = tService.listarTime();

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		return "errorLogin";
	}
	
	
}
