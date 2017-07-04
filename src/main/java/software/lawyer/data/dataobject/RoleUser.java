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
 * RoleUser entity. @author MyEclipse Persistence Tools
 */
@IdClass(RoleUserId.class)
@Entity
@Table(name = "role_user_p", catalog = "jkxt")
public class RoleUser implements java.io.Serializable {

	// Fields

	private User user;
	private Role role;
	
	private String roleId;
	private String userId;
	public RoleUser(User user, Role role, String roleId, String userId) {
		super();
		this.user = user;
		this.role = role;
		this.roleId = roleId;
		this.userId = userId;
	}




	// Constructors
	@Id
	@Column(name = "ROLE_ID", nullable = false, length = 40)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Id
	@Column(name = "USER_ID", nullable = false, length = 40)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}



	/** default constructor */
	public RoleUser() {
	}

	


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID", nullable = false, insertable = false, updatable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}