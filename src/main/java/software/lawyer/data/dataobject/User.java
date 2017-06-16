package software.lawyer.data.dataobject;
// default package

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_p", catalog = "jkxt")
public class User implements java.io.Serializable {

	// Fields

	private String userId;
	private Dept dept;
	private String userName;
	private String password;
	private Integer state;
	private String createBy;
	private String createDept;
	private Date createTime;
	private String updateBy;
	private Date updateTime;
	private Set<RoleUser> roleUserPs = new HashSet<RoleUser>(0);//一个用户对应多的用户角色
	private Set<UserInfo> userInfo = new HashSet<UserInfo>(0);//一个用户有一个用户信息
//	private UserInfo userInfo;
	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userId, Date createTime, Date updateTime) {
		this.userId = userId;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public User(String userId, Dept dept, String userName, String password,
			Integer state, String createBy, String createDept, Date createTime,
			String updateBy, Date updateTime, Set<RoleUser> roleUserPs,
			Set<UserInfo> userInfoPs) {
		this.userId = userId;
		this.dept = dept;
		this.userName = userName;
		this.password = password;
		this.state = state;
		this.createBy = createBy;
		this.createDept = createDept;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.roleUserPs = roleUserPs;
		this.userInfo = userInfoPs;
	}

	// Property accessors
	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, length = 40)
	/*@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")*/
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPT_ID")
	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Column(name = "USER_NAME", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD", length = 64)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "STATE")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "CREATE_BY", length = 40)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "CREATE_DEPT", length = 40)
	public String getCreateDept() {
		return this.createDept;
	}

	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}

	@Column(name = "CREATE_TIME", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "UPDATE_BY", length = 40)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "UPDATE_TIME", nullable = false, length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<RoleUser> getRoleUserPs() {
		return this.roleUserPs;
	}

	public void setRoleUserPs(Set<RoleUser> roleUserPs) {
		this.roleUserPs = roleUserPs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserInfo> getUserInfoPs() {
		return this.userInfo;
	}

	public void setUserInfoPs(Set<UserInfo> userInfo) {
		this.userInfo = userInfo;
	}

}