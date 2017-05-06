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
import software.lawyer.service.model.DeptDataModel;
import software.lawyer.service.model.base.PageResult;
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
		
		for (Dept dept : depts) {
			System.out.println(dept);
		}
		try {
			new  ResponseBuilder().writeJsonResponse(response, dataModel);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
