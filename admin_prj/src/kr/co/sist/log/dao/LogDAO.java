package kr.co.sist.log.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.log.vo.ChangeVO;
import kr.co.sist.log.vo.EmpVO;
import kr.co.sist.log.vo.FindIdVO;
import kr.co.sist.log.vo.FindPassVO;
import kr.co.sist.log.vo.LogVO;

@Component
public class LogDAO {
	
	public String selectAdminLogin(LogVO lv)throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		String id=ss.selectOne("selectAdminLogin", lv);
		
		if(ss!=null){
			ss.close();
		}
		
		return id;
	}
	
	public int insertAdmin(EmpVO ev)throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		int cnt=ss.insert("insertAdmin", ev);
		
		if(cnt==1){
			ss.commit();
		}
		
		if(ss!=null){
			ss.close();
		}
		
		return cnt;
	}

	public String selectAdminId(FindIdVO fiv)throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		String id=ss.selectOne("selectAdminId", fiv);
		
		if(ss!=null){
			ss.close();
		}
		
		return id;
	}
	
	public String selectAdminPass(FindPassVO fpv)throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		String id=ss.selectOne("selectAdminPass", fpv);
		
		if(ss!=null){
			ss.close();
		}
		
		return id;
	}
	
	public int updateAdminPass(ChangeVO cv)throws SQLException{
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		int cnt=ss.update("updatePass", cv);
		
		if(cnt==1){
			ss.commit();
		}
		
		if(ss!=null){
			ss.close();
		}
		
		return cnt;
	}

}
