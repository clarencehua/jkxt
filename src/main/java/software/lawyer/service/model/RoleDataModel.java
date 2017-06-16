package software.lawyer.service.model;

import java.util.List;

import software.lawyer.service.model.base.BaseDataTablesModel;

public class RoleDataModel extends BaseDataTablesModel{
	private List<RoleModel> data;

	public List<RoleModel> getData() {
		return data;
	}

	public void setData(List<RoleModel> data) {
		this.data = data;
	}
	
	
}
