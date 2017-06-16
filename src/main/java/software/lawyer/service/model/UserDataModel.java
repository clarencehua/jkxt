package software.lawyer.service.model;

import java.util.List;

import software.lawyer.service.model.base.BaseDataTablesModel;

public class UserDataModel extends BaseDataTablesModel{
	private List<UserModel> data;

	public List<UserModel> getDate() {
		return data;
	}

	public void setDate(List<UserModel> date) {
		this.data = date;
	}
	
}
