package view;

import java.sql.SQLException;

import application.Cadastro;
import application.Login;
import application.Main;
import database.ClienteManager;
import entidade.Cliente;
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
	private void acaoBotao() throws SQLException {
		Alert erroCadastro = new Alert(Alert.AlertType.ERROR);

		if (txtNome.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
				|| txtSenha.getText().trim().isEmpty() || txtCPF.getText().trim().isEmpty()
				|| txtTelefone.getText().trim().isEmpty()) {
			erroCadastro.setTitle("Erro de Cadstro!");
			erroCadastro.setContentText("Favor, entre com todos os dados necessários!");
			erroCadastro.showAndWait();
		} else {
			
			//Cliente cliente = new Cliente(txtCPF.getText(), txtNome.getText(), txtEmail.getText(), txtSenha.getText(), txtTelefone.getText());
			
			Main.clienteManager.inserir(new Cliente(txtCPF.getText(), txtNome.getText(), txtEmail.getText(), txtSenha.getText(), txtTelefone.getText()));
			
			Stage stage = (Stage) botao.getScene().getWindow();
			stage.close();
		}
		
	}

}
