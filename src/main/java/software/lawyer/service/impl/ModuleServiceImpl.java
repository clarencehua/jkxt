package software.lawyer.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import software.lawyer.data.dao.ModuleDao;
import software.lawyer.data.dataobject.Module;
import software.lawyer.service.ModuleService;
import software.lawyer.service.model.base.PageResult;
import software.lawyer.util.QueryHelper;
@Service("moduleService")
public class ModuleServiceImpl implements ModuleService{
	@Resource
	private ModuleDao moduleDao;
	public void setModuleDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}

	
	public void save(Module entity) {
		moduleDao.save(entity);
	}


	public void update(Module entity) {
		moduleDao.update(entity);
	}

	public void delete(Serializable id) {
		moduleDao.delete(id);
	}


	public Module findObjectById(Serializable id) {
		return moduleDao.findObjectById(id);
	}


	public List<Module> findObjects() {
		return moduleDao.findObjects();
	}

	public PageResult getWzPageList(String start, String pageLength) {
		QueryHelper queryHelper=new QueryHelper(Module.class, "i");
		queryHelper.addOrderByProperty("i.createTime", QueryHelper.ORDER_BY_DESC);
		PageResult pageResult=moduleDao.getPageResult(queryHelper, Integer.parseInt(start), Integer.parseInt(pageLength));
		return pageResult;
	}


	@Override
	public List<Module> findVaildModule() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	

}
