package kr.co.sist.rent.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.rent.domain.CarDetail;
import kr.co.sist.rent.domain.RentAble;
import kr.co.sist.rent.domain.Schedual;
import kr.co.sist.rent.domain.cntData;
import kr.co.sist.rent.vo.DataVO;
import kr.co.sist.rent.vo.DetailVO;
import kr.co.sist.rent.vo.RentInsertVO;
import kr.co.sist.rent.vo.ScheSearchVO;
import kr.co.sist.rent.vo.ScheVO;

@Component
public class RentDAO {
	public List<Schedual> selectRent(ScheVO sv)throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		List<Schedual> list=null;
		list=ss.selectList("selectRentSchedual", sv);
		
		if(ss!=null){
			ss.close();
		}
		
		return list;
	}
	
	public cntData selectCnt(ScheSearchVO ssv)throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		cntData cd=null;
		cd=ss.selectOne("selectRentCnt", ssv);
		
		if(ss!=null){
			ss.close();
		}
		
		return cd;
	}
	
	public int deleteRent(String resev_num)throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		int cnt=0;
		cnt=ss.delete("deleteRent", resev_num);
		
		if(cnt==1){
			ss.commit();
		}
		
		if(ss!=null){
			ss.close();
		}
		
		return cnt;
	}
	
	public List<RentAble> selectRentAble(DataVO dv)throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		List<RentAble> list=null;
		
		list=ss.selectList("selectRentAble", dv);
		
		if(ss!=null){
			ss.close();
		}
		
		return list;
	}
	
	public CarDetail selectDetail(DetailVO dv)throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		CarDetail cd=null;
		
		cd=ss.selectOne("selectDetailCar", dv);
		
		if(ss!=null){
			ss.close();
		}
		
		return cd;
	}
	
	public int insertRent(RentInsertVO riv)throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		int cnt=0;
		cnt=ss.insert("insertRent", riv);
		
		if(cnt==1){
			ss.commit();
		}
		
		if(ss!=null){
			ss.close();
		}
		
		return cnt;
	}
	
	public String selectMember(String id)throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		String member=null;
		
		member=ss.selectOne("selectMember", id);
		
		if(ss!=null){
			ss.close();
		}
		
		return member;
	}
}
