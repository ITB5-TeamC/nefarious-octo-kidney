package at.fhv.itb5c.ejb.interfaces;

import javax.ejb.Remote;

import at.fhv.itb5c.commons.dto.UserDTO;

@Remote
public interface GetByIdUserRemote {
	UserDTO getUserById(String sessionId, Long id);
}
