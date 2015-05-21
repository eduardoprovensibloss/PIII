package br.edu.unisep.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import br.edu.unisep.dao.ClienteDAO;
import br.edu.unisep.vo.ClienteVO;

public class ClientesController implements Initializable{
	
	@FXML private TextField txtNome;
	
	@FXML private TextField txtCPF;
	
	@FXML private TextField txtRG;
	
	@FXML private TextField txtEmail;
	
	@FXML private DatePicker txtDataNascimento;
	
	@FXML private TableView<ClienteVO> tabClientes;
	
	@FXML private TableColumn<ClienteVO, String> colNome;
	@FXML private TableColumn<ClienteVO, String> colEmail;
	@FXML private TableColumn<ClienteVO, String> colCPF;
	
	private ObservableList<ClienteVO> listaClientes;
	
	@FXML
	public void salvar(ActionEvent event) {
		ClienteVO cliente = new ClienteVO();
		
		cliente.setNome( txtNome.getText() );
		cliente.setCpf( txtCPF.getText() );
		cliente.setRg( txtRG.getText() );
		cliente.setEmail( txtEmail.getText() );
		
		cliente.setDataNascimento( txtDataNascimento.getValue() );
		
		ClienteDAO dao = new ClienteDAO();
		dao.incluir(cliente);
		
		txtNome.setText("");
		txtCPF.setText("");
		txtRG.setText("");
		txtEmail.setText("");
		
		txtDataNascimento.setValue(null);
	}

	/*
	 * Método que será executado pelo controller
	 * antes que a tela seja exibida.
	 * 
	 * Funciona como um construtor. Todo código que deve ser executado
	 * antes da abertura da tela deve ser chamado neste método.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ClienteDAO dao = new ClienteDAO();
		List<ClienteVO> lista = dao.listar();

		/*
		 * Cria um objeto do tipo ObservableList a partir da lista
		 * dos clientes que foram buscados a partir do banco de dados
		 */
		listaClientes = FXCollections.observableArrayList(lista);

	}
	
}