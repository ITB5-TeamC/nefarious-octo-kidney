package at.fhv.itb5c.commons.dto.rmi;

import java.rmi.RemoteException;
import java.util.Set;

import at.fhv.itb5c.commons.enums.TypeOfSport;

public interface ITeamRMI extends IBaseRMI {
	String getName() throws RemoteException;

	void setName(String name) throws RemoteException;

	TypeOfSport getTypeOfSport() throws RemoteException;

	void setTypeOfSport(TypeOfSport typeOfSport) throws RemoteException;

	Long getDepartmentId() throws RemoteException;

	void setDepartmentId(Long departmentId) throws RemoteException;

	Long getCoachId() throws RemoteException;

	void setCoachId(Long coachId) throws RemoteException;

	Long getLeagueId() throws RemoteException;

	void setLeagueId(Long leagueId) throws RemoteException;

	Set<Long> getMembers() throws RemoteException;

	void setMembers(Set<Long> members) throws RemoteException;
}