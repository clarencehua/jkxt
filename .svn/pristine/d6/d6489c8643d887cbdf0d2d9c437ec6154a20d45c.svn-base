package software.lawyer.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import software.lawyer.data.dataobject.Userb;
import software.lawyer.service.UserService;

@Controller
public class LoginController {
	private static Logger logger=Logger.getLogger(LoginController.class);
	@Resource
	private UserService userService;
	
	/**
	 * ��ʾ��¼����
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String showLogin(HttpServletRequest request,
			HttpServletResponse response, ModelMap model){
		
		Userb  user=new Userb();
		user.setUserName("4");
		user.setPassword("123");
		userService.save(user);
		return "login";
	}
	
	@RequestMapping(value = "user.do", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request,
			HttpServletResponse response, ModelMap model){
		
		return "login";
	}
	
}
