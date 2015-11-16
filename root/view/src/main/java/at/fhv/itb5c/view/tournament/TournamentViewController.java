package at.fhv.itb5c.view.tournament;

import java.io.IOException;
import java.rmi.RemoteException;

import at.fhv.itb5c.commons.dto.rmi.IDepartmentRMI;
import at.fhv.itb5c.commons.dto.rmi.IMatchRMI;
import at.fhv.itb5c.commons.dto.rmi.ITournamentRMI;
import at.fhv.itb5c.logging.ILogger;
import at.fhv.itb5c.view.tournament.addteams.TournamentAddTeamsFactory;
import at.fhv.itb5c.view.util.interfaces.IPanelClosable;
import at.fhv.itb5c.view.util.interfaces.IPanelCloseHandler;
import at.fhv.itb5c.view.util.listcell.ObjectListCell;
import at.fhv.itb5c.view.util.popup.ErrorPopUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class TournamentViewController implements IPanelClosable, ILogger {
	@FXML
	private Label _tournamentLabel;
	@FXML
	private ListView<Object> _teamsList;
	@FXML
	private Button _addTeamsButton;
	@FXML
	private ListView<IMatchRMI> _matchesList;
	@FXML
	private Button _addMatchesButton;
	
	private IDepartmentRMI _department;
	
	private TournamentModel _tournamentModel;
	
	public TournamentViewController(IDepartmentRMI department, ITournamentRMI tournament) {
		_department = department;
		_tournamentModel = new TournamentModel();
		try {
			_tournamentModel.setITournamentRMI(tournament);
		} catch (RemoteException e) {
			log.error(e.getMessage());
			ErrorPopUp.connectionError();
		}
	}

	@FXML
	public void initialize() {
		_tournamentLabel.textProperty().bindBidirectional(_tournamentModel.getTournamentName());
		_teamsList.itemsProperty().bindBidirectional(_tournamentModel.getTeams());
		_teamsList.setCellFactory(new Callback<ListView<Object>, ListCell<Object>>() {
			@Override
			public ListCell<Object> call(ListView<Object> param) {
				return new ObjectListCell();
			}
		});
	}

	// Event Listener on Button[#_addTeamsButton].onAction
	@FXML
	public void addTeamsButtonAction(ActionEvent event) {
		try {
			_panelCloseHandler.closeNext(new TournamentAddTeamsFactory(_department, _tournamentModel.getITournamentRMI()));
		} catch (IOException e) {
			log.error(e.getMessage());
			ErrorPopUp.criticalSystemError();
		}
	}
	// Event Listener on Button[#_addMatchesButton].onAction
	@FXML
	public void addMatchesButtonAction(ActionEvent event) {
		// TODO implement!
	}
	
	private IPanelCloseHandler _panelCloseHandler;

	@Override
	public void setPanelCloseHandler(IPanelCloseHandler panelCloseHandler) {
		_panelCloseHandler = panelCloseHandler;
	}
}