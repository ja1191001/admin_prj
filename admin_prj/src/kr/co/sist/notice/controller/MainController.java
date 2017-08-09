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
	 * �������� ���� ����Ʈ�� ���� �޼ҵ�
	 * @param model
	 * @param nsVO
	 * @param nvVO
	 * @param currentPage
	 * @param columnName
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value="/notice_main.do",method={GET,POST})
	 public String mainPage(Model model,NoticeSearchVO nsVO, NoticeValueVO nvVO, @RequestParam(defaultValue="1")int currentPage, @RequestParam(defaultValue="",value="columnName")String columnName, @RequestParam(defaultValue="",value="keyword")String keyword){//model�� �Ű������� ������ �ش�
		 
		String configLocation="kr/co/sist/notice/controller/app_con.xml";
		//Spring Container ���
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLocation);
		
		//bean ������
		MainService ms=ac.getBean("main_service",MainService.class); //���÷�Ʈ
		
		nsVO=ms.inputSearchValue(columnName, keyword);
		//����ó�� ��� �ޱ�, View�� ����
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
	 * �������׿��� �ش� ������ Ŭ���ϸ� ����â���� �̵�
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
	 * ���λ��׿��� ������ ����â���� �̵��ϴ� �޼ҵ�
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
	 * ����â���� ���������� ������ DB ���� ����
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

		//������ ID �����ñ��� 'admin'���� ����
		String id="admin";
		nmVO.setId(id);
		nmVO.setNotice_num(notice_num);
		
		boolean flag=ms.modifyNotice(nmVO);
			
		model.addAttribute("nmvo",nmVO);
		return "notice/notice_modify_result";
	}//noticeModify
	
	/**
	 * �ش� ���������� ����ó���ϰ�, �������� â�� ���
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
	 * �� �۾��� â���� �̵�
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
		
		//������ ID �����ñ��� 'admin'���� ����
		String id="admin";
		nwVO.setId(id);
		nwVO.setContent(content);
		nwVO.setTitle(title);
		
		boolean flag=ms.insertNotice(nwVO);
				
		return "notice/notice_write_result";
	}//noticeWriteAction
}//controller
