package br.upf.ads.rota.model;

import java.io.Serializable;
import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Pessoa implements Serializable { 
	 
	@Id
	private Long id;
	private String nome;
	private String loginApp;
	private String senha;
	
	

	
	



	public Pessoa(Long id, String nome, String loginApp, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.loginApp = loginApp;
		this.senha = senha;
	}






	public Pessoa() {
		super();
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getLoginApp() {
		return loginApp;
	}



	public void setLoginApp(String loginApp) {
		this.loginApp = loginApp;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((loginApp == null) ? 0 : loginApp.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		if (loginApp == null) {
			if (other.loginApp != null)
				return false;
		} else if (!loginApp.equals(other.loginApp))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", loginApp=" + loginApp + ", senha=" + senha + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
