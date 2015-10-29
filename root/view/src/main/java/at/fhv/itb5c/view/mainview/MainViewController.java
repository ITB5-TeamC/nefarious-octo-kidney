package at.fhv.itb5c.view.mainview;

import java.io.IOException;
import java.rmi.RemoteException;

import at.fhv.itb5c.model.UserModel;
import at.fhv.itb5c.rmi.client.RMIClient;
import at.fhv.itb5c.util.PanelCloseHandler;
import at.fhv.itb5c.util.RouteProvider;
import at.fhv.itb5c.util.StageUtil;
import at.fhv.itb5c.view.login.LoginController;
import at.fhv.itb5c.view.user.UserViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController {

	@FXML
	BorderPane _rootPane;

	@FXML
	Pane _mainPanel;

	@FXML
	private Button _loginButton;

	@FXML
	public void loginMenueItemActionHandler(ActionEvent event) {

		// TODO: extract
		Stage loginStage = new Stage();
		loginStage.initModality(Modality.WINDOW_MODAL);
		loginStage.initOwner(_rootPane.getScene().getWindow());

		try {
			StageUtil.loadScene(RouteProvider.getInstance().getRoot(LoginController.class), loginStage);
		} catch (IOException e) {
			// TODO add logging
			e.printStackTrace();
		}

		loginStage.show();
	}

	@FXML
	public void closeMenueItemActionHandler(ActionEvent event) {
		// TODO close resources etc . . .
		((Stage) _rootPane.getScene().getWindow()).close();
	}

	@FXML
	public void createUserMenueItemActionHandler(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(RouteProvider.getInstance().getRoot(UserViewController.class));
		UserViewController userViewController;
		
		try {
			userViewController = new UserViewController(
					new UserModel(RMIClient.getRMIClient().getUserFactory().createUser()));
			userViewController.setPanelCloseHandler(new PanelCloseHandler() {

				@Override
				public void close() {
					_mainPanel.getChildren().clear();
				}
			});
			loader.setController(userViewController);

			_mainPanel.getChildren().add(loader.load());
			_mainPanel.autosize();

			userViewController.initialize();
		} catch (RemoteException e1) {
			// TODO: handel can not connect
		}
	}
}
