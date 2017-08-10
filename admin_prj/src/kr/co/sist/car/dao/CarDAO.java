package kr.co.sist.car.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.car.domain.CarDomain;
import kr.co.sist.car.domain.CarNameDomain;
import kr.co.sist.car.domain.CarTypeDomain;
import kr.co.sist.car.domain.CarUpdateDomain;
import kr.co.sist.car.vo.CarInsertVO;
import kr.co.sist.car.vo.CarUpdateVO;
import kr.co.sist.car.vo.TypeInsertVO;
import kr.co.sist.car.vo.TypeUpdateVO;
@Component
public class CarDAO {
	
	/**
	 * 차량관리 메인페이지(차종 리스트)
	 * @return
	 * @throws SQLException
	 */
	public List<CarTypeDomain> selectCarType() throws SQLException{
		List<CarTypeDomain> listType=null;
		GetSqlSession gss=GetSqlSession.getInstance();
		SqlSession ss=gss.getSqlSession();
		listType=ss.selectList("selectCarType");
		return listType;
	}//selectCarType
	
	
	/**
	 * 차량관리 메인페이지(차량 리스트)
	 * @return
	 * @throws SQLException
	 */
	public List<CarDomain> selectCar() throws SQLException{
		List<CarDomain> list=null;
		GetSqlSession gss=GetSqlSession.getInstance();
		SqlSession ss=gss.getSqlSession();
		list=ss.selectList("selectCar");
		return list;
	}//selectCar
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////차종 관리////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * 차종 추가
	 * @param tiv
	 * @return
	 * @throws SQLException
	 */
	public int insertType(TypeInsertVO tiv) throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		int cnt=ss.insert("typeInsert", tiv);
		if(cnt==1){
			ss.commit();
		}
		return cnt;
	}//insertType
	
	/** 
	 * 차종 수정 이전에 기존 정보를 불러오는 일
	 * @param car_num
	 * @return
	 * @throws SQLException
	 */
	public CarTypeDomain updateSelectType(TypeInsertVO tiv) throws SQLException{
		CarTypeDomain ctd=null;
		GetSqlSession gss=GetSqlSession.getInstance();
		SqlSession ss=gss.getSqlSession();
		
		ctd=ss.selectOne("updateSelectType", tiv);
		return ctd;
	}//selectReservation
	
	/**
	 * 차종 수정
	 * @param car_num
	 * @return
	 * @throws SQLException
	 */
	public int updateType(TypeUpdateVO tuv) throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		int cnt=ss.update("typeUpdate", tuv);
		if(cnt==1){
			ss.commit();
		}
		return cnt;
	}//updateType
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////차량 관리////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 차량 추가 시, 기존 보유한 차량의 차량명을 select태그로 띄워주기 위함
	 * @param rv
	 * @return
	 * @throws SQLException
	 */
	public List<CarNameDomain> selectCarName() throws SQLException{
		List<CarNameDomain> list=null;
		GetSqlSession gss=GetSqlSession.getInstance();
		SqlSession ss=gss.getSqlSession();
		list=ss.selectList("selectCarName");
		return list;
	}//selectReservation
	
	/**
	 * 차량 추가
	 * @param tiv
	 * @return
	 * @throws SQLException
	 */
	public int insertCar(CarInsertVO civ) throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		int cnt=ss.insert("carInsert", civ);
		if(cnt==1){
			ss.commit();
		}
		return cnt;
	}//insertType
	
	/** 
	 * 차량 수정 이전에 기존 정보를 불러오는 일
	 * @param car_num
	 * @return
	 * @throws SQLException
	 */
	public CarUpdateDomain updateSelectCar(String car_num) throws SQLException{
		CarUpdateDomain cud=null;
		GetSqlSession gss=GetSqlSession.getInstance();
		SqlSession ss=gss.getSqlSession();
		
		cud=ss.selectOne("updateSelectCar", car_num);
		return cud;
	}//selectReservation
	
	
	/**
	 * 차량 수정
	 * @param car_num
	 * @return
	 * @throws SQLException
	 */
	public int updateCar(CarUpdateVO cuv) throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		int cnt=ss.update("carUpdate", cuv);
		if(cnt==1){
			ss.commit();
		}
		return cnt;
	}//updateCar
	
	
	
	/**
	 * 차량 삭제
	 * @param car_num
	 * @return
	 * @throws SQLException
	 */
	public int deleteCar(String car_num) throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		int cnt=ss.delete("carDelete", car_num);
		if(cnt==1){
			ss.commit();
		}
		return cnt;
	}//deleteCar
	
}//class























/*public List<CarData> selectCar(CarValueVO cvv) throws SQLException{
		List<CarData> list = null;
		SqlSession ss = GetSqlSession.getInstance().getSqlSession();
		list=ss.selectList("carView",cvv); //mainCarView는 mapper에 있는 id이다.
		if(ss!=null){
			ss.close();
		}//end if
		return list;
	}//selectQna
	
	
	
	public int insertCar(InsertCarVO ic)throws SQLException{
		GetSqlSession gss=GetSqlSession.getInstance();
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		int cnt=ss.insert("carInsert", ic);
		if(cnt==1){
			ss.commit();
		}
		return cnt;
	}//insertQna
	
	
	
	public int updateCar(UpdateCarVO uc)throws SQLException{
		GetSqlSession gss=GetSqlSession.getInstance();
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		int cnt=ss.update("carUpdate", uc);
		if(cnt==1){
			ss.commit();
		}
		return cnt;
	}//updateQna
	
	
	
	public CarDetailData selectCarDetail(String cnum) throws SQLException{
		CarDetailData cd = null;
		SqlSession ss = GetSqlSession.getInstance().getSqlSession();
		System.out.println("sqlsession--------"+ ss);
		cd=ss.selectOne("carDetailView",cnum);
		System.out.println("QnaDAO"+cd);
		if(ss!=null){
			ss.close();
		}//end if
		return cd;
	}//selectQnaDetail
	

	
public int deleteCar(String cnum)throws SQLException{
		GetSqlSession gss=GetSqlSession.getInstance();
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		int cnt=ss.delete("carDelete", cnum);
		if(cnt==1){
			ss.commit();
		}
		return cnt;
	}//deleteQna




public CarCntData selectCarCnt()throws SQLException{
	CarCntData ccd =null;
	SqlSession ss= GetSqlSession.getInstance().getSqlSession();
	ccd=ss.selectOne("carCnt");
	if(ss!=null){
		ss.close();
	}//end if
	return ccd;
}//selectCar

 */