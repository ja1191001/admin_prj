package kr.co.sist.notice.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

import kr.co.sist.notice.domain.NoticeCntData;
import kr.co.sist.notice.domain.NoticeData;
import kr.co.sist.notice.vo.NoticeModifyVO;
import kr.co.sist.notice.vo.NoticeSearchVO;
import kr.co.sist.notice.vo.NoticeVO;
import kr.co.sist.notice.vo.NoticeValueVO;
import kr.co.sist.notice.vo.NoticeWriteVO;
@Component
public class MainDAO {
	
	@Autowired(required=false)
	
	public List<NoticeData> selectNotice(NoticeValueVO nvv)throws SQLException{
		List<NoticeData> list=null;
		
		SqlSession ss= GetSqlSession.getInstance().getSqlSession();
		
		list=ss.selectList("noticeView",nvv);
		if(ss!=null){
			ss.close();
		}//end if
		
		return list;
	}//selectNotice
	
	public NoticeCntData selectNoticeCnt(NoticeSearchVO nsVO)throws SQLException{
		NoticeCntData ncd =null;
		
		SqlSession ss= GetSqlSession.getInstance().getSqlSession();
		ncd=ss.selectOne("noticeCnt",nsVO);
		if(ss!=null){
			ss.close();
		}//end if
		
		return ncd;
	}//selectNoticeCnt
	
	public NoticeData selectNoticeDetail( int num )throws SQLException{
		NoticeData nd=null;
		
		SqlSession ss= GetSqlSession.getInstance().getSqlSession();
		nd=ss.selectOne("noticeDetailView",num);
		if(ss!=null){
			ss.close();
		}//end if
		
		return nd;
	}//selectNoticeDetail

	public int modifyNotice(NoticeModifyVO nmVO )throws SQLException{
		int nd=0;
		
		SqlSession ss= GetSqlSession.getInstance().getSqlSession();
		nd=ss.update("modifyNoticeView",nmVO);
		ss.commit();
		if(ss!=null){
			ss.close();
		}//end if
		
		return nd;
	}//modifyNotice
	
	public int deleteNotice(String notice_num)throws SQLException{
		int nd=0;
		
		SqlSession ss= GetSqlSession.getInstance().getSqlSession();
		nd=ss.delete("deleteNoticeView",notice_num);
		ss.commit();
		if(ss!=null){
				ss.close();
		}//end if
		return nd;
	}//deleteNotice
	
	public int insertNotice(NoticeWriteVO nwVO)throws SQLException{
		int nd=0;
		
		SqlSession ss= GetSqlSession.getInstance().getSqlSession();
		nd=ss.insert("insertNoticeView",nwVO);
		ss.commit();
		if(ss!=null){
			ss.close();
		}//end if
		return nd;
	}//insertNotice
}//class
