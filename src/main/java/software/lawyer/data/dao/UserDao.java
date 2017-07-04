package software.lawyer.data.dao;

import software.lawyer.data.dataobject.User;

public interface UserDao extends BaseDao<User> {
	//public void save(Userb userb);
	public User findUserByUserName(String username);
}
