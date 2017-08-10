package kr.co.sist.rent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.rent.domain.CarDetail;
import kr.co.sist.rent.domain.RentAble;
import kr.co.sist.rent.domain.Schedual;
import kr.co.sist.rent.domain.cntData;
import kr.co.sist.rent.domain.pageData;
import kr.co.sist.rent.service.RentService;
import kr.co.sist.rent.vo.DataVO;
import kr.co.sist.rent.vo.DetailVO;
import kr.co.sist.rent.vo.RentInsertVO;
import kr.co.sist.rent.vo.ScheSearchVO;
import kr.co.sist.rent.vo.ScheVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class RentController {
	
	@RequestMapping(value="rent_list.do", method={GET, POST})
	public String rentList(Model model, 
			ScheVO sv,
			ScheSearchVO ssv,
			@RequestParam(defaultValue="1")int currentPage,
			@RequestParam(defaultValue="")String start_date,
			@RequestParam(defaultValue="")String end_date,
			@RequestParam(defaultValue="")String id){
		
		String configLoc="kr/co/sist/rent/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLoc);
		RentService rs=ac.getBean("rent_service", RentService.class);
		
		ssv=rs.inputData(start_date, end_date, id);
		cntData cd=rs.searchCnt(ssv);
		pageData pd=rs.searchPage(currentPage, cd);
		
		sv=rs.inputValue(cd, currentPage, start_date, end_date, id);
		
		List<Schedual> list=rs.searchRent(sv);
		
		model.addAttribute("rent_value", sv);
		model.addAttribute("rentList", list);
		model.addAttribute("rent_cnt", cd);
		model.addAttribute("rent_page", pd);
		
		return "rent/rent_list";
	}
	
	@RequestMapping(value="remove_rent.do", method={GET, POST})
	public String removeSchedual(String resev_num){
		String configLoc="kr/co/sist/rent/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLoc);
		RentService rs=ac.getBean("rent_service", RentService.class);
		
		rs.removeSchedual(resev_num);
		
		return "redirect:rent/remove_success.html";
	}
	
	@RequestMapping(value="rent_able.do", method=GET)
	public String rentAble(Model model,
			DataVO dv){
		String configLoc="kr/co/sist/rent/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLoc);
		RentService rs=ac.getBean("rent_service", RentService.class);
		if( dv.getStart_date()==null){
			dv.setStart_date("");
			dv.setEnd_date("");
			dv.setType("");
			dv.setFuel("");
		}
		List<RentAble> list=rs.searchRentAble(dv);
		for(RentAble ra : list){
			System.out.println(ra); 
		}
		model.addAttribute("rent_able", list);
		
		return "rent/rent_able";
	}
	
	@RequestMapping(value="rent_detail.do", method=GET)
	public String rentDetail(Model model, DetailVO dv){
		String configLoc="kr/co/sist/rent/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLoc);
		RentService rs=ac.getBean("rent_service", RentService.class);
		
		CarDetail cd=rs.searchDetailCar(dv);
		model.addAttribute("car_detail", cd);
		
		return "rent/rent_detail";
	}
	
	@RequestMapping(value="rent_add.do", method=GET)
	public String rentAdd(RentInsertVO riv){
		String configLoc="kr/co/sist/rent/controller/app_con.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(configLoc);
		RentService rs=ac.getBean("rent_service", RentService.class);
		
		rs.addRent(riv);
		
		return "rent/rent_success";
	}
	
	@RequestMapping(value="id_search.do", method=GET)
	public String idSearch(Model model, String c_id){
		if(c_id!=null&!"".equals(c_id)){
			String configLoc="kr/co/sist/rent/controller/app_con.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(configLoc);
			RentService rs=ac.getBean("rent_service", RentService.class);
			boolean flag=rs.searchMember(c_id);
			model.addAttribute("flag", flag);
		}
		
		return "rent/id_search";
	}
}
