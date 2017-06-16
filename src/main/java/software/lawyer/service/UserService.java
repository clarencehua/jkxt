package software.lawyer.service;

import java.io.Serializable;
import java.util.List;

import software.lawyer.data.dataobject.User;
import software.lawyer.service.model.base.PageResult;

public interface UserService {
	// 新增
	public void save(User entity);

	// 更新
	public void update(User entity);

	// 根据id删除
	public void delete(Serializable id);

	// 根据id查找
	public User findObjectById(Serializable id);

	// 查找列表
	public List<User> findObjects();

	public PageResult getWzPageList(String start, String pageLength);

	// 查找有效的部门
	public List<User> findVaildUser();

	// User根据id删除
	public void deleteById(Serializable id);
}
