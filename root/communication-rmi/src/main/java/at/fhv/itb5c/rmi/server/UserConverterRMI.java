package at.fhv.itb5c.rmi.server;

import java.rmi.RemoteException;

import at.fhv.itb5c.application.dto.UserDTO;
import at.fhv.itb5c.commons.dto.IUser;
import at.fhv.itb5c.commons.dto.rmi.IUserRMI;
import at.fhv.itb5c.logging.ILogger;

public class UserConverterRMI implements ILogger {
	public static IUserRMI toRMI(IUser user) {
		IUserRMI userrmi = null;
		try {
			userrmi = new UserRMI();
		} catch (RemoteException e) {
			log.error(e.getMessage());
		}

		if (user != null) {
			try {
				userrmi.setAddress(user.getAddress());
				userrmi.setDateOfBirth(user.getDateOfBirth());
				userrmi.setEmail(user.getEmail());
				userrmi.setFirstName(user.getFirstName());
				userrmi.setLastName(user.getLastName());
				userrmi.setGender(user.getGender());
				userrmi.setMembershipFee(user.getMembershipFee());
				userrmi.setRoles(user.getRoles());
				userrmi.setTelephoneNumber(user.getTelephoneNumber());
				userrmi.setTypeOfSports(user.getTypeOfSports());
			} catch (Exception e) {
				log.error(e.getMessage());
			}

		}

		return userrmi;
	}

	public static IUser toDTO(IUserRMI userrmi) {
		IUser user = new UserDTO();

		if (userrmi != null) {
			try {
				user.setAddress(userrmi.getAddress());
				user.setDateOfBirth(userrmi.getDateOfBirth());
				user.setEmail(userrmi.getEmail());
				user.setFirstName(userrmi.getFirstName());
				user.setLastName(userrmi.getLastName());
				user.setGender(userrmi.getGender());
				user.setMembershipFee(userrmi.getMembershipFee());
				user.setRoles(userrmi.getRoles());
				user.setTelephoneNumber(userrmi.getTelephoneNumber());
				user.setTypeOfSports(userrmi.getTypeOfSports());
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}

		return user;
	}
}