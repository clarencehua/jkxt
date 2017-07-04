package software.lawyer.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import software.lawyer.data.dataobject.User;
import software.lawyer.util.StringUtil;
import software.lawyer.util.SysConstant;

@Controller
public class LoginController {
	private static Logger logger=Logger.getLogger(LoginController.class);
	public static String Login="sysadmin/login/";
	@RequestMapping(value = "login.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String showLogin(HttpServletRequest request,
			HttpServletResponse response, ModelMap model){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(StringUtil.isEmpty(username)){
			return Login+"/login";
		}
		
		try {
			//1.得到Subject
			Subject subject = SecurityUtils.getSubject();
			//2.调用登录方法
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);//当这一代码执行时，就会自动跳入到AuthRealm中认证方法
			
			//3.登录成功时，就从Shiro中取出用户的登录信息
			User user = (User) subject.getPrincipal();
			
			//4.将用户放入session域中
			request.getSession().setAttribute(SysConstant.CURRENT_USER_INFO, user);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorInfo", "对不起，用户名或密码错误！");
			return Login+"/login";
		}
		
		return "home/fmain";
	}
	
	@RequestMapping(value = "user.do", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request,
			HttpServletResponse response, ModelMap model){
		
		return "login";
	}
	
}
