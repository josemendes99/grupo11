package br.upf.ads.rota.relatorios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;

import br.upf.ads.rota.jpa.JpaUtil;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * 
 * @author Jaqson Dalbosco
 *
 */
public class RelatorioUtil {
	
	/**
	 * Metodo responsavel por rodar um relatorio do jasper e responder uma requisicao  com um PDF
	 * @param pathRelatorio Caminho de onde esta o relatorio no contexto da aplicacao
	 * @param parameters Sao os parametros a serem repassados para o relatorio executar
	 * @throws SQLException
	 */
	public static void rodarRelatorioPDF(String pathRelatorio, HashMap parameters, String nomeArquivo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection con = getEntityManagerJDBCConnection();
		JasperPrint jasperPrint = JasperFillManager.fillReport(request.getServletContext().getRealPath("/"+pathRelatorio), parameters, con);
		byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline;filename="+nomeArquivo); // diretamente na pagina
		// response.setHeader("Content-disposition", "attachment;filename=arquivo.pdf"); // baixar ou salvar
		response.getOutputStream().write(b);
		response.getOutputStream().flush();
	    response.getOutputStream().close();
	}	
	
	/**
	 * M�todo responsavel por obter uma conexao JDBC a partir de uma EntityManager.
	 * Funciona com Hibernate 5.2 ou superior.
	 * @return conexao JDBC com o banco de dados
	 * @throws SQLException
	 */
    public static Connection getEntityManagerJDBCConnection() throws SQLException { 
        EntityManager em = JpaUtil.getEntityManager();
        Session s = (Session) em;
        SessionImplementor sim = (SessionImplementor) s;
        Connection conexao = sim.connection();
        em.close();
        conexao.setAutoCommit(false);
        return conexao; 
    }
    
	/* para vers�es mais antigas do Hibernate ...  
    public static Connection getEntityManagerJDBCConnection() throws SQLException { 
    	EntityManager em = getEntityManager(); 
    	HibernateEntityManager hem = (HibernateEntityManager) em;
    	SessionImplementor sim = (SessionImplementor) hem.getSession();
    	Connection conexao = sim.connection();
    	em.close();
    	return conexao; 
    }  
	 */

    // ou, mais antigo ainda fazer assim ...
	/*
	public static Connection getEntityManagerJDBCConnection() throws SQLException {
	   	EntityManager em = factory.createEntityManager();
	   	Session ses = (Session) em.getDelegate();
	   	SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();
	   	Connection conexao = sessionFactory.getConnectionProvider().getConnection();	
	   	em.close(); 
	    return conexao;
	} 
	*/
	
	
	
}
