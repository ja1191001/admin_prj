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
	 * �������� ����������(���� ����Ʈ)
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
	 * �������� ����������(���� ����Ʈ)
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
	//////////////////////////////////////////////////���� ����////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * ���� �߰�
	 * @param tiv
	 * @return
	 */
	public boolean addType(TypeInsertVO tiv){
		System.out.println("2.service����");
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
	 * ���� ���� ������ ���� ������ �������� ����ִ� ��
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
	 * ���� ����
	 * @param car_num
	 * @return
	 */
	public boolean modifyType(TypeUpdateVO tuv){
		System.out.println("modifyType()�޼ҵ� ����");
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
	//////////////////////////////////////////////////���� ����////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * ���� �߰� ��, ���� ������ ������ �������� select�±׷� ����ֱ� ����
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
	 * ���� �߰�
	 * @param civ
	 * @return
	 */
	public boolean addCar(CarInsertVO civ){
		System.out.println("addCar()�޼ҵ� ����");
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
	 * ���� ���� ������ ���� ������ �������� ����ִ� ��
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
	 * ���� ����
	 * @param car_num
	 * @return
	 */
	public boolean modifyCar(CarUpdateVO cuv){
		System.out.println("modifyCar()�޼ҵ� ����");
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
	 * ���� ����
	 * @param car_num
	 * @return
	 */
	public boolean removeCar(String car_num){
		System.out.println("removeCar()�޼ҵ� ����");
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
		//��ü �� ��
		int totalCount=ccd.getNum();
		//�� �������� ���� �� ��
		int pageScale=15;
		//��ü ������ ��
		int totalPage=0;
		totalPage=totalCount/pageScale;
		if(totalCount%pageScale!=0){totalPage++;}//�������� �����ϴ� ��� ������ �߰�
		int firstPage=(currentPage-1)/10;
		firstPage=firstPage*10+1;
		int lastPage=firstPage+9;
		if(totalPage<lastPage){lastPage=totalPage;}//������ �������� 10�������� �ȵ� ���
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
		if(endNum<=15){startNum=1;}//�ش��� �ְ� ��ȣ�� 15 ���̶�� ���۹�ȣ�� ������ 1��
		keyword="%"+HangulConv.toUTF(keyword)+"%";
		cvv.setStartNum(startNum);
		cvv.setEndNum(endNum);
		cvv.setColumName(columnName);
		cvv.setKeyword(keyword);
		return cvv;
	}*/