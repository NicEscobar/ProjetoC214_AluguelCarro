package view;

import javafx.scene.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.Dialog;
import java.io.IOException;
import java.sql.SQLException;

import application.ClienteHolder;
import application.Login;
import application.Main;
import database.ClienteManager;
import entidade.Cliente;
import javafx.application.*;
import javafx.fxml.*;

import javafx.event.ActionEvent;

public class TelaLogin {

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtSenha;

	@FXML
	private Button botaoSair;

	@FXML
	private void acaoBotaoOK(ActionEvent event) throws IOException, SQLException {

		Alert erroLogin = new Alert(Alert.AlertType.ERROR);

		if (txtEmail.getText().trim().isEmpty() && txtSenha.getText().trim().isEmpty()) {
			erroLogin.setTitle("Erro de Login");
			erroLogin.setHeaderText("Campos em branco!");
			erroLogin.setContentText("Favor, entre com os dados necessários");
			erroLogin.showAndWait();
		} else {
			
			Cliente cliente = Main.clienteManager.login(txtEmail.getText(), txtSenha.getText());

			if (cliente == null) {
				erroLogin.setTitle("Erro de Login");
				erroLogin.setHeaderText("Cliente não encontrado!");
				erroLogin.showAndWait();
			} else {				

				ClienteHolder.getInstance().setCliente(cliente);
				
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/FXMLPerfil.fxml"));
					Parent root2 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initStyle(StageStyle.UNIFIED);
					stage.setTitle("Perfil");
					stage.setScene(new Scene(root2));
					stage.show();
					
					((Node) (event.getSource())).getScene().getWindow().hide();
				
					
					
				} finally {
				}
			}
		}
	}

	@FXML
	private void acaoBotaoSair(ActionEvent event) {
		Stage stage = (Stage) botaoSair.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void acaoBotaoCadastrar() throws IOException {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLCadastro.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setTitle("Cadastro");
			stage.setScene(new Scene(root1));
			stage.show();
		} finally {
		}

	}
}
