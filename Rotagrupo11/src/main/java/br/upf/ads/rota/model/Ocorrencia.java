package br.upf.ads.rota.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.Base64;
  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Ocorrencia implements Serializable {
	
	@Id
	 @GeneratedValue
	private long id;
	
	private Date dataHora;
	private String titulo;
	private String descricao;
	private float lat;
	private float log;
	
	
	@Lob
	private byte[] foto;
	
	
	

	public Ocorrencia(long id, Date dataHora, String titulo, String descricao, float lat, float log, byte[] foto) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.titulo = titulo;
		this.descricao = descricao;
		this.lat = lat;
		this.log = log;
		this.foto = foto;
	}


	public Ocorrencia() {
		super();
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


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
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


	public byte[] getFoto() {
		return foto;
	}


	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
	public String getFotoBase64() {
		if (foto != null)
		   return new String(Base64.getEncoder().encode(foto));
		else
		   return "";
	}

	
	
	
	
	

	@Override
	public String toString() {
		return "Ocorrencia [id=" + id + ", dataHora=" + dataHora + ", titulo=" + titulo + ", descricao=" + descricao
				+ ", lat=" + lat + ", log=" + log + ", foto=" + Arrays.toString(foto) + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Float.floatToIntBits(lat);
		result = prime * result + Float.floatToIntBits(log);
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Ocorrencia other = (Ocorrencia) obj;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (!Arrays.equals(foto, other.foto))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(lat) != Float.floatToIntBits(other.lat))
			return false;
		if (Float.floatToIntBits(log) != Float.floatToIntBits(other.log))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	
	
	

}
