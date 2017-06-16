package software.lawyer.data.dataobject;
// default package

import java.util.Date;
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
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="user_info_p"
    ,catalog="jkxt"
)

public class UserInfo  implements java.io.Serializable {


    // Fields    

     private String userInfoId;
     private User user;
     private String name;
     private Date joinDate;
     private double salary;
     private Date birthday;
     private String gender;
     private String station;
     private String telephone;
     private Integer degree;
     private String remark;
     private Integer orderNo;
     private String createBy;
     private String createDept;
     private Date createTime;
     private String updateBy;
     private Date updateTime;


    // Constructors

    /** default constructor */
    public UserInfo() {
    }

	/** minimal constructor */
    public UserInfo(String userInfoId, Date joinDate, Date birthday, Date createTime, Date updateTime) {
        this.userInfoId = userInfoId;
        this.joinDate = joinDate;
        this.birthday = birthday;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public UserInfo(String userInfoId, User user, String name, Date joinDate, double salary, Date birthday, String gender, String station, String telephone, Integer degree, String remark, Integer orderNo, String createBy, String createDept, Date createTime, String updateBy, Date updateTime) {
        this.userInfoId = userInfoId;
        this.user = user;
        this.name = name;
        this.joinDate = joinDate;
        this.salary = salary;
        this.birthday = birthday;
        this.gender = gender;
        this.station = station;
        this.telephone = telephone;
        this.degree = degree;
        this.remark = remark;
        this.orderNo = orderNo;
        this.createBy = createBy;
        this.createDept = createDept;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

   
    // Property accessors
    @Id 
    @Column(name="USER_INFO_ID", unique=true, nullable=false, length=40)
  /*  @GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")*/
    public String getUserInfoId() {
        return this.userInfoId;
    }
    
    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="MANAGER_ID")

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Column(name="NAME", length=20)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="JOIN_DATE", nullable=false, length=19)

    public Date getJoinDate() {
        return this.joinDate;
    }
    
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
    
    @Column(name="SALARY", precision=8)

    public double getSalary() {
        return this.salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Column(name="BIRTHDAY", nullable=false, length=19)

    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    @Column(name="GENDER", length=1)

    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Column(name="STATION", length=20)

    public String getStation() {
        return this.station;
    }
    
    public void setStation(String station) {
        this.station = station;
    }
    
    @Column(name="TELEPHONE", length=100)

    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    @Column(name="DEGREE")

    public Integer getDegree() {
        return this.degree;
    }
    
    public void setDegree(Integer degree) {
        this.degree = degree;
    }
    
    @Column(name="REMARK", length=600)

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Column(name="ORDER_NO")

    public Integer getOrderNo() {
        return this.orderNo;
    }
    
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
    
    @Column(name="CREATE_BY", length=40)

    public String getCreateBy() {
        return this.createBy;
    }
    
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    
    @Column(name="CREATE_DEPT", length=40)

    public String getCreateDept() {
        return this.createDept;
    }
    
    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }
    
    @Column(name="CREATE_TIME", nullable=false, length=19)

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="UPDATE_BY", length=40)

    public String getUpdateBy() {
        return this.updateBy;
    }
    
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    
    @Column(name="UPDATE_TIME", nullable=false, length=19)

    public Date getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
   








}