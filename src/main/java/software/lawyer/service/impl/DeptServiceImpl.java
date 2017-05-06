package software.lawyer.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import software.lawyer.data.dao.DeptDao;
import software.lawyer.data.dataobject.Dept;
import software.lawyer.service.DeptService;
import software.lawyer.service.model.base.PageResult;
import software.lawyer.util.QueryHelper;
@Service("deptService")
public class DeptServiceImpl implements DeptService{
	@Resource
	private DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	public void save(Dept entity) {
		deptDao.save(entity);
	}

	public void update(Dept entity) {
		deptDao.update(entity);
	}

	public void delete(Serializable id) {
		deptDao.delete(id);
	}

	public Dept findObjectById(Serializable id) {
		return deptDao.findObjectById(id);
	}

	public List<Dept> findObjects() {
		return deptDao.findObjects();
	}

	public PageResult getWzPageList(String start, String pageLength) {
		QueryHelper queryHelper=new QueryHelper(Dept.class, "i");
		queryHelper.addOrderByProperty("i.state", QueryHelper.ORDER_BY_DESC);
		PageResult pageResult=deptDao.getPageResult(queryHelper, Integer.parseInt(start), Integer.parseInt(pageLength));
		
		return pageResult;
	}

}
