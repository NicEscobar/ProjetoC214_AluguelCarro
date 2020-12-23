package view;

import java.sql.SQLException;

import application.Main;
import database.ClienteManager;
import entidade.Cliente;
import entidade.ClienteFactory;
import holder.BancoHolder;
import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastro {

	@FXML
	private Button botao;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtSenha;

	@FXML
	private TextField txtCPF;

	@FXML
	private TextField txtTelefone;

	@FXML
	private void acaoBotao() {
		Alert erroCadastro = new Alert(Alert.AlertType.ERROR);

		if (txtNome.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
				|| txtSenha.getText().trim().isEmpty() || txtCPF.getText().trim().isEmpty()
				|| txtTelefone.getText().trim().isEmpty()) {
			erroCadastro.setTitle("Erro de Cadstro!");
			erroCadastro.setContentText("Favor, entre com todos os dados necessários!");
			erroCadastro.showAndWait();
		} else {
			try {
			BancoHolder.getInstance().getClienteManager().inserir(ClienteFactory.criaNovoCliente(txtCPF.getText(), txtNome.getText(), txtEmail.getText(), txtSenha.getText(), txtTelefone.getText()));
			
			Stage stage = (Stage) botao.getScene().getWindow();
			stage.close();
			} catch(SQLException e) {
								
				if (e.getErrorCode() == 19) {
					erroCadastro.setTitle("Erro de Cadstro!");
					erroCadastro.setContentText("CPF já cadastrado!");
					erroCadastro.showAndWait();
				}
			}
		}
		
	}

}
