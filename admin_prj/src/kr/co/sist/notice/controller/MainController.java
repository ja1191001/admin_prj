package kr.co.sist.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.sist.notice.domain.NoticeCntData;
import kr.co.sist.notice.domain.NoticeData;
import kr.co.sist.notice.domain.NoticePageData;
import kr.co.sist.notice.service.MainService;
import kr.co.sist.notice.vo.NoticeModifyVO;
import kr.co.sist.notice.vo.NoticeSearchVO;
import kr.co.sist.notice.vo.NoticeVO;
import kr.co.sist.notice.vo.NoticeValueVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class MainController {

	@RequestMapping(value="/notice_main.do",method={GET,POST})
	 public String mainPage(Model model,NoticeSearchVO nsVO, NoticeValueVO nvVO, @RequestParam(defaultValue="1")int currentPage, @RequestParam(defaultValue="",value="columnName")String columnName, @RequestParam(defaultValue="",value="keyword")String keyword){//model을 매개변수로 선언해 준다
		 
		String configLocation="kr/co/sist/notice/controller/app_con.xml";
		//Spring Container 사용
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLocation);
		
		//bean 꺼내기
		MainService ms=ac.getBean("main_service",MainService.class); //리플렉트
		
		nsVO=ms.inputSearchValue(columnName, keyword);
		//업무처리 결과 받기, View로 전달
		NoticeCntData ncd=ms.searchNoticeCnt(nsVO);
		NoticePageData npd=ms.searchNoticePage(currentPage, ncd);

		nvVO= ms.inputValue(ncd, currentPage, columnName, keyword);
		List<NoticeData> noticeList=ms.searchNotice(nvVO);
		
		model.addAttribute("notice_value",nvVO);
		model.addAttribute("noticeList",noticeList);
		model.addAttribute("notice_cnt",ncd);
		model.addAttribute("noticePage",npd);

		 return "main/notice_main";
	 }//configLocation
	
	@RequestMapping(value="/notice/read_notice_detail.do",method={GET,POST})
	public String useNoticeDetail(Model model, @RequestParam(defaultValue="0")int num){
		
		//service
		String configLocation="kr/co/sist/notice/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLocation);
		
		MainService ms=ac.getBean("main_service",MainService.class);
		NoticeData nd= ms.searchNoticeDetail(num);
		
		
		model.addAttribute("detail_data",nd);
		
		return "notice/read_notice_detail";
	}//useNoticeDetail
	
	@RequestMapping(value="/notice/notice_modify.do",method={GET,POST})
	public String modifyNoticeDetail(Model model, @RequestParam(defaultValue="0")int num){
		
		//service
		String configLocation="kr/co/sist/notice/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLocation);
		
		MainService ms=ac.getBean("main_service",MainService.class);
		NoticeData nd= ms.searchNoticeDetail(num);
		
		
		model.addAttribute("detail_data",nd);
		System.out.println("**-*/-*/-*/-*/-*/-665618"+nd.getTitle());
		
		return "notice/notice_modify";
	}//useNoticeDetail
	
	@RequestMapping(value="/notice/modify_detail.do",method={GET,POST})
	public String noticeModify(NoticeModifyVO nmVO){
	
	//service
		String configLocation="kr/co/sist/notice/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLocation);
		MainService ms=ac.getBean("main_service",MainService.class);

		System.out.println("@@@===@@@==%%%%");
		System.out.println("111111@@@===@@@==%%%%"+nmVO.getNotice_num());
		System.out.println("111111@@@===@@@==%%%%"+nmVO.getContent());
		
		boolean flag=ms.modifyNotice(nmVO);
				
		return "notice/read_notice_detail";
	}//noticeModify
}//controller
