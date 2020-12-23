package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import application.Main;
import entidade.Carro;
import entidade.Cliente;
import holder.BancoHolder;
import holder.ClienteHolder;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaCarros {

	@FXML
	private ListView listView;

	@FXML
	private Label lblMarca;

	@FXML
	private Label lblPlaca;

	@FXML
	private Label lblAlugado;

	@FXML
	private Label lblPreco;

	@FXML
	private Button botaoSair;

	@FXML
	private Button botaoAlugar;

	private ObservableList<Carro> modelos;

	ArrayList<Carro> carrosDisponiveis;

	private Carro carroSelecionado;

	@FXML
	void acaoBotaoOK(ActionEvent event) {

		Alert confirma = new Alert(Alert.AlertType.CONFIRMATION);
		Alert aviso = new Alert(Alert.AlertType.WARNING);

		try {
			confirma.setTitle("Confirmar!");
			confirma.setHeaderText("Deseja mesmo alugar esse carro?");
			confirma.setContentText("Vai custar " + String.format("%.2f", carroSelecionado.getAluguel()));
			Optional<ButtonType> result = confirma.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				BancoHolder.getInstance().getClienteManager().alugarCarro(ClienteHolder.getInstance().getCliente(), carroSelecionado);
			}
		} catch (SQLException e) {
		}

		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLPerfil.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setTitle("Aluguel");
			stage.setScene(new Scene(root1));
			stage.show();

			Stage stageClose = (Stage) botaoSair.getScene().getWindow();
			stageClose.close();
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

	@FXML
	void acaoBotaoSair(ActionEvent event) {

		Stage stage = (Stage) botaoSair.getScene().getWindow();
		stage.close();

	}

	@FXML
	void initialize() {

		botaoAlugar.setVisible(false);
		botaoAlugar.setManaged(false);

		try {
			carrosDisponiveis = BancoHolder.getInstance().getCarroManager().buscarDisponiveis();
		} catch (SQLException e) {

		}

		modelos = FXCollections.observableArrayList(carrosDisponiveis);
		listView.setItems(modelos);

		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Carro>() {

			@Override
			public void changed(ObservableValue<? extends Carro> observable, Carro oldValue, Carro newValue) {

				botaoAlugar.setVisible(true);
				botaoAlugar.setManaged(true);

				lblMarca.setText(newValue.getMarca());
				lblPreco.setText(String.format("%.2f", newValue.getAluguel()));
				lblPlaca.setText(newValue.getPlaca());

				carroSelecionado = newValue;
			}
		});
	}

}