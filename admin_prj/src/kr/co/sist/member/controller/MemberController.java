package kr.co.sist.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.member.domain.MemberCntData;
import kr.co.sist.member.domain.MemberData;
import kr.co.sist.member.domain.MemberPageData;
import kr.co.sist.member.service.MemberService;
import kr.co.sist.member.vo.MemberSearchVO;
import kr.co.sist.member.vo.MemberValueVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Controller
public class MemberController {
//	@RequestMapping(value="/main.do", method={GET,POST}) 
//	public String main(){
//		return "main/main";
//	}
	
	@RequestMapping(value="/member_main.do", method={GET,POST}) //index.do요청이 들어오면!
																	//dd에서 url-pattern은 *.do로 바꿔야한다.
	public String mainPage(Model model ,MemberSearchVO msVO,MemberValueVO mvVO, @RequestParam(defaultValue="1")int currentPage, @RequestParam(defaultValue="",value="columnName")String columnName, @RequestParam(defaultValue="",value="keyword")String keyword){
		String configLocation="kr/co/sist/member/controller/app_con.xml";
		//Spring Container
		ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
		MemberService ms = ac.getBean("member_service",MemberService.class);
		msVO=ms.inputSearchValue(columnName, keyword);
		
		//업무처리 결과 받기, View로 전달
		MemberCntData mcd=ms.searchMemberCnt(msVO);
		mvVO= ms.inputValue(mcd, currentPage, columnName, keyword);
		List<MemberData> memberList = ms.searchMember(mvVO);
		MemberPageData mpd=ms.searchMemberPage(currentPage, mcd);
		
		model.addAttribute("memberList",memberList);
		model.addAttribute("member_cnt",mcd);
		model.addAttribute("memberPage",mpd);
		return "main/member_main";
	}//mainPage
	
	@RequestMapping(value="/member_update.do",method={GET,POST})
	public String membercUpdate(String id){
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/member/controller/app_con.xml");
		
		MemberService ms=ac.getBean("member_service",MemberService.class);
		
		ms.updatem(id);
		
		return "/member/member_usuccess";
	}//membercUpdate
	

}//class

