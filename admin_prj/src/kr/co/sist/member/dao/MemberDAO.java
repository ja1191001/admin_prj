package kr.co.sist.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.member.domain.MemberCntData;
import kr.co.sist.member.domain.MemberData;
import kr.co.sist.member.vo.MemberSearchVO;
import kr.co.sist.member.vo.MemberValueVO;
import kr.co.sist.member.dao.GetSqlSession;

@Component
public class MemberDAO {

	public List<MemberData> selectMember(MemberValueVO mvv) throws SQLException{
		List<MemberData> list = null;
		SqlSession ss = GetSqlSession.getInstance().getSqlSession();
		list=ss.selectList("memberView",mvv); //mainCarView는 mapper에 있는 id이다.
		
		if(ss!=null){
			ss.close();
		}//end if
		return list;
	}//selectMember
	
	public int updateMember(String id)throws SQLException{
		GetSqlSession gss=GetSqlSession.getInstance();
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		
		int cnt=ss.update("memberUpdate", id);
		
		if(cnt==1){
			ss.commit();
		}
		return cnt;
	}//updateMember
	
	public MemberCntData selectmemberCnt(MemberSearchVO msVO)throws SQLException{
		MemberCntData mcd =null;
		
		SqlSession ss= GetSqlSession.getInstance().getSqlSession();
		mcd=ss.selectOne("memberCnt",msVO);
		if(ss!=null){
			ss.close();
		}//end if
		
		return mcd;
	}//selectmemberCnt

}//class
