package software.lawyer.service;

import java.io.Serializable;
import java.util.List;

import software.lawyer.data.dataobject.Dept;
import software.lawyer.service.model.WzDataTablesModel;
import software.lawyer.service.model.base.PageResult;

public interface DeptService {
	// 新增
	public void save(Dept entity);

	// 更新
	public void update(Dept entity);

	// 根据id删除
	public void delete(Serializable id);

	// 根据id查找
	public Dept findObjectById(Serializable id);

	// 查找列表
	public List<Dept> findObjects();
	
	public PageResult getWzPageList( String start, String pageLength);
}
