package software.lawyer.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import software.lawyer.data.dao.RoleDao;
import software.lawyer.data.dataobject.Role;
import software.lawyer.service.RoleService;
import software.lawyer.service.model.base.PageResult;
import software.lawyer.util.QueryHelper;
@Service("roleService")
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleDao roleDao;
	
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public void save(Role entity) {
		roleDao.save(entity);
	}

	@Override
	public void update(Role entity) {
		roleDao.update(entity);
	}

	@Override
	public void delete(Serializable id) {
		roleDao.delete(id);
	}

	@Override
	public Role findObjectById(Serializable id) {

		return roleDao.findObjectById(id);
	}

	@Override
	public List<Role> findObjects() {
		return roleDao.findObjects();
	}

	@Override
	public PageResult getWzPageList(String start, String pageLength) {
		QueryHelper queryHelper=new QueryHelper(Role.class, "i");
		queryHelper.addOrderByProperty("i.createTime", QueryHelper.ORDER_BY_DESC);
		PageResult pageResult=roleDao.getPageResult(queryHelper, Integer.parseInt(start), Integer.parseInt(pageLength));
		return pageResult;
	}

	@Override
	public List<Role> findVaildRole() {
		QueryHelper queryHelper=new QueryHelper(Role.class, "i");
		queryHelper.addCondition("i.state=?", 1);
		
		return roleDao.findObjects(queryHelper);
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		
	}

}
