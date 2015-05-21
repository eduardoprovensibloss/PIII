package br.edu.unisep.bancas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unisep.bancas.model.vo.AlunoVO;
import br.edu.unisep.bancas.model.vo.AvaliacaoVO;
import br.edu.unisep.bancas.model.vo.ProfessorVO;
import br.edu.unisep.dao.DAOGenerico;


public class AvaliacaoDAO extends DAOGenerico{

	public AvaliacaoDAO() {
		super("banca_avaliacoes");
	}
	
	public List<AvaliacaoVO> listar() {
		
		List<AvaliacaoVO> listaAvaliacoes = new ArrayList<AvaliacaoVO>();
		
		try {
			Connection con = obterConexao();
		
			PreparedStatement ps = con.prepareStatement(
					"select "
					+ " av.id_avaliacao,"
					+ " av.nm_avaliador, "
					+ " av.ds_consideracoes, "
					+ " a.id_aluno, "
					+ " a.nm_aluno, "
					+ " a.ds_trabalho, "
					+ " p.id_professor, "
					+ " p.nm_professor, "
					+ " from avaliacoes av "
					+ " inner join alunos a on "
					+ " av.id_aluno = a.id_aluno "
					+ " inner join professores p on "
					+ " a.id_orientador = p.id_professor ");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				AvaliacaoVO avaliacao = new AvaliacaoVO();
				
				Integer idAvaliacao = rs.getInt("id_avaliacao");
				avaliacao.setId(idAvaliacao);
				
				String avaliador = rs.getString("nm_avaliador");
				avaliacao.setAvaliador(avaliador);

				String consideracoes = rs.getString("ds_consideracoes");
				avaliacao.setConsideracoes(consideracoes);
				
				AlunoVO aluno = new AlunoVO();
				
				Integer id = rs.getInt("id_aluno");
				aluno.setId(id);

				String nome = rs.getString("nm_aluno");
				aluno.setNome(nome);
				
				ProfessorVO orientador = new ProfessorVO();
				
				Integer idProfessor = rs.getInt("id_professor");
				orientador.setId(idProfessor);
				
				String nomeProfessor = rs.getString("nm_professor");
				orientador.setNome(nomeProfessor);
				
				aluno.setOrientador(orientador);
				
				avaliacao.setAluno(aluno);
				
				listaAvaliacoes.add(avaliacao);
			}
			
			rs.close();
			ps.close();
			con.close();
					
		} catch (SQLException e) {
			System.out.println("Erro de SQL - Consulta de Alunos: " + e.getMessage());
			e.printStackTrace();
		}
		
		return listaAvaliacoes;
	}
	
	public void salvar(AvaliacaoVO avaliacao) {
		
		try {
			Connection con = obterConexao();
		
			PreparedStatement ps = con.prepareStatement(
					"insert into avaliacoes("
					+ "id_aluno, "
					+ "nm_avaliador, "
					+ "ds_consideracoes) "
					+ "values (?, ?, ?)");  

			ps.setInt(1, avaliacao.getAluno().getId());
			ps.setString(2, avaliacao.getAvaliador());
			ps.setString(3, avaliacao.getConsideracoes());

			ps.execute();
			
			ps.close();
			con.close();
					
		} catch (SQLException e) {
			System.out.println("Erro de SQL - Inclusao de Avaliacao: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}