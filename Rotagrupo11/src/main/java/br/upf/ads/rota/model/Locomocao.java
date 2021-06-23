package br.upf.ads.rota.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Locomocao implements Serializable  {

	@Id
	private long id;
	private String descricao;
	private String placa;
	
	
	
	
	
	
	public Locomocao() {
		super();
	}
	
	
	
	public Locomocao(long id, String descricao, String placa) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.placa = placa;
		
		
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}


	
	

	@Override
	public String toString() {
		return "Locomocao [id=" + id + ", descricao=" + descricao + ", placa=" + placa + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		Locomocao other = (Locomocao) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}



	public Locomocao(long id) {
		super();
		this.id = id;
	}
	
	
	
	
	
	
	
	
	
	
}
