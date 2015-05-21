package br.edu.unisep.bancas.model.vo;

public class AvaliacaoVO {

	private Integer id;
	
	private AlunoVO aluno;
	
	private String avaliador;
	
	private String consideracoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AlunoVO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoVO aluno) {
		this.aluno = aluno;
	}

	public String getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(String avaliador) {
		this.avaliador = avaliador;
	}

	public String getConsideracoes() {
		return consideracoes;
	}

	public void setConsideracoes(String consideracoes) {
		this.consideracoes = consideracoes;
	}
	
}