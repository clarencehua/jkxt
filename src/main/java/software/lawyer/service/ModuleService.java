package software.lawyer.service;

import java.io.Serializable;
import java.util.List;

import software.lawyer.data.dataobject.Module;
import software.lawyer.service.model.base.PageResult;

public interface ModuleService {
		// 新增
		public void save(Module entity);

		// 更新
		public void update(Module entity);

		// 根据id删除
		public void delete(Serializable id);

		// 根据id查找
		public Module findObjectById(Serializable id);

		// 查找列表
		public List<Module> findObjects();

		public PageResult getWzPageList(String start, String pageLength);

		// 查找有效的部门
		public List<Module> findVaildModule();

		// Module根据id删除
		public void deleteById(Serializable id);
}
