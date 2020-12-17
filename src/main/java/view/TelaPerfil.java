package view;

import java.io.IOException;

import application.ClienteHolder;
import entidade.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaPerfil {

	@FXML
	private Label lblNome;

	@FXML
	private Label lblEmail;

	@FXML
	private Label lblCPF;

	@FXML
	private Label lblTEL;

	@FXML
	private Button botaoSair;

	@FXML
	private Button botaoAlugar;

	private Cliente cliente = ClienteHolder.getInstance().getCliente();

	@FXML
	public void acaoBotaoSair(ActionEvent event) {
		Stage stage = (Stage) botaoSair.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void acaoBotaoAlugar(ActionEvent event) throws IOException {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLTelaCarros.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setTitle("Aluguel");
			stage.setScene(new Scene(root1));
			stage.show();
		} finally {
		}
	}
	
	@FXML
	public void initialize() {
		lblNome.setText(cliente.getNome());
		lblEmail.setText(cliente.getEmail());
		lblCPF.setText(cliente.getCPF());
		lblTEL.setText(cliente.getTelefone());
	}

}