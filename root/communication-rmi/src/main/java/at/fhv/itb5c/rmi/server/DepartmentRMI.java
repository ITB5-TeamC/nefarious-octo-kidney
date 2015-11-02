package at.fhv.itb5c.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import at.fhv.itb5c.commons.dto.rmi.IDepartmentRMI;

public class DepartmentRMI extends UnicastRemoteObject implements IDepartmentRMI {
	private static final long serialVersionUID = 1L;
	private long _id;
	private long _version;
	private String _name;

	protected DepartmentRMI() throws RemoteException {
		super();
	}

	@Override
	public void setId(long id) throws RemoteException {
		_id = id;
	}

	@Override
	public long getId() throws RemoteException {
		return _id;
	}

	@Override
	public void setVersion(long version) throws RemoteException {
		_version = version;
	}

	@Override
	public long getVersion() throws RemoteException {
		return _version;
	}

	@Override
	public void setName(String name) throws RemoteException {
		_name = name;
	}

	@Override
	public String getName() throws RemoteException {
		return _name;
	}

}