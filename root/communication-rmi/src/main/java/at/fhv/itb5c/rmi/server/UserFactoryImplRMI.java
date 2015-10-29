package at.fhv.itb5c.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import at.fhv.itb5c.application.controller.UserFactoryImpl;
import at.fhv.itb5c.commons.dto.IUser;
import at.fhv.itb5c.commons.dto.rmi.IUserFactoryRMI;
import at.fhv.itb5c.commons.dto.rmi.IUserRMI;

public class UserFactoryImplRMI extends UnicastRemoteObject implements IUserFactoryRMI {
	private static final long serialVersionUID = 1L;
	private UserFactoryImpl _factory;

	protected UserFactoryImplRMI() throws RemoteException {
		super();
		_factory = new UserFactoryImpl();
	}

	@Override
	public IUserRMI createUser() {
		return (IUserRMI) _factory.createUser();
	}

	@Override
	public void save(IUser user) {
		_factory.save((IUserRMI) user);
	}
}