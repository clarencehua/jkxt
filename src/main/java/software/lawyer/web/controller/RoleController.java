package software.lawyer.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import software.lawyer.data.dataobject.Role;
import software.lawyer.service.RoleService;
import software.lawyer.service.convertor.RoleDataModelConvertor;
import software.lawyer.service.model.RoleCustom;
import software.lawyer.service.model.RoleDataModel;
import software.lawyer.service.model.base.PageResult;
import software.lawyer.util.DateUtil;
import software.lawyer.web.ResponseBuilder;

@Controller
@RequestMapping("/sysadmin")
public class RoleController {
	private static Logger logger = Logger.getLogger(RoleController.class);
	public static String Role = "sysadmin/role/";
	@Resource
	private RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}
	@RequestMapping(value = "roleAction_list.do", method = RequestMethod.GET)
	public String list(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return Role + "jRoleList";
	}
	
	@RequestMapping(value = "getDataTablesRole.aj", method = RequestMethod.POST)
	public void getDataTablesDept(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String pageLength = request.getParameter("pageLength");
		String start = request.getParameter("start");
		PageResult pageResult = roleService.getWzPageList(start, pageLength);

		RoleDataModelConvertor convertor = new RoleDataModelConvertor();
		@SuppressWarnings("unchecked")
		List<Role> users = pageResult.getItems();
		RoleDataModel dataModel = convertor.roleDoConvetor(users);
		dataModel.setRecordsFiltered((int) pageResult.getTotalCount());
		dataModel.setRecordsTotal((int) pageResult.getTotalCount());
		try {
			new ResponseBuilder().writeJsonResponse(response, dataModel);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 查看部门 deptAction_toview deptAction_toview.do
	@RequestMapping(value = "roleAction_toview.do", method = RequestMethod.POST)
	public String toview(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String id = request.getParameter("id");
		Role role=roleService.findObjectById(id);
		model.addAttribute("role", role);
		return Role + "jRoleView";
	}
	//roleAction_tocreate.do
	@RequestMapping(value = "roleAction_tocreate.do", method = RequestMethod.POST)
	public String tocreate(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
	
		return Role + "jRoleCreate";
	}
	//roleAction_insert.do
	@RequestMapping(value = "roleAction_insert.do", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,
			HttpServletResponse response, RoleCustom roleCustom) {
		Role role=roleCustom.getRole();
		role.setCreateTime(DateUtil.today());
		role.setUpdateTime(DateUtil.today());
		roleService.save(role);
		return "redirect:roleAction_list.do";
	}
	//RoleAction_toupdate.do
	@RequestMapping(value = "RoleAction_toupdate.do", method = RequestMethod.POST)
	public String toupdate(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String id = request.getParameter("id");
		Role role=roleService.findObjectById(id);
		model.addAttribute("role", role);
		return Role + "jRoleUpdate";
	}
	//roleAction_update.do
	@RequestMapping(value = "roleAction_update.do", method = RequestMethod.POST)
	public String update(HttpServletRequest request,
			HttpServletResponse response, RoleCustom roleCustom) {
		Role role=roleCustom.getRole();
		Role obj=roleService.findObjectById(roleCustom.getRole().getRoleId());
		obj.setName(role.getName());
		obj.setRemark(role.getRemark());
		roleService.update(obj);
		return "redirect:roleAction_list.do";
	}
	
	@RequestMapping(value = "roleAction_delete.do", method = RequestMethod.POST)
	public String delete(HttpServletRequest request,
			HttpServletResponse response){
		String str[]=request.getParameterValues("id");
		for (String string : str) {
			roleService.delete(string);
		}
		return "redirect:roleAction_list.do";
	}
	
	
}
