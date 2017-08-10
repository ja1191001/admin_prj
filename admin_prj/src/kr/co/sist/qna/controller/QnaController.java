package kr.co.sist.qna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.qna.domain.QnaCntData;
import kr.co.sist.qna.domain.QnaData;
import kr.co.sist.qna.domain.QnaDetailData;
import kr.co.sist.qna.domain.QnaPageData;
import kr.co.sist.qna.service.QnaService;
import kr.co.sist.qna.vo.InsertQnaVO;
import kr.co.sist.qna.vo.QnaSearchVO;
import kr.co.sist.qna.vo.QnaValueVO;
import kr.co.sist.qna.vo.UpdateQnaVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Controller
public class QnaController {
	@RequestMapping(value="/qna_main.do", method={GET,POST}) //qna_main.do요청이 들어오면!
																	//dd에서 url-pattern은 *.do로 바꿔야한다.
	public String mainPage(Model model, QnaSearchVO qsVO,QnaValueVO qvVO, @RequestParam(defaultValue="1")int currentPage, @RequestParam(defaultValue="",value="columnName")String columnName, @RequestParam(defaultValue="",value="keyword")String keyword){
		String configLocation="kr/co/sist/qna/controller/app_con.xml";
		//Spring Container
		ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
		QnaService ms = ac.getBean("qna_service",QnaService.class);
		qsVO=ms.inputSearchValue(columnName, keyword);
		//업무처리 결과 받기, View로 전달
		QnaCntData qcd=ms.searchQnaCnt(qsVO);
		qvVO= ms.inputValue(qcd, currentPage, columnName, keyword);
		List<QnaData> qnaList = ms.searchQna(qvVO);
		QnaPageData qpd=ms.searchQnaPage(currentPage, qcd);

		 model.addAttribute("qnaList",qnaList);
		 model.addAttribute("qna_cnt",qcd);
		 model.addAttribute("qnaPage",qpd);
		
		return "main/qna_main";
	}//mainPage
	
	@RequestMapping(value="qnaview/qna_insert.do",method={GET,POST})
	public String qnacinsert(InsertQnaVO iq){
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/qna/controller/app_con.xml");
		
		QnaService ms=ac.getBean("qna_service",QnaService.class);
		ms.Insert(iq);

		
		return "/qna/qna_wsuccess";
	}//insert
	
	@RequestMapping(value="qna/qna_update.do",method={GET,POST})
	public String qnacUpdate(UpdateQnaVO uq){
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/qna/controller/app_con.xml");
		
		QnaService ms=ac.getBean("qna_service",QnaService.class);
		
		ms.updateq(uq);
		System.out.println(uq.getQnum());
		
		return "/qna/qna_usuccess";
	}//qnacUpdate
	
	@RequestMapping(value="/qna/qna_view.do")
	public String qnaDetail(Model model, @RequestParam(defaultValue="0") String qnum){
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/qna/controller/app_con.xml");

		QnaService ms=ac.getBean("qna_service",QnaService.class);

		QnaDetailData detailqna=ms.searchQnaDetail(qnum);

		model.addAttribute("detailqna",detailqna);
		
		
		return "/qna/qna_view";
	}//qnaDetail


	@RequestMapping(value="qna/qna_delete.do",method={GET,POST})
	public String qnacDelete(@RequestParam(defaultValue="0") String qnum){
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/qna/controller/app_con.xml");
		
		QnaService ms=ac.getBean("qna_service",QnaService.class);
		ms.delete(qnum);
		return "/qna/qna_dsuccess";
	}//qnacdelete
	


}//class

