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
import kr.co.sist.notice.vo.NoticeWriteVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class MainController {

	/**
	 * 공지사항 메인 리스트를 띄우는 메소드
	 * @param model
	 * @param nsVO
	 * @param nvVO
	 * @param currentPage
	 * @param columnName
	 * @param keyword
	 * @return
	 */
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
	
	/**
	 * 공지사항에서 해당 내용을 클릭하면 세부창으로 이동
	 * @param model
	 * @param num
	 * @return
	 */
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
	
	/**
	 * 세부사항에서 수정시 수정창으로 이동하는 메소드
	 * @param model
	 * @param num
	 * @return
	 */
	@RequestMapping(value="/notice/notice_modify.do",method={GET,POST})
	public String modifyNoticeDetail(Model model, @RequestParam(defaultValue="0")int num){
		
		//service
		String configLocation="kr/co/sist/notice/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLocation);
		
		MainService ms=ac.getBean("main_service",MainService.class);
		NoticeData nd= ms.searchNoticeDetail(num);
		
		
		model.addAttribute("detail_data",nd);
		
		return "notice/notice_modify";
	}//useNoticeDetail
	
	/**
	 * 수정창에서 수정내용을 가지고 DB 내용 변경
	 * @param model
	 * @param nmVO
	 * @param notice_num
	 * @return
	 */
	@RequestMapping(value="/notice/modify_detail.do",method={GET,POST})
	public String noticeModify(Model model, NoticeModifyVO nmVO, @RequestParam String notice_num){
	
		//service
		String configLocation="kr/co/sist/notice/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLocation);
		MainService ms=ac.getBean("main_service",MainService.class);

		//관리자 ID 연동시까지 'admin'으로 통일
		String id="admin";
		nmVO.setId(id);
		nmVO.setNotice_num(notice_num);
		
		boolean flag=ms.modifyNotice(nmVO);
			
		model.addAttribute("nmvo",nmVO);
		return "notice/notice_modify_result";
	}//noticeModify
	
	/**
	 * 해당 공지사항을 삭제처리하고, 삭제성공 창을 띄움
	 * @param notice_num
	 * @return
	 */
	@RequestMapping(value="/notice/notice_delete.do",method={GET,POST})
	public String noticeDelete(@RequestParam String notice_num){
		
		//service
		String configLocation="kr/co/sist/notice/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLocation);
		MainService ms=ac.getBean("main_service",MainService.class);
		
		boolean flag=ms.deleteNotice(notice_num);
		
		return "notice/notice_delete_result";
	}//noticeDelete
	
	/**
	 * 새 글쓰기 창으로 이동
	 * @return
	 */
	@RequestMapping(value="/notice/notice_write.do",method={GET,POST})
	public String noticeWrite(){
	
		return "notice/notice_write";
	}//noticeWrite
	
	@RequestMapping(value="notice/notice_write_action.do",method={GET,POST})
	public String noticeWriteAction(String title, String content, NoticeWriteVO nwVO){
		
		//service
		String configLocation="kr/co/sist/notice/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLocation);
		MainService ms=ac.getBean("main_service",MainService.class);
		
		//관리자 ID 연동시까지 'admin'으로 통일
		String id="admin";
		nwVO.setId(id);
		nwVO.setContent(content);
		nwVO.setTitle(title);
		
		boolean flag=ms.insertNotice(nwVO);
				
		return "notice/notice_write_result";
	}//noticeWriteAction
}//controller
