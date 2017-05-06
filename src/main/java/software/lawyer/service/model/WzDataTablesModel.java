package software.lawyer.service.model;

import java.util.List;

import software.lawyer.service.model.base.BaseDataTablesModel;

public class WzDataTablesModel extends BaseDataTablesModel{
	
	private List<DeptModel> data;

	public List<DeptModel> getData() {
		return data;
	}

	public void setData(List<DeptModel> data) {
		this.data = data;
	}

}
