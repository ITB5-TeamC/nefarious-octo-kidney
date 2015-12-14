package at.fhv.itb5c.commons.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {
	protected Long _id;
	protected Long _version;

	public Long getId() {
		return _id;
	}

	public void setId(Long id) {
		_id = id;
	}

	public Long getVersion() {
		return _version;
	}

	public void setVersion(Long version) {
		_version = version;
	}

}
