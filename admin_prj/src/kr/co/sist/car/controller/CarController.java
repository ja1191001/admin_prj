package kr.co.sist.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.sist.car.domain.CarDomain;
import kr.co.sist.car.domain.CarNameDomain;
import kr.co.sist.car.domain.CarTypeDomain;
import kr.co.sist.car.domain.CarUpdateDomain;
import kr.co.sist.car.service.CarService;
import kr.co.sist.car.vo.CarInsertVO;
import kr.co.sist.car.vo.CarUpdateVO;
import kr.co.sist.car.vo.TypeInsertVO;
import kr.co.sist.car.vo.TypeUpdateVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class CarController {
	
/*	*//**
	 * 차종 목록
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value="/car_main_type.do",method={GET,POST})
	public String carListType(Model model){
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		List<CarTypeDomain> listType=cs.searchCarType();
		model.addAttribute("listType", listType);
		return "car/type_update";
	}//carList
*/	
	/**
	 * 차량 목록
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/car_main.do",method={GET,POST})
	public String carList(Model model){
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		List<CarDomain> list=cs.searchCar();
		List<CarTypeDomain> listType=cs.searchCarType();
		model.addAttribute("listType", listType);
		model.addAttribute("list", list);
		return "main/car_main";
	}//carList
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////차종 관리/////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * 차종 추가
	 * @param tiv
	 * @return
	 */
	@RequestMapping(value="type_insert_success.do",method={GET,POST})
	public String typeInsert(TypeInsertVO tiv){
		System.out.println("1.controller 탑니다.");
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		cs.addType(tiv);
		return "redirect:/car/car_main.html";
	}//insert
	
	/**
	 * 차종 수정을 하기위해 기존의 정보를 불러오는 일(select)
	 * @param car_num
	 * @return
	 */
	@RequestMapping(value="type_update_process.do",method=GET)
	public String typeUpdateSelect(Model model,TypeInsertVO tiv){
		System.out.println(tiv.toString());
		System.out.println("1.controller탑니다. 차량수정을 위한 기존정보 불러오기 함수 입니다.");
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		CarTypeDomain ctd=cs.modifySearchType(tiv);
		model.addAttribute("ctd",ctd);
		System.out.println(ctd.toString());
		return "car/type_update_process";
	}//insert
	
	
	/**
	 * 차종 수정
	 * @param car_num
	 * @return
	 */
	@RequestMapping(value="type_update_success.do",method=GET)
	public String typeUpdate(TypeUpdateVO tuv){
		System.out.println("1.controller탑니다. 차량수정 입니다.");
		System.out.println(tuv.toString());
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		cs.modifyType(tuv);
		return "redirect:/car/car_main2.html";
	}//insert
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////차량 관리/////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 차량 추가 시, 기존 보유한 차량의 차량명을 select태그로 띄워주기 위함
	 * @param model
	 * @param rv
	 * @return
	 */
	@RequestMapping(value="car_insert.do",method={GET,POST})
	public String selectCarName(Model model){
		System.out.println("Controller안에 reserv()메소드 탄다!!");
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		List<CarNameDomain> list=cs.selectCarName();
		model.addAttribute("list", list);
		return "car/car_insert";
	}
	
	/**
	 * 차량 추가
	 * @param tiv
	 * @return
	 */
	  @RequestMapping(value="car_insert_success.do",method=POST)
	   public String typeInsert( HttpServletRequest request) throws IOException{
	      System.out.println("1.controller탑니다. 차량추가 입니다.");
	      String contextType=request.getContentType();
	      if( contextType != null && contextType.startsWith("multipart")){
	         //저장경로 설정
	         String upload_path="C:/dev/admin_prj/admin_prj/WebContent/images"; //우리는 저장하는 경로가 DD에 들어있다
	         int maxSize=1000*1000*5;
	      MultipartRequest mr=new MultipartRequest(request,upload_path,maxSize,"UTF-8",new DefaultFileRenamePolicy());
	      ////////////////////파일명 얻어내기/////////////////
	      Enumeration<String> fileName=mr.getFileNames();
	      String fileControlName="";
	      String images="";
	      while(fileName.hasMoreElements()){
	         fileControlName=fileName.nextElement();
	         images=mr.getFilesystemName(fileControlName);
	      }//end while
	      System.out.println(images);
	      CarInsertVO civ=new CarInsertVO(mr.getParameter("car_name"),mr.getParameter("assign_num"),mr.getParameter("car_year"),images,mr.getParameter("able_flag"));
	      ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
	      CarService cs=ac.getBean("car_service",CarService.class);
	      cs.addCar(civ);
	      }
	      return "redirect:/car/car_main2.html";
	   }//typeInsert
	
	
	/**
	 * 차량 수정을 하기위해 기존의 정보를 불러오는 일(select)
	 * @param car_num
	 * @return
	 */
	@RequestMapping(value="car_update.do",method=GET)
	public String carUpdateSelect(Model model,String car_num){
		System.out.println("1.controller탑니다. 차량수정을 위한 기존정보 불러오기 함수 입니다.");
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		CarUpdateDomain cud=cs.modifySearchCar(car_num);
		model.addAttribute("cud",cud);
		return "car/car_update";
	}//insert
	
	
	/**
	 * 차량 수정
	 * @param car_num
	 * @return
	 */
	@RequestMapping(value="car_update_success.do",method=GET)
	public String carUpdate(CarUpdateVO cuv){
		System.out.println("1.controller탑니다. 차량수정 입니다.");
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		cs.modifyCar(cuv);
		return "redirect:/car/car_main2.html";
	}//insert

	
	/**
	 * 차량 삭제
	 * @param car_num
	 * @return
	 */
	@RequestMapping(value="car_delete.do",method=GET)
	public String carDelete(String car_num){
		System.out.println("1.controller탑니다. 차량삭제 입니다.");
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		cs.removeCar(car_num);
		return "redirect:/car/car_main2.html";
	}//insert
	
	




	
	
}//class


































/*	@RequestMapping(value="/car_main.do", method={GET,POST}) //qna_main.do요청이 들어오면!
	public String mainPage(Model model, CarValueVO cvVO, @RequestParam(defaultValue="1")int currentPage, @RequestParam(defaultValue="",value="columnName")String columnName, @RequestParam(defaultValue="",value="keyword")String keyword){
		String configLocation="kr/co/sist/car/controller/app_con.xml";
		//Spring Container
		ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
		CarService cs = ac.getBean("car_service",CarService.class);
		//업무처리 결과 받기, View로 전달
		CarCntData ccd=cs.searchCarCnt();
		System.out.println("ccd=>"+ccd);
		cvVO= cs.inputValue(ccd, currentPage, columnName, keyword);
		List<CarData> carList = cs.searchCar(cvVO);
		CarPageData cpd=cs.searchCarPage(currentPage, ccd);
		 model.addAttribute("qnaList",carList);
		 model.addAttribute("qna_cnt",ccd);
		 model.addAttribute("qnaPage",cpd);
		return "main/car_main";
	}//mainPage

	
	
	
	@RequestMapping(value="carview/car_insert.do",method=GET)
	public String carcinsert(InsertCarVO ic){
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		cs.Insert(ic);
		return "/car/car_wsuccess";
	}//insert
	
	
	
	@RequestMapping(value="car/car_update.do",method=GET)
	public String carcUpdate(UpdateCarVO uc){
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		cs.updatec(uc);
		return "/car/car_usuccess";
	}//qnacUpdate
	
	
	
	@RequestMapping(value="/car/car_view.do")
	public String carDetail(Model model, @RequestParam(defaultValue="0") String cnum){
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		System.out.println("==== car service 조회"+cnum);
		CarService cs=ac.getBean("car_service",CarService.class);
		System.out.println("===00000000000= car service"+cs);
		CarDetailData detailcar=cs.searchCarDetail(cnum);
		System.out.println("Controller"+cnum);
		System.out.println( detailcar.getId());
		System.out.println( detailcar.getTitle());
		model.addAttribute("detailacr",detailcar);
		return "/car/car_view";
	}//qnaDetail

	

	@RequestMapping(value="car/car_delete.do",method=GET)
	public String carDelete(@RequestParam(defaultValue="0") String cnum){
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		
		CarService cs=ac.getBean("car_service",CarService.class);
		cs.delete(cnum);
		System.out.println("MainController"+cnum);
		return "/car/car_dsuccess";
	}//qnacdelete
 */