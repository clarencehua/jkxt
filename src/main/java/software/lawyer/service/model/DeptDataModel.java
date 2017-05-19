package software.lawyer.service.model;

import java.util.List;

import software.lawyer.service.model.base.BaseDataTablesModel;

public class DeptDataModel extends BaseDataTablesModel{
	private List<DeptModel> data;

	public List<DeptModel> getList() {
		return data;
	}

	public void setList(List<DeptModel> list) {
		this.data = list;
	}
	
}
