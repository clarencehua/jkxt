package software.lawyer.data.dataobject;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RoleModule entity. @author MyEclipse Persistence Tools
 */
@IdClass(RoleModuleId.class)
@Entity
@Table(name = "role_module_p", catalog = "jkxt")
public class RoleModule implements java.io.Serializable {

	// Fields

	private Role role;
	private Module module;
	private String moduleId;
	private String roleId;
	
	public RoleModule(Role role, Module module, String moduleId, String roleId) {
		super();
		this.role = role;
		this.module = module;
		this.moduleId = moduleId;
		this.roleId = roleId;
	}



	// Constructors

	@Id
	@Column(name = "MODULE_ID", nullable = false, length = 40)
	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	@Id
	@Column(name = "ROLE_ID", nullable = false, length = 40)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}



	/** default constructor */
	public RoleModule() {
	}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", nullable = false, insertable = false, updatable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MODULE_ID", nullable = false, insertable = false, updatable = false)
	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}