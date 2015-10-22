package at.fhv.itb5c.view.mainview;

import java.io.IOException;

import at.fhv.itb5c.model.UserModel;
import at.fhv.itb5c.util.RouteProvider;
import at.fhv.itb5c.util.StageUtil;
import at.fhv.itb5c.view.login.LoginController;
import at.fhv.itb5c.view.user.create.CreateUserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * TODO:
 * 	create general loader for an fxml
 */

public class MainViewController {
	
	@FXML
	BorderPane _rootPane;
	
	@FXML
	TabPane _mainTabView;
	
	@FXML
	private Button _loginButton;

	@FXML
	public void LoginMenueItemActionHandler(ActionEvent event) {
		
		//TODO: extract 
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
	public void CloseMenueItemActionHandler(ActionEvent event) {
		// TODO close resources etc . . .
		((Stage)_rootPane.getScene().getWindow()).close(); 
	}
	
	@FXML
	public void CreateUserMenueItemActionHandler(ActionEvent event) {
		Tab userTab = new Tab();
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(RouteProvider.getInstance().getRoot(CreateUserController.class));
		CreateUserController createUserController = new CreateUserController(new UserModel());
		loader.setController(createUserController);
		try {
			userTab.setText("Create User");
			userTab.setContent(loader.load());

		} catch (IOException e) {
			// TODO add logging
			e.printStackTrace();
		}
		createUserController.initialize();
		_mainTabView.getTabs().add(userTab);
	}
}