package software.lawyer.service;

import java.io.Serializable;
import java.util.List;

import software.lawyer.data.dataobject.UserInfo;

public interface UserInfoService {
	// 新增
	public void save(UserInfo entity);

	// 更新
	public void update(UserInfo entity);

	// 根据id删除
	public void delete(Serializable id);

	// 根据id查找
	public UserInfo findObjectById(Serializable id);

	// 查找列表
	public List<UserInfo> findObjects();
}
