package software.lawyer.data.dataobject;
// default package

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RoleModuleId entity. @author MyEclipse Persistence Tools
 */

public class RoleModuleId implements java.io.Serializable {

	// Fields

	private String moduleId;
	private String roleId;

	// Constructors

	/** default constructor */
	public RoleModuleId() {
	}

	/** full constructor */
	public RoleModuleId(String moduleId, String roleId) {
		this.moduleId = moduleId;
		this.roleId = roleId;
	}

	// Property accessors

	@Column(name = "MODULE_ID", nullable = false, length = 40)
	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	@Column(name = "ROLE_ID", nullable = false, length = 40)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoleModuleId))
			return false;
		RoleModuleId castOther = (RoleModuleId) other;

		return ((this.getModuleId() == castOther.getModuleId()) || (this
				.getModuleId() != null && castOther.getModuleId() != null && this
				.getModuleId().equals(castOther.getModuleId())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this
						.getRoleId() != null && castOther.getRoleId() != null && this
						.getRoleId().equals(castOther.getRoleId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getModuleId() == null ? 0 : this.getModuleId().hashCode());
		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		return result;
	}

}