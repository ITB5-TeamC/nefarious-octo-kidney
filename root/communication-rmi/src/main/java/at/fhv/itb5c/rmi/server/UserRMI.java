package at.fhv.itb5c.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.Set;

import at.fhv.itb5c.commons.dto.IDepartment;
import at.fhv.itb5c.commons.dto.rmi.IDepartmentRMI;
import at.fhv.itb5c.commons.dto.rmi.IUserRMI;
import at.fhv.itb5c.commons.enums.Gender;
import at.fhv.itb5c.commons.enums.TypeOfSport;
import at.fhv.itb5c.commons.enums.UserRole;

public class UserRMI extends UnicastRemoteObject implements IUserRMI {
	private static final long serialVersionUID = 1L;
	
	private Long _id;
	private Long _version;
	private String _firstName;
	private String _lastName;
	private String _email;
	private String _telephoneNumber;
	private Gender _gender;
	private String _address;
	private LocalDate _dateOfBirth;
	private double _membershipFee;
	private Set<UserRole> _roles;
	private Set<TypeOfSport> _typeOfSports;
	private IDepartmentRMI _department;
	private boolean _membershipFeePaid;

	protected UserRMI() throws RemoteException {
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
		_telephoneNumber =telephoneNumber;
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
	public double getMembershipFee() throws RemoteException {
		return _membershipFee;
	}

	@Override
	public void setMembershipFee(double membershipFee) throws RemoteException {
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
	public Long getId() throws RemoteException {
		return _id;
	}

	@Override
	public Long getVersion() throws RemoteException {
		return _version;
	}

	@Override
	public void setId(Long id) throws RemoteException {
		_id = id;
	}

	@Override
	public void setVersion(Long version) throws RemoteException {
		_version = version;
	}

	@Override
	public boolean getMembershipFeePaid() throws RemoteException {
		return _membershipFeePaid;
	}

	@Override
	public void setMembershipFeePaid(boolean membershipFeePaid) throws RemoteException {
		_membershipFeePaid = membershipFeePaid;
	}

	@Override
	public IDepartmentRMI getDepartment() throws RemoteException {
		return _department;
	}

	@Override
	public void setDepartment(IDepartment department) throws RemoteException {
		if(department instanceof IDepartmentRMI) {
			_department = (IDepartmentRMI) department;
		} else {
			_department = DepartmentConverterRMI.toRMI(department);
		}
	}
}
