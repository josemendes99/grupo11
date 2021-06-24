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
	
	private long id;
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
	
	
	
	
	
	




	public Ronda(long id, Date dataHoraInicio, Date dataHoraFim, float latUltima, float longUltima, Date dataHoraUltima,
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










	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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
   
}
