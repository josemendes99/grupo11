package br.upf.ads.rota.model;

import java.io.Serializable;

import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Ocorrencia implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	
	private Long id;
	private Date dataHora;
	private String titulo;
	private String descricao;
	private float lat;
	private float log;
	
	
	
	@Lob
	private byte[] foto;

	@ManyToOne
	private Ronda ronda;


	




	public Ocorrencia(Long id, Date dataHora, String titulo, String descricao, float lat, float log, Ronda ronda) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.titulo = titulo;
		this.descricao = descricao;
		this.lat = lat;
		this.log = log;
		this.ronda = ronda;
	}









	public Ocorrencia() {
		super();
	}









	public Long getId() {
		return id;
	}









	public void setId(Long id) {
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









	public Ronda getRonda() {
		return ronda;
	}









	public void setRonda(Ronda ronda) {
		this.ronda = ronda;
	}









	public static long getSerialversionuid() {
		return serialVersionUID;
	}










	
	
	
	
	
	
	
	
	

}


