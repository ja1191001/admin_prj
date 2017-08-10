package kr.co.sist.qna.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.qna.dao.GetSqlSession;
import kr.co.sist.qna.domain.QnaCntData;
import kr.co.sist.qna.domain.QnaData;
import kr.co.sist.qna.domain.QnaDetailData;
import kr.co.sist.qna.vo.InsertQnaVO;
import kr.co.sist.qna.vo.QnaSearchVO;
import kr.co.sist.qna.vo.QnaValueVO;
import kr.co.sist.qna.vo.UpdateQnaVO;
@Component
public class QnaDAO {

	public List<QnaData> selectQna(QnaValueVO qvv) throws SQLException{
		List<QnaData> list = null;
		SqlSession ss = GetSqlSession.getInstance().getSqlSession();
		list=ss.selectList("qnaView",qvv); //mainCarView는 mapper에 있는 id이다.
		
		if(ss!=null){
			ss.close();
		}//end if
		return list;
	}//selectQna
	
	public int insertQna(InsertQnaVO iq)throws SQLException{
		GetSqlSession gss=GetSqlSession.getInstance();
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		
		int cnt=ss.insert("qnaInsert", iq);
		
		if(cnt==1){
			ss.commit();
		}
		return cnt;
	}//insertQna
	
	public int updateQna(UpdateQnaVO uq)throws SQLException{
		GetSqlSession gss=GetSqlSession.getInstance();
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		
		int cnt=ss.update("qnaUpdate", uq);
		
		if(cnt==1){
			ss.commit();
		}
		return cnt;
	}//updateQna
	
	public QnaDetailData selectQnaDetail(String qnum) throws SQLException{
		QnaDetailData qd = null;
		
		SqlSession ss = GetSqlSession.getInstance().getSqlSession();
		qd=ss.selectOne("qnaDetailView",qnum);
		if(ss!=null){
			ss.close();
		}//end if
		return qd;
		
	}//selectQnaDetail
	

	
public int deleteQna(String qnum)throws SQLException{
		GetSqlSession gss=GetSqlSession.getInstance();
		SqlSession ss=GetSqlSession.getInstance().getSqlSession();
		
		int cnt=ss.delete("qnaDelete", qnum);
		
		if(cnt==1){
			ss.commit();
		}
		return cnt;
	}//deleteQna

public QnaCntData selectqnaCnt(QnaSearchVO qsVO)throws SQLException{
	QnaCntData qcd =null;
	
	SqlSession ss= GetSqlSession.getInstance().getSqlSession();
	qcd=ss.selectOne("qnaCnt",qsVO);
	if(ss!=null){
		ss.close();
	}//end if
	
	return qcd;
}//selectqnaCnt




}//class
