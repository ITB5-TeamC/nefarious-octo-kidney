package at.fhv.itb5c.rmi.server.rmiclasses;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Set;

import at.fhv.itb5c.commons.dto.rmi.IUserRMI;
import at.fhv.itb5c.commons.enums.Gender;
import at.fhv.itb5c.commons.enums.TypeOfSport;
import at.fhv.itb5c.commons.enums.UserRole;

public class UserRMI extends BaseRMI implements IUserRMI {
	private static final long serialVersionUID = 1L;

	private String _firstName;
	private String _lastName;
	private String _email;
	private String _telephoneNumber;
	private Gender _gender;
	private String _address;
	private LocalDate _dateOfBirth;
	private Double _membershipFee;
	private Set<UserRole> _roles;
	private Set<TypeOfSport> _typeOfSports;
	private Boolean _membershipFeePaid;
	private Long _departmentId;
	private String _ldapUID;

	public UserRMI() throws RemoteException {
		super();
	}

	@Override
	public String getFirstName() throws RemoteException {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) throws RemoteException {
		_firstName = firstName;
	}

	@Override
	public String getLastName() throws RemoteException {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) throws RemoteException {
		_lastName = lastName;
	}

	@Override
	public String getEmail() throws RemoteException {
		return _email;
	}

	@Override
	public void setEmail(String email) throws RemoteException {
		_email = email;
	}

	@Override
	public String getTelephoneNumber() throws RemoteException {
		return _telephoneNumber;
	}

	@Override
	public void setTelephoneNumber(String telephoneNumber) throws RemoteException {
		_telephoneNumber = telephoneNumber;
	}

	@Override
	public Gender getGender() throws RemoteException {
		return _gender;
	}

	@Override
	public void setGender(Gender gender) throws RemoteException {
		_gender = gender;
	}

	@Override
	public String getAddress() throws RemoteException {
		return _address;
	}

	@Override
	public void setAddress(String address) throws RemoteException {
		_address = address;
	}

	@Override
	public LocalDate getDateOfBirth() throws RemoteException {
		return _dateOfBirth;
	}

	@Override
	public void setDateOfBirth(LocalDate dateOfBirth) throws RemoteException {
		_dateOfBirth = dateOfBirth;
	}

	@Override
	public Double getMembershipFee() throws RemoteException {
		return _membershipFee;
	}

	@Override
	public void setMembershipFee(Double membershipFee) throws RemoteException {
		_membershipFee = membershipFee;
	}

	@Override
	public Set<UserRole> getRoles() throws RemoteException {
		return _roles;
	}

	@Override
	public void setRoles(Set<UserRole> roles) throws RemoteException {
		_roles = roles;
	}

	@Override
	public Set<TypeOfSport> getTypeOfSports() throws RemoteException {
		return _typeOfSports;
	}

	@Override
	public void setTypeOfSports(Set<TypeOfSport> typeOfSports) throws RemoteException {
		_typeOfSports = typeOfSports;
	}

	@Override
	public Boolean getMembershipFeePaid() throws RemoteException {
		return _membershipFeePaid;
	}

	@Override
	public void setMembershipFeePaid(Boolean membershipFeePaid) throws RemoteException {
		_membershipFeePaid = membershipFeePaid;
	}

	@Override
	public Long getDepartmentId() throws RemoteException {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(Long departmentId) throws RemoteException {
		_departmentId = departmentId;
	}

	@Override
	public String getLdapUID() throws RemoteException {
		return _ldapUID;
	}

	@Override
	public void setLdapUID(String ldapUID) throws RemoteException {
		_ldapUID = ldapUID;
	}
}
