package br.usjt.ads.best.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.ads.best.model.entity.Campeonato;
import br.usjt.ads.best.model.entity.Status;
import br.usjt.ads.best.model.entity.Time;
import br.usjt.ads.best.model.entity.Usuario;
import br.usjt.ads.best.model.service.CampeonatoService;
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
	
	public ManterDadosController(){
		UService = new UsuarioService();
		sService = new StatusService();
		tService = new TimeService();
		cService = new CampeonatoService();
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
	
	@RequestMapping("dados_campeonato")
	public String dadosDoCampeonato(){
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
	
	@RequestMapping("cadastrar_times")
	public String papararCadastroDeTimes(HttpSession session){
		
		return "cadastroDeTimesNovo";
	}
	
	@RequestMapping("efetivar_time")
	public String cadastrarTimes(HttpSession session){
		
		return "cadastroDeTimesNovo";
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
	
	
}
