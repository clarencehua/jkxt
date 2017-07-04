package software.lawyer.data.dao.impl;

import java.util.List;

import software.lawyer.data.dao.UserDao;
import software.lawyer.data.dataobject.User;
//@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User findUserByUserName(String username) {
		String hql = "from User where userName=?";
		List<User> list=this.getHibernateTemplate().find(hql,username);
		if(list!=null && list.size()>0){
			User user = list.get(0);
			return user;
			}
		else {
			return null;
		}
	}


	/*public void save(Userb userb) {
		getHibernateTemplate().save(userb);
	}*/

}
