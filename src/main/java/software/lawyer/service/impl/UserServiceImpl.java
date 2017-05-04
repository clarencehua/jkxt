package software.lawyer.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import software.lawyer.data.dao.UserDao;
import software.lawyer.data.dataobject.Userb;
import software.lawyer.service.UserService;

/**
 * �û�Service
 * @author wzq
 * 2015-7-5
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void save(Userb userb) {
		userDao.save(userb);
	}

	
}
