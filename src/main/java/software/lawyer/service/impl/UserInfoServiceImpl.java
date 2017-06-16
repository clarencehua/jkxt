package software.lawyer.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import software.lawyer.data.dao.UserInfoDao;
import software.lawyer.data.dataobject.UserInfo;
import software.lawyer.service.UserInfoService;
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
	@Resource
	private UserInfoDao userInfoDao;
	
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public void save(UserInfo entity) {
		userInfoDao.save(entity);
	}

	@Override
	public void update(UserInfo entity) {
		userInfoDao.update(entity);
	}

	@Override
	public void delete(Serializable id) {
		userInfoDao.delete(id);
	}

	@Override
	public UserInfo findObjectById(Serializable id) {
		return userInfoDao.findObjectById(id);
	}

	@Override
	public List<UserInfo> findObjects() {
		return userInfoDao.findObjects();
	}

}
