package br.com.daniape.AppControleContatos.dto;

public class MalaDiretaDTO {
	
	private Long id;
	private String nome;
	private String maladireta;
	
	public MalaDiretaDTO(){}
	
	public MalaDiretaDTO(Long id, String nome, String maladireta) {
		this.id = id;
		this.nome = nome;
		this.maladireta = maladireta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMaladireta() {
		return maladireta;
	}

	public void setMaladireta(String maladireta) {
		this.maladireta = maladireta;
	}
		
}
