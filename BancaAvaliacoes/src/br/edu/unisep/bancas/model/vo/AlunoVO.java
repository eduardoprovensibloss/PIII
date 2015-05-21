package br.edu.unisep.bancas.model.vo;

public class AlunoVO {

	private Integer id;
	
	private String nome;
	
	private ProfessorVO orientador;
	
	private String trabalho;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ProfessorVO getOrientador() {
		return orientador;
	}

	public void setOrientador(ProfessorVO orientador) {
		this.orientador = orientador;
	}

	public String getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(String trabalho) {
		this.trabalho = trabalho;
	}
	
	
}