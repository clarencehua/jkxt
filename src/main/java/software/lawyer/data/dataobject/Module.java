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
 * Module entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "module_p", catalog = "jkxt")
public class Module implements java.io.Serializable {

	// Fields

	private String moduleId;
	private String parentId;
	private String parentName;
	private String name;
	private Integer layerNum;
	private Integer isLeaf;
	private String ico;
	private String cpermission;
	private String curl;
	private Integer ctype;
	private Integer state;
	private String belong;
	private String cwhich;
	private Integer quoteNum;
	private String remark;
	private Integer orderNo;
	private String createBy;
	private String createDept;
	private Date createTime;
	private String updateBy;
	private Date updateTime;
	private Set<RoleModule> roleModulePs = new HashSet<RoleModule>(0);

	// Constructors

	/** default constructor */
	public Module() {
	}

	/** minimal constructor */
	public Module(Date createTime, Date updateTime) {
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public Module(String parentId, String parentName, String name,
			Integer layerNum, Integer isLeaf, String ico, String cpermission,
			String curl, Integer ctype, Integer state, String belong,
			String cwhich, Integer quoteNum, String remark, Integer orderNo,
			String createBy, String createDept, Date createTime,
			String updateBy, Date updateTime, Set<RoleModule> roleModulePs) {
		this.parentId = parentId;
		this.parentName = parentName;
		this.name = name;
		this.layerNum = layerNum;
		this.isLeaf = isLeaf;
		this.ico = ico;
		this.cpermission = cpermission;
		this.curl = curl;
		this.ctype = ctype;
		this.state = state;
		this.belong = belong;
		this.cwhich = cwhich;
		this.quoteNum = quoteNum;
		this.remark = remark;
		this.orderNo = orderNo;
		this.createBy = createBy;
		this.createDept = createDept;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.roleModulePs = roleModulePs;
	}

	// Property accessors
	@Id
	@Column(name = "MODULE_ID", unique = true, nullable = false, length = 40)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	@Column(name = "PARENT_ID", length = 40)
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "PARENT_NAME", length = 100)
	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "LAYER_NUM")
	public Integer getLayerNum() {
		return this.layerNum;
	}

	public void setLayerNum(Integer layerNum) {
		this.layerNum = layerNum;
	}

	@Column(name = "IS_LEAF")
	public Integer getIsLeaf() {
		return this.isLeaf;
	}

	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}

	@Column(name = "ICO", length = 20)
	public String getIco() {
		return this.ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	@Column(name = "CPERMISSION", length = 20)
	public String getCpermission() {
		return this.cpermission;
	}

	public void setCpermission(String cpermission) {
		this.cpermission = cpermission;
	}

	@Column(name = "CURL", length = 200)
	public String getCurl() {
		return this.curl;
	}

	public void setCurl(String curl) {
		this.curl = curl;
	}

	@Column(name = "CTYPE")
	public Integer getCtype() {
		return this.ctype;
	}

	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}

	@Column(name = "STATE")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "BELONG", length = 100)
	public String getBelong() {
		return this.belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	@Column(name = "CWHICH", length = 20)
	public String getCwhich() {
		return this.cwhich;
	}

	public void setCwhich(String cwhich) {
		this.cwhich = cwhich;
	}

	@Column(name = "QUOTE_NUM")
	public Integer getQuoteNum() {
		return this.quoteNum;
	}

	public void setQuoteNum(Integer quoteNum) {
		this.quoteNum = quoteNum;
	}

	@Column(name = "REMARK", length = 100)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "module")
	public Set<RoleModule> getRoleModulePs() {
		return this.roleModulePs;
	}

	public void setRoleModulePs(Set<RoleModule> roleModulePs) {
		this.roleModulePs = roleModulePs;
	}

}