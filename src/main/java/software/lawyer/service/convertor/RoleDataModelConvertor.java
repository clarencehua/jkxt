package software.lawyer.service.convertor;

import java.util.ArrayList;
import java.util.List;

import software.lawyer.data.dataobject.Role;
import software.lawyer.service.model.RoleDataModel;
import software.lawyer.service.model.RoleModel;
import software.lawyer.util.BeanUtilsEx;

public class RoleDataModelConvertor {

	public RoleDataModel roleDoConvetor(List<Role> roles) {
		RoleDataModel roleDataModel=new RoleDataModel();
		List<RoleModel> data=new ArrayList<RoleModel>();
		for (Role role : roles) {
			RoleModel roleModel=new RoleModel();
			BeanUtilsEx.copyProperties(roleModel, role);
			data.add(roleModel);
		}
		roleDataModel.setData(data);
		return roleDataModel;
	}

}
