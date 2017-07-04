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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role_p", catalog = "jkxt")
public class Role implements java.io.Serializable {

	// Fields

	private String roleId;
	private String name;
	private String remark;
	private Integer orderNo;
	private String createBy;
	private String createDept;
	private Date createTime;
	private String updateBy;
	private Date updateTime;
	private Set<RoleUser> roleUsers = new HashSet<RoleUser>(0);
	private Set<RoleModule> roleModulePs = new HashSet<RoleModule>(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(Date createTime, Date updateTime) {
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public Role(String name, String remark, Integer orderNo, String createBy,
			String createDept, Date createTime, String updateBy,
			Date updateTime, Set<RoleUser> roleUsers,
			Set<RoleModule> roleModulePs) {
		this.name = name;
		this.remark = remark;
		this.orderNo = orderNo;
		this.createBy = createBy;
		this.createDept = createDept;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.roleUsers = roleUsers;
		this.roleModulePs = roleModulePs;
	}

	// Property accessors
	@Id
	@Column(name = "ROLE_ID", unique = true, nullable = false, length = 40)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "NAME", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "REMARK", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "ORDER_NO")
	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
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
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<RoleUser> getRoleUsers() {
		return roleUsers;
	}

	public void setRoleUsers(Set<RoleUser> roleUsers) {
		this.roleUsers = roleUsers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "role")
	public Set<RoleModule> getRoleModulePs() {
		return this.roleModulePs;
	}

	public void setRoleModulePs(Set<RoleModule> roleModulePs) {
		this.roleModulePs = roleModulePs;
	}

}