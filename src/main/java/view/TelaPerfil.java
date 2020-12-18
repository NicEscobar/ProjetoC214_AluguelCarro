package view;

import java.io.IOException;
import java.sql.SQLException;

import application.ClienteHolder;
import application.Main;
import entidade.Carro;
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
	private Label lblModelo;

	@FXML
	private Label lblMarca;

	@FXML
	private Label lblPlaca;

	@FXML
	private Button botaoSair;

	@FXML
	private Button botaoAlugar;

	@FXML
	private Button botaoDevolver;

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

		Stage stage = (Stage) botaoSair.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void acaoBotaoDevolver(ActionEvent event) throws IOException {
		try {
			Cliente clientAux = Main.clienteManager.buscarPrimeiro(cliente.getCPF());
			Main.clienteManager.devolverCarro(clientAux);

			lblMarca.setText("N/A");
			lblPlaca.setText("N/A");
			lblModelo.setText("N/A");
			
			botaoAlugar.setVisible(true);
			botaoAlugar.setManaged(true);
			botaoDevolver.setVisible(false);
			botaoDevolver.setManaged(false);
						
		} catch (SQLException e) {

		}
	}

	@FXML
	public void initialize() {
		try {
			Cliente clientAux = Main.clienteManager.buscarPrimeiro(cliente.getCPF());

			lblNome.setText(clientAux.getNome());
			lblEmail.setText(clientAux.getEmail());
			lblCPF.setText(clientAux.getCPF());
			lblTEL.setText(clientAux.getTelefone());

			if (clientAux.getCarroPlaca() != null) {
				
				botaoAlugar.setVisible(false);
				botaoAlugar.setManaged(false);
				botaoDevolver.setVisible(true);
				botaoDevolver.setManaged(true);
				
				Carro carro = Main.carroManager.buscarPrimeiro(clientAux.getCarroPlaca());

				if (carro != null) {
					lblMarca.setText(carro.getMarca());
					lblPlaca.setText(carro.getPlaca());
					lblModelo.setText(carro.getModelo());					
				}
			}else {
				botaoAlugar.setVisible(true);
				botaoAlugar.setManaged(true);
				botaoDevolver.setVisible(false);
				botaoDevolver.setManaged(false);
			}
		} catch (SQLException e) {
		}

	}
}
