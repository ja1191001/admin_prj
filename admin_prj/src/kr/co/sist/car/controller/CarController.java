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
	 * ���� ���
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
	 * ���� ���
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
	//////////////////////////////////////////////���� ����/////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * ���� �߰�
	 * @param tiv
	 * @return
	 */
	@RequestMapping(value="type_insert_success.do",method={GET,POST})
	public String typeInsert(TypeInsertVO tiv){
		System.out.println("1.controller ž�ϴ�.");
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		cs.addType(tiv);
		return "redirect:/car/car_main.html";
	}//insert
	
	/**
	 * ���� ������ �ϱ����� ������ ������ �ҷ����� ��(select)
	 * @param car_num
	 * @return
	 */
	@RequestMapping(value="type_update_process.do",method=GET)
	public String typeUpdateSelect(Model model,TypeInsertVO tiv){
		System.out.println(tiv.toString());
		System.out.println("1.controllerž�ϴ�. ���������� ���� �������� �ҷ����� �Լ� �Դϴ�.");
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		CarTypeDomain ctd=cs.modifySearchType(tiv);
		model.addAttribute("ctd",ctd);
		System.out.println(ctd.toString());
		return "car/type_update_process";
	}//insert
	
	
	/**
	 * ���� ����
	 * @param car_num
	 * @return
	 */
	@RequestMapping(value="type_update_success.do",method=GET)
	public String typeUpdate(TypeUpdateVO tuv){
		System.out.println("1.controllerž�ϴ�. �������� �Դϴ�.");
		System.out.println(tuv.toString());
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		cs.modifyType(tuv);
		return "redirect:/car/car_main2.html";
	}//insert
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////���� ����/////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * ���� �߰� ��, ���� ������ ������ �������� select�±׷� ����ֱ� ����
	 * @param model
	 * @param rv
	 * @return
	 */
	@RequestMapping(value="car_insert.do",method={GET,POST})
	public String selectCarName(Model model){
		System.out.println("Controller�ȿ� reserv()�޼ҵ� ź��!!");
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		List<CarNameDomain> list=cs.selectCarName();
		model.addAttribute("list", list);
		return "car/car_insert";
	}
	
	/**
	 * ���� �߰�
	 * @param tiv
	 * @return
	 */
	  @RequestMapping(value="car_insert_success.do",method=POST)
	   public String typeInsert( HttpServletRequest request) throws IOException{
	      System.out.println("1.controllerž�ϴ�. �����߰� �Դϴ�.");
	      String contextType=request.getContentType();
	      if( contextType != null && contextType.startsWith("multipart")){
	         //������ ����
	         String upload_path="C:/dev/admin_prj/admin_prj/WebContent/images"; //�츮�� �����ϴ� ��ΰ� DD�� ����ִ�
	         int maxSize=1000*1000*5;
	      MultipartRequest mr=new MultipartRequest(request,upload_path,maxSize,"UTF-8",new DefaultFileRenamePolicy());
	      ////////////////////���ϸ� ����/////////////////
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
	 * ���� ������ �ϱ����� ������ ������ �ҷ����� ��(select)
	 * @param car_num
	 * @return
	 */
	@RequestMapping(value="car_update.do",method=GET)
	public String carUpdateSelect(Model model,String car_num){
		System.out.println("1.controllerž�ϴ�. ���������� ���� �������� �ҷ����� �Լ� �Դϴ�.");
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		CarUpdateDomain cud=cs.modifySearchCar(car_num);
		model.addAttribute("cud",cud);
		return "car/car_update";
	}//insert
	
	
	/**
	 * ���� ����
	 * @param car_num
	 * @return
	 */
	@RequestMapping(value="car_update_success.do",method=GET)
	public String carUpdate(CarUpdateVO cuv){
		System.out.println("1.controllerž�ϴ�. �������� �Դϴ�.");
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		cs.modifyCar(cuv);
		return "redirect:/car/car_main2.html";
	}//insert

	
	/**
	 * ���� ����
	 * @param car_num
	 * @return
	 */
	@RequestMapping(value="car_delete.do",method=GET)
	public String carDelete(String car_num){
		System.out.println("1.controllerž�ϴ�. �������� �Դϴ�.");
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/car/controller/app_con.xml");
		CarService cs=ac.getBean("car_service",CarService.class);
		cs.removeCar(car_num);
		return "redirect:/car/car_main2.html";
	}//insert
	
	




	
	
}//class


































/*	@RequestMapping(value="/car_main.do", method={GET,POST}) //qna_main.do��û�� ������!
	public String mainPage(Model model, CarValueVO cvVO, @RequestParam(defaultValue="1")int currentPage, @RequestParam(defaultValue="",value="columnName")String columnName, @RequestParam(defaultValue="",value="keyword")String keyword){
		String configLocation="kr/co/sist/car/controller/app_con.xml";
		//Spring Container
		ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
		CarService cs = ac.getBean("car_service",CarService.class);
		//����ó�� ��� �ޱ�, View�� ����
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
		System.out.println("==== car service ��ȸ"+cnum);
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