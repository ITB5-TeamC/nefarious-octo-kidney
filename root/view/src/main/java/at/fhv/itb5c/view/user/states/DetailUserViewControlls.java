package at.fhv.itb5c.view.user.states;

import java.io.IOException;
import java.net.URL;

import at.fhv.itb5c.view.user.UserViewController;
import at.fhv.itb5c.view.user.UserViewController.UserViewState;
import at.fhv.itb5c.view.util.RouteProvider;
import at.fhv.itb5c.view.user.IUserViewState;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class DetailUserViewControlls  implements IUserViewState {
	private UserViewController _userViewController;
	private URL _controlsFXMLURL;
	
	public DetailUserViewControlls(UserViewController userViewController) {
		_userViewController = userViewController;
		_controlsFXMLURL =  RouteProvider.getInstance().get(this.getClass());
	}
	
	@Override
	public String getTitel() {
		return "User: " + _userViewController.getUserModel().getFirstName().getValue() + " " + _userViewController.getUserModel().getLastName().getValue();
	}

	@Override
	public URL getControlsFXML() {
		return _controlsFXMLURL;
	}

	@Override
	public void activate() {
		_userViewController.setDisable(true);
	}
	
	@FXML 
	public void modifyButtonMouseReleasedEventHandler(MouseEvent mouseEvent) throws IOException {
		_userViewController.setState(UserViewState.modifieState);
	}
	
	@FXML 
	public void closeButtonMouseReleasedEventHandler(MouseEvent mouseEvent) {
		_userViewController.close();
	}
}
