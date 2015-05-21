package br.edu.unisep.bancas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unisep.bancas.model.vo.AlunoVO;
import br.edu.unisep.bancas.model.vo.ProfessorVO;
import br.edu.unisep.dao.DAOGenerico;


public class AlunoDAO extends DAOGenerico{

	public AlunoDAO() {
		super("banca_avaliacoes");
	}
	
	public List<AlunoVO> listar() {
		
		List<AlunoVO> listaAlunos = new ArrayList<AlunoVO>();
		
		try {
			Connection con = obterConexao();
		
			PreparedStatement ps = con.prepareStatement(
					"select "
					+ " a.id_aluno, "
					+ " a.nm_aluno, "
					+ " a.ds_trabalho, "
					+ " p.id_professor, "
					+ " p.nm_professor, "
					+ " from alunos a"
					+ " inner join professores p on "
					+ " a.id_orientador = p.id_professor ");
			
			ResultSet rs = ps.executeQuery();
			
			// Percorre todas as linhas da tabela retornadas pela consulta
			while (rs.next()) {
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
				
				listaAlunos.add(aluno);
			}
			
			rs.close();
			ps.close();
			con.close();
					
		} catch (SQLException e) {
			System.out.println("Erro de SQL - Consulta de Alunos: " + e.getMessage());
			e.printStackTrace();
		}
		
		return listaAlunos;
	}
	
}