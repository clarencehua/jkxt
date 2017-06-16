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

import software.lawyer.data.dataobject.Module;
import software.lawyer.data.dataobject.Role;
import software.lawyer.service.ModuleService;
import software.lawyer.service.convertor.ModuleDataModelConvertor;
import software.lawyer.service.model.ModuleCustom;
import software.lawyer.service.model.ModuleDataModel;
import software.lawyer.service.model.RoleCustom;
import software.lawyer.service.model.base.PageResult;
import software.lawyer.util.DateUtil;
import software.lawyer.web.ResponseBuilder;

@Controller
@RequestMapping("/sysadmin")
public class ModuleController {
	private static Logger logger = Logger.getLogger(ModuleController.class);
	public static String Module = "sysadmin/module/";
	@Resource
	private ModuleService moduleService;

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping(value = "moduleAction_list.do", method = RequestMethod.GET)
	public String list(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return Module + "jModuleList";
	}

	// getDataTablesModule
	@RequestMapping(value = "getDataTablesModule.aj", method = RequestMethod.POST)
	public void getDataTablesDept(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String pageLength = request.getParameter("pageLength");
		String start = request.getParameter("start");
		PageResult pageResult = moduleService.getWzPageList(start, pageLength);

		ModuleDataModelConvertor convertor = new ModuleDataModelConvertor();
		@SuppressWarnings("unchecked")
		List<Module> modules = pageResult.getItems();
		ModuleDataModel dataModel = convertor.moduleDoConvertor(modules);
		dataModel.setRecordsFiltered((int) pageResult.getTotalCount());
		dataModel.setRecordsTotal((int) pageResult.getTotalCount());
		try {
			new ResponseBuilder().writeJsonResponse(response, dataModel);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// moduleAction_toview.do
	@RequestMapping(value = "moduleAction_toview.do", method = RequestMethod.POST)
	public String toview(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String id = request.getParameter("id");
		Module module = moduleService.findObjectById(id);
		model.addAttribute("module", module);
		return Module + "jModuleView";
	}

	// roleAction_tocreate.do
	@RequestMapping(value = "moduleAction_tocreate.do", method = RequestMethod.POST)
	public String tocreate(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		return Module + "jModuleCreate";
	}

	// roleAction_insert.do
	@RequestMapping(value = "moduleAction_insert.do", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,
			HttpServletResponse response, ModuleCustom moduleCustom) {
		Module module = moduleCustom.getModule();
		module.setCreateTime(DateUtil.today());
		module.setUpdateTime(DateUtil.today());
		moduleService.save(module);
		return "redirect:moduleAction_list.do";
	}

	// roleAction_update.do
	@RequestMapping(value = "moduleAction_toupdate.do", method = RequestMethod.POST)
	public String update(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String id = request.getParameter("id");
		Module module = moduleService.findObjectById(id);
		model.addAttribute("module", module);
		return Module + "jModuleUpdate";
	}

	// roleAction_update.do
	@RequestMapping(value = "moduleAction_update.do", method = RequestMethod.POST)
	public String update(HttpServletRequest request,
			HttpServletResponse response, ModuleCustom moduleCustom) {
		Module model = moduleCustom.getModule();
		Module obj = moduleService.findObjectById(moduleCustom.getModule()
				.getModuleId());
		// 2.设置修改的属性
		obj.setName(model.getName());
		obj.setLayerNum(model.getLayerNum());
		obj.setCpermission(model.getCpermission());
		obj.setCurl(model.getCurl());
		obj.setCtype(model.getCtype());
		obj.setState(model.getState());
		obj.setBelong(model.getBelong());
		obj.setCwhich(model.getCwhich());
		obj.setRemark(model.getRemark());
		obj.setOrderNo(model.getOrderNo());
		moduleService.save(obj);
		return "redirect:moduleAction_list.do";
	}
	
	@RequestMapping(value = "moduleAction_delete.do", method = RequestMethod.POST)
	public String delete(HttpServletRequest request,
			HttpServletResponse response){
		String str[]=request.getParameterValues("id");
		for (String string : str) {
			moduleService.delete(string);
		}
		return "redirect:moduleAction_list.do";
	}

}
