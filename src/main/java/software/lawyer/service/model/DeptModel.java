package software.lawyer.service.model;

import software.lawyer.data.dataobject.Dept;

public class DeptModel {
	private String deptId;
	private String deptName;
	private Integer state;
	private String fdeptId;
	private String fdeptName;
	private Integer fstate;
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getFdeptId() {
		return fdeptId;
	}
	public void setFdeptId(String fdeptId) {
		this.fdeptId = fdeptId;
	}
	public String getFdeptName() {
		return fdeptName;
	}
	public void setFdeptName(String fdeptName) {
		this.fdeptName = fdeptName;
	}
	public Integer getFstate() {
		return fstate;
	}
	public void setFstate(Integer fstate) {
		this.fstate = fstate;
	}
	
}
