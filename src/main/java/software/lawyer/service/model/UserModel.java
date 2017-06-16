package software.lawyer.service.model;

import java.util.Date;

import software.lawyer.data.dataobject.Dept;

/**
 * @author Administrator
 *
 */
public class UserModel {
	private String userId;
	private String userName;
	private String password;
	private Integer state;
	private String createBy;
	private String createDept;
	//private Date createTime;
	private String updateBy;
	//private Date updateTime;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDept() {
		return createDept;
	}
	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}
	/*public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}*/
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
/*	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}*/
	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", state=" + state + ", createBy="
				+ createBy + ", createDept=" + createDept + ", updateBy="
				+ updateBy + "]";
	}
	
}
