package view;

import java.sql.SQLException;
import java.util.ArrayList;

import application.ClienteHolder;
import application.Main;
import entidade.Carro;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

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

	private ObservableList<Carro> modelos;

	ArrayList<Carro> carrosDisponiveis;

	private Carro carroSelecionado;

	@FXML
	void acaoBotaoOK(ActionEvent event) {
		try {
			Main.clienteManager.alugarCarro(ClienteHolder.getInstance().getCliente(), carroSelecionado);
		} catch (SQLException e) {
		}

		Stage stage = (Stage) botaoSair.getScene().getWindow();
		stage.close();

	}

	@FXML
	void acaoBotaoSair(ActionEvent event) {

		Stage stage = (Stage) botaoSair.getScene().getWindow();
		stage.close();

	}

	@FXML
	void initialize() {

		try {
			carrosDisponiveis = Main.carroManager.buscarDisponiveis();
		} catch (SQLException e) {

		}

		modelos = FXCollections.observableArrayList(carrosDisponiveis);
		listView.setItems(modelos);

		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Carro>() {

			@Override
			public void changed(ObservableValue<? extends Carro> observable, Carro oldValue, Carro newValue) {

				lblMarca.setText(newValue.getMarca());
				lblPreco.setText(newValue.getAluguel() + "");
				lblPlaca.setText(newValue.getPlaca());

				carroSelecionado = newValue;
			}
		});
	}

}