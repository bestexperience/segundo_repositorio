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
import org.springframework.web.bind.annotation.RequestMapping;

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

	
}
