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
	@GeneratedValue
	private long Id;
	private Date DataHoraInicio;
	private Date DataHoraFim;
	private float latUltima;
	private float longUltima;
	private Date DataHoraUltima;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Pessoa> Vigilantes;
	@ManyToOne
	private Locomocao locomocao;
	
	private static final long serialVersionUID = 1L;

	public Ronda() {
		super();
	} 
	
	
	
	
	
	public Ronda( Date dataHoraInicio, Date dataHoraFim, float latUltima, float longUltima, Date dataHoraUltima,
			List<Pessoa> vigilantes, Locomocao locomocao) {
		super();
		
		this.DataHoraInicio = dataHoraInicio;
		this.DataHoraFim = dataHoraFim;
		this.latUltima = latUltima;
		this.longUltima = longUltima;
		this.DataHoraUltima = dataHoraUltima;
		this.Vigilantes = vigilantes;
		this.locomocao = locomocao;
	}





	public long getId() {
		return this.Id;
	}

	public void setId(long Id) {
		this.Id = Id;
	}   
	public Date getDataHoraInicio() {
		return this.DataHoraInicio;
	}

	public void setDataHoraInicio(Date DataHoraInicio) {
		this.DataHoraInicio = DataHoraInicio;
	}   
	public Date getDataHoraFim() {
		return this.DataHoraFim;
	}

	public void setDataHoraFim(Date DataHoraFim) {
		this.DataHoraFim = DataHoraFim;
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
		return this.DataHoraUltima;
	}

	public void setDataHoraUltima(Date DataHoraUltima) {
		this.DataHoraUltima = DataHoraUltima;
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
   
}
