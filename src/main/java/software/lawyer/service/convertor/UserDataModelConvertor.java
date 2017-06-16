package software.lawyer.service.convertor;

import java.util.ArrayList;
import java.util.List;

import software.lawyer.data.dataobject.User;
import software.lawyer.service.model.UserDataModel;
import software.lawyer.service.model.UserModel;
import software.lawyer.util.BeanUtilsEx;

public class UserDataModelConvertor {

	public UserDataModel userDoConvetor(
			List<User> users) {
		UserDataModel userDataModel=new UserDataModel();
		List<UserModel> userModels=new ArrayList<UserModel>();
		for (User user : users) {
			UserModel userModel=new UserModel();
			BeanUtilsEx.copyProperties(userModel, user);
			userModels.add(userModel);
		}
		userDataModel.setDate(userModels);
		return userDataModel;
	}

}
