package br.upf.ads.rota.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ronda
 *
 */
@Entity
public class Ronda implements Serializable {

	   
	@Id
	
	private Long id;
	private Date dataHoraInicio;
	private Date dataHoraFim;
	private float latUltima;
	private float longUltima;
	private Date dataHoraUltima;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Pessoa> Vigilantes;
	@ManyToOne
	private Locomocao locomocao;
	
	private static final long serialVersionUID = 1L;

	public Ronda() {
		super();
	} 
	


	public Ronda(Long id, Date dataHoraInicio, Date dataHoraFim, float latUltima, float longUltima, Date dataHoraUltima,
			List<Pessoa> vigilantes, Locomocao locomocao) {
		super();
		this.id = id;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.latUltima = latUltima;
		this.longUltima = longUltima;
		this.dataHoraUltima = dataHoraUltima;
		this.Vigilantes = vigilantes;
		this.locomocao = locomocao;
	}










	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Date getDataHoraInicio() {
		return this.dataHoraInicio;
	}

	public void setDataHoraInicio(Date DataHoraInicio) {
		this.dataHoraInicio = DataHoraInicio;
	}   
	public Date getDataHoraFim() {
		return this.dataHoraFim;
	}

	public void setDataHoraFim(Date DataHoraFim) {
		this.dataHoraFim = DataHoraFim;
	}   
	public float getLatUltima() {
		return this.latUltima;
	}

	public void setLatUltima(float latUltima) {
		this.latUltima = latUltima;
	}   
	public float getLongUltima() {
		return this.longUltima;
	}

	public void setLongUltima(float longUltima) {
		this.longUltima = longUltima;
	}   
	public Date getDataHoraUltima() {
		return this.dataHoraUltima;
	}

	public void setDataHoraUltima(Date DataHoraUltima) {
		this.dataHoraUltima = DataHoraUltima;
	}   
	public List<Pessoa> getVigilantes() {
		return this.Vigilantes;
	}

	public void setVigilantes(List<Pessoa> Vigilantes) {
		this.Vigilantes = Vigilantes;
	}   
	public Locomocao getLocomocao() {
		return this.locomocao;
	}

	public void setLocomocao(Locomocao locomocao) {
		this.locomocao = locomocao;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Vigilantes == null) ? 0 : Vigilantes.hashCode());
		result = prime * result + ((dataHoraFim == null) ? 0 : dataHoraFim.hashCode());
		result = prime * result + ((dataHoraInicio == null) ? 0 : dataHoraInicio.hashCode());
		result = prime * result + ((dataHoraUltima == null) ? 0 : dataHoraUltima.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(latUltima);
		result = prime * result + ((locomocao == null) ? 0 : locomocao.hashCode());
		result = prime * result + Float.floatToIntBits(longUltima);
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
		Ronda other = (Ronda) obj;
		if (Vigilantes == null) {
			if (other.Vigilantes != null)
				return false;
		} else if (!Vigilantes.equals(other.Vigilantes))
			return false;
		if (dataHoraFim == null) {
			if (other.dataHoraFim != null)
				return false;
		} else if (!dataHoraFim.equals(other.dataHoraFim))
			return false;
		if (dataHoraInicio == null) {
			if (other.dataHoraInicio != null)
				return false;
		} else if (!dataHoraInicio.equals(other.dataHoraInicio))
			return false;
		if (dataHoraUltima == null) {
			if (other.dataHoraUltima != null)
				return false;
		} else if (!dataHoraUltima.equals(other.dataHoraUltima))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(latUltima) != Float.floatToIntBits(other.latUltima))
			return false;
		if (locomocao == null) {
			if (other.locomocao != null)
				return false;
		} else if (!locomocao.equals(other.locomocao))
			return false;
		if (Float.floatToIntBits(longUltima) != Float.floatToIntBits(other.longUltima))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Ronda [id=" + id + ", dataHoraInicio=" + dataHoraInicio + ", dataHoraFim=" + dataHoraFim
				+ ", latUltima=" + latUltima + ", longUltima=" + longUltima + ", dataHoraUltima=" + dataHoraUltima
				+ ", Vigilantes=" + Vigilantes + ", locomocao=" + locomocao + "]";
	}
	
	
	
	
   
}
