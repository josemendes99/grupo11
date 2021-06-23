package br.upf.ads.rota.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upf.ads.rota.jpa.JpaUtil;
import br.upf.ads.rota.model.Localizacao;
import br.upf.ads.rota.model.Pessoa;
import net.iamvegan.multipartrequest.HttpServletMultipartRequest;

/**
 * Servlet implementation class LocalizacaoCon
 */
@WebServlet("/Privada/Localizacao/LocalizacaoCon")
public class LocalizacaoCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LocalizacaoCon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		if (request.getParameter("incluir") != null) {
			incluir(request, response);
		} else if (request.getParameter("alterar") != null) {
			alterar(request, response);
		} else if (request.getParameter("excluir") != null) {
            excluir(request, response);			
		} else if (request.getParameter("gravar") != null) {
			gravar(request, response);			
		} else if (request.getParameter("cancelar") != null) {
			cancelar(request, response);			
		}  else {
			listar(request, response);
		}
		
	}
	
	

	

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			List<Localizacao> lista = em.createQuery("from Localizacao").getResultList(); // recuperamos as Localizacaos do BD
			request.setAttribute("lista", lista);
			em.close(); 
			request.getRequestDispatcher("LocalizacaoList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void cancelar(HttpServletRequest request, HttpServletResponse response) {
		listar(request, response);		
	}

	private void gravar(HttpServletRequest request, HttpServletResponse response) {
		
		
		Date d = null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("dataHora"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Long n= Long.parseLong(request.getParameter("id"));
		float l = Float.parseFloat(request.getParameter("lat"));
		float lo = Float.parseFloat(request.getParameter("log"));
	EntityManager em = JpaUtil.getEntityManager(); 
	
	
	Localizacao p = new Localizacao(n,
			d, l, lo);
			

	
				
	
		em.getTransaction().begin(); 	
		em.merge(p); 					
		em.getTransaction().commit(); 	
	    em.close();
		listar(request, response);
	}
	


	private void excluir(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager(); // pega a entitymanager para persistir
		em.getTransaction().begin(); 	// inicia a transação
		em.remove(em.find(Localizacao.class, Long.parseLong(request.getParameter("excluir"))));	// excluir o objeto no BD
		em.getTransaction().commit(); 	// commit na transação
		em.close();
		listar(request, response);
	}
	
	

	private void alterar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Localizacao obj = em.find(Localizacao.class,  Long.parseLong(request.getParameter("alterar")));
			request.setAttribute("obj", obj);
			em.close();
			request.getRequestDispatcher("LocalizacaoForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void incluir(HttpServletRequest request, HttpServletResponse response) {
		try {
			Localizacao obj = new Localizacao();
			request.setAttribute("obj", obj);
			request.getRequestDispatcher("LocalizacaoForm.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
