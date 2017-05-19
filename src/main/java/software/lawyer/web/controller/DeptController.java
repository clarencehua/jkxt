package software.lawyer.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import software.lawyer.data.dataobject.Dept;
import software.lawyer.service.DeptService;
import software.lawyer.service.convertor.DeptDataModelConvertor;
import software.lawyer.service.model.DeptCustom;
import software.lawyer.service.model.DeptDataModel;
import software.lawyer.service.model.base.PageResult;
import software.lawyer.util.UUIDGenerator;
import software.lawyer.web.ResponseBuilder;
@Controller
@RequestMapping("/sysadmin")
public class DeptController {
	private DeptService deptService;
	
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	private static Logger logger=Logger.getLogger(DeptController.class);
	public static String Dept="sysadmin/dept/"; 
	
	@RequestMapping(value = "deptAction_list.do", method = RequestMethod.GET)
	public String list(HttpServletRequest request,
			HttpServletResponse response, ModelMap model){
		return Dept+"jDeptList";
	}
	//getDataTablesDept.aj
	@RequestMapping(value = "getDataTablesDept.aj", method = RequestMethod.POST)
	public void getDataTablesDept(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String pageLength = request.getParameter("pageLength");
		String start = request.getParameter("start");
		PageResult pageResult= deptService.getWzPageList(start, pageLength);
		
		DeptDataModelConvertor convertor=new DeptDataModelConvertor();
		@SuppressWarnings("unchecked")
		List<Dept> depts=pageResult.getItems();
		DeptDataModel dataModel=convertor.deptDoConvetor(depts);
		dataModel.setRecordsFiltered((int)pageResult.getTotalCount());
		dataModel.setRecordsTotal((int)pageResult.getTotalCount());
		try {
			new  ResponseBuilder().writeJsonResponse(response, dataModel);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//查看部门 deptAction_toview deptAction_toview.do
	@RequestMapping(value = "deptAction_toview.do", method = RequestMethod.POST)
	public String toview(HttpServletRequest request,
			HttpServletResponse response, ModelMap model){
		String id=request.getParameter("id");
		Dept dept=deptService.findObjectById(id);
		model.addAttribute("dept", dept);
		return Dept+"jDeptView";
	}
	//deptAction_tocreate.do
	@RequestMapping(value = "deptAction_tocreate.do", method = RequestMethod.POST)
	public String tocreate(HttpServletRequest request,
			HttpServletResponse response, ModelMap model){
		List<Dept> deptList = deptService.findVaildDept(); 
		model.addAttribute("deptList", deptList);
		return Dept+"jDeptCreate";
	}
	//deptAction_insert.do insert 增加部门
	@RequestMapping(value = "deptAction_insert.do", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,
			HttpServletResponse response, DeptCustom deptCustom){
		Dept dept=deptCustom.getDept();
		//dept.setDeptId(UUIDGenerator.getUUID());
		deptService.save(dept);
		return "redirect:deptAction_list.do";
	}
	//toupdate() 修改 deptAction_toupdate.do
	@RequestMapping(value = "deptAction_toupdate.do", method = RequestMethod.POST)
	public String toupdate(HttpServletRequest request,
			HttpServletResponse response, ModelMap model){
		String id=request.getParameter("id");
		Dept dept=deptService.findObjectById(id);
		model.addAttribute("dept", dept);
		List<Dept> deptList = deptService.findVaildDept(); 
		model.addAttribute("deptList", deptList);
		return Dept+"jDeptUpdate";
	}
	//保存修改
	@RequestMapping(value = "deptAction_update.do", method = RequestMethod.POST)
	public String update(HttpServletRequest request,
			HttpServletResponse response,DeptCustom deptCustom){
		Dept dept=deptService.findObjectById(deptCustom.getDept().getDeptId());
		String parentid=deptCustom.getDept().getDept().getDeptId();
		String deptname=deptCustom.getDept().getDeptName();
		dept.setDeptName(deptname);
		Dept dept2=new Dept();
		dept2.setDeptId(parentid);
		dept.setDept(dept2);
		deptService.update(dept);
		return "redirect:deptAction_list.do";
	}
	//删除部门 deptAction_delete.do
	@RequestMapping(value = "deptAction_delete.do", method = RequestMethod.POST)
	public String delete(HttpServletRequest request,
			HttpServletResponse response){
		String str[]=request.getParameterValues("id");
		for (String string : str) {
			deptService.deleteById(string);
		}
		return "redirect:deptAction_list.do";
	}
	
}
