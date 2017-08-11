package kr.co.sist.log.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sist.log.service.LogService;
import kr.co.sist.log.vo.ChangeVO;
import kr.co.sist.log.vo.EmpVO;
import kr.co.sist.log.vo.FindIdVO;
import kr.co.sist.log.vo.FindPassVO;
import kr.co.sist.log.vo.LogVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SessionAttributes("id")
@Controller
public class LogController {
	
	@RequestMapping(value="menu.do", method={GET,POST})
	public String callMenu(){
		return "menu/menu";
	}//callMenu
	
	@RequestMapping(value="start.do", method={GET, POST})
	public String first(){
		return "main/login";
	}
	
	@RequestMapping(value="login.do", method=POST)
	public String login(Model model, LogVO lv){
		String configLoc="kr/co/sist/log/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLoc);
		String jsp="";
		
		LogService ls=ac.getBean("login_admin", LogService.class);
		String id=ls.loginAdmin(lv);
		
		if(id==null||id.trim().equals("")){
			jsp="main/login_fail";
		}else{
			model.addAttribute("id", id);
			jsp="main/main";
		}
		
		return jsp;
	}
	
	@RequestMapping(value="sign_in.do", method={GET,POST})
	public String join(EmpVO ev){
		String configLoc="kr/co/sist/log/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLoc);
		LogService ls=ac.getBean("login_admin", LogService.class);
		String jsp="";
		boolean flag=ls.signInAdmin(ev);
		
		if(flag){
			jsp="main/sign_in_success";
		}else{
			jsp="main/sign_in_fail";
		}
		
		return jsp;
	}
	
	@RequestMapping(value="find_id.do", method={GET, POST})
	public String findId(Model model, FindIdVO fiv){
		String configLoc="kr/co/sist/log/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLoc);
		LogService ls=ac.getBean("login_admin", LogService.class);
		String jsp="";
		
		String ad_id=ls.findAdminId(fiv);
		
		if(ad_id==null||ad_id.equals("")){
			jsp="main/find_id_fail";
		}else{
			model.addAttribute("ad_id", ad_id);
			jsp="main/find_id_success";
		}
		
		return jsp;
	}
	
	@RequestMapping(value="find_pass.do", method={GET, POST})
	public String findPass(Model model, FindPassVO fpv){
		String configLoc="kr/co/sist/log/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLoc);
		LogService ls=ac.getBean("login_admin", LogService.class);
		String jsp="";
		
		String ad_id=ls.findAdminPass(fpv);
		if(ad_id==null||ad_id.equals("")){
			jsp="main/find_pass_fail";
		}else{
			model.addAttribute("ad_id", ad_id);
			jsp="main/find_pass_success";
		}
		
		return jsp;
	}
	
	@RequestMapping(value="change_pass.do", method=POST)
	public String changePass(ChangeVO cv){
		String configLoc="kr/co/sist/log/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLoc);
		LogService ls=ac.getBean("login_admin", LogService.class);
		ls.changePass(cv);
		
		return "main/change_success";
	}
}
