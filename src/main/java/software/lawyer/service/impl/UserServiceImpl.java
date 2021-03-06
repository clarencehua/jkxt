package software.lawyer.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import software.lawyer.data.dao.UserDao;
import software.lawyer.data.dataobject.Dept;
import software.lawyer.data.dataobject.User;
import software.lawyer.service.UserService;
import software.lawyer.service.model.base.PageResult;
import software.lawyer.util.QueryHelper;

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
	public void save(User entity) {
		userDao.save(entity);
	}
	public void update(User entity) {
		userDao.update(entity);
	}
	public void delete(Serializable id) {
		userDao.delete(id);
	}
	public User findObjectById(Serializable id) {
		return userDao.findObjectById(id);
	}
	public List<User> findObjects() {
		return userDao.findObjects();
	}
	public PageResult getWzPageList(String start, String pageLength) {
		QueryHelper queryHelper=new QueryHelper(User.class, "i");
		queryHelper.addOrderByProperty("i.createTime", QueryHelper.ORDER_BY_DESC);
		PageResult pageResult=userDao.getPageResult(queryHelper, Integer.parseInt(start), Integer.parseInt(pageLength));
		return pageResult;
	}
	public List<User> findVaildUser() {
		QueryHelper queryHelper=new QueryHelper(User.class, "i");
		queryHelper.addCondition("i.state=?", 1);
		
		return userDao.findObjects(queryHelper);
	}
	public void deleteById(Serializable id) {
		
	}
	@Override
	public User findUserByUsername(String username) {
		return userDao.findUserByUserName(username);
	}

	
}
