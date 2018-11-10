package br.usjt.ads.best.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object ManterDadosController) throws Exception {
		
		String uri = request.getRequestURI();
        if(uri.endsWith("/") || 
                uri.endsWith("login") || 
                uri.endsWith("listar_equipes") || 
                uri.endsWith("dados_campeonato") || 
                uri.endsWith("turno_rodadas") || 
                uri.endsWith("comissao_executiva") || 
                uri.endsWith("novo_usuario") || 
                uri.endsWith("fazer_login") || 
                uri.endsWith("efetuar_cadastro") || 
                
                        uri.contains("css/bootstrap-tagsinput.css")||
                        uri.contains("css/bootstrap.css")||
                        uri.contains("css/bootstrap.min.css")||
                        uri.contains("css/form-style.css")||
                        uri.contains("css/style.css")||
                        uri.contains("css/style-menubar.css")||
                        
                        uri.contains("js/bootstrap-tagsinput.min.js")||
                        uri.contains("js/bootstrap.js")||
                        uri.contains("js/form-js.js")||
                        uri.contains("js/bootstrap.min.js")||
                        uri.contains("js/form-select.js")||
                        uri.contains("js/jquery-1.6.2.js")||
                        uri.contains("js/jquery.min.js")||
                        uri.contains("js/npm.js")||
                        
                        uri.contains("img/screen.jpg")|| 
                        uri.contains("img/cadUsuario.png")|| 
                        uri.contains("img/co.png")|| 
                        uri.contains("img/img-sss.jpg")|| 
                        uri.contains("img/usuario.png")){
            return true;
        }
		
		if(request.getSession().getAttribute("usuario") != null) {
            return true;
        }else{
        	response.sendRedirect("login");
        	return false;    
        }
    }
}
