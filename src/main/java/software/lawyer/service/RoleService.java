package software.lawyer.service;

import java.io.Serializable;
import java.util.List;

import software.lawyer.data.dataobject.Role;
import software.lawyer.service.model.base.PageResult;

public interface RoleService {
	// 新增
	public void save(Role entity);

	// 更新
	public void update(Role entity);

	// 根据id删除
	public void delete(Serializable id);

	// 根据id查找
	public Role findObjectById(Serializable id);

	// 查找列表
	public List<Role> findObjects();

	public PageResult getWzPageList(String start, String pageLength);

	// 查找有效的部门
	public List<Role> findVaildRole();

	// Role根据id删除
	public void deleteById(Serializable id);
}
