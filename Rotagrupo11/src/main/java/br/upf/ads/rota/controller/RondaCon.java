package br.upf.ads.rota.controller;

import java.io.IOException;
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
import br.upf.ads.rota.model.Locomocao;
import br.upf.ads.rota.model.Pessoa;
import br.upf.ads.rota.model.Ronda;
import br.upf.ads.rota.uteis.Upload;
import net.iamvegan.multipartrequest.HttpServletMultipartRequest;

/**
 * Servlet implementation class RondaCon
 */
@WebServlet("/Privada/Ronda/RondaCon")
public class RondaCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RondaCon() {
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
		}  

		//--------------------
		
		else if (request.getParameter("Vigilantes") != null) {
			vigilantes(request, response);			
		
		} else if (request.getParameter("incluirVigilante") != null) {
			incluirVigilante(request, response);			
		
		}else if (request.getParameter("excluirVigilante") != null) {
			 excluirVigilante(request, response);			
			
			 //--------------------------------
			 
			 
		}else {
			listar(request, response);
		}
		
	}
	
	
	
	 
	 
	
	
	
	
           private void Locomocao(HttpServletRequest request, HttpServletResponse response) {
        	   try {
       			EntityManager em = JpaUtil.getEntityManager();
       			List<Locomocao> Locomocao = em.createQuery("from Locomocao").getResultList(); // recuperamos as Rondas do BD
       			request.setAttribute("Locomocao", Locomocao);
       			em.close(); 
       			request.getRequestDispatcher("RondaLocomocao.jsp").forward(request, response);
       		} catch (Exception e) {
       			e.printStackTrace();
       		} 
		
	}

           
           
           
           
           
           
           
		private void excluirVigilante(HttpServletRequest request, HttpServletResponse response) {
        	   EntityManager em = JpaUtil.getEntityManager(); 
       		em.getTransaction().begin(); 	
       		
       		Ronda r = em.find(Ronda.class, Long.parseLong(request.getParameter("idRonda")));
       		
       		Pessoa p = em.find(Pessoa.class, Long.parseLong(request.getParameter("excluirVigilante")));
       	
       		r.getVigilantes().remove(p);
       		em.merge(r); 
       		em.getTransaction().commit(); 	
       		em.close();
       		
       	
       		listarVigilantes(request, response, r.getId());
		
	       }
           
           
           
           private void vigilantes(HttpServletRequest request, HttpServletResponse response) {
        	   listarVigilantes(request, response, Long.parseLong(request.getParameter("Vigilantes")));
       	}
           
           
           private void listarVigilantes(HttpServletRequest request, HttpServletResponse response, Long idRonda) {
       		try {
       			EntityManager em = JpaUtil.getEntityManager();
       			Ronda obj = em.find(Ronda.class, idRonda);
       			request.setAttribute("obj", obj);
       			List<Pessoa> pessoas = em.createQuery("from Pessoa order by nome").getResultList();
       			request.setAttribute("pessoas", pessoas);
       			em.close();
       			request.getRequestDispatcher("RondaVigilantes.jsp").forward(request, response);
       		} catch (Exception e) {
       			e.printStackTrace();
       		} 
       	}	
           
		
           private void incluirVigilante(HttpServletRequest request, HttpServletResponse response) {
       		EntityManager em = JpaUtil.getEntityManager(); 
       		em.getTransaction().begin(); 	
       	
       		Ronda r = em.find(Ronda.class, Long.parseLong(request.getParameter("idRonda")));
       	
       		Pessoa p = em.find(Pessoa.class, Long.parseLong(request.getParameter("vigilante"))); 
       		
       		r.getVigilantes().add(p);
       		em.merge(r); 
       		em.getTransaction().commit(); 	
       		em.close();
       		
       		
       		listarVigilantes(request, response, r.getId());
       		
       	}	


	

	
	
	

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			List<Ronda> lista = em.createQuery("from Ronda").getResultList(); 
			request.setAttribute("lista", lista);
			em.close(); 
			request.getRequestDispatcher("RondaList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	

	private void cancelar(HttpServletRequest request, HttpServletResponse response) {
		listar(request, response);		
	}
	
	

	private void gravar(HttpServletRequest request, HttpServletResponse response) {
		
	EntityManager em = JpaUtil.getEntityManager(); 
	Locomocao locomocao = em.find(Locomocao.class, Long.parseLong(request.getParameter("locomocao")) );
	Ronda p = new Ronda(Long.parseLong(request.getParameter("id")),
			new Date(), 
			new Date(), 
			Float.parseFloat(request.getParameter("latUltima")), 
			Float.parseFloat(request.getParameter("longUltima")), 
			new Date(),
			new ArrayList(), locomocao);
	
				
	
		em.getTransaction().begin(); 	
		em.merge(p); 					
		em.getTransaction().commit(); 	
	    em.close();
		listar(request, response);
	}
	
	
	
	


	private void excluir(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager(); 
		em.getTransaction().begin(); 	
		em.remove(em.find(Ronda.class, Long.parseLong(request.getParameter("excluir"))));	
		em.getTransaction().commit(); 	
		em.close();
		listar(request, response);
	}
	
	

	private void alterar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Ronda obj = em.find(Ronda.class,  Long.parseLong(request.getParameter("alterar")));
			List<Locomocao> locomo = em.createQuery("from Locomocao").getResultList();
			request.setAttribute("locomo", locomo);
			request.setAttribute("obj", obj);
			em.close();
			request.getRequestDispatcher("RondaForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void incluir(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Ronda obj = new Ronda();
			List<Locomocao> locomo = em.createQuery("from Locomocao").getResultList();
			request.setAttribute("obj", obj);
			request.setAttribute("locomo", locomo);
			
			request.getRequestDispatcher("RondaForm.jsp").forward(request, response);
			em.close();
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
