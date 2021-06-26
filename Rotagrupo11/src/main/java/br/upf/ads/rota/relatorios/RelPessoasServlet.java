package br.upf.ads.rota.relatorios;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RelPessoasServlet
 */
@WebServlet("/Privada/Relatorios/RelPessoasServlet")
public class RelPessoasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelPessoasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		HashMap<String, Object> parameters = new HashMap();
		RelatorioUtil.rodarRelatorioPDF("WEB-INF/relatorios/Pessoas/Pessoas.jasper",
		parameters, "RelPessoas.pdf", request, response);
		} catch (Exception e) {
		e.printStackTrace();
		response.getWriter().append("Não foi possível executar o relatório. Erro:" +
		e.getMessage());
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
