package br.upf.ads.rota.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Localizacao implements Serializable {

	
	
	@Id
	@GeneratedValue
	private long id;
	private Date dataHora;
	private float lat;
	private float log;
	
	

	
	public Localizacao() {
		super();
	}



	public Localizacao(long id, Date dataHora, float lat, float log) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.lat = lat;
		this.log = log;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String toString() {
		return "Localizacao [id=" + id + ", dataHora=" + dataHora + ", lat=" + lat + ", log=" + log + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Float.floatToIntBits(lat);
		result = prime * result + Float.floatToIntBits(log);
		return result;
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
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(lat) != Float.floatToIntBits(other.lat))
			return false;
		if (Float.floatToIntBits(log) != Float.floatToIntBits(other.log))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
}
