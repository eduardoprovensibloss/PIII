package br.edu.unisep.bancas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unisep.bancas.model.vo.ProfessorVO;
import br.edu.unisep.dao.DAOGenerico;


public class ProfessorDAO extends DAOGenerico{

	public ProfessorDAO() {
		super("banca_avaliacoes");
	}
	
	public List<ProfessorVO> listar() {
		
		List<ProfessorVO> listaProfessores = new ArrayList<ProfessorVO>();
		
		try {
			Connection con = obterConexao();
		
			PreparedStatement ps = con.prepareStatement(
					"select * from professores");
			
			ResultSet rs = ps.executeQuery();
			
			// Percorre todas as linhas da tabela retornadas pela consulta
			while (rs.next()) {
				ProfessorVO professor = new ProfessorVO();
				
				Integer id = rs.getInt("id_professor");
				professor.setId(id);

				String nome = rs.getString("nm_professor");
				professor.setNome(nome);
				
				listaProfessores.add(professor);
			}
			
			rs.close();
			ps.close();
			con.close();
					
		} catch (SQLException e) {
			System.out.println("Erro de SQL - Consulta de Professores: " + e.getMessage());
			e.printStackTrace();
		}
		
		return listaProfessores;
	}
	
}