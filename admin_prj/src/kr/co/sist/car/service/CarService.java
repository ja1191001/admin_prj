package kr.co.sist.car.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.car.dao.CarDAO;
import kr.co.sist.car.domain.CarDomain;
import kr.co.sist.car.domain.CarNameDomain;
import kr.co.sist.car.domain.CarTypeDomain;
import kr.co.sist.car.domain.CarUpdateDomain;
import kr.co.sist.car.vo.CarInsertVO;
import kr.co.sist.car.vo.CarUpdateVO;
import kr.co.sist.car.vo.TypeInsertVO;
import kr.co.sist.car.vo.TypeUpdateVO;

@Component("car_service")
public class CarService {
	@Autowired(required=false)
	private CarDAO cd;
	
	/**
	 * 차량관리 메인페이지(차종 리스트)
	 * @return
	 */
	public List<CarTypeDomain> searchCarType() {
		List<CarTypeDomain> listType=null;
		try {
			listType=cd.selectCarType();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return listType;
	}//searchCar
	
	/**
	 * 차량관리 메인페이지(차량 리스트)
	 * @return
	 */
	public List<CarDomain> searchCar() {
		List<CarDomain> list=null;
		try {
			list=cd.selectCar();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return list;
	}//searchCar
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////차종 관리////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 차종 추가
	 * @param tiv
	 * @return
	 */
	public boolean addType(TypeInsertVO tiv){
		System.out.println("2.service탔다");
		boolean flag=false;
		try {
			if(cd.insertType(tiv)==1){
				flag=true;
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return flag;
	}//Insert
	
	/**
	 * 차종 수정 이전에 기존 차량의 정보들을 띄워주는 일
	 * @param car_num
	 * @return
	 */
	public CarTypeDomain modifySearchType(TypeInsertVO tiv){
		CarTypeDomain ctd=null;
		try {
			ctd=cd.updateSelectType(tiv);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return ctd;
	}//modifySearchCar
	
	
	/**
	 * 차량 수정
	 * @param car_num
	 * @return
	 */
	public boolean modifyType(TypeUpdateVO tuv){
		System.out.println("modifyType()메소드 탔다");
		System.out.println(tuv.toString());
		boolean flag=false;
		try {
			if(cd.updateType(tuv)==1){
				flag=true;
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return flag;
	}//modifyType
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////차량 관리////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 차량 추가 시, 기존 보유한 차량의 차량명을 select태그로 띄워주기 위함
	 * @param rv
	 * @return
	 */
	public List<CarNameDomain> selectCarName(){
		List<CarNameDomain> list=null;
		try {
			list=cd.selectCarName();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return list;
	}//carReservation
	
	
	/**
	 * 차량 추가
	 * @param civ
	 * @return
	 */
	public boolean addCar(CarInsertVO civ){
		System.out.println("addCar()메소드 탔다");
		boolean flag=false;
		try {
			if(cd.insertCar(civ)==1){
				flag=true;
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return flag;
	}//Insert
	
	
	/**
	 * 차량 수정 이전에 기존 차량의 정보들을 띄워주는 일
	 * @param car_num
	 * @return
	 */
	public CarUpdateDomain modifySearchCar(String car_num){
		CarUpdateDomain cud=null;
		try {
			cud=cd.updateSelectCar(car_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return cud;
	}//modifySearchCar
	
	
	/**
	 * 차량 수정
	 * @param car_num
	 * @return
	 */
	public boolean modifyCar(CarUpdateVO cuv){
		System.out.println("modifyCar()메소드 탔다");
		boolean flag=false;
		try {
			if(cd.updateCar(cuv)==1){
				flag=true;
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return flag;
	}//modifyCar
	
	
	
	/**
	 * 차량 삭제
	 * @param car_num
	 * @return
	 */
	public boolean removeCar(String car_num){
		System.out.println("removeCar()메소드 탔다");
		boolean flag=false;
		try {
			if(cd.deleteCar(car_num)==1){
				flag=true;
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return flag;
	}//removeCar
	
	
	
}//class




























/*
	public boolean Insert(InsertCarVO ic){
		boolean flag=false;
		try {
			if(cd.insertCar(ic)==1){
				flag=true;
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return flag;
	}//Insert
	
	
	public boolean updatec(UpdateCarVO uc){
		boolean flag=false;
		try {
			if(cd.updateCar(uc)==1){
				flag=true;
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return flag;
	}//updateq
	
	
	
	public boolean delete(String cnum){
		boolean flag=false;
		try {
			if(cd.deleteCar(cnum)==1){
				flag=true;
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		System.out.println("MainService"+cnum);
		return flag;
	}
	

	
	public CarDetailData searchCarDetail(String cnum){
		CarDetailData cdd =null;
		try {
			cdd=cd.selectCarDetail(cnum);
			System.out.println("QnaService-----------"+cnum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cdd;
	}//searchQna

	
	public CarPageData searchCarPage(int currentPage, CarCntData ccd){
		CarPageData cpd=new CarPageData();
		//전체 글 수
		int totalCount=ccd.getNum();
		//한 페이지에 나올 글 수
		int pageScale=15;
		//전체 페이지 수
		int totalPage=0;
		totalPage=totalCount/pageScale;
		if(totalCount%pageScale!=0){totalPage++;}//나머지가 존재하는 경우 페이지 추가
		int firstPage=(currentPage-1)/10;
		firstPage=firstPage*10+1;
		int lastPage=firstPage+9;
		if(totalPage<lastPage){lastPage=totalPage;}//마지막 페이지가 10페이지가 안될 경우
		cpd.setTatalPage(totalPage);
		cpd.setFirstPage(firstPage);
		cpd.setLastPage(lastPage);
		return cpd;
	}//searchQnaPage
	
	
	public CarCntData searchCarCnt(){
		CarCntData ccd=null;
		try {
			ccd=cd.selectCarCnt();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return ccd;
	}//searchQnaCnt

	
	
	public CarValueVO inputValue(CarCntData ccd, int currentPage, String columnName, String keyword){
		CarValueVO cvv=new CarValueVO();
		int pageScale=15;
		int endNum=ccd.getNum()-(currentPage-1)*pageScale; 
		int startNum=endNum-14;
		if(endNum<=15){startNum=1;}//해당목록 최고 번호가 15 밑이라면 시작번호는 무조건 1번
		keyword="%"+HangulConv.toUTF(keyword)+"%";
		cvv.setStartNum(startNum);
		cvv.setEndNum(endNum);
		cvv.setColumName(columnName);
		cvv.setKeyword(keyword);
		return cvv;
	}*/