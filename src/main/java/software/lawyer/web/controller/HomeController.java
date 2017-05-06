package software.lawyer.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController extends BaseController{
	private static Logger logger=Logger.getLogger(HomeController.class);
	@RequestMapping(value = "homeAction_toleft.do", method = RequestMethod.GET)
	public String toleft(HttpServletRequest request,
			HttpServletResponse response, ModelMap model){
		String moduleName=getRequetString(request);
		
		return moduleName+"/left";
	}
	@RequestMapping(value = "homeAction_tomain.do", method = RequestMethod.GET)
	public String tomain(HttpServletRequest request,
			HttpServletResponse response, ModelMap model){
		String moduleName=getRequetString(request);
		
		return moduleName+"/main";
	}
	
	@RequestMapping(value = "homeAction_title.do", method = RequestMethod.GET)
	public String title(HttpServletRequest request,
			HttpServletResponse response, ModelMap model){
		
		return "home/title";
	}
}
