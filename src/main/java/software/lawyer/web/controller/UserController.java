package software.lawyer.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import software.lawyer.data.dataobject.Dept;
import software.lawyer.data.dataobject.User;
import software.lawyer.data.dataobject.UserInfo;
import software.lawyer.service.DeptService;
import software.lawyer.service.UserInfoService;
import software.lawyer.service.UserService;
import software.lawyer.service.convertor.UserDataModelConvertor;
import software.lawyer.service.model.DeptCustom;
import software.lawyer.service.model.UserCustom;
import software.lawyer.service.model.UserDataModel;
import software.lawyer.service.model.UserInfoCustom;
import software.lawyer.service.model.base.PageResult;
import software.lawyer.util.DateUtil;
import software.lawyer.util.UUIDGenerator;
import software.lawyer.web.ResponseBuilder;

@Controller
@RequestMapping("/sysadmin")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	public static String User = "sysadmin/user/";
	@Resource
	private UserService userService;
	private DeptService deptService;
	private UserInfoService userInfoService;
	
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	// true:允许输入空值，false:不能为空值
	// userAction_list.do
	@RequestMapping(value = "userAction_list.do", method = RequestMethod.GET)
	public String list(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return User + "jUserList";
	}

	@RequestMapping(value = "getDataTablesUser.aj", method = RequestMethod.POST)
	public void getDataTablesDept(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String pageLength = request.getParameter("pageLength");
		String start = request.getParameter("start");
		PageResult pageResult = userService.getWzPageList(start, pageLength);

		UserDataModelConvertor convertor = new UserDataModelConvertor();
		@SuppressWarnings("unchecked")
		List<User> users = pageResult.getItems();
		UserDataModel dataModel = convertor.userDoConvetor(users);
		dataModel.setRecordsFiltered((int) pageResult.getTotalCount());
		dataModel.setRecordsTotal((int) pageResult.getTotalCount());
		try {
			new ResponseBuilder().writeJsonResponse(response, dataModel);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 查看部门 deptAction_toview deptAction_toview.do
	@RequestMapping(value = "userAction_toview.do", method = RequestMethod.POST)
	public String toview(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String id = request.getParameter("id");
		User user = userService.findObjectById(id);
		model.addAttribute("user", user);
		return User + "jUserView";
	}

	// deptAction_tocreate.do
	@RequestMapping(value = "userAction_tocreate.do", method = RequestMethod.POST)
	public String tocreate(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		List<Dept> deptList = deptService.findVaildDept();
		model.addAttribute("deptList", deptList);
		List<User> userList = userService.findVaildUser();
		model.addAttribute("userList", userList);

		return User + "jUserCreate";
	}

	// deptAction_insert.do insert 增加部门
	@RequestMapping(value = "userAction_insert.do", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,
			HttpServletResponse response, UserCustom userCustom,
			UserInfoCustom userInfoCustom, DeptCustom deptCustom) {
		// ---------------------------
		// 保证user表和userinfo表的id一致
		String id = UUIDGenerator.getUUID();
		User user = userCustom.getUser();
		user.setUserId(id);
		UserInfo userInfo = userInfoCustom.getUserInfo();
		userInfo.setUserInfoId(id);
		// -----------------------------
		String userId = request.getParameter("zsld");
		User user2 = new User();
		user2.setUserId(userId);
		userInfo.setUser(user2);
		Set<UserInfo> set = new HashSet<UserInfo>();
		userInfo.setUpdateTime(DateUtil.today());
		userInfo.setCreateTime(DateUtil.today());
		set.add(userInfo);
		Dept dept = deptCustom.getDept();
		user.setDept(dept);
		user.setUserInfoPs(set);
		user.setCreateTime(DateUtil.today());
		user.setUpdateTime(DateUtil.today());
		userService.save(user);
		return "redirect:userAction_list.do";
	}

	// userAction_toupdate.do
	@RequestMapping(value = "userAction_toupdate.do", method = RequestMethod.POST)
	public String toupdate(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String id = request.getParameter("id");
		User user = userService.findObjectById(id);
		model.addAttribute("user", user);
		List<Dept> deptList = deptService.findVaildDept();
		model.addAttribute("deptList", deptList);
		return User + "jUserUpdate";
	}

	// userAction_update.do
	// 保存修改
	@RequestMapping(value = "userAction_update.do", method = RequestMethod.POST)
	public String update(HttpServletRequest request,
			HttpServletResponse response, UserCustom userCustom) {
		User user1=userCustom.getUser();
		User user=userService.findObjectById(userCustom.getUser().getUserId());
		user.setDept(user1.getDept());
		user.setUserName(user1.getUserName());
		user.setState(user1.getState());
		userService.update(user);
		return "redirect:userAction_list.do";
	}
	//userAction_delete.do
	@RequestMapping(value = "userAction_delete.do", method = RequestMethod.POST)
	public String delete(HttpServletRequest request,
			HttpServletResponse response){
		String str[]=request.getParameterValues("id");
		for (String string : str) {
			//deptService.deleteById(string);
			userService.delete(string);
			userInfoService.delete(string);
		}
		return "redirect:userAction_list.do";
	}
}
