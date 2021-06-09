package br.upf.ads.rota.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.upf.ads.rota.model.Usuario;

/**
 * Servlet Filter implementation class LoginFiltro
 */
@WebFilter(urlPatterns={"/Privada/*"}) 
public class LoginFiltro implements Filter {


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	   HttpServletRequest httpRequest = (HttpServletRequest) request; 
	   HttpServletResponse httpResponse = (HttpServletResponse) response; 
	   HttpSession sessao = httpRequest.getSession(); 
	   String contextPath = httpRequest.getContextPath();
	   
	   Usuario usuarioLogado = (Usuario) sessao.getAttribute("usuarioLogado"); // pegar da sessão usuário deixado quando autentica com sucesso 
	   if (usuarioLogado == null){ 
		   httpResponse.sendRedirect(contextPath + "/Login.jsp"); // redirecionar para login - acesso não permitido 
	   } else { 
		   chain.doFilter(request, response); // deixar seguir
	   }
	}
	
	
	
	
	
    /**
     * Default constructor. 
     */
    public LoginFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
