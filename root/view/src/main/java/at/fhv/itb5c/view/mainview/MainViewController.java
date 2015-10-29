package at.fhv.itb5c.view.mainview;

import java.io.IOException;
import at.fhv.itb5c.util.RouteProvider;
import at.fhv.itb5c.util.StageUtil;
import at.fhv.itb5c.view.login.LoginController;
import at.fhv.itb5c.view.user.UserViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
	public void loginMenueItemActionHandler(ActionEvent event) throws IOException {

		//TODO(san7985): replace with controlfx login view
		Stage loginStage = new Stage();
		loginStage.initModality(Modality.WINDOW_MODAL);
		loginStage.initOwner(_rootPane.getScene().getWindow());

		StageUtil.loadScene(RouteProvider.getInstance().getRoot(LoginController.class), loginStage);

		loginStage.show();
	}

	@FXML
	public void closeMenueItemActionHandler(ActionEvent event) {
		((Stage) _rootPane.getScene().getWindow()).close();
	}

	@FXML
	public void createUserMenueItemActionHandler(ActionEvent event) throws IOException {				
		UserViewFactory.CreateNewUserView(_mainPanel, at.fhv.itb5c.view.user.UserViewController.UserViewState.newState);
	}
}
