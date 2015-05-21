package br.edu.unisep.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unisep.vo.ClienteVO;

public class ClienteDAO {

	public void incluir(ClienteVO cliente) {
		
		try {
			Connection con = obterConexao();
			
			/*
			 * Cria um objeto PreparedStatement com um comando SQL
			 * que poderá posteriormente ser executado diretamente
			 * no banco de dados.
			 */
			PreparedStatement ps = con.prepareStatement(
					"insert into clientes ("
					+ " nome_cliente, "
					+ " cpf_cliente, "
					+ " rg_cliente, "
					+ " email_cliente, "
					+ " dt_nascimento_cliente) "
					+ " values "
					+ " (?, ?, ?, ?, ?) ");
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getRg());
			ps.setString(4, cliente.getEmail());
			
			/*
			 * Converte o objeto do tipo LocalDate para java.sql.Date
			 */
			Date data = Date.valueOf(cliente.getDataNascimento());
			ps.setDate(5, data);
			
			ps.execute();
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Erro de SQL - Inclusão: " + e.getMessage());
			e.printStackTrace();
		}
	}	
	
	public List<ClienteVO> listar() {
		
		List<ClienteVO> listaClientes = new ArrayList<ClienteVO>();
		
		try {
			Connection con = obterConexao();
		
			PreparedStatement ps = con.prepareStatement(
					"select * from clientes");
			
			ResultSet rs = ps.executeQuery();
			
			// Percorre todas as linhas da tabela retornadas pela consulta
			while (rs.next()) {
				ClienteVO cliente = new ClienteVO();
				
				String nome = rs.getString("nome_cliente");
				cliente.setNome(nome);
				
				String cpf = rs.getString("cpf_cliente");
				cliente.setCpf(cpf);
				
				String rg = rs.getString("rg_cliente");
				cliente.setRg(rg);
				
				String email = rs.getString("email_cliente");
				cliente.setEmail(email);
				
				Date data = rs.getDate("dt_nascimento_cliente");
				cliente.setDataNascimento(data.toLocalDate());
				
				Integer id = rs.getInt("id_cliente");
				cliente.setId(id);
				
				listaClientes.add(cliente);
			}
			
			rs.close();
			ps.close();
			con.close();
					
		} catch (SQLException e) {
			System.out.println("Erro de SQL - Consulta: " + e.getMessage());
			e.printStackTrace();
		}
		
		return listaClientes;
	}
	
	public void excluir(ClienteVO cliente) {
		
		try {
			Connection con = obterConexao();

			PreparedStatement ps = con.prepareStatement(
					"delete from clientes where id_cliente = ?");
			ps.setInt(1, cliente.getId());
			
			ps.execute();
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Erro de SQL - Exclusão: " +
					e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private Connection obterConexao() {
		
		Connection con = null;
		
		try {
			// Carrega a classe do driver de conexão com o banco de dados
			Class.forName("org.postgresql.Driver");
	
			// Estabelece uma conexão entre a aplicação Java e o banco de dados
			con = DriverManager.getConnection(
								"jdbc:postgresql://localhost:5432/clientes", 
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