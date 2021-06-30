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













	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(lat);
		result = prime * result + Float.floatToIntBits(log);
		result = prime * result + ((ronda == null) ? 0 : ronda.hashCode());
		return result;
	}













	@Override
	public String toString() {
		return "Localizacao [id=" + id + ", dataHora=" + dataHora + ", lat=" + lat + ", log=" + log + ", ronda=" + ronda
				+ "]";
	}













	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localizacao other = (Localizacao) obj;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(lat) != Float.floatToIntBits(other.lat))
			return false;
		if (Float.floatToIntBits(log) != Float.floatToIntBits(other.log))
			return false;
		if (ronda == null) {
			if (other.ronda != null)
				return false;
		} else if (!ronda.equals(other.ronda))
			return false;
		return true;
	}



	
	
	
	
	
}
