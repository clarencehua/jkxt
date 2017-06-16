package software.lawyer.service.model;

import java.util.List;

import software.lawyer.service.model.base.BaseDataTablesModel;

public class ModuleDataModel extends BaseDataTablesModel{
	private List<ModuleModel> data;

	public List<ModuleModel> getData() {
		return data;
	}

	public void setData(List<ModuleModel> data) {
		this.data = data;
	}
	
}
