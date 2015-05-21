package br.edu.unisep.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOGenerico {

	private String banco;
	
	public DAOGenerico(String nomeBanco) {
		this.banco = nomeBanco;
	}
	
	protected Connection obterConexao() {
		
		Connection con = null;
		
		try {
			// Carrega a classe do driver de conexão com o banco de dados
			Class.forName("org.postgresql.Driver");
	
			// Estabelece uma conexão entre a aplicação Java e o banco de dados
			con = DriverManager.getConnection(
								"jdbc:postgresql://localhost:5432/" + banco, 
									"postgres", "admin");
		
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao carregar driver. " + 
					e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro ao abrir conexão. " + e.getMessage());
			e.printStackTrace();
		}
		
		return con;
	}	
}
