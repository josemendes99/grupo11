package Class;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Pessoa {

	 @Id
	 @GeneratedValue
	private long id;
	private String nome;
	private String senha;
	
	
	
	
	public Pessoa(long id, String nome, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}




	public Pessoa() {
		super();
	}
	
	
	
	
	
	
	
	
	
}
