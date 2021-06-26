package br.upf.ads.rota.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Localizacao implements Serializable {

	  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private Date dataHora;
	private float lat;
	private float log;
	
	@ManyToOne
	private Ronda ronda; 
	
	


	public Localizacao(Long id, Date dataHora, float lat, float log, Ronda ronda) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.lat = lat;
		this.log = log;
		this.ronda = ronda;
	}













	public Localizacao() {
		super();
	}













	public Ronda getRonda() {
		return ronda;
	}













	public void setRonda(Ronda ronda) {
		this.ronda = ronda;
	}













	public void setId(Long id) {
		this.id = id;
	}


//Long e n long
	public Long getId() {
		return id;
	}
	
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLog() {
		return log;
	}
	public void setLog(float log) {
		this.log = log;
	}



	
	
	
	
	
}
