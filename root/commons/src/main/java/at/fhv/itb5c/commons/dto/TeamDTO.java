package at.fhv.itb5c.commons.dto;

import java.util.Map;
import java.util.Set;

import at.fhv.itb5c.commons.enums.TeamInvitationStatus;
import at.fhv.itb5c.commons.enums.TypeOfSport;

public class TeamDTO extends BaseDTO {
	private String _name;
	private TypeOfSport _typeOfSport;
	private Long _departmentId;
	private Long _coachId;
	private Long _leagueId;
	private Set<Long> _memberIds;
	private Map<Long, TeamInvitationStatus> _memberStatus;

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public TypeOfSport getTypeOfSport() {
		return _typeOfSport;
	}

	public void setTypeOfSport(TypeOfSport typeOfSport) {
		_typeOfSport = typeOfSport;
	}

	public Long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		_departmentId = departmentId;
	}

	public Long getCoachId() {
		return _coachId;
	}

	public void setCoachId(Long coachId) {
		_coachId = coachId;
	}

	public Long getLeagueId() {
		return _leagueId;
	}

	public void setLeagueId(Long leagueId) {
		_leagueId = leagueId;
	}

	public Set<Long> getMemberIds() {
		return _memberIds;
	}

	public void setMemberIds(Set<Long> memberIds) {
		_memberIds = memberIds;
	}
	
	public Map<Long, TeamInvitationStatus> getMemberStatus() {
		return _memberStatus;
	}

	public void setMemberStatus(Map<Long, TeamInvitationStatus> memberStatus) {
		_memberStatus = memberStatus;
	}
	
	/**
	 * @param userId must be contained in {@link #_memberIds}
	 * @param status null = undefined, true = accepted, false = declined
	 */
	public void setMemberStatus(Long userID, TeamInvitationStatus status) {
		if(_memberIds.contains(userID)) {
			_memberStatus.put(userID, status);
		}
	}
}
