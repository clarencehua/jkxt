package software.lawyer.data.dataobject;
// default package

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
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Dept entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dept_p", catalog = "jkxt")
public class Dept implements java.io.Serializable {

	// Fields

	private String deptId;
	private Dept dept;
	private String deptName;
	private Integer state;
	private Set<Dept> depts = new HashSet<Dept>(0);
	private Set<User> userPs = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public Dept() {
	}

	/** full constructor */
	public Dept(Dept dept, String deptName, Integer state, Set<Dept> depts,
			Set<User> userPs) {
		this.dept = dept;
		this.deptName = deptName;
		this.state = state;
		this.depts = depts;
		this.userPs = userPs;
	}

	// Property accessors
	@Id
	@Column(name = "DEPT_ID", unique = true, nullable = false, length = 40)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Column(name = "DEPT_NAME", length = 40)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "STATE")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dept")
	public Set<Dept> getDepts() {
		return this.depts;
	}

	public void setDepts(Set<Dept> depts) {
		this.depts = depts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dept")
	public Set<User> getUserPs() {
		return this.userPs;
	}

	public void setUserPs(Set<User> userPs) {
		this.userPs = userPs;
	}

}